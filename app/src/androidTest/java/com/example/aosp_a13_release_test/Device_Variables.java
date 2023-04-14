package com.example.aosp_a13_release_test;

public class Device_Variables {

    /*
     * Resource ID - RID
     * class name - CN
     * content description - CD
     * index - IDX
     * text - TXT
     * xpath - XP
     *
     */

    //****** ANDROID AOSP 13 - Home Screen and Main Menu App list Elements *******

    String AOSP_13_HOME_SCREEN_G_SEARCH_CONTAINER_RID = "com.google.android.apps.nexuslauncher:id/search_container_hotseat"; //TXT - Search
    String AOSP_13_HOME_SCREEN_G_SEARCH_CONTAINER_MIC_RID = "com.google.android.apps.nexuslauncher:id/mic_icon"; //TXT - Voice search
    String AOSP_13_HOME_SCREEN_G_SEARCH_CONTAINER_G_LENS_RID = "com.google.android.apps.nexuslauncher:id/lens_icon"; // TXT - Google Lens

    String AOSP_13_HOME_SCREEN_PAGE_INDICATOR_RID = "com.google.android.apps.nexuslauncher:id/page_indicator"; // WHEN Multiple PAGES in the HOME SCREEN
    String AOSP_13_HOME_SCREEN_HOT_SEAT_APPS_CN = "android.view.ViewGroup"; // hot Seat Icons, INDEX 0 - 4
    String AOSP_13_HOME_SCREEN_HOME_CN = "android.view.View"; //TXT - Home
    String AOSP_13_HOME_SCREEN_WRKSPACE_RID = "com.google.android.apps.nexuslauncher:id/workspace";
    String AOSP_13_APP_MENU_G_SEARCH_RID = "com.google.android.apps.nexuslauncher:id/search_container_all_apps";

    String AOSP_13_N6_1_APP_MENU_SEARCH_RID = "com.android.launcher3:id/search_container_all_apps";
    String AOSP_13_APP_MENU_G_SEARCH_INPUT_RID = "com.google.android.apps.nexuslauncher:id/input"; // TXT - Search apps, web and more

    //*********************Android 13 AOSP CAMERA **************************
    String AOSP_13_SETTINGS_Scroll_RID = "com.android.settings:id/settings_homepage_container";
    String AOSP_13_CAMERA_mode_RID = "com.android.camera2:id/mode_options_overlay";
    String AOSP_13_CAMERA_opt_CD = "Options";
    String AOSP_13_CAMERA_shutter_CD = "Shutter";
    String AOSP_13_CAMERA_thumbnail_view_RID = "com.android.camera2:id/rounded_thumbnail_view";
    String AOSP_13_CAMERA_switch_to_camera_CD = "Switch to Camera Mode";
    String AOSP_13_CAMERA_switch_to_video_CD = "Switch to Video Camera";
    String AOSP_13_CAMERA_Settings_CD = "Settings";
    String AOSP_13_CAMERA_Set_Resolution_Quality_TXT = "Resolution & quality";
    String AOSP_13_CAMERA_Set_save_location_Toggle_TXT = "Save location";
    String AOSP_13_CAMERA_Set_Advanced_TXT = "Advanced";
    String AOSP_13_CAMERA_Video_Play_Button_RID = "com.android.camera2:id/play_button";
    String AOSP_13_CAMERA_Delete_video_Photo_RID = "com.android.camera2:id/filmstrip_bottom_control_delete";

    //******************* CONTACTS ***************************

    String AOSP_13_CONTACTS_search_cntcts_TXT = "Search contacts";
    String AOSP_13_CONTACTS_search_enter_cntcts_RID ="com.google.android.contacts:id/open_search_bar_text_view";
    String AOSP_13_CONTACTS_Search_floating_contact_RID ="com.google.android.contacts:id/cliv_name_textview";// need to use index and text contains
    String AOSP_13_CONTACTS_s_navi_drawer_CD = "Open navigation drawer";

    String AOSP_13_CONTACTS_s_more_opt_CD = "More options";
    String AOSP_13_CONTACTS_s_opt_customise_view_TXT = "Customise view";

    String AOSP_13_CONTACTS_filter_phone_cntcts_TXT = "Phone contacts";
    String AOSP_13_CONTACTS_filter_email_cntcts_TXT = "Email contacts";

