package edu.csumb.quizzu;

import java.util.ArrayList;

/**
 * Created by asymkowick on 3/6/16.
 */
public class Quiz {
    String quizName;
    ArrayList<Question> quizQuestions;
    Category quizCategory;


    //Default Constructor
    public Quiz() {
        //what should a default quiz contain?
    }

    //Start the quiz taskflow
    public void startQuiz() {

    }

    //Stop the quiz taskflow because user reached the end of quiz (save data)
    public void finishQuiz() {

    }

    //Stop the quiz taskflow because the user gave up (don't save data)
    public void cancelQuiz() {

    }

    //Return a list of questions that the user answered correctly
    public ArrayList<Question> questionsCorrect() {
        return quizQuestions; //Placeholder
    }

    //Return a list of questions that the user answered incorrectly
    public ArrayList<Question> questionsIncorrect() {
        return quizQuestions; //Placeholder
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public ArrayList<Question> getQuizQuestions() {
        return quizQuestions;
    }

    public void setQuizQuestions(ArrayList<Question> quizQuestions) {
        this.quizQuestions = quizQuestions;
    }

    public Category getQuizCategory() {
        return quizCategory;
    }

    public void setQuizCategory(Category quizCategory) {
        this.quizCategory = quizCategory;
    }

    //Return the user's score for this quiz
    public double determineScore() {
        return 999; //Placeholder

    }

}
