package edu.csumb.quizzu;

import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Date;

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

    Integer id;
    String name;
    String author;
    String question;
    String answer;
    String difficulty;
    String category;
    String created;

    public Quiz(String name, String author, String question, String answer,
                String difficulty, String category, String created) {
        this.name = name;
        this.author = author;
        this.question = question;
        this.answer = answer;
        this.difficulty = difficulty;
        this.category = category;
        this.created = getTimeStamp();
    }

    public void Quizzu(String name, String author, String question, String answer,
                String difficulty, String category, String created) {
        this.name = name;
        this.author = author;
        this.question = question;
        this.answer = answer;
        this.difficulty = difficulty;
        this.category = category;
        this.created = getTimeStamp();
    }
    //Return a list of questions that the user answered correctly
    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String getId(){
        return Integer.toString(id);
    }
    public String getName(){
        return name;
    }
    public String getAuthor(){
        return author;
    }
    public String getQuestion(){
        return question;
    }
    public String getAnswer(){
        return answer;
    }
    public String getCategory(){
        return category;
    }
    public String getDifficulty(){
        return difficulty;
    }
    public String getTimeStamp() {return created; }

    public void setId(Integer id){

    }
    public void setName(String name){

    }
    public void setAuthor(String author){

    }
    public void setQuestion(String question){

    }
    public void setAnswer(String answer) {

    }
    public void setCategory(String category){

    }
    public void setDifficulty(String difficulty) {

    }
    public void setCreated(String created) {

    }

}
