package edu.csumb.quizzu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.gms.games.quest.QuestEntity;

import java.util.ArrayList;

import signin.SignInActivity;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "ya'll are turkeys", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View demoQuizButton = (Button) findViewById(R.id.demoQuizBtn);
        demoQuizButton.setOnClickListener(this);

        // Button For quiz landing
        View quizLanding = (Button) findViewById(R.id.quizLanding);
        quizLanding.setOnClickListener(this);

        //Button for flipper page
        View flipperDemo = (Button) findViewById(R.id.flipperButton);
        flipperDemo.setOnClickListener(this);

    }

    public void onClick(View v) {
        if(v.getId() == R.id.demoQuizBtn)
        {
            generateDemoQuiz(); //Create a demo quiz for Milestone 1

            //TODO: PutExtra all the quiz info into the new activity, MUST FIRST IMPLEMENT PARCELABLE ON ALL CUSTOM CLASSES ¯\_(ツ)_/¯
            Intent i = new Intent(this, QuizActivity.class);
            startActivity(i);
        }

        /*
        Added button to go to quiz landing page to test DB and a flipper for taking quizes witout starting a new activity
        - RI
         */
        if(v.getId() == R.id.quizLanding)
        {
            createQuizData();
            Intent i = new Intent(this, QuizLanding.class);
            startActivity(i);
        }

        if(v.getId() == R.id.flipperButton)
        {
            Intent i = new Intent(this, FlipperActivity.class);
            startActivity(i);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void generateDemoQuiz() {
        //YO, check it out guys. I wrote out a demo of how to create a quiz and tried to show most of the methods we are gonna need
        Quiz demoQuiz = new Quiz(); //Instantiate a Quiz
        Category testCategory = makeCategory(); //Make some bs categories to attach the quiz
        Question question1 = new Question(); //Make some bs questions (just one for now)
        question1.setQuestion("Which of the following famous scientist cured Cat Cancer?"); //Set the question ... of the question? IDK how to word this better

        //Make some funny cat names
        Answer a1 = new Answer("H. John Whiskers");
        Answer a2 = new Answer("Bartolemeu Meowser");
        Answer a3 = new Answer("Catalie Portman");
        Answer a4 = new Answer("Anderson Pooper");

        //Build an arraylist full of said cat names
        ArrayList<Answer> answerList = new ArrayList<Answer>();
        answerList.add(a1);
        answerList.add(a2);
        answerList.add(a3);
        answerList.add(a4);

        //Put those answers inside that question!
        question1.setAnswerChoices(answerList);
        question1.setCorrectAnswer(a1); //Everybody knows H John Whiskers cured kitty cancer

        //Build an arraylist full of the question(s) you just made, in our demo case there is only one question
        ArrayList<Question> questionList = new ArrayList<Question>();
        questionList.add(question1); //Put the questions inside your list


        //Put all the data you just made into a Quiz
        demoQuiz.setQuizName("Famous Cat Scientists");
        demoQuiz.setQuizCategory(testCategory);
        demoQuiz.setQuizQuestions(questionList);

    }

    public Category makeCategory() {
        Category test = new Category();
        test.setCategoryName("Science");
        return test;
    }

    public void createQuizData() {
        QuizzuSQLiteHelper quizTest = new QuizzuSQLiteHelper(this);
        for(int i = 0; i < 4; i++){
            quizTest.insertQuiz(new Quiz("name", "author", "question", "answer", "description", "difficulty", "timeStamp"));
        }

    }


}
