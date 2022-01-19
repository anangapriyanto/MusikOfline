package com.example.lagu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class SecondActivity3 extends AppCompatActivity implements View.OnClickListener{

    TextView title3, description3, adalah3, terjemahan3, makna3;
    String data11, data12, data13, data14, data15;
    //Deklarasi Variable
    private Button Play3, Pause3, Stop3;
    private MediaPlayer mediaPlayer3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second3);

        title3 = findViewById(R.id.title3);
        description3 = findViewById(R.id.description3);
        adalah3 = findViewById(R.id.adalah3);
        terjemahan3 = findViewById(R.id.terjemahan3);
        makna3 = findViewById(R.id.makna3);

        getData();
        setData();

        //Inisialisasi Button
        Play3 = findViewById(R.id.play3);
        Pause3 = findViewById(R.id.pause3);
        Stop3 = findViewById(R.id.stop3);

        //Menambahkan Listener pada Button
        Play3.setOnClickListener(this);
        Pause3.setOnClickListener(this);
        Stop3.setOnClickListener(this);

        stateAwal();
    }

    //Untuk menentukan kondisi saat aplikasi pertama kali berjalan
    private void stateAwal(){
        Play3.setEnabled(true);
        Pause3.setEnabled(false);
        Stop3.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio(){
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer3 = MediaPlayer.create(this, R.raw.lea_on);

        //Kondisi Button setelah tombol play di klik
        Play3.setEnabled(false);
        Pause3.setEnabled(true);
        Stop3.setEnabled(true);

        //Menjalankan Audio / Musik
        try{
            mediaPlayer3.prepare();
        }catch (IllegalStateException ex){
            ex.printStackTrace();
        }catch (IOException ex1){
            ex1.printStackTrace();
        }
        mediaPlayer3.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void pauseAudio(){

        //Jika audio sedang dimainkan, maka audio dapat di pause
        if(mediaPlayer3.isPlaying()){
            if(mediaPlayer3 != null){
                mediaPlayer3.pause();
                Pause3.setText("Lanjutkan");
            }
        }else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if(mediaPlayer3 != null){
                mediaPlayer3.start();
                Pause3.setText("Pause");
            }
        }
    }

    //Method untuk mengakhiri musik
    private void stopAudio(){
        mediaPlayer3.stop();
        try {
            //Menyetel audio ke status awal
            mediaPlayer3.prepare();
            mediaPlayer3.seekTo(0);
        }catch (Throwable t){
            t.printStackTrace();
        }
        stateAwal();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play3:
                playAudio();
                break;

            case R.id.pause3:
                pauseAudio();
                break;

            case R.id.stop3:
                stopAudio();
                break;
        }
    }


    private void getData() {
        if(getIntent().hasExtra("data11") &&
                getIntent().hasExtra("data12") && getIntent().hasExtra("data13") &&
                getIntent().hasExtra("data14") && getIntent().hasExtra("data15")){
            data11 = getIntent().getStringExtra("data11");
            data12 = getIntent().getStringExtra("data12");
            data13 = getIntent().getStringExtra("data13");
            data14 = getIntent().getStringExtra("data14");
            data15 = getIntent().getStringExtra("data15");
        }else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        title3.setText(data11);
        description3.setText(data12);
        adalah3.setText(data13);
        terjemahan3.setText(data14);
        makna3.setText(data15);

    }
}