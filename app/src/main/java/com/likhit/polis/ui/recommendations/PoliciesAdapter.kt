package com.likhit.polis.ui.recommendations

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.likhit.polis.R
import com.likhit.polis.data.models.Policy
import com.likhit.polis.databinding.LayoutPolicyItemBinding
import com.likhit.polis.listeners.OnItemClickListener
import com.likhit.polis.utils.Utils
import com.squareup.picasso.Picasso

class PoliciesAdapter(private val onItemClickListener: OnItemClickListener<Policy>) : RecyclerView.Adapter<PoliciesAdapter.PoliciesViewHolder>() {

    private var policies: List<Policy>? = null

    private var inflater: LayoutInflater? = null

    fun setPolicies(policies: List<Policy>) {
        this.policies = policies
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): PoliciesViewHolder {
        if (inflater == null) {
            inflater = LayoutInflater.from(viewGroup.context)
        }
        return PoliciesAdapter.PoliciesViewHolder(inflater!!.inflate(R.layout.layout_policy_item, viewGroup, false))
    }

    override fun onBindViewHolder(policiesViewHolder: PoliciesViewHolder, i: Int) {
        val policy = policies!![i]
        policiesViewHolder.binding!!.policyTitleTv.text = policy.name
        val imageUrlNoParams = Utils.getUrlWithoutParameters(policy.image)
        Picasso.get().load(policy.image)
                .stableKey(imageUrlNoParams)
                .placeholder(R.drawable.ic_launcher_background)
                .fit()
                .into(policiesViewHolder.binding.policyIv)

        policiesViewHolder.binding.policyLayout.setOnClickListener { v -> onItemClickListener.onItemClick(policy, policiesViewHolder.adapterPosition, v) }
    }


    override fun getItemCount(): Int {
        return if (policies != null && policies!!.size > 0) {
            policies!!.size
        } else 0
    }

    inner class PoliciesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: LayoutPolicyItemBinding?

        init {
            binding = DataBindingUtil.bind(itemView)
        }
    }
}
