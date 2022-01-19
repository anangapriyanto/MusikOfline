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

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView title, description, adalah, terjemahan, makna;
    String data1, data2, data3, data4, data5;
    //Deklarasi Variable
    private Button Play, Pause, Stop;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        adalah = findViewById(R.id.adalah);
        terjemahan = findViewById(R.id.terjemahan);
        makna = findViewById(R.id.makna);

        getData();
        setData();
        //Inisialisasi Button
        Play = findViewById(R.id.play);
        Pause = findViewById(R.id.pause);
        Stop = findViewById(R.id.stop);

        //Menambahkan Listener pada Button
        Play.setOnClickListener(this);
        Pause.setOnClickListener(this);
        Stop.setOnClickListener(this);

        stateAwal();
    }

    //Untuk menentukan kondisi saat aplikasi pertama kali berjalan
    private void stateAwal(){
        Play.setEnabled(true);
        Pause.setEnabled(false);
        Stop.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio(){
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer = MediaPlayer.create(this, R.raw.oksang_baraaa);


        //Kondisi Button setelah tombol play di klik
        Play.setEnabled(false);
        Pause.setEnabled(true);
        Stop.setEnabled(true);

        //Menjalankan Audio / Musik
        try{
            mediaPlayer.prepare();
        }catch (IllegalStateException ex){
            ex.printStackTrace();
        }catch (IOException ex1){
            ex1.printStackTrace();
        }
        mediaPlayer.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void pauseAudio(){

        //Jika audio sedang dimainkan, maka audio dapat di pause
        if(mediaPlayer.isPlaying()){
            if(mediaPlayer != null){
                mediaPlayer.pause();
                Pause.setText("Lanjutkan");
            }
        }else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if(mediaPlayer != null){
                mediaPlayer.start();
                Pause.setText("Pause");
            }
        }
    }

    //Method untuk mengakhiri musik
    private void stopAudio(){
        mediaPlayer.stop();
        try {
            //Menyetel audio ke status awal
            mediaPlayer.prepare();
            mediaPlayer.seekTo(0);
        }catch (Throwable t){
            t.printStackTrace();
        }
        stateAwal();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play:
                playAudio();
                break;

            case R.id.pause:
                pauseAudio();
                break;

            case R.id.stop:
                stopAudio();
                break;
        }
    }

    private void getData() {
        if(getIntent().hasExtra("data1") &&
                getIntent().hasExtra("data2") && getIntent().hasExtra("data3") &&
                getIntent().hasExtra("data4") && getIntent().hasExtra("data5")){
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            data3 = getIntent().getStringExtra("data3");
            data4 = getIntent().getStringExtra("data4");
            data5 = getIntent().getStringExtra("data5");
        }else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        title.setText(data1);
        description.setText(data2);
        adalah.setText(data3);
        terjemahan.setText(data4);
        makna.setText(data5);

    }

}