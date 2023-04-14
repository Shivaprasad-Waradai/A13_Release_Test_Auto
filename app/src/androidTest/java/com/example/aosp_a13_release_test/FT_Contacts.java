package com.example.aosp_a13_release_test;

import android.view.View;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiSelector;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class FT_Contacts extends Utility_Functions{

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
    public void AOSP_13_contacts() throws Exception {
        try {
            int i;
            for (i = 1; i <= 1; i++) {
                clear_Recent_Apps();
                //add_label("Team C");
                //addContacts("Nokia", "Android", "0000000013");
                //addContacts_withEmail("Nokia", "Android", "0000000013", "abc@gmail.com");
                //editContact("Nokia","AOSP");
                //send_sms_from_contacts("Virat Kohli", "Hi Virat - The Batsman");
                //send_email_from_contacts("Kallappa Badami", "Subject test mail", "Test Email body");
                //deleteContact("AOSP "+"Android");
                //deleteAllContact();
                //call_from_contacts("Kallappa Badami");
                //add_contact_wedget("Kallappa Badami");
                //delete_contact_wedget("Kallappa");
                //Change_contact_name_display_format();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addContacts(String fname, String lname, String Pno)throws Exception{
        UiObject AddBtn = new UiObject(new UiSelector()
                .description(AOSP_13_CONTACTS_add_contact_btn_CD));
        UiObject Fname = new UiObject(new UiSelector()
                .text(AOSP_13_CONTACTS_ENTER_FIRST_NAME_TXT));
        UiObject Lname = new UiObject(new UiSelector()
                .text(AOSP_13_CONTACTS_ENTER_LAST_NAME_TXT));
        UiObject PhoneNo = new UiObject(new UiSelector()
                .text(AOSP_13_CONTACTS_ENTER_PHONE_NO_TXT));
        UiObject Save = new UiObject(new UiSelector()
                .resourceId(AOSP_13_CONTACTS_SAVE_BTN_RID));
        UiObject Scroller = new UiObject(new UiSelector()
                .resourceId(AOSP_13_CONTACTS_EDIT_Scroller_RID));

        ufMenu_srch_App("Contacts");

        AddBtn.click();
        Log.i(TAG,"* Click Add Contact Button");
        Fname.setText(fname);
        Log.i(TAG,"* Enter First Name");
        Lname.setText(lname);
        Log.i(TAG,"* Enter Last Name");
        Scroller.swipeUp(2);
        Log.i(TAG,"* Scroll up to add Number");
        PhoneNo.setText(Pno);
        Log.i(TAG,"* Enter phone number");
        Save.click();
        Log.i(TAG,"* Enter First Name");

        device.pressBack();
        go_to_idle();

    }
    public void addContacts_withEmail(String fname, String lname, String Pno, String email)throws Exception{
        UiObject AddBtn = new UiObject(new UiSelector()
                .description(AOSP_13_CONTACTS_add_contact_btn_CD));
        UiObject Fname = new UiObject(new UiSelector()
                .text(AOSP_13_CONTACTS_ENTER_FIRST_NAME_TXT));
        UiObject Lname = new UiObject(new UiSelector()
                .text(AOSP_13_CONTACTS_ENTER_LAST_NAME_TXT));
        UiObject PhoneNo = new UiObject(new UiSelector()
                .text(AOSP_13_CONTACTS_ENTER_PHONE_NO_TXT));
        UiObject Save = new UiObject(new UiSelector()
                .resourceId(AOSP_13_CONTACTS_SAVE_BTN_RID));
        UiObject Scroller = new UiObject(new UiSelector()
                .resourceId(AOSP_13_CONTACTS_EDIT_Scroller_RID));
        UiObject email_id = new UiObject(new UiSelector()
                .text("Email"));

        ufMenu_srch_App("Contacts");

        AddBtn.click();
        Log.i(TAG,"* Click Add Contact Button");
        Fname.setText(fname);
        Log.i(TAG,"* Enter First Name");
        Lname.setText(lname);
        Log.i(TAG,"* Enter Last Name");
        Scroller.swipeUp(2);
        Log.i(TAG,"* Scroll up to add Number");
        PhoneNo.setText(Pno);
        Log.i(TAG,"* Enter phone number");
        email_id.legacySetText(email);
        Log.i(TAG,"* Enter email Id");
        Save.click();
        Log.i(TAG,"* Click on Save");

        device.pressBack();
        go_to_idle();

    }
    public void deleteContact(String fname)throws Exception{
        UiObject SrchCntct = new UiObject(new UiSelector()
                .text(AOSP_13_CONTACTS_search_cntcts_TXT));
        UiObject EnterCntatName = new UiObject(new UiSelector()
                .resourceId(AOSP_13_CONTACTS_search_enter_cntcts_RID));
        UiObject first_floating_contcat = new UiObject(new UiSelector()
                .resourceId(AOSP_13_CONTACTS_Search_floating_contact_RID).index(1).textContains(fname));
        UiObject More_opt = new UiObject(new UiSelector()
                .description("More options"));
        UiObject delete = new UiObject(new UiSelector()
                .text("Delete"));
        UiObject popup_delete = new UiObject(new UiSelector()
                .text("Move to Trash"));
        UiObject No_contacts_yet = new UiObject(new UiSelector()
                .text("No contacts yet"));
        UiObject No_results = new UiObject(new UiSelector()
                .text("No results"));
        ufMenu_srch_App("Contacts");
        if (No_contacts_yet.exists()){
            Log.i(TAG, "No Contacts available to delete");
        }else {
            SrchCntct.click();
            Log.i(TAG,"* Go to Search Contact");
            EnterCntatName.legacySetText(fname);
            Log.i(TAG,"* Enter Contact name to Search :" + fname);
            if (No_results.exists()){
                Log.i(TAG,"No results found for the searched contact : " + fname);
            }else if(first_floating_contcat.getText().equals(fname)) {
                first_floating_contcat.click();
                Log.i(TAG,"* Select 1st Floating Contact in Search list");
                More_opt.click();
                Log.i(TAG,"* Click on More Option in selected contact");
                delete.click();
                Log.i(TAG,"* Click on Delete");
                popup_delete.click();
                Log.i(TAG,"* Again click on Move to trash");
            }else{
                Log.i(TAG, "No Matching Contacts available to delete");
            }
        }
        device.pressBack();
        go_to_idle();

    }
    public void editContact(String fname, String newFname)throws Exception{
        UiObject SrchCntct = new UiObject(new UiSelector()
                .text(AOSP_13_CONTACTS_search_cntcts_TXT));
        UiObject EnterCntatName = new UiObject(new UiSelector()
                .resourceId(AOSP_13_CONTACTS_search_enter_cntcts_RID));
        UiObject first_floating_contcat = new UiObject(new UiSelector()
                .resourceId(AOSP_13_CONTACTS_Search_floating_contact_RID).index(1).textContains(fname));
        UiObject Fname = new UiObject(new UiSelector()
                .text(fname));
        UiObject Edit_contact = new UiObject(new UiSelector()
                .description("Edit contact"));
        UiObject delete = new UiObject(new UiSelector()
                .text("Delete"));
        UiObject Save = new UiObject(new UiSelector()
                .text("Save"));
        UiObject No_contacts_yet = new UiObject(new UiSelector()
                .text("No contacts yet"));
        UiObject No_results = new UiObject(new UiSelector()
                .text("No results"));
        ufMenu_srch_App("Contacts");
        if (No_contacts_yet.exists()){
            Log.i(TAG, "No Contacts available to delete");
        }else {
            SrchCntct.click();
            Log.i(TAG,"* Go to Search Contact");
            EnterCntatName.legacySetText(fname);
            Log.i(TAG,"* Enter Contact name to Search :" + fname);
            if (No_results.exists()){
                Log.i(TAG,"No results found for the searched contact : " + fname);
            }else {
                first_floating_contcat.click();
                Log.i(TAG,"* Select 1st Floating Contact in Search list");
                Edit_contact.click();
                Log.i(TAG,"* Click on More Option in selected contact");
                //Fname.clearTextField();
                Fname.setText(newFname);
                Log.i(TAG,"* Click on Delete");
                Save.click();
                Log.i(TAG,"* Again on Delete to Confirm");
            }
        }

        device.pressBack();
        go_to_idle();

    }
    public void call_from_contacts(String name)throws Exception{
        UiObject SrchCntct = new UiObject(new UiSelector()
                .text(AOSP_13_CONTACTS_search_cntcts_TXT));
        UiObject EnterCntatName = new UiObject(new UiSelector()
                .resourceId(AOSP_13_CONTACTS_search_enter_cntcts_RID));
        UiObject first_floating_contcat = new UiObject(new UiSelector()
                .resourceId(AOSP_13_CONTACTS_Search_floating_contact_RID).index(1).textContains(name));
        UiObject call = new UiObject(new UiSelector()
                .text("Call"));
        UiObject Send_key = new UiObject(new UiSelector()
                .resourceId("com.google.android.apps.messaging:id/send_message_button_icon"));
        UiObject Save = new UiObject(new UiSelector()
                .text("Save"));
        UiObject No_contacts_yet = new UiObject(new UiSelector()
                .text("No contacts yet"));
        UiObject No_results = new UiObject(new UiSelector()
                .text("No results"));
        UiObject x_clear = new UiObject(new UiSelector()
                .resourceId("com.google.android.contacts:id/og_apd_internal_image_view"));
        ufMenu_srch_App("Contacts");
        if (No_contacts_yet.exists()){
            Log.i(TAG, "No Contacts available to delete");
        }else {
            SrchCntct.click();
            Log.i(TAG,"* Go to Search Contact");
            if(x_clear.exists()){
                x_clear.click();
            }
            Log.i(TAG,"* Go to Search Contact");
            EnterCntatName.legacySetText(name);
            Log.i(TAG,"* Enter Contact name to Search :" + name);
            if (No_results.exists()){
                Log.i(TAG,"No results found for the searched contact : " + name);
            }else {
                first_floating_contcat.click();
                Log.i(TAG,"* Select 1st Floating Contact in Search list");
                call.click();
                Log.i(TAG,"* Select Call ");
            }
        }
        device.pressBack();
        device.pressBack();
        go_to_idle();

    }
    public void send_sms_from_contacts(String name, String shortsms)throws Exception{
        UiObject SrchCntct = new UiObject(new UiSelector()
                .text(AOSP_13_CONTACTS_search_cntcts_TXT));
        UiObject EnterCntatName = new UiObject(new UiSelector()
                .resourceId(AOSP_13_CONTACTS_search_enter_cntcts_RID));
        UiObject first_floating_contcat = new UiObject(new UiSelector()
                .resourceId(AOSP_13_CONTACTS_Search_floating_contact_RID).index(1).textContains(name));
        UiObject txt_sms = new UiObject(new UiSelector()
                .text("Text"));
        UiObject Compose_sms = new UiObject(new UiSelector()
                .resourceId("com.google.android.apps.messaging:id/compose_message_text"));
        UiObject Send_key = new UiObject(new UiSelector()
                .resourceId("com.google.android.apps.messaging:id/send_message_button_icon"));
        UiObject Save = new UiObject(new UiSelector()
                .text("Save"));
        UiObject No_contacts_yet = new UiObject(new UiSelector()
                .text("No contacts yet"));
        UiObject No_results = new UiObject(new UiSelector()
                .text("No results"));
        ufMenu_srch_App("Contacts");
        if (No_contacts_yet.exists()){
            Log.i(TAG, "No Contacts available to delete");
        }else {
            SrchCntct.click();
            Log.i(TAG,"* Go to Search Contact");
            EnterCntatName.legacySetText(name);
            Log.i(TAG,"* Enter Contact name to Search :" + name);
            if (No_results.exists()){
                Log.i(TAG,"No results found for the searched contact : " + name);
            }else {
                first_floating_contcat.click();
                Log.i(TAG,"* Select 1st Floating Contact in Search list");
                txt_sms.click();
                Log.i(TAG,"* Select Text to navigate to Chat window");
                Compose_sms.click();
                Compose_sms.legacySetText(shortsms);
                Log.i(TAG,"* Write short message ");
                //Fname.clearTextField();
                Send_key.click();
                Log.i(TAG,"* Click on Send Key");
                Thread.sleep(2000);
            }
        }

        device.pressBack();
        go_to_idle();

    }
    public void send_email_from_contacts(String name, String Sub, String mailbody)throws Exception{
        UiObject SrchCntct = new UiObject(new UiSelector()
                .text(AOSP_13_CONTACTS_search_cntcts_TXT));
        UiObject EnterCntatName = new UiObject(new UiSelector()
                .resourceId(AOSP_13_CONTACTS_search_enter_cntcts_RID));
        UiObject first_floating_contcat = new UiObject(new UiSelector()
                .resourceId(AOSP_13_CONTACTS_Search_floating_contact_RID).index(1).textContains(name));
        UiObject Email = new UiObject(new UiSelector()
                .text("Email"));
        UiObject Subject = new UiObject(new UiSelector()
                .resourceId("com.google.android.gm:id/subject"));
        UiObject Email_body = new UiObject(new UiSelector()
                .className("android.webkit.WebView").index(0));
        UiObject filter_Email_contacts = new UiObject(new UiSelector()
                .text(AOSP_13_CONTACTS_filter_email_cntcts_TXT));
        UiObject No_contacts_yet = new UiObject(new UiSelector()
                .text("No contacts yet"));
        UiObject No_results = new UiObject(new UiSelector()
                .text("No results"));
        UiObject Send = new UiObject(new UiSelector()
                .resourceId("com.google.android.gm:id/send"));


        ufMenu_srch_App("Contacts");
        if (No_contacts_yet.exists()){
            Log.i(TAG, "No Contacts available to delete");
        }else {
            filter_Email_contacts.click();
            Log.i(TAG,"* Filter Email Contacts");
            SrchCntct.click();
            Log.i(TAG,"* Go to Search Contact");
            EnterCntatName.legacySetText(name);
            Log.i(TAG,"* Enter Contact name to Search :" + name);
            if (No_results.exists()){
                Log.i(TAG,"No results found for the searched contact : " + name);
            }else {
                first_floating_contcat.click();
                Log.i(TAG,"* Select 1st Floating Contact in Search list");
                Email.click();
                Log.i(TAG,"* Select Text to navigate to Chat window");
                Subject.click();
                Subject.legacySetText(Sub);
                Log.i(TAG,"* Write Subject ");
                Email_body.click();
                Email_body.legacySetText(mailbody);
                Log.i(TAG,"* Write mail body ");
                //Fname.clearTextField();
                Send.click();
                Log.i(TAG,"* Click on Send Key");
                Thread.sleep(2000);
            }
        }
        device.pressBack();
        filter_Email_contacts.click();
        device.pressBack();
        device.pressBack();
        go_to_idle();
        Thread.sleep(2000);

    }
    public void deleteAllContact()throws Exception{
        UiObject delete = new UiObject(new UiSelector()
                .description("Delete"));
        UiObject option_select_all = new UiObject(new UiSelector()
                .text("Select all"));
        UiObject More_opt = new UiObject(new UiSelector()
                .description("More options"));
        UiObject move_to_trash = new UiObject(new UiSelector()
                .text("Move to Trash"));
        UiObject No_contacts_yet = new UiObject(new UiSelector()
                .text("No contacts yet"));


        ufMenu_srch_App("Contacts");
        if (No_contacts_yet.exists()){
            Log.i(TAG,"There is no Contacts to Delete");
        }else {
            More_opt.click();
            Log.i(TAG,"* Click More Options");
            option_select_all.click();
            Log.i(TAG,"* Click on Select All");
            delete.click();
            Log.i(TAG,"* Click on Delete");
            move_to_trash.click();
            Log.i(TAG,"* Click on move to trash");
            if (No_contacts_yet.exists()){
                Log.i(TAG, "All Contacts Deleted Successfuly");
            }
        }

        device.pressBack();
        go_to_idle();

    }
    public void add_contact_wedget(String fname)throws Exception{
        UiObject SrchCntct = new UiObject(new UiSelector()
                .text(AOSP_13_CONTACTS_search_cntcts_TXT));
        UiObject EnterCntatName = new UiObject(new UiSelector()
                .resourceId(AOSP_13_CONTACTS_search_enter_cntcts_RID));
        UiObject first_floating_contcat = new UiObject(new UiSelector()
                .resourceId(AOSP_13_CONTACTS_Search_floating_contact_RID).index(1).textContains(fname));
        UiObject More_opt = new UiObject(new UiSelector()
                .description("More options"));
        UiObject Add_to_home_screen = new UiObject(new UiSelector()
                .text("Add to Home screen"));
        UiObject popup_add_to_home_screen = new UiObject(new UiSelector()
                .text("ADD TO HOME SCREEN"));
        UiObject No_contacts_yet = new UiObject(new UiSelector()
                .text("No contacts yet"));
        UiObject No_results = new UiObject(new UiSelector()
                .text("No results"));
        UiObject x_clear = new UiObject(new UiSelector()
                .resourceId("com.google.android.contacts:id/og_apd_internal_image_view"));

        ufMenu_srch_App("Contacts");

        if (No_contacts_yet.exists()){
            Log.i(TAG, "* No Contacts available to delete");
        }else {
            SrchCntct.click();
            Log.i(TAG,"* Go to Search Contact");
            if(x_clear.exists()){
                x_clear.click();
            }
                EnterCntatName.legacySetText(fname);
            Log.i(TAG,"* Enter Contact name to Search :" + fname);
            if (No_results.exists()){
                Log.i(TAG,"* No results found for the searched contact : " + fname);
            }else if(first_floating_contcat.getText().equals(fname)) {
                first_floating_contcat.click();
                Log.i(TAG,"* Select 1st Floating Contact in Search list");
                More_opt.click();
                Log.i(TAG,"* Click on More Option in selected contact");
                Add_to_home_screen.click();
                Log.i(TAG,"* Click on Add to home screen");
                popup_add_to_home_screen.click();
                Log.i(TAG,"* Again click on Add to home screen");
            }else{
                Log.i(TAG, "* No Matching Contacts available to add to home screen");
            }
        }
        device.pressBack();
        go_to_idle();

    }
    public void delete_contact_wedget(String name) throws Exception{
        UiObject contct = new UiObject(new UiSelector()
                .descriptionContains(name));
        UiObject Home_screen = new UiObject(new UiSelector()
                .resourceId("com.google.android.apps.nexuslauncher:id/page_indicator"));
        Home_screen.swipeLeft(50);
        Thread.sleep(1000);
        contct.waitForExists(2000);
        contct.dragTo(535,165,50);
        device.pressHome();
    }
    public void Change_contact_name_display_format()throws Exception{
        UiObject google_Acc_symbol = new UiObject(new UiSelector()
                .resourceId("com.google.android.contacts:id/og_apd_internal_image_view"));
        UiObject Contact_App_Setting = new UiObject(new UiSelector()
                .text("Contacts app settings"));
        UiObject Name_format = new UiObject(new UiSelector()
                .text("Name format"));
        UiObject First_name_first = new UiObject(new UiSelector()
                .text("First name first"));
        UiObject Last_name_first = new UiObject(new UiSelector()
                .text("Last name first"));
        UiObject Contcat_name = new UiObject(new UiSelector()
                .resourceId("com.google.android.contacts:id/cliv_name_textview"));

        ufMenu_srch_App("Contacts");

        google_Acc_symbol.click();
        Contact_App_Setting.click();
        Name_format.click();

        if (First_name_first.isChecked()){
            Log.i(TAG, "* FIRST NAME first is checked and changing it to LAST NAME first");
            Last_name_first.click();
            device.pressBack();
            Contcat_name.waitForExists(1000);
            if (Contcat_name.getText().contains(", ")){
                Log.i(TAG, "* Name format is changed to LAST NAME first successfully");
            }

        }else {
            Log.i(TAG, "* LAST NAME first is checked and changing it to FIRST NAME first");
            First_name_first.click();
            device.pressBack();
            Contcat_name.waitForExists(1000);
            if (Contcat_name.getText().contains(" ")) {
                Log.i(TAG, "* Name format is changed to FIRST NAME first successfully");
            }
        }
        Log.i(TAG, "* after test changing it to default settings");
        google_Acc_symbol.click();
        Contact_App_Setting.click();
        Name_format.click();
        First_name_first.click();
        device.pressBack();
        go_to_idle();
    }

    public void add_label(String label)throws Exception{
        UiObject Navigation_drawer = new UiObject(new UiSelector()
                .description(AOSP_13_CONTACTS_s_navi_drawer_CD));
        UiObject Ok = new UiObject(new UiSelector()
                .text("OK"));
        UiObject Create_label = new UiObject(new UiSelector()
                .text("Create label"));
        UiObject Label_name = new UiObject(new UiSelector()
                .text("Label name"));
        UiObject Select_label = new UiObject(new UiSelector()
                .text(label));
        UiObject More_opt = new UiObject(new UiSelector()
                .description("More options"));
        UiObject Rename_label = new UiObject(new UiSelector()
                .text("Rename label"));
        UiObject New_label_name = new UiObject(new UiSelector()
                .text(label));


        ufMenu_srch_App("Contacts");

        Navigation_drawer.click();
        Create_label.waitForExists(2000);
        Create_label.click();
        Label_name.setText(label);
        Ok.click();
        device.pressBack();
        Navigation_drawer.click();
        Select_label.click();
        More_opt.click();
        Rename_label.waitForExists(2000);
        Rename_label.click();
        New_label_name.setText("New "+label);
        Ok.click();
        device.pressBack();
        go_to_idle();
    }
    public void delete_label(String label)throws Exception{

        try{
            UiObject Navigation_drawer = new UiObject(new UiSelector()
                    .description(AOSP_13_CONTACTS_s_navi_drawer_CD));
            UiObject Ok = new UiObject(new UiSelector()
                    .text("OK"));
            UiObject Create_label = new UiObject(new UiSelector()
                    .resourceId("com.google.android.contacts:id/design_menu_item_text"));
            UiObject Label_name = new UiObject(new UiSelector()
                    .text("Label name"));
            ufMenu_srch_App("Contacts");

            Navigation_drawer.click();
            Create_label.click();
            Label_name.setText(label);
            Ok.click();

        }catch (Exception e){
            device.pressBack();
            go_to_idle();
        }

    }

    /*public void Share_contact_info_via_Message(String mobileNo, String Contactname) throws Exception{
        UiObject SrchCntct = new UiObject(new UiSelector()
                .text(AOSP_13_CONTACTS_search_cntcts_TXT));
        UiObject EnterCntatName = new UiObject(new UiSelector()
                .resourceId(AOSP_13_CONTACTS_search_enter_cntcts_RID));
        UiObject first_floating_contcat = new UiObject(new UiSelector()
                .resourceId(AOSP_13_CONTACTS_Search_floating_contact_RID).index(1).textContains(Contactname));
        UiObject More_opt = new UiObject(new UiSelector()
                .description("More options"));
        UiObject Share = new UiObject(new UiSelector()
                .text("Share"));
        UiObject Continue = new UiObject(new UiSelector()
                .text("Continue"));
        UiObject Messages_App = new UiObject(new UiSelector()
                .text("Messages"));
        UiObject newMessage = new UiObject(new UiSelector()
                .text("New message"));
        UiObject t = new UiObject(new UiSelector()
                .text("New message"));
        UiObject No_contacts_yet = new UiObject(new UiSelector()
                .text("No contacts yet"));
        UiObject No_results = new UiObject(new UiSelector()
                .text("No results"));
        ufMenu_srch_App("Contacts");
        if (No_contacts_yet.exists()){
            Log.i(TAG, "No Contacts available to delete");
        }else {
            SrchCntct.click();
            Log.i(TAG,"* Go to Search Contact");
            EnterCntatName.legacySetText();
            Log.i(TAG,"* Enter Contact name to Search :" + fname);
            if (No_results.exists()){
                Log.i(TAG,"No results found for the searched contact : " + fname);
            }else if(first_floating_contcat.getText().equals(fname)) {
                first_floating_contcat.click();
                Log.i(TAG,"* Select 1st Floating Contact in Search list");
                More_opt.click();
                Log.i(TAG,"* Click on More Option in selected contact");
                delete.click();
                Log.i(TAG,"* Click on Delete");
                popup_delete.click();
                Log.i(TAG,"* Again click on Move to trash");
            }else{
                Log.i(TAG, "No Matching Contacts available to delete");
            }
        }
        device.pressBack();
        go_to_idle();
    }

     */
}
