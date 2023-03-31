package com.example.aosp_a13_release_test;



/*
 *
 * TEST SCENARIO : Navigate to all Native apps
 * TEST CASE :
 * 1. Return to home Screen
 * 2. Go to App Menu
 * 3. Search Native App (Like, Calculator, Calendar, Settings etc.....)
 * 4. Launch Searched App
 * 5. Returned Home Screen
 * 6. Repeat 1 - 5 Steps for all Native Apps
 *
 */

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiSelector;

import junit.framework.AssertionFailedError;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class Navigate_to_all_apps extends Utility_Functions{

    private UiDevice device;
    private static final String TAG = "TEST";
    @Before
    public void setUp() throws Exception {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        device.pressHome();
    }

    @Test
    public void Operation_Open_and_close_Calendar_App() throws Exception {

        try {
            int i;
            Log.i(TAG, "* Test Started");
            for (i = 1; i <= 1; i++) {
                /*openClose_Apps("Calculator");
                openClose_Apps("Calendar");
                openClose_Apps("Camera");
                openClose_Apps("Clock");
                openClose_Apps("Contacts");
                openClose_Apps("Messages");
                openClose_Apps("Phone");
                openClose_Apps("Settings");

                 */
                mst_Settings();
            Log.i(TAG, "* Test Ended");

            }

        } catch (Exception e)
        {
            Log.d(TAG, "* Test Failed...");
            throw new AssertionFailedError();
        }
    }
    @Test
    public void Mst_Manu_structure() throws Exception {

        try {
            int i;
            Log.i(TAG, "* Test Started");
            for (i = 1; i <= 1; i++) {
                mst_Settings();
                Log.i(TAG, "* Test Ended");

            }

        } catch (Exception e)
        {
            Log.d(TAG, "* Test Failed...");
            throw new AssertionFailedError();
        }
    }

    public void mst_Settings() throws Exception {
        try {

            //***********************************************************
            //Object initialization
            //***********************************************************
            UiObject Settings_drag = new UiObject(new UiSelector()
                    .resourceId("com.android.settings:id/settings_homepage_container"));
            UiObject Network_Internet = new UiObject(new UiSelector()
                    .text(AOSP_13_SETTINGS_NW_internet_TXT));
            UiObject Connected_Dev = new UiObject(new UiSelector()
                    .text(AOSP_13_SETTINGS_conneted_devices_TXT));
            UiObject Apps = new UiObject(new UiSelector()
                    .text(AOSP_13_SETTINGS_apps_TXT));
            UiObject Notifi = new UiObject(new UiSelector()
                    .text(AOSP_13_SETTINGS_notifications_TXT));
            UiObject storage = new UiObject(new UiSelector()
                    .text(AOSP_13_SETTINGS_storage_TXT));
            UiObject Battery = new UiObject(new UiSelector()
                    .text(AOSP_13_SETTINGS_battery_TXT));
            UiObject Display = new UiObject(new UiSelector()
                    .text(AOSP_13_SETTINGS_display_TXT));
            UiObject Sound_vib  = new UiObject(new UiSelector()
                    .text(AOSP_13_SETTINGS_Snd_vib_TXT));
            UiObject Walpaper  = new UiObject(new UiSelector()
                    .text(AOSP_13_SETTINGS_wallpaper_TXT));
            UiObject Security  = new UiObject(new UiSelector()
                    .text(AOSP_13_SETTINGS_Security_TXT));
            UiObject Accessibility  = new UiObject(new UiSelector()
                    .text(AOSP_13_SETTINGS_accessibility_TXT));
            UiObject Privacy  = new UiObject(new UiSelector()
                    .text(AOSP_13_SETTINGS_Privacy_TXT));
            UiObject Location  = new UiObject(new UiSelector()
                    .text(AOSP_13_SETTINGS_Location_TXT));
            UiObject Safety  = new UiObject(new UiSelector()
                    .text(AOSP_13_SETTINGS_safety_emergency_TXT));
            UiObject D_well  = new UiObject(new UiSelector()
                    .text(AOSP_13_SETTINGS_Digi_wellbeing_TXT));
            UiObject Google  = new UiObject(new UiSelector()
                    .text(AOSP_13_SETTINGS_Google_TXT));
            UiObject System  = new UiObject(new UiSelector()
                    .text(AOSP_13_SETTINGS_system_TXT));
            UiObject About_phone  = new UiObject(new UiSelector()
                    .text(AOSP_13_SETTINGS_About_phone_TXT));
            UiObject password_Acc = new UiObject(new UiSelector()
                    .text(AOSP_13_SETTINGS_paswrd_accs_TXT));

            //***********************************************************
            //Open Settings and return to the Home Screen
            //************************************************************

            device.pressBack();
            device.pressHome();

            ufMenu_srch_App("Settings");
            Settings_drag.swipeDown(200);
            Network_Internet.click();
            device.pressBack();
            Connected_Dev.waitForExists(1000);
            Connected_Dev.click();
            device.pressBack();
            Apps.waitForExists(1000);
            Apps.click();
            device.pressBack();
            Notifi.waitForExists(1000);
            Notifi.click();
            device.pressBack();
            Battery.waitForExists(1000);
            Battery.click();
            device.pressBack();
            storage.waitForExists(1000);
            storage.click();
            device.pressBack();

            Settings_drag.swipeUp(100);

            Sound_vib.waitForExists(1000);
            Sound_vib.click();
            device.pressBack();
            Display.waitForExists(1000);
            Display.click();
            device.pressBack();
            Walpaper.waitForExists(1000);
            Walpaper.click();
            device.pressBack();
            Accessibility.waitForExists(1000);
            Accessibility.click();
            device.pressBack();
            Security.waitForExists(1000);
            Security.click();
            device.pressBack();
            Privacy.waitForExists(1000);
            Privacy.click();
            device.pressBack();

            Settings_drag.swipeUp(100);

            Location.waitForExists(1000);
            Location.click();
            device.pressBack();
            Safety.waitForExists(1000);
            Safety.click();
            device.pressBack();
            password_Acc.waitForExists(1000);
            password_Acc.click();
            device.pressBack();
            D_well.waitForExists(1000);
            D_well.click();
            device.pressBack();
            Google.waitForExists(1000);
            Google.click();
            device.pressBack();
            System.waitForExists(1000);
            System.click();
            device.pressBack();
            About_phone.waitForExists(1000);
            About_phone.click();
            device.pressBack();
            Thread.sleep(3000);
            Settings_drag.swipeDown(2);
            go_to_idle();
            //System.out.println("**********************Open and close Phone app - PASS ********************");

        } catch (Exception e) {

            //device.takeScreenshot( );
            e.printStackTrace();
            System.out.println("**********************Open and close Phone app - FAILED********************");
            go_to_idle();
        }
    }

}
