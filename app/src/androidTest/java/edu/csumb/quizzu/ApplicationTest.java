package edu.csumb.quizzu;

import android.app.Application;
import android.test.ApplicationTestCase;

import java.util.ArrayList;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {

        super(Application.class);












    }

    public void testCategory() {
        Category c = new Category();
        c.setCategoryName("Animals");
        assertEquals("Animals", c.getCategoryName());
    }

    public void testAnswer() {
        Answer a = new Answer();
        a.setText("Cat");
        ArrayList<Answer> answerArrayList = new ArrayList<Answer>();
        answerArrayList.add(a);

        assertEquals("Cat", a.getText());

    }

    public void testQuestion() {
        Answer a = new Answer();
        a.setText("Cat");
        ArrayList<Answer> answerArrayList = new ArrayList<Answer>();
        answerArrayList.add(a);

        Question myQuestion = new Question();
        myQuestion.setQuestion("What is the opposite of a dog?");
        myQuestion.setAnswerChoices(answerArrayList);

        assertEquals(answerArrayList, myQuestion.getAnswerChoices()); //Just checking that the answers are stored correctly
    }

    public void testQuiz() {
        Category c = new Category();
        c.setCategoryName("Animals");
        assertEquals("Animals", c.getCategoryName());

        Answer a = new Answer();
        a.setText("Cat");
        ArrayList<Answer> answerArrayList = new ArrayList<Answer>();
        answerArrayList.add(a);

        Question myQuestion = new Question();
        myQuestion.setQuestion("What is the opposite of a dog?");
        myQuestion.setAnswerChoices(answerArrayList);

        ArrayList<Question> questionArrayList = new ArrayList<>();
        questionArrayList.add(myQuestion);


        Quiz q = new Quiz();
        q.setQuizName("A History of Dance Styles Inspired by the Common House Cat");
        q.setQuizCategory(c);
        q.setQuizQuestions(questionArrayList);

        assertEquals("A History of Dance Styles Inspired by the Common House Cat", q.getQuizName());
        assertEquals("Animals", q.getQuizCategory().getCategoryName());
        assertEquals(questionArrayList, q.getQuizQuestions());
    }


}