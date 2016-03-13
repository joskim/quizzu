package edu.csumb.quizzu;

/**
 * Created by asymkowick on 3/6/16.
 */
public class Answer {
    String text;

    //Default Constructor
    public Answer() {

    }

    public Answer(String t) {
        this.text = t;
    }

    //Set the text of an answer
    public void setText(String t) {
        this.text = t;
    }

    //Get the answer text
    public String getText() {
        return this.text;
    }

    @Override
    public String toString() {
        return text;
    }


    @Override
    public int hashCode() {
        return text != null ? text.hashCode() : 0;
    }

    @Override
    public boolean equals(Object s) {
        if(s.toString().equals(this.text))
            return true;
        else return false;
    }
}
