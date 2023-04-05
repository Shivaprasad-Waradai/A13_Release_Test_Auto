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

import java.io.IOException;

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
    @Test
    public void Monkey_run() throws Exception {

        try {
            int i;
            Log.i(TAG, "* Monkey run test started");
            for (i = 1; i <= 1; i++) {
                monkey_run();
                Log.i(TAG, "* Monkey run Test Ended");

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
    public void monkey_run() throws Exception {
        device.executeShellCommand("monkey -p com.android.camera2 -v 5000");
        device.executeShellCommand("monkey -p com.google.android.apps.messaging -v 5000");
        device.executeShellCommand("monkey -p com.google.android.dialer -v 5000");
        device.executeShellCommand("monkey -p com.google.android.deskclock -v 5000");
        device.executeShellCommand("monkey -p com.google.android.contacts -v 5000");
        device.executeShellCommand("monkey -p com.google.android.calculator -v 5000");
        device.executeShellCommand("monkey -p com.android.camera2 -v 5000");

        device.pressBack();
        go_to_idle();
    }
    public void mst_Clock() throws Exception{
        try{

            ufMenu_srch_App("Clock");


            UiObject tab_Clock = new UiObject(new UiSelector()
                    .className(CLOCK_MAIN_TABS_className).index(1));
            tab_Clock.click();
            System.out.println("Clicked on Clock Tab");

            device.pressBack();
            device.pressHome();
            ufMenu_srch_App("Clock");

            UiObject tab_Alarm = new UiObject(new UiSelector()
                    .className(CLOCK_MAIN_TABS_className).index(0));
            tab_Alarm.click();
            System.out.println("Clicked on Alarm Tab");

            device.pressBack();
            device.pressHome();
            ufMenu_srch_App("Clock");

            UiObject tab_Timer = new UiObject(new UiSelector()
                    .className(CLOCK_MAIN_TABS_className).index(2));
            tab_Timer.click();
            System.out.println("Clicked on Timer Tab");

            device.pressBack();
            device.pressHome();
            ufMenu_srch_App("Clock");

            UiObject tab_Stopwatch = new UiObject(new UiSelector()
                    .className(CLOCK_MAIN_TABS_className).index(3));
            tab_Stopwatch.click();
            System.out.println("Clicked on Stop Watch Tab");

            device.pressBack();
            device.pressHome();
            ufMenu_srch_App("Clock");

            UiObject tab_More_Opt = new UiObject(new UiSelector()
                    .className(CLOCK_TAB_MORE_OPT_className).description(CLOCK_MORE_OPT_contentDescription));
            tab_More_Opt.click();
            UiObject more_Opt_ScreenSaver = new UiObject(new UiSelector()
                    .className(CLOCK_MORE_OPT_DROPDOWN_className).index(0));
            more_Opt_ScreenSaver.click();
            System.out.println("Clicked on Screen Saver Option");

            Thread.sleep(2000);
            device.pressBack();
            //device.pressBack();

            tab_More_Opt.click();
            UiObject more_Opt_Settings = new UiObject(new UiSelector()
                    .className(CLOCK_MORE_OPT_DROPDOWN_className).index(1));
            more_Opt_Settings.click();
            System.out.println("Clicked on Setting Option");
            device.pressBack();

            tab_More_Opt.click();
            UiObject more_Opt_Send_Feedback = new UiObject(new UiSelector()
                    .className(CLOCK_MORE_OPT_DROPDOWN_className).index(2));
            more_Opt_Send_Feedback.click();
            System.out.println("Clicked on Send Feedback Option");
            device.pressBack();
            Thread.sleep(2000);
            device.pressBack();

            tab_More_Opt.click();
            UiObject more_Opt_Help = new UiObject(new UiSelector()
                    .className(CLOCK_MORE_OPT_DROPDOWN_className).index(3));
            more_Opt_Help.click();
            System.out.println("Clicked on Help Option");
            device.pressBack();
            device.pressHome();

            System.out.println("**********************mst_Clock PASSED********************");

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("**********************mst_Clock FAILED********************");
        }
    }
    public void mst_Contacts() throws Exception{

        try {

            device.pressBack();
            go_to_idle();
            ufMenu_srch_App("Contacts");
            System.out.println("Opened the Contact Application");
            UiObject create_new_contact = new UiObject(new UiSelector()
                    .description("Create new contact"));
            create_new_contact.click();

            device.pressBack();
            device.pressBack();
            device.pressHome();
            System.out.println("Returned To the Home Screen");

            Thread.sleep(3000);
            //*********************************************************

            //open and go to options
            //**************************************************************

            device.pressBack();
            device.pressHome();

            ufMenu_srch_App("Contacts");
            System.out.println("Opened the Contact Application");

            UiObject open_navigation_drawer = new UiObject(new UiSelector()
                    .description("Open navigation drawer"));
            open_navigation_drawer.click();


            UiObject create_label = new UiObject(new UiSelector()
                    .className("android.widget.TextView").text("Create label"));
            create_label.click();
            System.out.println("Opened the More Options > Create Label");
            UiObject Popup_Cancle = new UiObject(new UiSelector()
                    .resourceId("android:id/button2"));
            Popup_Cancle.click();
            System.out.println("Navigated to More Options>");


            device.pressBack();
            device.pressHome();

            System.out.println("Returned to Home Screen");

            Thread.sleep(3000);

            device.pressBack();
            device.pressHome();

            ufMenu_srch_App("Contacts");
            System.out.println("Opened the Contact Application");

            open_navigation_drawer.click();

            UiObject contact_Settings = new UiObject(new UiSelector()
                    .className("android.widget.TextView").text("Settings"));
            contact_Settings.click();
            System.out.println("Opened the More Options > Settings ");
            device.pressBack();
            device.pressHome();

            System.out.println("Returned To Home Screen");
            Thread.sleep(3000);

            device.pressBack();
            device.pressHome();

            ufMenu_srch_App("Contacts");
            System.out.println("Opened the Contact Application");

            open_navigation_drawer.click();

            UiObject contact_help_feedback = new UiObject(new UiSelector()
                    .className("android.widget.TextView").text("Help & feedback"));
            contact_help_feedback.click();
            System.out.println("Opened More Option Help Feedback");

            device.pressBack();
            device.pressHome();
            System.out.println("Returned to home Screen");
            Thread.sleep(3000);

            System.out.println("**********************mst_Contacts PASSED********************");
        }catch (Exception e){

            //device.takeScreenshot( );
            e.printStackTrace();
            System.out.println("**********************mst_Contacts FAILED********************");
            device.pressBack();
            device.pressHome();
        }


    }
    public void mst_Messages() throws Exception{
        try {
            device.pressBack();
            go_to_idle();
            ufMenu_srch_App("Messages");

            UiObject msg_Create_New_Msg = new UiObject(new UiSelector()
                    .className(MSG_MORE_OPT_className).index(1));
            msg_Create_New_Msg.click();

            device.pressBack();


            UiObject msg_More_Opt = new UiObject(new UiSelector()
                    .className(MSG_MORE_OPT_className).description(MSG_MORE_OPT_contentDescription));
            msg_More_Opt.click();


            UiObject msg_More_Opt_Settings = new UiObject(new UiSelector()
                    .className(MSG_MORE_OPT_LIST_className).index(2));
            msg_More_Opt_Settings.click();
            device.pressBack();
            msg_More_Opt.click();

            UiObject msg_More_Opt_Archived = new UiObject(new UiSelector()
                    .className(MSG_MORE_OPT_LIST_className).index(0));
            msg_More_Opt_Archived.click();
            device.pressBack();
            msg_More_Opt.click();


            UiObject msg_More_Opt_Blocked_Contacts = new UiObject(new UiSelector()
                    .className(MSG_MORE_OPT_LIST_className).index(1));
            msg_More_Opt_Blocked_Contacts.click();
            device.pressBack();
            msg_More_Opt.click();


            UiObject msg_More_Opt_Help = new UiObject(new UiSelector()
                    .className(MSG_MORE_OPT_LIST_className).index(3));
            msg_More_Opt_Help.click();
            device.pressBack();
            device.pressHome();


            System.out.println("************************* Application found & PASSED **************************");

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("************************* Application Not found & FAILED **************************");
            device.pressBack();
            device.pressHome();

        }
    }
    public void mst_Phone() throws Exception{

        try {
//            UiObject menu_Mark = new UiObject(new UiSelector()
//                    .resourceId("com.android.launcher3_demo:id/all_apps_handle"));
//            menu_Mark.click();
//
//            UiObject search_input = new UiObject(new UiSelector()
//                    .resourceId("com.android.launcher3_demo:id/search_box_input"));
//            search_input.setText("Phone");
//
//            UiObject wedget_icon = new UiObject(new UiSelector()
//                    .className("android.widget.TextView").index(1));
//            wedget_icon.click();

            device.pressBack();
            device.pressHome();

            ufMenu_srch_App("Phone");

            device.pressBack();
            device.pressHome();

            //*****************************************************

//            menu_Mark.click();
//            search_input.setText("Phone");
//            wedget_icon.click();

            ufMenu_srch_App("Phone");

            UiObject Call_History_Tab = new UiObject(new UiSelector()
                    .description("Call history tab."));
            Call_History_Tab.click();
            UiObject Contact_Tab = new UiObject(new UiSelector()
                    .description("Contacts tab."));
            Contact_Tab.click();
            UiObject Speed_dial_Tab = new UiObject(new UiSelector()
                    .description("Speed dial tab."));
            Speed_dial_Tab.click();

            device.pressBack();
            device.pressHome();

            //*****************************************************
//            menu_Mark.click();
//            search_input.setText("Phone");
//            wedget_icon.click();

            ufMenu_srch_App("Phone");

            UiObject More_Option = new UiObject(new UiSelector()
                    .description("More options"));
            More_Option.click();

            UiObject Call_History_opt = new UiObject(new UiSelector()
                    .className("android.widget.LinearLayout").index(0));
            Call_History_opt.click();
            UiObject Navigate_Up = new UiObject(new UiSelector()
                    .description("Navigate up"));
            Navigate_Up.click();

            device.pressBack();
            device.pressHome();


            //*****************************************************


//            menu_Mark.click();
//            search_input.setText("Phone");
//            wedget_icon.click();

            ufMenu_srch_App("Phone");


            More_Option.click();

            UiObject Clear_Frequents_opt = new UiObject(new UiSelector()
                    .className("android.widget.LinearLayout").index(1));
            Clear_Frequents_opt.click();

            UiObject Popup_Cancle = new UiObject(new UiSelector()
                    .resourceId("android:id/button2"));
            if(Popup_Cancle.exists()) {
                Popup_Cancle.click();
            }
            device.pressBack();
            device.pressHome();


            //*****************************************************


//            menu_Mark.click();
//            search_input.setText("Phone");
//            wedget_icon.click();

            ufMenu_srch_App("Phone");

            More_Option.click();

            UiObject Settings_opt = new UiObject(new UiSelector()
                    .className("android.widget.LinearLayout").index(2));
            Settings_opt.click();

            Navigate_Up.click();

            device.pressBack();
            device.pressHome();


            //*****************************************************


//            menu_Mark.click();
//            search_input.setText("Phone");
//            wedget_icon.click();

            ufMenu_srch_App("Phone");

            More_Option.click();

            Settings_opt.click();

            UiObject sett_Disp_Option = new UiObject(new UiSelector()
                    .className("android.widget.LinearLayout").index(0));
            sett_Disp_Option.click();

            device.pressBack();

            Thread.sleep(2000);

            UiObject sett_Sound_Vib = new UiObject(new UiSelector()
                    .className("android.widget.LinearLayout").index(1));
            sett_Sound_Vib.click();

            device.pressBack();

            Thread.sleep(2000);


            UiObject sett_Quik_Resp = new UiObject(new UiSelector()
                    .className("android.widget.LinearLayout").index(2));
            sett_Quik_Resp.click();

            device.pressBack();

            Thread.sleep(2000);


            UiObject sett_Callin_Acc = new UiObject(new UiSelector()
                    .className("android.widget.LinearLayout").index(3));
            sett_Callin_Acc.click();

            device.pressBack();

            Thread.sleep(2000);


            UiObject sett_Call_Blockin = new UiObject(new UiSelector()
                    .className("android.widget.LinearLayout").index(4));
            sett_Call_Blockin.click();

            device.pressBack();

            Thread.sleep(2000);


            UiObject sett_Voice_Mail = new UiObject(new UiSelector()
                    .className("android.widget.LinearLayout").index(5));
            sett_Voice_Mail.click();

            device.pressBack();

            Thread.sleep(2000);


            UiObject sett_Access = new UiObject(new UiSelector()
                    .className("android.widget.LinearLayout").index(6));
            sett_Access.click();

            device.pressBack();

            Thread.sleep(2000);

            UiObject sett_About = new UiObject(new UiSelector()
                    .className("android.widget.LinearLayout").index(7));
            sett_About.click();

            device.pressBack();

            Thread.sleep(2000);

            device.pressBack();
            device.pressHome();
            System.out.println("**********************mst_Phone PASSED********************");

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("**********************mst_Phone FAILED********************");

            device.pressBack();
            device.pressHome();
        }
    }
    public void mst_Calculator() throws Exception{
        // Menu Navigation Stability test on Calculator
        try {

            UiObject more_Opt = new UiObject(new UiSelector()
                    .description("More options"));
            UiObject history = new UiObject(new UiSelector()
                    .className("android.widget.LinearLayout").index(0));
            UiObject navigate_Up = new UiObject(new UiSelector()
                    .description("Navigate up"));
            UiObject send_Feedback = new UiObject(new UiSelector()
                    .className("android.widget.LinearLayout").index(1));
            UiObject close = new UiObject(new UiSelector()
                    .description("Close"));
            UiObject help = new UiObject(new UiSelector()
                    .className("android.widget.LinearLayout").index(2));
            UiObject article0 = new UiObject(new UiSelector()
                    .resourceId("com.google.android.gms:id/gh_popular_article_0"));
            UiObject article1 = new UiObject(new UiSelector()
                    .resourceId("com.google.android.gms:id/gh_popular_article_1"));
            UiObject article2 = new UiObject(new UiSelector()
                    .resourceId("com.google.android.gms:id/gh_popular_article_2"));
            UiObject article3 = new UiObject(new UiSelector()
                    .resourceId("com.google.android.gms:id/gh_popular_article_3"));
            UiObject article4 = new UiObject(new UiSelector()
                    .resourceId("com.google.android.gms:id/gh_popular_article_4"));
            UiObject help_send_Feedback = new UiObject(new UiSelector()
                    .resourceId("com.google.android.gms:id/gh_contact_option_title"));


            //Opening the calculation App and returning to Home Screen
            //***********************************************************************
            device.pressBack();
            device.pressHome();

            ufMenu_srch_App("Calculator");
            System.out.println("Opened the Calculator App");

            device.pressBack();
            device.pressHome();
            System.out.println("Closed the Calculator App and returned to the Home screen");
            //************************************************************************

            //Go to History in Calculator and Navigate all menu
            ufMenu_srch_App("Calculator");
            System.out.println("Opened the Calculator App");

            more_Opt.click();
            Thread.sleep(1000);
            history.click();
            Thread.sleep(1000);
            more_Opt.click();
            Thread.sleep(1000);
            device.pressBack();
            Thread.sleep(1000);
            navigate_Up.click();
            Thread.sleep(1000);
            System.out.println("Go to History in Calculator and Navigate all menu");

            //Go to Send FeedBack and return to Main menu
            device.pressBack();
            device.pressHome();System.out.println("Returned to Home Screen");

            ufMenu_srch_App("Calculator");
            System.out.println("Opened the Calculator App");

            more_Opt.click();
            Thread.sleep(1000);
            send_Feedback.click();System.out.println("Go to Send FeedBack and return to Main menu");
            Thread.sleep(1000);
            navigate_Up.click();
            Thread.sleep(1000);


            // Go to Help in Calculator and Navigate to each Help option
            device.pressBack();
            device.pressHome();System.out.println("Returned to Home Screen");

            ufMenu_srch_App("Calculator");
            System.out.println("Opened the Calculator App");

            more_Opt.click();
            Thread.sleep(1000);
            help.click();
            Thread.sleep(1000);
            article0.click();
            device.pressBack();System.out.println("Go to Help in Calculator and Navigate to each Help option");


            device.pressBack();
            device.pressHome();

            ufMenu_srch_App("Calculator");
            System.out.println("Opened the Calculator App");


            more_Opt.click();
            Thread.sleep(1000);
            help.click();System.out.println("Opened the Help Option");
            Thread.sleep(1000);
            article1.click();
            device.pressBack();

            device.pressBack();
            device.pressHome();

            ufMenu_srch_App("Calculator");
            System.out.println("Opened the Calculator App");

            more_Opt.click();
            Thread.sleep(1000);
            help.click();System.out.println("Opened the Help Option");
            Thread.sleep(1000);
            article2.click();
            device.pressBack();

            device.pressBack();
            device.pressHome();

            ufMenu_srch_App("Calculator");
            System.out.println("Opened the Calculator App");

            more_Opt.click();
            Thread.sleep(1000);
            help.click();System.out.println("Opened the Help Option");
            Thread.sleep(1000);
            article3.click();
            device.pressBack();

            device.pressBack();
            device.pressHome();

            ufMenu_srch_App("Calculator");
            System.out.println("Opened the Calculator App");

            more_Opt.click();
            Thread.sleep(1000);
            help.click();System.out.println("Opened the Help Option");
            Thread.sleep(1000);
            article4.click();
            device.pressBack();


            device.pressBack();
            device.pressHome();

            ufMenu_srch_App("Calculator");
            System.out.println("Opened the Calculator App");

            more_Opt.click();
            Thread.sleep(1000);
            help.click();System.out.println("Opened the Help Option");
            Thread.sleep(1000);
            help_send_Feedback.click();
            navigate_Up.click();
            close.click();
            Thread.sleep(1000);


            // Numeric to Advance and return Back
            device.pressBack();
            device.pressHome();

            ufMenu_srch_App("Calculator");
            System.out.println("Opened the Calculator App");

            Thread.sleep(1000);
            UiObject Advanced_Pad = new UiObject(new UiSelector()
                    .resourceId("com.google.android.calculator:id/pad_advanced"));
            Advanced_Pad.click();

            UiObject Number_Pad = new UiObject(new UiSelector()
                    .resourceId("com.google.android.calculator:id/pad_numeric"));
            Number_Pad.click();

            device.pressBack();
            device.pressHome();

            //Go To Idle
            device.pressBack();
            Thread.sleep(1000);
            device.pressHome();
            Thread.sleep(1000);
            System.out.println("***************** mst_Calculator PASSED *****************");

        }catch (Exception e){

            e.printStackTrace();
            System.out.println("***************** mst_Calculator FAILED *****************");
            device.pressHome();
            String path = "D:\\";
            //device.takeScreenshot();
        }
    }

}
