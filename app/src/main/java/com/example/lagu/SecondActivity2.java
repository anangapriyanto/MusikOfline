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

public class SecondActivity2 extends AppCompatActivity implements View.OnClickListener {

    TextView title2, description2, adalah2, terjemahan2, makna2;
    String data6, data7, data8, data9, data10;
    //Deklarasi Variable
    private Button Play2, Pause2, Stop2;
    private MediaPlayer mediaPlayer2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        title2 = findViewById(R.id.title2);
        description2 = findViewById(R.id.description2);
        adalah2 = findViewById(R.id.adalah2);
        terjemahan2 = findViewById(R.id.terjemahan2);
        makna2 = findViewById(R.id.makna2);

        getData();
        setData();

        //Inisialisasi Button
        Play2 = findViewById(R.id.play2);
        Pause2 = findViewById(R.id.pause2);
        Stop2 = findViewById(R.id.stop2);

        //Menambahkan Listener pada Button
        Play2.setOnClickListener(this);
        Pause2.setOnClickListener(this);
        Stop2.setOnClickListener(this);

        stateAwal();
    }

    //Untuk menentukan kondisi saat aplikasi pertama kali berjalan
    private void stateAwal(){
        Play2.setEnabled(true);
        Pause2.setEnabled(false);
        Stop2.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio(){
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer2 = MediaPlayer.create(this, R.raw.tetap_tersenyum_kawan);

        //Kondisi Button setelah tombol play di klik
        Play2.setEnabled(false);
        Pause2.setEnabled(true);
        Stop2.setEnabled(true);

        //Menjalankan Audio / Musik
        try{
            mediaPlayer2.prepare();
        }catch (IllegalStateException ex){
            ex.printStackTrace();
        }catch (IOException ex1){
            ex1.printStackTrace();
        }
        mediaPlayer2.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void pauseAudio(){

        //Jika audio sedang dimainkan, maka audio dapat di pause
        if(mediaPlayer2.isPlaying()){
            if(mediaPlayer2 != null){
                mediaPlayer2.pause();
                Pause2.setText("Lanjutkan");
            }
        }else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if(mediaPlayer2 != null){
                mediaPlayer2.start();
                Pause2.setText("Pause");
            }
        }
    }

    //Method untuk mengakhiri musik
    private void stopAudio(){
        mediaPlayer2.stop();
        try {
            //Menyetel audio ke status awal
            mediaPlayer2.prepare();
            mediaPlayer2.seekTo(0);
        }catch (Throwable t){
            t.printStackTrace();
        }
        stateAwal();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play2:
                playAudio();
                break;

            case R.id.pause2:
                pauseAudio();
                break;

            case R.id.stop2:
                stopAudio();
                break;
        }
    }



    private void getData() {
        if(getIntent().hasExtra("data6") &&
                getIntent().hasExtra("data7") && getIntent().hasExtra("data8") &&
                getIntent().hasExtra("data9") && getIntent().hasExtra("data10")){
            data6 = getIntent().getStringExtra("data6");
            data7 = getIntent().getStringExtra("data7");
            data8 = getIntent().getStringExtra("data8");
            data9 = getIntent().getStringExtra("data9");
            data10 = getIntent().getStringExtra("data10");
        }else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        title2.setText(data6);
        description2.setText(data7);
        adalah2.setText(data8);
        terjemahan2.setText(data9);
        makna2.setText(data10);

    }
}