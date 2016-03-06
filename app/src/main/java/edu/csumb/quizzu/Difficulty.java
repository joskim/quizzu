package edu.csumb.quizzu;

/**
 * Created by asymkowick on 3/6/16.
 */
public class Difficulty {
    String difficultyName;

    public Difficulty() {
        this.difficultyName = "Easy";
    }

    public void setDifficulty(int d) {

        switch(d) {
            case 1: this.difficultyName = "Easy";
                    break;
            case 2: this.difficultyName = "Medium";
                    break;
            case 3: this.difficultyName = "Hard";
        }
    }
}
