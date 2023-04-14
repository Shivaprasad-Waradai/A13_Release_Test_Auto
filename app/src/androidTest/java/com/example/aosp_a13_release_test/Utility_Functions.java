package com.example.aosp_a13_release_test;

import static androidx.test.core.app.DeviceCapture.takeScreenshot;
import static androidx.test.core.graphics.BitmapStorage.writeToTestStorage;

import android.view.KeyEvent;

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
                    .resourceId(AOSP_13_N6_1_APP_MENU_SEARCH_RID));
            UiObject search_app_web_n_more_input = new UiObject(new UiSelector()
                    .resourceId(AOSP_13_APP_MENU_G_SEARCH_INPUT_RID));
            UiObject click_on_App = new UiObject(new UiSelector()
                    .className("android.widget.TextView").text(AppName));
            UiObject click_on_App1 = new UiObject(new UiSelector()
                    .className("android.widget.TextView").text("Settings"));


            Hm_screen_scroll_up.swipeUp(2);
            Log.i(TAG, "* Launching Main Menu");
            if(search_App.exists()){
                search_App.click();
                search_App.setText(AppName);
            }

            if (search_app_web_n_more_input.exists()){
                search_app_web_n_more_input.setText(AppName);
            }
            // search_App.click();
            // Log.i(TAG, "Click on Search App");

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

    public void clear_Recent_Apps() {
        //try {

            UiObject clr_all_rcnt_apps = new UiObject(new UiSelector()
                    .text("CLEAR ALL"));
            UiObject scroll_right_to_get_Clear_all = new UiObject(new UiSelector()
                    .className("com.android.launcher3:id/overview_panel"));
            UiObject No_recent_items = new UiObject(new UiSelector()
                    .className("com.android.launcher3:id/overview_panel").text("No recent items"));

            //device.pressKeyCode(KeyEvent.KEYCODE_APP_SWITCH);
            device.pressKeyCode(KeyEvent.KEYCODE_APP_SWITCH);
           /* if (No_recent_items.exists()){
                go_to_idle();
            }else {
                do {
                    scroll_right_to_get_Clear_all.swipeRight(1);
                }while(clr_all_rcnt_apps.exists()==false);{
                    clr_all_rcnt_apps.click();
                }

                clr_all_rcnt_apps.waitForExists(1000);
                if (clr_all_rcnt_apps.exists()) {
                    clr_all_rcnt_apps.click();
                    Thread.sleep(2000);
                } else {
                    device.pressBack();
                    go_to_idle();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

            */

    }
}
