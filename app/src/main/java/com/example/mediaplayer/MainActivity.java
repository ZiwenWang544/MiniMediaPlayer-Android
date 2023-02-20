package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private MediaPlayer mp;
    private Button b1;
    private int ponsicion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.button5);
    }

    public void iniciar(View view) {
        destruir();
        mp = MediaPlayer.create(this, R.raw.audio);

        mp.start();
        String op = b1.getText().toString();
        if (op.equals("No reproducir en forma circular"))
            mp.setLooping(false);
        else
            mp.setLooping(true);
    }

    public void destruir() {
        if (mp != null) {
            mp.release();
        }
    }
    public void pausar(View v) {
        if (mp != null && mp.isPlaying()==true) {
            ponsicion = mp.getCurrentPosition();
            mp.pause();
        }
    }

    public void continuar(View view) {
        if (mp != null && mp.isPlaying() == false) {
            mp.seekTo(ponsicion);
            mp.start();
        }
    }
    public void detener(View v) {
        if (mp != null) {
            mp.stop();
            ponsicion = 0;
        }
    }
    public void circular(View v) {
        detener(null);
        String op = b1.getText().toString();
        if (op.equals("No reproducir en forma circular"))
            b1.setText("Reproducir en forma circular");
        else
            b1.setText("No reproducir en forma circular");
    }
}

