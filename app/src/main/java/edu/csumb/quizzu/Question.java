package edu.csumb.quizzu;

import java.util.ArrayList;

/**
 * Created by asymkowick on 3/6/16.
 */
public class Question {
    Quiz ownedByQuiz; //Keep track of where this question belongs
    String question; //The actual question, like, What is the square root of a cat?
    ArrayList<Answer> answerChoices; //List of the possible answers for this quiz
    Difficulty difficultyLevel; //Organize questions into difficulty levels
    int scoreValue; //How many points this question is worth

    //Default constructor
    public Question() {

    }

    public Quiz getOwnedByQuiz() {
        return ownedByQuiz;
    }

    public void setOwnedByQuiz(Quiz ownedByQuiz) {
        this.ownedByQuiz = ownedByQuiz;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<Answer> getAnswerChoices() {
        return answerChoices;
    }

    public void setAnswerChoices(ArrayList<Answer> answerChoices) {
        this.answerChoices = answerChoices;
    }

    public Difficulty getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(Difficulty difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public int getScoreValue() {
        return scoreValue;
    }

    public void setScoreValue(int scoreValue) {
        this.scoreValue = scoreValue;
    }

    //Check if the user's response is correct
    public boolean checkAnswer() {
        return true; //Placeholder
    }
}
