package com.likhit.polis.data.models;

import java.io.Serializable;
import java.util.List;

public class QA implements Serializable {

    private String question;

    private List<String> answers;

    private boolean isQuestionMultiSelect;

    public QA() {
    }

    public QA(String question, List<String> answers, boolean isQuestionMultiSelect) {
        this.question = question;
        this.answers = answers;
        this.isQuestionMultiSelect = isQuestionMultiSelect;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public boolean isQuestionMultiSelect() {
        return isQuestionMultiSelect;
    }

    public void setQuestionMultiSelect(boolean questionMultiSelect) {
        isQuestionMultiSelect = questionMultiSelect;
    }
}
