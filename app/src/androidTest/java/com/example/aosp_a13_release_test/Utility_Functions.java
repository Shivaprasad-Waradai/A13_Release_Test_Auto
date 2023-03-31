package com.example.aosp_a13_release_test;

import static androidx.test.core.app.DeviceCapture.takeScreenshot;
import static androidx.test.core.graphics.BitmapStorage.writeToTestStorage;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.screenshot.Screenshot;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiSelector;

import org.junit.rules.TestName;

public class Utility_Functions extends Device_Variables{


    private UiDevice device;
    private static final String TAG = "TEST";
    public TestName nameRule = new TestName();
    Long time = System.nanoTime();
    public void DeviceInit() throws Exception {

        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        device.pressHome();

    }


    public void go_to_idle()throws Exception{
        DeviceInit();
        device.pressBack();
        device.pressHome();
        Log.i(TAG, "* Go to Idle State");

    }

    public void ufMenu_srch_App(String AppName) throws Exception {
        try {
            Log.i(TAG, "* Opening Main Menu and searching for the App " + AppName);
            UiObject Hm_screen_scroll_up = new UiObject(new UiSelector()
                    .className(AOSP_13_HOME_SCREEN_HOME_CN));
            UiObject search_App = new UiObject(new UiSelector()
                    .resourceId(AOSP_13_APP_MENU_G_SEARCH_RID));
            UiObject search_app_web_n_more_input = new UiObject(new UiSelector()
                    .resourceId(AOSP_13_APP_MENU_G_SEARCH_INPUT_RID));
            UiObject click_on_App = new UiObject(new UiSelector()
                    .className("android.widget.TextView").text(AppName));
            UiObject click_on_App1 = new UiObject(new UiSelector()
                    .className("android.widget.TextView").text("Settings"));


            Hm_screen_scroll_up.swipeUp(2);
            Log.i(TAG, "* Launching Main Menu");
            // search_App.click();
            // Log.i(TAG, "Click on Search App");
            search_app_web_n_more_input.setText(AppName);
            Log.i(TAG, "* Enter the App Name " + AppName);

            //search_app_web_n_more_input.click();
            Thread.sleep(2000);

            if (click_on_App1.exists()) {
                click_on_App1.click();
                Thread.sleep(2000);
                Log.i(TAG, "* Click to open the SETTINGS");
            } else {
                click_on_App.click();
                Thread.sleep(2000);
                Log.i(TAG, "* Click to open the " +AppName);
            }


        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "* "+AppName + " not found.... ");
            //writeToTestStorage(takeScreenshot(), getClass().getSimpleName() + "_" + nameRule.getMethodName());
            writeToTestStorage(takeScreenshot(), getClass().getSimpleName() + "_" + nameRule.getMethodName()+"_"+time);
            Log.i(TAG,"* Screenshot Captured....");

        }
    }
    public void openClose_Apps(String str) throws Exception {
        try {
            DeviceInit();
            //***********************************************************
            //Open the Messages App and return to the Home Screen
            //************************************************************
            go_to_idle();

            ufMenu_srch_App(str);

            go_to_idle();
            Thread.sleep(3000);


        }catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "* Open and close App " +str+" Failed....");
            go_to_idle();
        }
    }
}
