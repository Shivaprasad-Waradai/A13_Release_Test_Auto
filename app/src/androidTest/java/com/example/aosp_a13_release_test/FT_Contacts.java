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
    public void AOSP_13_Add_delete_contacts() throws Exception {
        try {
            int i;
            for (i = 1; i <= 1; i++) {
                addContacts("Nokia", "Android", "0000000013");
                editContact("Nokia","AOSP");
                deleteContact("AOSP "+"Android");
                deleteAllContact();
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
}
