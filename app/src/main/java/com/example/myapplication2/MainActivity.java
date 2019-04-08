package com.example.myapplication2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] images = {R.drawable.dziewczynka, R.drawable.dziewczynka2,R.drawable.avatar3,R.drawable.avatar4,R.drawable.avatar5,R.drawable.avatar6};
    TextView contact_name;
    ImageView image_contact;
    MediaPlayer currentsound;
    boolean isplaying = false;
    String sound_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contact_name = findViewById(R.id.contact_name);
        contact_name.setText(Myapp.current_contact);
        sound_name = Myapp.current_sound;
        image_contact = findViewById(R.id.imageView4);
       //
        Random rand = new Random();
        image_contact.setImageResource(images[rand.nextInt(images.length)]);
        Button change_contact = findViewById(R.id.button7);
        change_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Change_Contact_Activity.class);
                startActivityForResult(i,1);


            }
        });

        Button change_sound = findViewById(R.id.button8);
        change_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, Change_Sound_Activity.class);
                startActivityForResult(i,2);
            }
        });

        final FloatingActionButton przycisk = findViewById(R.id.floatingActionButton4);
        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isplaying)
                {
                    currentsound.stop();
                    przycisk.setImageResource(android.R.drawable.ic_media_play);
                    isplaying=false;
                }
                else
                {
                    switch(sound_name)
                    {
                        case  "Sound1":
                            currentsound = MediaPlayer.create(MainActivity.this, R.raw.muz3);
                            currentsound.start();
                            przycisk.setImageResource(android.R.drawable.ic_media_pause);
                            isplaying=true;
                            break;
                        case  "Sound2":
                            currentsound = MediaPlayer.create(MainActivity.this, R.raw.muz2);
                            currentsound.start();
                            przycisk.setImageResource(android.R.drawable.ic_media_pause);
                            isplaying=true;
                            break;
                    }
                }

            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( requestCode == 1)
        {
            if(resultCode == Change_Contact_Activity.RESULT_OK)
            {
                contact_name.setText(Myapp.current_contact);
                Random rand = new Random();
                image_contact.setImageResource(images[rand.nextInt(images.length)]);
            }


        }
        if(requestCode ==2)
        {
            if(resultCode == Change_Sound_Activity.RESULT_OK)
            {
                sound_name= Myapp.current_sound;
            }
        }
    }

}

