package StackOverflow.Question;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import StackOverflow.Answer.*;
import StackOverflow.User.User;

public class Question {
    private int id;
    private String questionString;
    private User author;
    private ArrayList<Answer> answerList;
    private ArrayList<Tag> tags;
    private String createdAt;

    public Question(String questionString, User author, ArrayList<Tag> tags) {
        Random random = new Random();
        this.id = random.nextInt();
        this.questionString = questionString;
        this.author = author;
        this.tags = tags;
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.createdAt = formatter.format(dateTime);
    }

    public int getId() {
        return id;
    }

    public String getQuestionString() {
        return questionString;
    }

    public void setQuestionString(String questionString) {
        this.questionString = questionString;
    }

    public User getAuthor() {
        return author;
    }

    public void addTags() {
        this.tags.addAll(tags);
    }

    public void removeTags(ArrayList<Tag> removeTags) {
        for (int i = 0; i < this.tags.size(); i++) {
            for (int j = 0; j < removeTags.size(); j++) {
                if (this.tags.get(i).getId() == removeTags.get(j).getId()) {
                    this.tags.remove(i);
                }
            }
        }
    }

    public ArrayList<Tag> getAllTags() {
        return this.tags;
    }

    public ArrayList<Answer> getAllAnswers() {
        return this.answerList;
    }

    public void addAnswer(Answer answer) {
        this.answerList.add(answer);
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
