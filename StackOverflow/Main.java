package StackOverflow;

import java.util.ArrayList;
import java.util.Arrays;

import StackOverflow.Answer.Answer;
import StackOverflow.Question.Question;
import StackOverflow.Question.Tag;
import StackOverflow.User.User;

public class Main {
    public static void main(String[] args) {
        StackOverFlowDemo stackOverFlow = StackOverFlowDemo.getInstance();

        User u1 = stackOverFlow.createUser("bhima2001", "bhimashankar2001@gmail.com");
        System.out.println("Id: " + u1.getId() + " Name: " + u1.getName());

        ArrayList<String> tags = new ArrayList<String>(Arrays.asList("lld", "JAVA", "oops"));
        Question q = stackOverFlow.askQuestion("How to learn low level desgin?", u1, tags);
        System.out.println(
                "Id: " + q.getId() + " Question: " + q.getQuestionString() + " Author: " + q.getAuthor().getName());

        ArrayList<Tag> tags2 = new ArrayList<Tag>();
        tags2 = q.getAllTags();
        for (int i = 0; i < tags2.size(); i++)
            System.out.println(tags2.get(i).getTagName());

        User u2 = stackOverFlow.createUser("shankar", "shankar@gmail.com");
        Answer a = stackOverFlow.answerQuestion("You have to practise lld by coding", q.getId(), u2.getId());
        System.out.println(
                "Id: " + a.getId() + " Question: " + a.getAnswerString() + " Author: " + a.getUser().getName());
    }
}