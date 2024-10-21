package StackOverflow;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import StackOverflow.Answer.Answer;
import StackOverflow.Question.Question;
import StackOverflow.Question.Tag;
import StackOverflow.User.User;

public class StackOverFlowDemo {
    private static StackOverFlowDemo stackOverFlow;
    private Map<Integer, Question> questionList;
    private Map<Integer, User> userList;
    private Map<Integer, Answer> answerList;
    private Map<String, Tag> tagList;

    private StackOverFlowDemo() {
        questionList = new ConcurrentHashMap<Integer, Question>();
        userList = new ConcurrentHashMap<Integer, User>();
        answerList = new ConcurrentHashMap<Integer, Answer>();
        tagList = new ConcurrentHashMap<String, Tag>();
    }

    public static StackOverFlowDemo getInstance() {
        if (stackOverFlow == null) {
            stackOverFlow = new StackOverFlowDemo();
        }
        return stackOverFlow;
    }

    public User createUser(String name, String email) {
        User user = new User(name, email);
        userList.put(user.getId(), user);
        return user;
    }

    public Question askQuestion(String questionString, User autor, ArrayList<String> tags) {
        Question question = new Question(questionString, autor, findOrCreateTag(tags));
        questionList.put(question.getId(), question);

        return question;
    }

    public ArrayList<Tag> findOrCreateTag(ArrayList<String> tags) {
        ArrayList<Tag> tagsList = new ArrayList<Tag>();
        for (int i = 0; i < tags.size(); i++) {
            if (tagList.containsKey(tags.get(i).toUpperCase())) {
                tagsList.add(tagList.get(tags.get(i).toUpperCase()));
            } else {
                Tag newTag = new Tag(tags.get(i).toUpperCase());
                tagList.put(tags.get(i).toUpperCase(), newTag);
                tagsList.add(newTag);
            }
        }
        return tagsList;
    }

    public Answer answerQuestion(String answerString, int questionId, int userId) {
        if (!questionList.containsKey(questionId)) {
            return null;
        }
        if (!userList.containsKey(userId)) {
            return null;
        }

        Answer answer = new Answer(answerString, questionList.get(questionId), userList.get(userId));
        answerList.put(answer.getId(), answer);

        return answer;
    }

    public String addAComment(String commentString, int answerId, int userId) {
        if (!answerList.containsKey(answerId)) {
            return "Please answer an existing question.";
        }
        if (!userList.containsKey(userId)) {
            return "Please login or create an account.";
        }

        answerList.get(answerId).addComment(commentString, userList.get(userId));
        return "Comment has been added successfully.";
    }

    public User getUser(int userId) {
        if (!userList.containsKey(userId)) {
            return null;
        }

        return userList.get(userId);
    }

    public Answer getAnswer(int answerId) {
        if (!answerList.containsKey(answerId)) {
            return null;
        }

        return answerList.get(answerId);
    }

    public Question getQuestion(int questionId) {
        if (!questionList.containsKey(questionId)) {
            return null;
        }

        return questionList.get(questionId);
    }
}
