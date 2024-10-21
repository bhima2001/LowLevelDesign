package StackOverflow.User;

import java.util.ArrayList;
import java.util.Random;

import StackOverflow.Answer.Answer;

public class User {
    private int id;
    private String name;
    private String email;
    private ArrayList<Answer> answersSubmited;

    public User(String name, String email) {
        Random random = new Random();
        this.id = random.nextInt();
        this.name = name;
        this.email = email;
        this.answersSubmited = new ArrayList<Answer>();
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int calculateReputation() {
        int reputation = 0;
        for (int i = 0; i < this.answersSubmited.size(); i++) {
            reputation += (this.answersSubmited.get(i).getUpVotes() - this.answersSubmited.get(i).getDownVotes());
        }

        return reputation;
    }
}
