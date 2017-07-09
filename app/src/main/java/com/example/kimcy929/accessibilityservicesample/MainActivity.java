package com.example.kimcy929.accessibilityservicesample;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.widget.Button;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private Button btnOpenAccessibilitySettings;
    private AppCompatTextView txtAccessibilitySate;

    private static final int ACCESSIBILITY_SERVICE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        Timber.d(MyAccessibilityService.class.getCanonicalName());

        btnOpenAccessibilitySettings = findViewById(R.id.btnOpenAccessibilitySettings);
        txtAccessibilitySate = findViewById(R.id.txtAccessibilitySate);

        txtAccessibilitySate.setText(getInfoAccess());

        btnOpenAccessibilitySettings.setOnClickListener(view -> {
            /*if (!AccessibilityUtils.isAccessibilitySettingsOn(this)) {
                Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                startActivityForResult(intent, ACCESSIBILITY_SERVICE_REQUEST);
            } else {
                Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
            }*/

            Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
            startActivityForResult(intent, ACCESSIBILITY_SERVICE_REQUEST);
        });

    }

    private String getInfoAccess() {
        return "Is Enabled Accessibility service -> " + AccessibilityUtils.isAccessibilitySettingsOn(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ACCESSIBILITY_SERVICE_REQUEST) {
            Timber.d("Accessibility Request");
            String info = getInfoAccess();
            Timber.d(info);
            txtAccessibilitySate.setText(info);
        }
    }
}