    String AOSP_13_CONTACTS_s_gmail_account_RID = "com.google.android.contacts:id/og_apd_ring_view";
    String AOSP_13_CONTACTS_add_contact_btn_CD = "Create contact";
    String AOSP_13_CONTACTS_ENTER_FIRST_NAME_TXT = "First name";
    String AOSP_13_CONTACTS_ENTER_LAST_NAME_TXT = "Last name";

    String AOSP_13_CONTACTS_ENTER_PHONE_NO_TXT = "Phone";//Enter Mobile NumbeR
    String AOSP_13_CONTACTS_EDIT_Scroller_RID = "com.google.android.contacts:id/contact_editor_scroller";
    String AOSP_13_CONTACTS_SAVE_BTN_RID = "com.google.android.contacts:id/toolbar_button";
    String AOSP_13_CONTACTS_TAB_contacts_CD = "Contacts";
    String AOSP_13_CONTACTS_TAB_fix_manage_CD = "Fix & manage";

    String AOSP_13_CONTACTS_F_M_merge_TXT = "Merge and fix";
    String AOSP_13_CONTACTS_F_M_restore_cntcts_TXT = "Restore contacts";
    String AOSP_13_CONTACTS_F_M_import_frm_file_TXT = "Import from file";
    String AOSP_13_CONTACTS_F_M_bin_TXT = "Bin";
    String AOSP_13_CONTACTS_F_M_Settings_TXT = "Settings";
    String AOSP_13_CONTACTS_F_M_blocked_nos_TXT = "Blocked numbers";
    String AOSP_13_CONTACTS_Blkd_nos_unknown_Toggle_TXT = "Unknown";
    String AOSP_13_CONTACTS_add_blocked_nos_RID = "com.android.server.telecom:id/add_blocked";
    String AOSP_13_CONTACTS_popup_input_block_nos_RID = "com.android.server.telecom:id/add_blocked_number";
    String AOSP_13_CONTACTS_popup_btn_Block_nos_TXT = "Block";
    String AOSP_13_CONTACTS_popup_btn_Cancel_nos_TXT = "Cancel";

    //************************ PHONE ************************
    String AIT_13_PHONE_search_RID = "com.google.android.dialer:id/open_search_bar";//com.google.android.dialer:id/open_search_bar_text_view
    String AIT_13_PHONE_search_mic_RID = "com.google.android.dialer:id/action_voice";

    String AIT_13_PHONE_more_opt_CN = "More options";
    String AIT_13_PHONE_opt_History_TXT = "Call history";
    String AIT_13_PHONE_opt_Settings_TXT = "Settings";
    String AIT_13_PHONE_opt_feedback_TXT = "Help and feedback";

    String AIT_13_PHONE_Dialer_RID = "com.google.android.dialer:id/dialpad_fab";

    String AIT_13_PHONE_TAB_Favourites_CN = "Favourites";
    String AIT_13_PHONE_TAB_Recent_CN = "Recent";
    String AIT_13_PHONE_TAB_Contacts_CN = "Contacts";
    String AOSP_13_PHONE_save_BTN_RID = "com.google.android.contacts:id/save_button";
//********************** SETTINGS **********************

    String AOSP_13_SETTINGS_NW_internet_TXT = "Network & internet";
    String AOSP_13_SETTINGS_conneted_devices_TXT = "Connected devices";
    String AOSP_13_SETTINGS_apps_TXT = "Apps";
    String AOSP_13_SETTINGS_notifications_TXT = "Notifications";
    String AOSP_13_SETTINGS_battery_TXT = "Battery";
    String AOSP_13_SETTINGS_storage_TXT = "Storage";
    String AOSP_13_SETTINGS_Snd_vib_TXT = "Sound & vibration";
    String AOSP_13_SETTINGS_display_TXT = "Display";
    String AOSP_13_SETTINGS_wallpaper_TXT = "Wallpaper";
    String AOSP_13_SETTINGS_accessibility_TXT = "Accessibility";
    String AOSP_13_SETTINGS_Security_TXT = "Security";
    String AOSP_13_SETTINGS_Privacy_TXT = "Privacy";
    String AOSP_13_SETTINGS_Location_TXT = "Location";
    String AOSP_13_SETTINGS_safety_emergency_TXT = "Safety & emergency";
    String AOSP_13_SETTINGS_paswrd_accs_TXT = "Passwords & accounts";
    String AOSP_13_SETTINGS_Digi_wellbeing_TXT = "Digital Wellbeing & parental controls";
    String AOSP_13_SETTINGS_Google_TXT = "Google";
    String AOSP_13_SETTINGS_system_TXT = "System";
    String AOSP_13_SETTINGS_About_phone_TXT = "About phone";

}
