package com.example.aosp_a13_release_test;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiSelector;

import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

public class FT_Camera extends Utility_Functions{

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
    public void AOSP_13_video_Capture() throws Exception {

        int i;
        for(i=1;i<=1;i++){
            //Take_Video(20000);
            //Photo_Capture(2);
            //Delete_video_captured();
            //Delete_photo_Captured(2);
            Photo_Capture_front_cam(2);
            //Photo_Capture_with_options(2);
        }


    }


    private void Take_Video(int seconds) throws Exception {
        try {
            go_to_idle();

            ufMenu_srch_App("Camera");
            UiObject Swipe_to_switch_mode = new UiObject(new UiSelector()
                    .resourceId(AOSP_13_CAMERA_mode_RID));
            UiObject Switch_to_video_mode = new UiObject(new UiSelector()
                    .description(AOSP_13_CAMERA_switch_to_video_CD));
            UiObject click_on_Shutter = new UiObject(new UiSelector()
                    .description(AOSP_13_CAMERA_shutter_CD));

            Swipe_to_switch_mode.swipeRight(2);
            Log.i(TAG, "* Swiped right to Camera switch mode");
            Switch_to_video_mode.click();
            Log.i(TAG, "* Selected Video Mode");
            click_on_Shutter.click();
            Thread.sleep(seconds);
            click_on_Shutter.click();

            device.pressBack();
            go_to_idle();

        } catch (Exception e) {
            e.printStackTrace();
            go_to_idle();
        }
    }

    private void Photo_Capture(int no_photos) throws Exception {
        try {
            int i;
            go_to_idle();

            ufMenu_srch_App("Camera");
            UiObject Swipe_to_switch_mode = new UiObject(new UiSelector()
                    .resourceId(AOSP_13_CAMERA_mode_RID));
            UiObject Switch_to_photo_mode = new UiObject(new UiSelector()
                    .description(AOSP_13_CAMERA_switch_to_camera_CD));
            UiObject click_on_Shutter = new UiObject(new UiSelector()
                    .description(AOSP_13_CAMERA_shutter_CD));

            Swipe_to_switch_mode.swipeRight(2);
            Log.i(TAG, "* Swiped right to Camera switch mode");
            Switch_to_photo_mode.click();
            Log.i(TAG, "* Selected Video Mode");
            default_camera_settings();
            for (i = 1; i <= no_photos; i++) {
                click_on_Shutter.waitForExists(1000);
                click_on_Shutter.click();
                Log.i(TAG, "* Capture Photo : "+i);
            }

            device.pressBack();
            go_to_idle();

        } catch (Exception e) {
            e.printStackTrace();
            device.pressHome();
        }
    }

    private void Delete_video_captured() throws Exception {
        try {
            go_to_idle();
            ufMenu_srch_App("Camera");

            UiObject Swipe_to_switch_mode = new UiObject(new UiSelector()
                    .resourceId(AOSP_13_CAMERA_mode_RID));
            UiObject Switch_to_video_mode = new UiObject(new UiSelector()
                    .description(AOSP_13_CAMERA_switch_to_video_CD));
            UiObject click_on_Shutter = new UiObject(new UiSelector()
                    .description(AOSP_13_CAMERA_shutter_CD));
            UiObject thumbnail_view = new UiObject(new UiSelector()
                    .resourceId(AOSP_13_CAMERA_thumbnail_view_RID));
            UiObject Swipe_to_Gallary = new UiObject(new UiSelector()
                    .resourceId(AOSP_13_CAMERA_mode_RID));
            UiObject Delete = new UiObject(new UiSelector()
                    .resourceId(AOSP_13_CAMERA_Delete_video_Photo_RID));

            Swipe_to_switch_mode.swipeRight(2);
            Log.i(TAG, "Swiped right to Camera switch mode");
            Switch_to_video_mode.click();
            Log.i(TAG, "Selected Video Mode");
            click_on_Shutter.click();
            Log.i(TAG, "Tapped on Shutter to start record video and recording");
            Thread.sleep(5000);
            click_on_Shutter.click();
            Log.i(TAG, "Tapped on Shutter to stop video record");
            Log.i(TAG, "Checking Thumbnail view Exists then click else swipe to left to get the gallary for video");
            if (thumbnail_view.exists())
            {
                thumbnail_view.click();
                Log.i(TAG, "Clicking on Thumbnail view icon");

            }else {
                Swipe_to_Gallary.swipeLeft(3);
                //device.swipe(1000,1000,200,1000, 2);
                Log.i(TAG, "Swiped left to get the gallery");
            }
            Delete.waitForExists(2);
            Log.i(TAG, "Waiting for delete element to exists");
            Delete.click();
            Thread.sleep(1000);
            Log.i(TAG, "Click on Delete Video");

            device.pressBack();
            go_to_idle();

            //return true;
        }catch (Exception e) {
            e.printStackTrace();
            go_to_idle();
            Log.d(TAG, "Failed...");
            //return false;
        }
    }

