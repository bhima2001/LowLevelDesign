package StackOverflow.Answer;

import java.util.Random;

import StackOverflow.User.User;

public class Comment {
    private int id;
    private String commentString;
    private int upVotes = 0;
    private int downVotes = 0;
    private Answer answer;
    private User user;

    public Comment(String commentString, Answer answer, User user) {
        Random random = new Random();
        this.id = random.nextInt();
        this.commentString = commentString;
        this.answer = answer;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getComment() {
        return commentString;
    }

    public boolean setComment(String comment, int userId) {
        if (this.user.getId() != userId) {
            return false;
        }
        this.commentString = comment;
        return true;
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

    public Answer getAnswer() {
        return answer;
    }
}
