package com.likhit.polis.ui.q_a


import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.likhit.polis.base.BaseFragment
import com.likhit.polis.data.models.QA
import com.likhit.polis.databinding.FragmentQandBinding
import com.likhit.polis.listeners.OnItemClickListener
import com.likhit.polis.ui.home.HomeActivity
import com.likhit.polis.ui.home.HomeFragementListener
import com.likhit.polis.utils.AppConstants
import com.likhit.polis.utils.SampleQA

import java.util.ArrayList

class QandAFragment : BaseFragment(), OnItemClickListener<String> {

    private var binding: FragmentQandBinding? = null
    private var qa: QA? = null
    private var qaList: List<QA>? = null
    private val answers = ArrayList<String>()
    private var questionFinished = 0
    private var answersAdapter: AnswersAdapter? = null

    private var fragementListener: HomeFragementListener? = null
    private var homeActivity: HomeActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            this.qa = arguments!!.getSerializable(AppConstants.BUNDLE_KEY_QA) as QA
        }
        SampleQA.setQA()
        qaList = SampleQA.qas
        homeActivity = activity as HomeActivity?
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is HomeFragementListener) {
            fragementListener = context
        }
    }

    override fun onDetach() {
        fragementListener = null
        super.onDetach()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentQandBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun initViews(view: View) {
        super.initViews(view)
        if (answersAdapter == null) {
            answersAdapter = AnswersAdapter(this)
        }
        binding!!.answersRv.layoutManager = LinearLayoutManager(baseActivity, LinearLayoutManager.VERTICAL, false)
        binding!!.answersRv.adapter = answersAdapter
        updateView()
    }

    private fun updateView() {
        qa = qaList!![questionFinished]
        binding!!.questionsTv.text = qa!!.question
        answersAdapter!!.setAnswers(qa!!.answers)
        answersAdapter!!.notifyDataSetChanged()
    }

    override fun onItemClick(item: String, position: Int, view: View) {
        questionFinished++
        answers.add(Integer.toString(position + 1))
        homeActivity!!.updateAnswers(answers)
        if (questionFinished == qaList!!.size) {
            fragementListener!!.launchRecommendations(false)
            questionFinished = 0
        } else {
            updateView()
        }

    }

    companion object {
        val TAG = "QandAFragment"

        fun newInstance(): QandAFragment {
            return QandAFragment()
        }
    }
}