    private void Delete_photo_Captured ( int no_photos) throws Exception {
        try {
            Log.i(TAG, "Test Scenario : Delete Captured Photos");
            int i;
            go_to_idle();
            Log.i(TAG, "Taking phone to Idle State");
            ufMenu_srch_App("Camera");
            UiObject Swipe_to_switch_mode = new UiObject(new UiSelector()
                    .resourceId(AOSP_13_CAMERA_mode_RID));
            UiObject Switch_to_photo_mode = new UiObject(new UiSelector()
                    .description(AOSP_13_CAMERA_switch_to_camera_CD));
            UiObject click_on_Shutter = new UiObject(new UiSelector()
                    .description(AOSP_13_CAMERA_shutter_CD));
            UiObject thumbnail_view = new UiObject(new UiSelector()
                    .resourceId(AOSP_13_CAMERA_thumbnail_view_RID));
            UiObject Swipe_to_Gallary = new UiObject(new UiSelector()
                    .resourceId(AOSP_13_CAMERA_mode_RID));
            UiObject Delete = new UiObject(new UiSelector()
                    .resourceId(AOSP_13_CAMERA_Delete_video_Photo_RID));

            Swipe_to_switch_mode.swipeRight(2);
            Log.i(TAG, "Swiped right to Camera switch mode");
            Switch_to_photo_mode.click();
            Log.i(TAG, "Select Photo mode");
            for (i = 1; i <= no_photos; i++) {
                click_on_Shutter.waitForExists(200);
                click_on_Shutter.click();
                Log.i(TAG, "Captured Photo " + i);
            }

            if (thumbnail_view.exists()) {
                thumbnail_view.click();
                Log.i(TAG, "Clicking on Thumbnail view icon");

            } else {
                Swipe_to_Gallary.swipeLeft(3);
                //device.swipe(1000,1000,200,1000, 2);
                Log.i(TAG, "Swiped left to get the gallery");
            }
            Delete.waitForExists(2);
            Log.i(TAG, "Waiting for delete element to exists");
            for (i = 1; i <= no_photos; i++) {
                Delete.click();
                Thread.sleep(1000);
                Log.i(TAG, "Click on Delete Photo " + i);
            }

            device.pressBack();
            go_to_idle();

            Log.i(TAG, "Test case Completed Successfully");

        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "Test Scenario : Delete Captured Photos Failed...!!!");
            go_to_idle();
        }

    }
    private void Photo_Capture_front_cam(int no_photos) throws Exception {
        try {
            int i;
            go_to_idle();

            ufMenu_srch_App("Camera");
            UiObject Swipe_to_switch_mode = new UiObject(new UiSelector()
                    .resourceId(AOSP_13_CAMERA_mode_RID));
            UiObject Switch_to_photo_mode = new UiObject(new UiSelector()
                    .description(AOSP_13_CAMERA_switch_to_camera_CD));
            UiObject click_on_Shutter = new UiObject(new UiSelector()
                    .description(AOSP_13_CAMERA_shutter_CD));
            UiObject Front_Cam= new UiObject(new UiSelector()
                    .description("Front camera"));
            UiObject Options= new UiObject(new UiSelector()
                    .description("Options"));
            UiObject Back_Cam= new UiObject(new UiSelector()
                    .description("Back camera"));

            Swipe_to_switch_mode.swipeRight(2);
            Log.i(TAG, "* Swipe right to switch Shoot Video or Capture Photo");
            Switch_to_photo_mode.click();
            Log.i(TAG, "* Select Capture Photo");
            default_camera_settings();
            for (i = 1; i <= no_photos; i++) {
                click_on_Shutter.waitForExists(1000);
                click_on_Shutter.click();
                Log.i(TAG, "* Capture Photo : "+i);
            }
            Options.click();
            if(Front_Cam.exists()){
                Log.i(TAG, "* Select Back Camera");
                Front_Cam.click();
            }else {
                Back_Cam.click();
                Log.i(TAG, "* Select Front Camera");
            }
            for (i = 1; i <= no_photos; i++) {
                click_on_Shutter.waitForExists(1000);
                click_on_Shutter.click();
                Log.i(TAG, "* Capture Photo : "+i);
            }

            device.pressBack();
            go_to_idle();

        } catch (Exception e) {
            e.printStackTrace();
            device.pressHome();
        }
    }

    private void Photo_Capture_with_options(int no_photos) throws Exception {
        try {
            int i;
            go_to_idle();

            ufMenu_srch_App("Camera");
            UiObject Swipe_to_switch_mode = new UiObject(new UiSelector()
                    .resourceId(AOSP_13_CAMERA_mode_RID));
            UiObject Switch_to_photo_mode = new UiObject(new UiSelector()
                    .description(AOSP_13_CAMERA_switch_to_camera_CD));
            UiObject click_on_Shutter = new UiObject(new UiSelector()
                    .description(AOSP_13_CAMERA_shutter_CD));
            UiObject Timer = new UiObject(new UiSelector()
                    .descriptionContains("Countdown timer"));
                    //.description("Countdown timer duration is set to 3 seconds")
                    //.description("Countdown timer duration is set to 10 seconds"));
            UiObject Options= new UiObject(new UiSelector()
                    .description("Options"));
            UiObject HDR = new UiObject(new UiSelector()
                    .descriptionContains("HDR")); // HDR on / HDR off
            UiObject Flash = new UiObject(new UiSelector()
                    .descriptionContains("Flash")); // Flash off / Flash auto / Flash on
            UiObject Grid = new UiObject(new UiSelector()
                    .descriptionContains("Grid")); // Grid lines on / Grid lines off
            UiObject get_Timer_CD_value = new UiObject(new UiSelector()
                    .resourceId("com.android.camera2:id/countdown_toggle_button"));
            UiObject get_grid_CD_Value = new UiObject(new UiSelector()
                    .resourceId("com.android.camera2:id/grid_lines_toggle_button"));
            UiObject get_HDR_CD_Value = new UiObject(new UiSelector()
                    .resourceId("com.android.camera2:id/hdr_plus_toggle_button"));
            UiObject get_Flash_CD_Value = new UiObject(new UiSelector()
                    .resourceId("com.android.camera2:id/flash_toggle_button"));
            Swipe_to_switch_mode.swipeRight(2);
            Log.i(TAG, "* Swipe right to switch Shoot Video or Capture Photo");
            Switch_to_photo_mode.click();
            Log.i(TAG, "* Select Capture Photo");
            Options.click();
            Log.i(TAG, "* Click Camera options to choose HDR, Timer & Flash");
            HDR.click();
            Log.i(TAG, "* Set "+ get_HDR_CD_Value.getContentDescription());
            Timer.click();
            Log.i(TAG, "* "+ get_Timer_CD_value.getContentDescription());
            Grid.click();
            Log.i(TAG, "* Set "+ get_grid_CD_Value.getContentDescription());
            if(Flash.isEnabled()){
                Flash.click();
                String flashvalue = get_Flash_CD_Value.getContentDescription();
                Log.i(TAG, "* Set "+ flashvalue);
            }else{
                Log.i(TAG, "* Flash is Disabled for Front Camera and HDR");
            }

            for (i = 1; i <= no_photos; i++) {
                click_on_Shutter.click();
                click_on_Shutter.waitForExists(11000);
                Log.i(TAG, "* Captured Photo : "+ i);
            }

            device.pressBack();
            go_to_idle();

        } catch (Exception e) {
            e.printStackTrace();
            device.pressHome();
        }
    }
    private void default_camera_settings() throws Exception{
        UiObject Options= new UiObject(new UiSelector()
                .description("Options"));
        UiObject Timer = new UiObject(new UiSelector()
                .descriptionContains("Countdown timer"));
        UiObject HDR = new UiObject(new UiSelector()
                .descriptionContains("HDR"));
        UiObject Flash = new UiObject(new UiSelector()
                .descriptionContains("Flash"));
        UiObject Grid = new UiObject(new UiSelector()
                .descriptionContains("Grid"));
        UiObject get_Timer_CD_value = new UiObject(new UiSelector()
                .resourceId("com.android.camera2:id/countdown_toggle_button"));
        UiObject get_grid_CD_Value = new UiObject(new UiSelector()
                .resourceId("com.android.camera2:id/grid_lines_toggle_button"));
        UiObject get_HDR_CD_Value = new UiObject(new UiSelector()
                .resourceId("com.android.camera2:id/hdr_plus_toggle_button"));
        UiObject get_Flash_CD_Value = new UiObject(new UiSelector()
                .resourceId("com.android.camera2:id/flash_toggle_button"));
            Options.click();
      while (!Objects.equals(get_Timer_CD_value.getContentDescription(), "Countdown timer is off")){
            Timer.click();
            Log.i(TAG, "* " +get_Timer_CD_value.getContentDescription());
      }
      while (!Objects.equals(get_grid_CD_Value.getContentDescription(), "Grid lines off")){
            Grid.click();
          Log.i(TAG, "* " +get_grid_CD_Value.getContentDescription());
      }
      while (!Objects.equals(get_HDR_CD_Value.getContentDescription(), "HDR off")){
            HDR.click();
          Log.i(TAG, "* " +get_HDR_CD_Value.getContentDescription());
      }
      while (!Objects.equals(get_Flash_CD_Value.getContentDescription(), "Flash off")){
            Flash.click();
          Log.i(TAG, "* " +get_Flash_CD_Value.getContentDescription());

      }

    }

}



