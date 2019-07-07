package com.likhit.polis.utils

import com.likhit.polis.data.models.QA

import java.util.ArrayList

object SampleQA {

    var qas: List<QA>? = null

    private val q1 = "Why do you want Insurance?"
    private val q1a1 = "Invest for safe future"
    private val q1a2 = "Worried of coming future"
    private val q1a3 = "Increase in Inflation"
    private val q1a4 = "To meet demand"
    private val q2 = "What is your source of Income?"
    private val q2a1 = "Salaried"
    private val q2a2 = "Daily Wages"
    private val q2a3 = "Self Employed"
    private val q2a4 = "Freelancer"
    private val q3 = "What is your monthly income?"
    private val q3a1 = "< ₹25000"
    private val q3a2 = "₹25000 - ₹50000"
    private val q3a3 = "₹50000-₹100000"
    private val q3a4 = "₹100000 >"
    private val q4 = "Do you exercise daily?"
    private val q4a1 = "Yes"
    private val q4a2 = "No"
    private val q4a3 = "2-3 days in week"
    private val q4a4 = "Once in a blue moon"
    private val q5 = "Are you addicted to Alcohol/Tobacco?"
    private val q5a1 = "Yes"
    private val q5a2 = "No"
    private val q5a3 = "Yes, when in tension"
    private val q5a4 = "Yes, occasionally"

    fun setQA() {
        val qaList = ArrayList<QA>()
        val answers1 = ArrayList<String>()
        answers1.add(q1a1)
        answers1.add(q1a2)
        answers1.add(q1a3)
        answers1.add(q1a4)
        val qa1 = QA()
        qa1.question = q1
        qa1.answers = answers1
        qaList.add(qa1)
        val answers2 = ArrayList<String>()
        answers2.add(q2a1)
        answers2.add(q2a2)
        answers2.add(q2a3)
        answers2.add(q2a4)
        val qa2 = QA()
        qa2.question = q2
        qa2.answers = answers2
        qaList.add(qa2)
        val answers3 = ArrayList<String>()
        answers3.add(q3a1)
        answers3.add(q3a2)
        answers3.add(q3a3)
        answers3.add(q3a4)
        val qa3 = QA()
        qa3.question = q3
        qa3.answers = answers3
        qaList.add(qa3)
        val answers4 = ArrayList<String>()
        answers4.add(q4a1)
        answers4.add(q4a2)
        answers4.add(q4a3)
        answers4.add(q4a4)
        val qa4 = QA()
        qa4.question = q4
        qa4.answers = answers4
        qaList.add(qa4)
        val answers5 = ArrayList<String>()
        answers5.add(q5a1)
        answers5.add(q5a2)
        answers5.add(q5a3)
        answers5.add(q5a4)
        val qa5 = QA()
        qa5.question = q5
        qa5.answers = answers5
        qaList.add(qa5)
        qas = qaList
    }
}
