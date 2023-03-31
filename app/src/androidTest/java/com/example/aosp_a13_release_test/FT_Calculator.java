package com.example.aosp_a13_release_test;


import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiSelector;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class FT_Calculator extends Utility_Functions{

    private UiDevice device;
    private static final String TAG = "TEST";
    Random rand = new Random();
    double rand_dub1 = rand.nextDouble();
    double rand_dub2 = rand.nextDouble();
    int rand_int1 = rand.nextInt(1000);
    int rand_int2 = rand.nextInt(1000);
    double rint1 = Double.valueOf(rand_int1);
    double rint2 = Double.valueOf(rand_int2);

    double dADD;

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
    public void AOSP_13_Add_numbers() throws Exception {

        int i;
        for(i=1;i<=1;i++){
            Log.i(TAG, "* ADD no1 : "+rand_dub1+ " no2 :" +rand_dub2);
            dADD = rand_dub1 + rand_dub2;
            add(rand_dub1,rand_dub2);

            Log.i(TAG, "* ADD no1 : "+rint1+ " no2 :" +rint2);
            dADD = rint1 + rint2;
            add(rint1,rint2);

            Log.i(TAG, "* Subtract no1 : "+rand_dub1+ " no2 :" +rand_dub2);
            dADD = rand_dub1 - rand_dub2;
            sub(rand_dub1,rand_dub2);

            Log.i(TAG, "* Subtract no1 : "+rint1+ "no2 :" +rint2);
            dADD = rint1 - rint2;
            sub(rint1,rint2);

            Log.i(TAG, "* Multiply no1 : "+rand_dub1+ " no2 :" +rand_dub2);
            dADD = rand_dub1 * rand_dub2;
            mul(rand_dub1,rand_dub2);

            Log.i(TAG, "* Multiply no1 : "+rint1+ " no2 :" +rint2);
            dADD = rint1 * rint2;
            mul(rint1,rint2);

            Log.i(TAG, "* Division no1 : "+rand_dub1+ " no2 :" +rand_dub2);
            dADD = rand_dub1 / rand_dub2;
            div(rand_dub1,rand_dub2);

            Log.i(TAG, "* Division no1 : "+rint1+ " no2 :" +rint2);
            dADD = rint1 / rint2;
            div(rint1,rint2);
        }


    }

    public void add(double no1, double no2) throws Exception{

        String s1 = String.valueOf(no1);
        String s2 = String.valueOf(no2);
        s1.length();
        s2.length();
        try {
            ufMenu_srch_App("Calculator");
            UiObject clear = new UiObject(new UiSelector()
                    .description("clear"));
            clear.click();
            Log.i(TAG,"* Clear");
            for (int i = 0; i <= s1.length() - 1; i++) {

                String c1 = String.valueOf(s1.charAt(i));
                UiObject Enter_digit = new UiObject(new UiSelector()
                        .description(c1));
                if (c1.equals(".")) {
                    UiObject point = new UiObject(new UiSelector()
                            .resourceId("com.google.android.calculator:id/dec_point"));
                    point.click();
                    Thread.sleep(1000);
                } else {
                    Enter_digit.click();
                }
            }
            Log.i(TAG, "* Entered First No : " + no1);

            UiObject plus = new UiObject(new UiSelector()
                    .resourceId("com.google.android.calculator:id/op_add"));
            plus.click();
            Log.i(TAG, "* Click Plus");


            for (int i = 0; i <= s2.length() - 1; i++) {

                String c2 = String.valueOf(s2.charAt(i));
                UiObject Enter_digit = new UiObject(new UiSelector()
                        .description(c2));
                if (c2.equals(".")) {
                    UiObject point = new UiObject(new UiSelector()
                            .resourceId("com.google.android.calculator:id/dec_point"));
                    point.click();
                    Thread.sleep(1000);
                } else {
                    Enter_digit.click();
                }
            }
            Log.i(TAG, "* Entered Second No : " + no2);

            UiObject equals = new UiObject(new UiSelector()
                    .resourceId("com.google.android.calculator:id/eq"));
            equals.click();
            Log.i(TAG, "* equals");
            UiObject final_result = new UiObject(new UiSelector()
                    .resourceId("com.google.android.calculator:id/result_final"));
            String fr = final_result.getText();
            Log.i(TAG, "* Expected result : "+dADD);
            Log.i(TAG, "* Actual Result : "+fr);

            if((String.valueOf(dADD).contains(fr))){
                Log.i(TAG, "* Add function PASS");
            }
            Thread.sleep(1000);
            go_to_idle();

        }catch (Exception e){
            e.printStackTrace();
            Log.d(TAG, "* Failed....");
            go_to_idle();
        }

    }

    public void sub(double no1, double no2) throws Exception{

        String s1 = String.valueOf(no1);
        String s2 = String.valueOf(no2);
        s1.length();
        s2.length();
        try {
            ufMenu_srch_App("Calculator");
            UiObject clear = new UiObject(new UiSelector()
                    .description("clear"));
            clear.click();
            Log.i(TAG,"* Clear");
            for (int i = 0; i <= s1.length() - 1; i++) {

                String c1 = String.valueOf(s1.charAt(i));
                UiObject Enter_digit = new UiObject(new UiSelector()
                        .description(c1));
                if (c1.equals(".")) {
                    UiObject point = new UiObject(new UiSelector()
                            .resourceId("com.google.android.calculator:id/dec_point"));
                    point.click();
                    Thread.sleep(1000);
                } else {
                    Enter_digit.click();
                }
            }
            Log.i(TAG, "* Entered First No : " +no1);

            UiObject sub = new UiObject(new UiSelector()
                    .resourceId("com.google.android.calculator:id/op_sub"));
            sub.click();
            Log.i(TAG, "* Click Subtract");


            for (int i = 0; i <= s2.length() - 1; i++) {

                String c2 = String.valueOf(s2.charAt(i));
                UiObject Enter_digit = new UiObject(new UiSelector()
                        .description(c2));
                if (c2.equals(".")) {
                    UiObject point = new UiObject(new UiSelector()
                            .resourceId("com.google.android.calculator:id/dec_point"));
                    point.click();
                    Thread.sleep(1000);
                } else {
                    Enter_digit.click();
                }
            }
            Log.i(TAG,"* Entered Second No : " + no2);
            UiObject equals = new UiObject(new UiSelector()
                    .resourceId("com.google.android.calculator:id/eq"));
            equals.click();
            Log.i(TAG,"* equals");
            UiObject final_result = new UiObject(new UiSelector()
                    .resourceId("com.google.android.calculator:id/result_final"));
            String fr = final_result.getText();
            Log.i(TAG, "* Expected result : "+dADD);
            Log.i(TAG, "* Actual Result : "+ fr);
            String value = String.valueOf(dADD);
            Log.i(TAG, "* String valueOf dADD is : " + value );
            if((String.valueOf(dADD).contains(fr))){
                Log.i(TAG, "* Subtract function PASS");
            }
            //Log.i(TAG, "Entered Second No");
            go_to_idle();

        }catch (Exception e){
            e.printStackTrace();
            Log.d(TAG, "* Failed....");
            go_to_idle();
        }

    }

    public void mul(double no1, double no2) throws Exception{

        String s1 = String.valueOf(no1);
        String s2 = String.valueOf(no2);
        s1.length();
        s2.length();
        try {
            ufMenu_srch_App("Calculator");
            UiObject clear = new UiObject(new UiSelector()
                    .description("clear"));
            clear.click();
            Log.i(TAG,"* Clear");
            for (int i = 0; i <= s1.length() - 1; i++) {

                String c1 = String.valueOf(s1.charAt(i));
                UiObject Enter_digit = new UiObject(new UiSelector()
                        .description(c1));
                if (c1.equals(".")) {
                    UiObject point = new UiObject(new UiSelector()
                            .resourceId("com.google.android.calculator:id/dec_point"));
                    point.click();
                    Thread.sleep(1000);
                } else {
                    Enter_digit.click();
                }

            }
            Log.i(TAG, "* Entered First No : " + no1);
            UiObject mul = new UiObject(new UiSelector()
                    .resourceId("com.google.android.calculator:id/op_mul"));
            mul.click();
            Log.i(TAG, "* Click Multiply");


            for (int i = 0; i <= s2.length() - 1; i++) {

                String c2 = String.valueOf(s2.charAt(i));
                UiObject Enter_digit = new UiObject(new UiSelector()
                        .description(c2));
                if (c2.equals(".")) {
                    UiObject point = new UiObject(new UiSelector()
                            .resourceId("com.google.android.calculator:id/dec_point"));
                    point.click();
                    Thread.sleep(1000);
                } else {
                    Enter_digit.click();
                }

            }
            Log.i(TAG, "* Entered Second No : " + no1);


            UiObject equals = new UiObject(new UiSelector()
                    .resourceId("com.google.android.calculator:id/eq"));
            equals.click();
            Log.i(TAG, "* Equals");
            UiObject final_result = new UiObject(new UiSelector()
                    .resourceId("com.google.android.calculator:id/result_final"));
            String fr = final_result.getText();
            Log.i(TAG, "* Expected result : "+dADD);
            Log.i(TAG, "* Actual Result : "+fr);

            if((String.valueOf(dADD).contains(fr))){
                Log.i(TAG, "* Multiply function PASS");
            }
            //Log.i(TAG, "Entered Second No");
            go_to_idle();

        }catch (Exception e){
            e.printStackTrace();
            Log.d(TAG, "Failed....");
            go_to_idle();

        }

    }

    public void div(double no1, double no2) throws Exception{

        String s1 = String.valueOf(no1);
        String s2 = String.valueOf(no2);
        s1.length();
        s2.length();
        try {
            ufMenu_srch_App("Calculator");
            UiObject clear = new UiObject(new UiSelector()
                    .description("clear"));
            clear.click();
            Log.i(TAG,"* Clear");
            for (int i = 0; i <= s1.length() - 1; i++) {

                String c1 = String.valueOf(s1.charAt(i));
                UiObject Enter_digit = new UiObject(new UiSelector()
                        .description(c1));
                if (c1.equals(".")) {
                    UiObject point = new UiObject(new UiSelector()
                            .resourceId("com.google.android.calculator:id/dec_point"));
                    point.click();
                    Thread.sleep(1000);
                } else {
                    Enter_digit.click();
                }

            }
            Log.i(TAG, "* Entered First No : " + no1);
            UiObject mul = new UiObject(new UiSelector()
                    .resourceId("com.google.android.calculator:id/op_div"));
            mul.click();
            Log.i(TAG, "* Click Division");


            for (int i = 0; i <= s2.length() - 1; i++) {

                String c2 = String.valueOf(s2.charAt(i));
                UiObject Enter_digit = new UiObject(new UiSelector()
                        .description(c2));
                if (c2.equals(".")) {
                    UiObject point = new UiObject(new UiSelector()
                            .resourceId("com.google.android.calculator:id/dec_point"));
                    point.click();
                    Thread.sleep(1000);
                } else {
                    Enter_digit.click();
                }

            }
            Log.i(TAG, "* Entered Second No : " + no1);


            UiObject equals = new UiObject(new UiSelector()
                    .resourceId("com.google.android.calculator:id/eq"));
            equals.click();
            Log.i(TAG, "* Equals");
            UiObject final_result = new UiObject(new UiSelector()
                    .resourceId("com.google.android.calculator:id/result_final"));
            String fr = final_result.getText();
            Log.i(TAG, "* Expected result : "+dADD);
            Log.i(TAG, "* Actual Result : "+fr);

            if((String.valueOf(dADD).contains(fr))){
                Log.i(TAG, "* Division function PASS");
            }
            //Log.i(TAG, "Entered Second No");
            go_to_idle();

        }catch (Exception e){
            e.printStackTrace();
            Log.d(TAG, "* Failed....");
            go_to_idle();

        }

    }
}
