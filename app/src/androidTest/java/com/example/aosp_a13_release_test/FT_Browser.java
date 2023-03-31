package com.example.aosp_a13_release_test;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiSelector;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class FT_Browser extends Utility_Functions{

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
    public void AOSP_13_openBrowser() throws Exception {
        try {
            int i;
            for (i = 1; i <= 1; i++) {
                openBrowser_navigateToSite("www.google.com");
                openBrowser_navigateToSite("www.facebook.com");
                openBrowser_navigateToSite("www.bing.com");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void openBrowser_navigateToSite(String SiteName) throws Exception{
        UiObject Searchbar = new UiObject(new UiSelector()
                .resourceId("com.android.chrome:id/search_box_text"));
        UiObject addressbar = new UiObject(new UiSelector()
                .resourceId("com.android.chrome:id/url_bar"));
        ufMenu_srch_App("Chrome");
        Searchbar.click();
        addressbar.legacySetText(SiteName);

        device.pressEnter();

        device.pressBack();
        go_to_idle();

    }


}
