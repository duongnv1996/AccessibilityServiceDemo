package com.example.kimcy929.accessibilityservicesample;


import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toast;

import timber.log.Timber;

public class MyAccessibilityService extends AccessibilityService {

    public static final String TAG = MyAccessibilityService.class.getSimpleName();

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        Toast.makeText(this, "onServiceConnected", Toast.LENGTH_SHORT).show();
        Timber.d("Service connected");
    }

    public MyAccessibilityService() {
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {

        String packageName = accessibilityEvent.getPackageName().toString();

        //Timber.e("Package name -> " + packageName);

        //Timber.d(accessibilityEvent.getAction() + " " +  accessibilityEvent.toString());

        /*int eventType = accessibilityEvent.getEventType();
        if (eventType == AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED
                || eventType == AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED) {
            Timber.d("Typing text");
        } else {
            Timber.d("Not Typing " + accessibilityEvent.toString().substring(0, accessibilityEvent.toString().indexOf(";")));
        }*/
    }

    @Override
    public void onInterrupt() {
        Timber.d("Service interrupt");
    }

    @Override
    public void onDestroy() {
        Timber.d("onDestroy");
        Toast.makeText(this, "Destroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
