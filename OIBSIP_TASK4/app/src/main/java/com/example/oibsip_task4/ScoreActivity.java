package com.example.oibsip_task4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        // Get the score from the intent
        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);
        int totalQuestions = intent.getIntExtra("totalQuedtions" , 10);

        // Display the score
        TextView scoreTextView = findViewById(R.id.scoreTextView);
        scoreTextView.setText("Your score is " + score + " Out of " + totalQuestions + ".");

        // ReStart the Quiz
        Button restartButton = findViewById(R.id.restartButton);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(intent2);
            }
        });

    }
}