package com.example.aosp_a13_release_test;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiSelector;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class FT_Settings extends Utility_Functions {
    private UiDevice device;
    private static final String TAG = "TEST";

    @Before
    public void setUp() throws Exception {

        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        device.pressHome();
        if (null == device) {
            Log.e(TAG, "can't find the UiDevice");
            return;
        }
    }

    @Test
    public void AOSP_13_Settings() throws Exception {
        try {
            int i;
            for (i = 1; i <= 1; i++) {
                //turnonFlightMode();
                //Bluetooth_pair_unpair("SP things");
                //Flash_on_off();
                //display_brightness_adjust();
                change_ringtone_Volume();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    public void turnonFlightMode() throws Exception {
        UiObject nw_internet = new UiObject(new UiSelector()
                .text("Network & internet"));
        UiObject Airplane_mode = new UiObject(new UiSelector()
                .text("Airplane mode"));
        ufMenu_srch_App("Settings");

        nw_internet.click();
        Log.i(TAG, "* Network & internet");
        Airplane_mode.click();
        Log.i(TAG, "* click Airplane mode to turn on");
        Thread.sleep(1000);
        Airplane_mode.click();
        Log.i(TAG, "* click Airplane mode to turn off");
        device.pressBack();
        go_to_idle();

    }

    public void Bluetooth_pair_unpair(String BT_name) throws Exception {
        UiObject Connected_Devices = new UiObject(new UiSelector()
                .text("Connected devices"));
        UiObject Pair_new_device = new UiObject(new UiSelector()
                .text("Pair new device"));
        UiObject Select_Bluetooth = new UiObject(new UiSelector()
                .textContains(BT_name));
        UiObject Check_Allow_Access = new UiObject(new UiSelector()
                .textContains("Allow access to your contacts and call history"));
        UiObject Pair = new UiObject(new UiSelector()
                .text("PAIR"));
        UiObject Paired_BT_Settings = new UiObject(new UiSelector()
                .description("Settings"));
        UiObject forgot = new UiObject(new UiSelector()
                .text("FORGET"));
        UiObject forgot_device = new UiObject(new UiSelector()
                .text("FORGET DEVICE"));

        ufMenu_srch_App("Settings");

        Connected_Devices.click();
        Log.i(TAG, "* click Connected Devices");
        Pair_new_device.click();
        Thread.sleep(1000);
        Log.i(TAG, "* click Pair New Device");
        Select_Bluetooth.waitForExists(10000);
        Log.i(TAG, "* waiting for the Bluetooth : " + BT_name);
        Select_Bluetooth.click();
        Log.i(TAG, "* click on : " + BT_name);
        //Check_Allow_Access.click();
        Pair.click();
        device.pressBack();
        go_to_idle();

        //Unpair
        ufMenu_srch_App("Settings");
        Connected_Devices.click();
        Log.i(TAG, "* click Connected Devices");
        Paired_BT_Settings.click();
        Log.i(TAG, "* click on paired device settings");
        forgot.click();
        Log.i(TAG, "* click on forgot to unpair Bluetooth");
        forgot_device.click();
        Log.i(TAG, "* click forgot device to confirm unpair BT");
        device.pressBack();
        go_to_idle();

    }

    public void Flash_on_off() throws Exception{
        UiObject Hm_screen_scroll_down = new UiObject(new UiSelector()
                .className(AOSP_13_HOME_SCREEN_HOME_CN));
        UiObject flashlight = new UiObject(new UiSelector()
                .description("Flashlight"));

        go_to_idle();

        Hm_screen_scroll_down.swipeDown(3);
        Log.i(TAG, "* swipe down to access Notification bar");
        flashlight.click();
        Log.i(TAG, "* Flash light ON");
        flashlight.click();
        //nw_internet.click();
        Log.i(TAG, "* Flash light OFF");
        device.pressBack();
        go_to_idle();

    }
    public void display_brightness_adjust () throws Exception {
        UiObject Display = new UiObject(new UiSelector()
                .text("Display"));
        UiObject Brightnes_level = new UiObject(new UiSelector()
                .text("Brightness level"));
        UiObject Search_Settings = new UiObject(new UiSelector()
                .resourceId("com.android.settings:id/search_action_bar"));
        UiObject Search_ = new UiObject(new UiSelector()
                .resourceId("android:id/search_src_text"));
        ufMenu_srch_App("Settings");

        Search_Settings.click();
        Search_.setText("Displa");
        Display.waitForExists(2000);
        Display.click();
        Log.i(TAG, "* Open Display");
        Brightnes_level.click();
        Log.i(TAG, "* click brightness level option");
        Thread.sleep(1000);
        device.click(210,210);
        Log.i(TAG, "* click on coordinates to change brightness level to low");
        Thread.sleep(2000);
        device.click(610,210);
        Thread.sleep(2000);
        device.click(810,210);
        Log.i(TAG, "* click on coordinates to change brightness level to high");
        device.pressBack();
        go_to_idle();

    }

    public void change_ringtone_Volume() throws Exception{
        UiObject Search_Settings = new UiObject(new UiSelector()
                .resourceId("com.android.settings:id/search_action_bar"));
        UiObject Type_to_search = new UiObject(new UiSelector()
                .resourceId("android:id/search_src_text"));
        UiObject Click_on_Searched_Setting = new UiObject(new UiSelector()
                .resourceId("android:id/title").text("Sound & vibration"));
        UiObject SV_Scroller = new UiObject(new UiSelector()
                .resourceId("com.android.settings:id/content_parent"));
        UiObject Media_volume = new UiObject(new UiSelector()
                .resourceId("android:id/seekbar").description("Media volume"));
        UiObject Call_Volume = new UiObject(new UiSelector()
                .resourceId("android:id/seekbar").text("Call volume"));

        go_to_idle();
        ufMenu_srch_App("Settings");
        Search_Settings.click();
        Log.i(TAG, "* Click on Search Settings");
        Type_to_search.setText("Sound & Vibration");
        Log.i(TAG, "* Search Sound & Vaibration");
        Click_on_Searched_Setting.click();
        SV_Scroller.swipeDown(1);
        //Click on coordinaties to set Media volume
        Media_volume.swipeLeft(7);
        Media_volume.swipeRight(7);

        Call_Volume.swipeLeft(7);
        Call_Volume.swipeRight(7);

        //nw_internet.click();
        Log.i(TAG, "* Flash light OFF");
        device.pressBack();
        go_to_idle();

    }


}
