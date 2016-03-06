package edu.csumb.quizzu;

/**
 * Created by asymkowick on 3/6/16.
 */
public class Answer {
    String text;

    //Default Constructor
    public Answer() {

    }

    //Set the text of an answer
    public void setText(String t) {
        this.text = t;
    }

    //Get the answer text
    public String getText() {
        return this.text;
    }
}
