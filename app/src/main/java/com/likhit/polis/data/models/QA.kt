package com.likhit.polis.data.models

import java.io.Serializable

class QA : Serializable {

    var question: String? = null

    var answers: List<String>? = null

    var isQuestionMultiSelect: Boolean = false

    constructor() {}

    constructor(question: String, answers: List<String>, isQuestionMultiSelect: Boolean) {
        this.question = question
        this.answers = answers
        this.isQuestionMultiSelect = isQuestionMultiSelect
    }
}
