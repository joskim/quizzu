package edu.csumb.quizzu;

/**
 * Created by asymkowick on 3/6/16.
 */
public class Category {
    String categoryName;


    public Category() {
        this.categoryName = "DEFAULT";
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}

