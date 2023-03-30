package com.example.oibsip_task4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private QuizQuestion[] quizQuestions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Initialize quiz questions
        quizQuestions = new QuizQuestion[] {
                new QuizQuestion("Identify the language on which Android is based upon.", new String[] {"Python", "R", "Java", "None"}, 2),
                new QuizQuestion("All layout classes are the subclasses of", new String[] {"android.widget", "android.view.View", "android.view.ViewGroup", "None"}, 2),
                new QuizQuestion("While developing android application developers can test their apps on", new String[] {"Emulators in Android SDK", "Android Phone", "Third_party Emulator", "All the above"}, 3),
                new QuizQuestion("The full form of ADB is.", new String[] {"Android Delete Bridge", "Android Destroy Bridge", "Android Debug Bridge", "Android Developed Bridge"}, 2),
                new QuizQuestion("AVD stands for", new String[] {"Android Virtual Device", "Active Virtual Device", "Android Virtual Display", "Active Virtual Display"}, 0),
                new QuizQuestion("Choose the option which is contained in the src folder", new String[] {"Manifest", "Java Source Code", "XML", "All of them"}, 1),
                new QuizQuestion("Identify the parent class of activity.", new String[] {"contextThemeWrapper", "context", "object", "None"}, 0),
                new QuizQuestion("When was Open Handset Alliance announced?", new String[] {"2004", "2005", "2006","2007"}, 3),
                new QuizQuestion("Choose the built-in database of Android.", new String[] {"MySQL", "SQLite", "Oracle","None"}, 1),
                new QuizQuestion("Identify among the one which is used to log debug messages.", new String[] {"Log.R()", "Log.d()", "Log.D()", "Log.r()"}, 2)
        };

        // Display first quiz question
        displayQuestion();
    }

    private void displayQuestion() {
        // Get references to UI elements
        TextView questionTextView = findViewById(R.id.questionTextView);
        RadioButton answerRadioButton1 = findViewById(R.id.answerRadioButton1);
        RadioButton answerRadioButton2 = findViewById(R.id.answerRadioButton2);
        RadioButton answerRadioButton3 = findViewById(R.id.answerRadioButton3);
        RadioButton answerRadioButton4 = findViewById(R.id.answerRadioButton4);

        // Set question and answer text
        QuizQuestion currentQuestion = quizQuestions[currentQuestionIndex];
        questionTextView.setText(currentQuestion.getQuestion());
        answerRadioButton1.setText(currentQuestion.getAnswers()[0]);
        answerRadioButton2.setText(currentQuestion.getAnswers()[1]);
        answerRadioButton3.setText(currentQuestion.getAnswers()[2]);
        answerRadioButton4.setText(currentQuestion.getAnswers()[3]);
    }
    public void onSubmitButtonClick(View view) {
        // Get selected answer
        RadioGroup answersRadioGroup = findViewById(R.id.answersRadioGroup);
        int selectedAnswerIndex = answersRadioGroup.indexOfChild(findViewById(answersRadioGroup.getCheckedRadioButtonId()));

        // Check answer and update score
        QuizQuestion currentQuestion = quizQuestions[currentQuestionIndex];
        if (currentQuestion.isCorrect(selectedAnswerIndex)) {
            score++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }

        // Move to next question or end quiz
        if (currentQuestionIndex == quizQuestions.length - 1) {
            endQuiz();
        } else {
            currentQuestionIndex++;
            displayQuestion();
        }
    }

    private void endQuiz() {
        // Display final score
        // Launch the ScoreActivity and pass the score as an extra
        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra("score", score);
        intent.putExtra("totalQuestions", quizQuestions.length);
        startActivity(intent);
    }
}