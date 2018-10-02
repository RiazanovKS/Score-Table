package com.example.kirill.scoreboard;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int firstTeamScores;
    private int secondTeamScores;

    TextView tvFirstTeamScores;
    TextView tvSecondTeamScores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         tvFirstTeamScores = (TextView) findViewById(R.id.firstTeamScores);
         tvSecondTeamScores= (TextView) findViewById(R.id.secondTeamScores);

        Button btnResetScores = (Button)findViewById(R.id.resetScoresBtn);
        Button addScoresForFirstTeam = (Button) findViewById(R.id.addScoresFor1stTeam);
        Button addScoresForSecondTeam = (Button)findViewById(R.id.addScoresFor2ndTeam);

        addScoresForFirstTeam.setOnClickListener(this);
        addScoresForSecondTeam.setOnClickListener(this);
        btnResetScores.setOnClickListener(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("firstTeamScores", firstTeamScores);
        outState.putInt("secondTeamScores", secondTeamScores);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        firstTeamScores = savedInstanceState.getInt("firstTeamScores");
        secondTeamScores = savedInstanceState.getInt("secondTeamScores");
        resetUI();
    }

    public void resetUI(){
        tvFirstTeamScores.setText(String.valueOf(firstTeamScores));
        tvSecondTeamScores.setText(String.valueOf(secondTeamScores));
    }

    public void resetScore() {
        firstTeamScores = 0;
        secondTeamScores = 0;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addScoresFor1stTeam:
                tvFirstTeamScores.setText(String.valueOf(++firstTeamScores));
                break;
            case R.id.addScoresFor2ndTeam:
                tvSecondTeamScores.setText(String.valueOf(++secondTeamScores));
                break;
            case R.id.resetScoresBtn:
                resetScore();
                tvFirstTeamScores.setText("0");
                tvSecondTeamScores.setText("0");
                break;
        }
    }
}
