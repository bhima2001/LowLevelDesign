package StackOverflow.Question;

import java.util.Random;

public class Tag {
    private int id;
    private String tagName;

    public Tag(String tagName) {
        Random random = new Random();
        this.id = random.nextInt();
        this.tagName = tagName.toUpperCase();
    }

    public String getTagName() {
        return tagName;
    }

    public int getId() {
        return id;
    }
}