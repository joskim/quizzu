package edu.csumb.quizzu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //This will be where each quiz is loaded
        //Data will dynamically change based on which quiz the user chose
        //For now it will run the demo quiz

        View startQuizButton = (Button) findViewById(R.id.quizStartBtn);
        startQuizButton.setOnClickListener(this);

        View doNotStartQuizButton = (Button) findViewById(R.id.quizOopsBtn);
        doNotStartQuizButton.setOnClickListener(this);

    }


    public void onClick(View v) {
        if(v.getId() == R.id.quizStartBtn) //If the green button is clicked, start the question
        {
            Intent i = new Intent(this, QuestionActivity.class);
            startActivity(i);
        }

        else if(v.getId() == R.id.quizOopsBtn) //Else go back to home
        {
            Intent i = new Intent(this, HomeActivity.class);
            startActivity(i);
        }

    }
}
