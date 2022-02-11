package com.example.jeudedes;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import android.hardware.SensorManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;




import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class MainActivity extends AppCompatActivity {
    MediaPlayer monson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button lancer = (Button)findViewById(R.id.button);
        ImageView iv =(ImageView)findViewById(R.id.imageView);
        ImageView iv2 =(ImageView)findViewById(R.id.imageView2);
        ImageView iv3 =(ImageView)findViewById(R.id.imageView3);
        TextView score = (TextView) findViewById(R.id.score);

        Glide.with(this).load(R.raw.dice3droll).into(iv);
        Glide.with(this).load(R.raw.dice3droll).into(iv2);
        Glide.with(this).load(R.raw.dice3droll).into(iv3);


        lancer.setOnClickListener(new View.OnClickListener() {
            //private SoundPool soundPool;

            public void onClick(View v) {
                monson = MediaPlayer.create(getApplicationContext(),R.raw.shake_dice );
                monson.start();
                Random random = new Random();
                int randomNum;
                randomNum = (random.nextInt(6)+1);

                 switch(randomNum){
                     case 1:
                         iv.setImageResource(R.drawable.dice_1);
                         break;
                     case 2:
                         iv.setImageResource(R.drawable.dice_2);
                         break;
                     case 3:
                         iv.setImageResource(R.drawable.dice_3);
                         break;
                     case 4:
                         iv.setImageResource(R.drawable.dice_4);
                         break;
                     case 5:
                         iv.setImageResource(R.drawable.dice_5);
                         break;
                     case 6:
                         iv.setImageResource(R.drawable.dice_6);
                         break;
                 }

                Random random2 = new Random();
                int randomNum2;
                randomNum2 = (random2.nextInt(6)+1);

                switch(randomNum2){
                    case 1:
                        iv2.setImageResource(R.drawable.dice_1);
                        break;
                    case 2:
                        iv2.setImageResource(R.drawable.dice_2);
                        break;
                    case 3:
                        iv2.setImageResource(R.drawable.dice_3);
                        break;
                    case 4:
                        iv2.setImageResource(R.drawable.dice_4);
                        break;
                    case 5:
                        iv2.setImageResource(R.drawable.dice_5);
                        break;
                    case 6:
                        iv2.setImageResource(R.drawable.dice_6);
                        break;
                }

                Random random3 = new Random();
                int randomNum3;
                randomNum3 = (random3.nextInt(6)+1);

                switch(randomNum3){
                    case 1:
                        iv3.setImageResource(R.drawable.dice_1);
                        break;
                    case 2:
                        iv3.setImageResource(R.drawable.dice_2);
                        break;
                    case 3:
                        iv3.setImageResource(R.drawable.dice_3);
                        break;
                    case 4:
                        iv3.setImageResource(R.drawable.dice_4);
                        break;
                    case 5:
                        iv3.setImageResource(R.drawable.dice_5);
                        break;
                    case 6:
                        iv3.setImageResource(R.drawable.dice_6);
                        break;
                }
                int scorefinal = randomNum + randomNum2 + randomNum3;
                score.setText(String.valueOf(scorefinal));


                if(randomNum == randomNum2 || randomNum == randomNum3 || randomNum2 == randomNum3){
                    Toast toastX2 = Toast.makeText(MainActivity.this, "Double ! ", Toast.LENGTH_SHORT);
                    toastX2.show();
                }

                if(randomNum == randomNum2 && randomNum == randomNum3){
                    Toast toastX3 = Toast.makeText(MainActivity.this, "Triple ! ", Toast.LENGTH_SHORT);
                    toastX3.show();
                }
            }

            });





        }


    protected void onPause() {
        super.onPause();
        monson.release();
        finish();

    }





}