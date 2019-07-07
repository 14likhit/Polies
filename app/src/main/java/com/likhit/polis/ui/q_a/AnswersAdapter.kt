package com.likhit.polis.ui.q_a

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.likhit.polis.R
import com.likhit.polis.databinding.LayoutQABinding
import com.likhit.polis.listeners.OnItemClickListener

class AnswersAdapter(private val onItemClickListener: OnItemClickListener<String>) : RecyclerView.Adapter<AnswersAdapter.AnswerViewHolder>() {

    private var answers: List<String>? = null

    private var inflater: LayoutInflater? = null

    fun setAnswers(answers: List<String>) {
        this.answers = answers
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): AnswerViewHolder {
        if (inflater == null) {
            inflater = LayoutInflater.from(viewGroup.context)
        }
        return AnswersAdapter.AnswerViewHolder(inflater!!.inflate(R.layout.layout_q_a, viewGroup, false))
    }

    override fun onBindViewHolder(answerViewHolder: AnswerViewHolder, i: Int) {
        val answer = answers!![i]
        answerViewHolder.binding!!.answersTv.text = answer

        answerViewHolder.binding.qaCv.setOnClickListener { v -> onItemClickListener.onItemClick(answer, answerViewHolder.adapterPosition, v) }

    }

    override fun getItemCount(): Int {
        return if (answers != null && answers!!.size > 0) {
            answers!!.size
        } else 0
    }

    inner class AnswerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding: LayoutQABinding?

        init {
            binding = DataBindingUtil.bind(itemView)
        }
    }
}
