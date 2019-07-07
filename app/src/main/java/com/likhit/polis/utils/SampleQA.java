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
        List<String> answers1 = new ArrayList<>();
        answers1.add(q1a1);
        answers1.add(q1a2);
        answers1.add(q1a3);
        answers1.add(q1a4);
        QA qa1 = new QA();
        qa1.setQuestion(q1);
        qa1.setAnswers(answers1);
        qaList.add(qa1);
        List<String> answers2 = new ArrayList<>();
        answers2.add(q2a1);
        answers2.add(q2a2);
        answers2.add(q2a3);
        answers2.add(q2a4);
        QA qa2 = new QA();
        qa2.setQuestion(q2);
        qa2.setAnswers(answers2);
        qaList.add(qa2);
        List<String> answers3 = new ArrayList<>();
        answers3.add(q3a1);
        answers3.add(q3a2);
        answers3.add(q3a3);
        answers3.add(q3a4);
        QA qa3 = new QA();
        qa3.setQuestion(q3);
        qa3.setAnswers(answers3);
        qaList.add(qa3);
        List<String> answers4 = new ArrayList<>();
        answers4.add(q4a1);
        answers4.add(q4a2);
        answers4.add(q4a3);
        answers4.add(q4a4);
        QA qa4 = new QA();
        qa4.setQuestion(q4);
        qa4.setAnswers(answers4);
        qaList.add(qa4);
        List<String> answers5 = new ArrayList<>();
        answers5.add(q5a1);
        answers5.add(q5a2);
        answers5.add(q5a3);
        answers5.add(q5a4);
        QA qa5 = new QA();
        qa5.setQuestion(q5);
        qa5.setAnswers(answers5);
        qaList.add(qa5);
        setQas(qaList);
    }
}
