package com.serma.crocobisunes.timetable;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.serma.crocobisunes.timetable.MainActivity;
import com.serma.crocobisunes.timetable.R;

public class SecondPage extends AppCompatActivity {

    ImageButton dir1;
    ImageButton dir2;

    ImageButton jumping;
    ImageButton sleeping;
    ImageButton walking;

    TextView question2;

    TextView ansVar3;
    TextView ansVar4;

    MediaPlayer mpJumpWrong;
    MediaPlayer mpSleepWrong;
    MediaPlayer mpWalkPerfect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        hideNavigator();

        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        MediaPlayer click = MediaPlayer.create(this, R.raw.walking);
        click.start();

        dir2 = (ImageButton) findViewById(R.id.dir2);

        dir2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SecondPage.this, MainActivity.class);
                startActivity(intent);

            }
        });

        jumping = (ImageButton) findViewById(R.id.jumping);

        jumping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    public void run() {
                        mpJumpWrong = MediaPlayer.create(SecondPage.this, R.raw.wrong);
                        mpJumpWrong.start();
                    }
                }.start();

                Toast.makeText(SecondPage.this, "Неправильно!", Toast.LENGTH_SHORT).show();
                Animation animation = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.translate);
                jumping.startAnimation(animation);

                Toast.makeText(SecondPage.this, "Правильно!", Toast.LENGTH_SHORT).show();
                Animation animation1 = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.scale);
                walking.startAnimation(animation1);
            }
        });

        sleeping = (ImageButton) findViewById(R.id.sleeping);

        sleeping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread() {
                    public void run() {
                        mpSleepWrong = MediaPlayer.create(SecondPage.this, R.raw.wrong);
                        mpSleepWrong.start();
                    }
                }.start();
                Toast.makeText(SecondPage.this, "Неправильно!", Toast.LENGTH_SHORT).show();
                Animation animation = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.translate);
                sleeping.startAnimation(animation);

                Animation animation1 = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.scale);
                walking.startAnimation(animation1);
                Toast.makeText(SecondPage.this, "Вот правильный ответ!", Toast.LENGTH_SHORT).show();
            }
        });

        walking = (ImageButton) findViewById(R.id.walking);

        walking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    public void run() {
                        mpWalkPerfect = MediaPlayer.create(SecondPage.this, R.raw.wrong);
                        mpWalkPerfect.start();
                    }
                }.start();
                Toast.makeText(SecondPage.this, "Неправильно!", Toast.LENGTH_SHORT).show();
                Animation animation = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.translate);
                walking.startAnimation(animation);
            }
        });
    }

    public void hideNavigator(){
        View decorView =getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
}
