package edu.csumb.quizzu;

import java.util.ArrayList;

/**
 * Created by asymkowick on 3/6/16.
 */
public class Question {
    Quiz ownedByQuiz; //Keep track of where this question belongs
    ArrayList<Answer> answerChoices; //List of the possible answers for this quiz
    Difficulty difficultyLevel; //Organize questions into difficulty levels
    int scoreValue; //How many points this question is worth

    //Default constructor
    public Question() {

    }

    //Check if the user's response is correct
    public boolean checkAnswer() {
        return true; //Placeholder
    }
}
