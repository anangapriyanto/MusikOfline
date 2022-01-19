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

public class SecondActivity5 extends AppCompatActivity implements View.OnClickListener{

    TextView title5, description5, adalah5, terjemahan5, makna5;
    String data21, data22, data23, data24, data25;
    //Deklarasi Variable
    private Button Play5, Pause5, Stop5;
    private MediaPlayer mediaPlayer5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second5);

        title5 = findViewById(R.id.title5);
        description5 = findViewById(R.id.description5);
        adalah5 = findViewById(R.id.adalah5);
        terjemahan5 = findViewById(R.id.terjemahan5);
        makna5 = findViewById(R.id.makna5);

        getData();
        setData();

        //Inisialisasi Button
        Play5 = findViewById(R.id.play5);
        Pause5 = findViewById(R.id.pause5);
        Stop5 = findViewById(R.id.stop5);

        //Menambahkan Listener pada Button
        Play5.setOnClickListener(this);
        Pause5.setOnClickListener(this);
        Stop5.setOnClickListener(this);

        stateAwal();
    }

    //Untuk menentukan kondisi saat aplikasi pertama kali berjalan
    private void stateAwal(){
        Play5.setEnabled(true);
        Pause5.setEnabled(false);
        Stop5.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio(){
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer5 = MediaPlayer.create(this, R.raw.gravity);

        //Kondisi Button setelah tombol play di klik
        Play5.setEnabled(false);
        Pause5.setEnabled(true);
        Stop5.setEnabled(true);

        //Menjalankan Audio / Musik
        try{
            mediaPlayer5.prepare();
        }catch (IllegalStateException ex){
            ex.printStackTrace();
        }catch (IOException ex1){
            ex1.printStackTrace();
        }
        mediaPlayer5.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void pauseAudio(){

        //Jika audio sedang dimainkan, maka audio dapat di pause
        if(mediaPlayer5.isPlaying()){
            if(mediaPlayer5 != null){
                mediaPlayer5.pause();
                Pause5.setText("Lanjutkan");
            }
        }else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if(mediaPlayer5 != null){
                mediaPlayer5.start();
                Pause5.setText("Pause");
            }
        }
    }

    //Method untuk mengakhiri musik
    private void stopAudio(){
        mediaPlayer5.stop();
        try {
            //Menyetel audio ke status awal
            mediaPlayer5.prepare();
            mediaPlayer5.seekTo(0);
        }catch (Throwable t){
            t.printStackTrace();
        }
        stateAwal();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play5:
                playAudio();
                break;

            case R.id.pause5:
                pauseAudio();
                break;

            case R.id.stop5:
                stopAudio();
                break;
        }
    }

    private void getData() {
        if(getIntent().hasExtra("data21") &&
                getIntent().hasExtra("data22") && getIntent().hasExtra("data23") &&
                getIntent().hasExtra("data24") && getIntent().hasExtra("data25")){
            data21 = getIntent().getStringExtra("data21");
            data22 = getIntent().getStringExtra("data22");
            data23 = getIntent().getStringExtra("data23");
            data24 = getIntent().getStringExtra("data24");
            data25 = getIntent().getStringExtra("data25");
        }else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        title5.setText(data21);
        description5.setText(data22);
        adalah5.setText(data23);
        terjemahan5.setText(data24);
        makna5.setText(data25);

    }
}