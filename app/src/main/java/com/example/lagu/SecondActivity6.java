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

public class SecondActivity6 extends AppCompatActivity implements View.OnClickListener{

    TextView title6, description6, adalah6, terjemahan6, makna6;
    String data26, data27, data28, data29, data30;
    //Deklarasi Variable
    private Button Play6, Pause6, Stop6;
    private MediaPlayer mediaPlayer6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second6);

        title6 = findViewById(R.id.title6);
        description6 = findViewById(R.id.description6);
        adalah6 = findViewById(R.id.adalah6);
        terjemahan6 = findViewById(R.id.terjemahan6);
        makna6 = findViewById(R.id.makna6);

        getData();
        setData();

        //Inisialisasi Button
        Play6 = findViewById(R.id.play6);
        Pause6 = findViewById(R.id.pause6);
        Stop6 = findViewById(R.id.stop6);

        //Menambahkan Listener pada Button
        Play6.setOnClickListener(this);
        Pause6.setOnClickListener(this);
        Stop6.setOnClickListener(this);

        stateAwal();
    }

    //Untuk menentukan kondisi saat aplikasi pertama kali berjalan
    private void stateAwal(){
        Play6.setEnabled(true);
        Pause6.setEnabled(false);
        Stop6.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio(){
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer6 = MediaPlayer.create(this, R.raw.gravity);

        //Kondisi Button setelah tombol play di klik
        Play6.setEnabled(false);
        Pause6.setEnabled(true);
        Stop6.setEnabled(true);

        //Menjalankan Audio / Musik
        try{
            mediaPlayer6.prepare();
        }catch (IllegalStateException ex){
            ex.printStackTrace();
        }catch (IOException ex1){
            ex1.printStackTrace();
        }
        mediaPlayer6.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer6.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void pauseAudio(){

        //Jika audio sedang dimainkan, maka audio dapat di pause
        if(mediaPlayer6.isPlaying()){
            if(mediaPlayer6 != null){
                mediaPlayer6.pause();
                Pause6.setText("Lanjutkan");
            }
        }else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if(mediaPlayer6 != null){
                mediaPlayer6.start();
                Pause6.setText("Pause");
            }
        }
    }

    //Method untuk mengakhiri musik
    private void stopAudio(){
        mediaPlayer6.stop();
        try {
            //Menyetel audio ke status awal
            mediaPlayer6.prepare();
            mediaPlayer6.seekTo(0);
        }catch (Throwable t){
            t.printStackTrace();
        }
        stateAwal();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play6:
                playAudio();
                break;

            case R.id.pause6:
                pauseAudio();
                break;

            case R.id.stop6:
                stopAudio();
                break;
        }
    }

    private void getData() {
        if(getIntent().hasExtra("data26") &&
                getIntent().hasExtra("data27") && getIntent().hasExtra("data28") &&
                getIntent().hasExtra("data29") && getIntent().hasExtra("data30")){
            data26 = getIntent().getStringExtra("data26");
            data27 = getIntent().getStringExtra("data27");
            data28 = getIntent().getStringExtra("data28");
            data29 = getIntent().getStringExtra("data29");
            data30 = getIntent().getStringExtra("data30");
        }else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        title6.setText(data26);
        description6.setText(data27);
        adalah6.setText(data28);
        terjemahan6.setText(data29);
        makna6.setText(data30);

    }
}