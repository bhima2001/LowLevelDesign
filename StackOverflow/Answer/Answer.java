package StackOverflow.Answer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import StackOverflow.Question.Question;
import StackOverflow.User.User;

public class Answer {
    private int id;
    private String answerString;
    private int upVotes = 0;
    private int downVotes = 0;
    private Question question;
    private ArrayList<Comment> comments;
    private User user;
    private String createdAt;

    public Answer(String answerString, Question question, User user) {
        Random random = new Random();
        this.id = random.nextInt();
        this.answerString = answerString;
        this.user = user;
        this.question = question;
        this.comments = new ArrayList<Comment>();
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.createdAt = formatter.format(dateTime);
    }

    public int getId() {
        return id;
    }

    public String getAnswerString() {
        return answerString;
    }

    public void setAnswerString(String answerString) {
        this.answerString = answerString;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public void incrUpvote() {
        this.upVotes += 1;
    }

    public int getDownVotes() {
        return downVotes;
    }

    public void incrDownvote() {
        this.downVotes += 1;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public Question getQuestion() {
        return question;
    }

    public User getUser() {
        return user;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void addComment(String commentString, User user) {
        new Comment(commentString, this, user);
    }
}