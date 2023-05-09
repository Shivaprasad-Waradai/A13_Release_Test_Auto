package com.example.aosp_a13_release_test;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiSelector;

import org.junit.Before;
import org.junit.Test;

public class FT_Phone extends Utility_Functions{
    private UiDevice device;
    private static final String TAG = "TEST";
    @Before
    public void setUp() throws Exception {

        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        device.pressHome();
        if (null == device) {
            Log.e(TAG, "* can't find the UiDevice");
            return;
        }
    }
    @Test
    public void AOSP_13_dial_a_number() throws Exception {
        try {
            int i;
            for (i = 1; i <= 1; i++) {
                 //dial_a_number_n_call("9945994183");
                // dial_a_number_n_save("9876543210", "Kallappa", "Badami");
               // Search_contact_n_call("Kallappa");
                Add_contacts_to_favorite("Ajinkya");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dial_a_number_n_call(String PhoneNo) throws Exception{
        UiObject dialer = new UiObject(new UiSelector()
                .resourceId(AIT_13_PHONE_Dialer_RID));
        UiObject Call = new UiObject(new UiSelector()
                .resourceId("com.google.android.dialer:id/dialpad_voice_call_button"));

        ufMenu_srch_App("Phone");
        dialer.click();
        int j = PhoneNo.length();
        for (int i = 0; i <= j - 1; i++) {
            String c1 = String.valueOf(PhoneNo.charAt(i));
            UiObject dial_number = new UiObject(new UiSelector()
                    .resourceId("com.google.android.dialer:id/dialpad_key_number").text(c1));
            dial_number.click();
        }
        Log.i(TAG, "* Phone Number " + PhoneNo);
        Call.click();
        Log.i(TAG,"* Click ON CALL");
        device.pressBack();
        go_to_idle();
    }
    public void dial_a_number_n_save(String PhoneNo, String fname, String lname) throws Exception{
        UiObject dialer = new UiObject(new UiSelector()
                .resourceId(AIT_13_PHONE_Dialer_RID));
        UiObject Fname = new UiObject(new UiSelector()
                .text(AOSP_13_CONTACTS_ENTER_FIRST_NAME_TXT));
        UiObject Lname = new UiObject(new UiSelector()
                .text(AOSP_13_CONTACTS_ENTER_LAST_NAME_TXT));
        UiObject Save = new UiObject(new UiSelector()
                .resourceId(AOSP_13_PHONE_save_BTN_RID));
        UiObject Create_Contact = new UiObject(new UiSelector()
                .text("Create new contact"));

        ufMenu_srch_App("Phone");
        dialer.click();
        int j = PhoneNo.length();
        for (int i = 0; i <= j - 1; i++) {
            String c1 = String.valueOf(PhoneNo.charAt(i));
            UiObject dial_number = new UiObject(new UiSelector()
                    .resourceId("com.google.android.dialer:id/dialpad_key_number").text(c1));
            dial_number.click();
        }
        Log.i(TAG, "* digit " +PhoneNo);
        Create_Contact.click();
        Log.i(TAG,"* Click on Create Contact");
        Fname.legacySetText(fname);
        Log.i(TAG,"* Enter First Name");
        Lname.legacySetText(lname);
        Log.i(TAG,"* Enter Last Name");
        Save.click();
        Log.i(TAG,"* Click ON Save");
        device.pressBack();
        go_to_idle();
    } //TSCA-3210 TSCA-3209
    public void Search_contact_n_call(String name) throws Exception{
        UiObject Phone_search_field = new UiObject(new UiSelector()

                .resourceId("com.google.android.dialer:id/open_search_bar_text_view"));
        UiObject click_floting_contcat = new UiObject(new UiSelector()
                .className("android.widget.TextView").index(1).textContains(name));
        UiObject Call = new UiObject(new UiSelector()
                .resourceId("com.google.android.dialer:id/call_to_action"));

        ufMenu_srch_App("Phone");
        Phone_search_field.click();
        Phone_search_field.legacySetText(name);
        click_floting_contcat.click();
        Log.i(TAG, "* Phone Number " + name);
        Call.click();
        Log.i(TAG,"* Click ON CALL");
        device.pressBack();
        go_to_idle();
    }
    public void Add_contacts_to_favorite(String name) throws Exception{
        UiObject Favoritescontact = new UiObject(new UiSelector()
                .resourceId("com.google.android.dialer:id/name").textContains(name));
        UiObject Addforites = new UiObject(new UiSelector()
                .descriptionContains("Add to favorites"));
        UiObject Phone_search_field = new UiObject(new UiSelector()
                .resourceId("com.google.android.dialer:id/open_search_bar_text_view"));
        UiObject click_floting_contcat = new UiObject(new UiSelector()
                .resourceId("com.google.android.dialer:id/photo").descriptionContains(name));
        UiObject Favorites = new UiObject(new UiSelector()
                .resourceId("com.google.android.dialer:id/navigation_bar_item_icon_view"));



        ufMenu_srch_App("Phone");
        Phone_search_field.click();
        Phone_search_field.legacySetText(name);
        click_floting_contcat.click();
        Log.i(TAG, "* Phone Number " + name);
        Addforites.click();
        Log.i(TAG,"* Selected contact added to fevorites" );
        device.pressBack();
        go_to_idle();
        ufMenu_srch_App("Phone");
        Favorites.click();
        Favoritescontact.click();


    }
}
