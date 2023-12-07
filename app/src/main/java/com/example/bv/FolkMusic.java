package com.example.bv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class FolkMusic extends AppCompatActivity {

    /*Music*/
    private Button buttonPibare, buttonRaga;
    private Button[] buttons;
    private MediaPlayer mpPibare, mpRaga;
    private MediaPlayer[] mediaPlayers;

    private int[] txtPlay, txtPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folk_music);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        /*Media Player*/
        buttonPibare = findViewById(R.id.btPibare);
        buttonRaga = findViewById(R.id.btRaga);

        buttonPibare.setOnClickListener(buttonListener);
        buttonRaga.setOnClickListener(buttonListener);

        mpPibare = MediaPlayer.create(this, R.raw.pibare);
        mpRaga = MediaPlayer.create(this, R.raw.raga);

        buttons = new Button[]{buttonPibare, buttonRaga};
        mediaPlayers = new MediaPlayer[]{mpPibare, mpRaga};
        txtPlay = new int[]{R.string.btPibare, R.string.btRaga};
        txtPause = new int[]{R.string.btPibarePause, R.string.btRagaPause};
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();

        return super.onOptionsItemSelected(item);
    }

    View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Ukulele == 0; drums == 1, as per the arrays above
            int currentInstrumentNumber = (v == buttonPibare) ? 0 : 1;
            int otherInstrumentNumber = (currentInstrumentNumber == 0) ? 1 : 0;

            MediaPlayer mpCurrent = mediaPlayers[currentInstrumentNumber];

            Button btnCurrent = buttons[currentInstrumentNumber];
            Button btnOther = buttons[otherInstrumentNumber];

            int currentPlayText = txtPlay[currentInstrumentNumber];
            int currentPauseText = txtPause[currentInstrumentNumber];

            if (! (mpCurrent.isPlaying()) ) {
                mpCurrent.start();
                btnCurrent.setText(currentPauseText);
//                btnOther.setVisibility(View.INVISIBLE);
                btnOther.setEnabled(false);
            }
            else {
                mpCurrent.pause();
                btnCurrent.setText(currentPlayText);
//                btnOther.setVisibility(View.VISIBLE);
                btnOther.setEnabled(true);
            }

        }
    };
}