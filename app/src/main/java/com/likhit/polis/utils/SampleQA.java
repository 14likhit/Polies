package com.likhit.polis.utils;

import com.likhit.polis.data.models.QA;

import java.util.ArrayList;
import java.util.List;

public class SampleQA {

    private static List<QA> qas;

    private static String q1 = "Why do you want Insurance?";
    private static String q1a1 = "Invest for safe future";
    private static String q1a2 = "Worried of coming future";
    private static String q1a3 = "Increase in Inflation";
    private static String q1a4 = "To meet demand";
    private static String q2 = "What is your source of Income?";
    private static String q2a1 = "Salaried";
    private static String q2a2 = "Daily Wages";
    private static String q2a3 = "Self Employed";
    private static String q2a4 = "Freelancer";
    private static String q3 = "What is your monthly income?";
    private static String q3a1 = "< ₹25000";
    private static String q3a2 = "₹25000 - ₹50000";
    private static String q3a3 = "₹50000-₹100000";
    private static String q3a4 = "₹100000 >";
    private static String q4 = "Do you exercise daily?";
    private static String q4a1 = "Yes";
    private static String q4a2 = "No";
    private static String q4a3 = "2-3 days in week";
    private static String q4a4 = "Once in a blue moon";
    private static String q5 = "Are you addicted to Alcohol/Tobacco?";
    private static String q5a1 = "Yes";
    private static String q5a2 = "No";
    private static String q5a3 = "Yes, when in tension";
    private static String q5a4 = "Yes, occasionally";


    public static List<QA> getQas() {
        return qas;
    }

    public static void setQas(List<QA> qas) {
        SampleQA.qas = qas;
    }

    public static void setQA() {
        List<QA> qaList = new ArrayList<>();
        QA qa = new QA();
        List<String> answers = new ArrayList<>();
        answers.add(q1a1);
        answers.add(q1a2);
        answers.add(q1a3);
        answers.add(q1a4);
        qa.setQuestion(q1);
        qa.setAnswers(answers);
        qaList.add(qa);
        answers.clear();
        answers.add(q2a1);
        answers.add(q2a2);
        answers.add(q2a3);
        answers.add(q2a4);
        qa.setQuestion(q2);
        qa.setAnswers(answers);
        qaList.add(qa);
        answers.clear();
        answers.add(q3a1);
        answers.add(q3a2);
        answers.add(q3a3);
        answers.add(q3a4);
        qa.setQuestion(q3);
        qa.setAnswers(answers);
        qaList.add(qa);
        answers.clear();
        answers.add(q4a1);
        answers.add(q4a2);
        answers.add(q4a3);
        answers.add(q4a4);
        qa.setQuestion(q4);
        qa.setAnswers(answers);
        qaList.add(qa);
        answers.clear();
        answers.add(q5a1);
        answers.add(q5a2);
        answers.add(q5a3);
        answers.add(q5a4);
        qa.setQuestion(q5);
        qa.setAnswers(answers);
        qaList.add(qa);
        setQas(qaList);
    }
}
