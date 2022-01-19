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

public class SecondActivity4 extends AppCompatActivity implements View.OnClickListener{

    TextView title4, description4, adalah4, terjemahan4, makna4;
    String data16, data17, data18, data19, data20;
    //Deklarasi Variable
    private Button Play4, Pause4, Stop4;
    private MediaPlayer mediaPlayer4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second4);

        title4 = findViewById(R.id.title4);
        description4 = findViewById(R.id.description4);
        adalah4 = findViewById(R.id.adalah4);
        terjemahan4 = findViewById(R.id.terjemahan4);
        makna4 = findViewById(R.id.makna4);

        getData();
        setData();

        //Inisialisasi Button
        Play4 = findViewById(R.id.play4);
        Pause4 = findViewById(R.id.pause4);
        Stop4 = findViewById(R.id.stop4);

        //Menambahkan Listener pada Button
        Play4.setOnClickListener(this);
        Pause4.setOnClickListener(this);
        Stop4.setOnClickListener(this);

        stateAwal();
    }

    //Untuk menentukan kondisi saat aplikasi pertama kali berjalan
    private void stateAwal(){
        Play4.setEnabled(true);
        Pause4.setEnabled(false);
        Stop4.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio(){
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer4 = MediaPlayer.create(this, R.raw.gravity);

        //Kondisi Button setelah tombol play di klik
        Play4.setEnabled(false);
        Pause4.setEnabled(true);
        Stop4.setEnabled(true);

        //Menjalankan Audio / Musik
        try{
            mediaPlayer4.prepare();
        }catch (IllegalStateException ex){
            ex.printStackTrace();
        }catch (IOException ex1){
            ex1.printStackTrace();
        }
        mediaPlayer4.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void pauseAudio(){

        //Jika audio sedang dimainkan, maka audio dapat di pause
        if(mediaPlayer4.isPlaying()){
            if(mediaPlayer4 != null){
                mediaPlayer4.pause();
                Pause4.setText("Lanjutkan");
            }
        }else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if(mediaPlayer4 != null){
                mediaPlayer4.start();
                Pause4.setText("Pause");
            }
        }
    }

    //Method untuk mengakhiri musik
    private void stopAudio(){
        mediaPlayer4.stop();
        try {
            //Menyetel audio ke status awal
            mediaPlayer4.prepare();
            mediaPlayer4.seekTo(0);
        }catch (Throwable t){
            t.printStackTrace();
        }
        stateAwal();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play4:
                playAudio();
                break;

            case R.id.pause4:
                pauseAudio();
                break;

            case R.id.stop4:
                stopAudio();
                break;
        }
    }


    private void getData() {
        if(getIntent().hasExtra("data16") &&
                getIntent().hasExtra("data17") && getIntent().hasExtra("data18") &&
                getIntent().hasExtra("data19") && getIntent().hasExtra("data20")){
            data16 = getIntent().getStringExtra("data16");
            data17 = getIntent().getStringExtra("data17");
            data18 = getIntent().getStringExtra("data18");
            data19 = getIntent().getStringExtra("data19");
            data20 = getIntent().getStringExtra("data20");
        }else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        title4.setText(data16);
        description4.setText(data17);
        adalah4.setText(data18);
        terjemahan4.setText(data19);
        makna4.setText(data20);

    }
}