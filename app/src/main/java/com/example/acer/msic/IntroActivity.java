package com.example.acer.msic;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.SlideFragmentBuilder;

/**
 * Created by Sarvesh on 4/13/2017.
 */
public class IntroActivity extends MaterialIntroActivity {

    SharedPreferences sharedPreferences;
    boolean firstTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences("ShaPreferences", Context.MODE_PRIVATE);
        firstTime = sharedPreferences.getBoolean("first", true);


        if (!firstTime) {

            Intent intent = new Intent(IntroActivity.this,SplashActivity.class);
            startActivity(intent);
            finish();
        } else {





            hideBackButton();


            addSlide(new SlideFragmentBuilder()
                    .backgroundColor(R.color.colorPrimary)
                    .buttonsColor(R.color.colorAccent)
                    .neededPermissions(new String[]{

                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE})
                    .title("Hello there Welcome To Muzio")
                    .description("Before we get started we need a Few Permissions")
                    .build());



        }
    }


    @Override
    public void onFinish() {
        super.onFinish();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("first", false);
        editor.apply();

        Intent i = new Intent(IntroActivity.this,SplashActivity.class);
        startActivity(i);
        finish();

    }

}
