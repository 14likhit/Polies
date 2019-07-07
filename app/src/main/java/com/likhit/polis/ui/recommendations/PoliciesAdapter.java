package com.likhit.polis.ui.recommendations;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.likhit.polis.R;
import com.likhit.polis.data.models.Policies;
import com.likhit.polis.databinding.LayoutPolicyItemBinding;
import com.likhit.polis.listeners.OnItemClickListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class PoliciesAdapter extends RecyclerView.Adapter<PoliciesAdapter.PoliciesViewHolder> {

    private List<Policies> policies;

    private OnItemClickListener<Policies> onItemClickListener;

    private LayoutInflater inflater;

    public PoliciesAdapter(OnItemClickListener<Policies> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setPolicies(List<Policies> policies) {
        this.policies = policies;
    }

    @NonNull
    @Override
    public PoliciesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (inflater == null) {
            inflater = LayoutInflater.from(viewGroup.getContext());
        }
        return new PoliciesAdapter.PoliciesViewHolder(inflater.inflate(R.layout.layout_policy_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PoliciesViewHolder policiesViewHolder, int i) {
        Policies policy = policies.get(i);
        policiesViewHolder.binding.policyTitleTv.setText(policy.getName());
        String imageUrlNoParams = getUrlWithoutParameters(policy.getImage());
        Picasso.get().load(policy.getImage())
                .stableKey(imageUrlNoParams)
                .placeholder(R.drawable.ic_launcher_background)
                .fit()
                .into(policiesViewHolder.binding.policyIv);
    }

    private String getUrlWithoutParameters(String url) {
        try {
            URI uri = new URI(url);
            return new URI(uri.getScheme(),
                    uri.getAuthority(),
                    uri.getPath(),
                    null, // Ignore the query part of the input url
                    uri.getFragment()).toString();
        } catch (URISyntaxException e) {
            return url;
        }
    }

    @Override
    public int getItemCount() {
        if (policies != null && policies.size() > 0) {
            return policies.size();
        }
        return 0;
    }

    public class PoliciesViewHolder extends RecyclerView.ViewHolder {
        private LayoutPolicyItemBinding binding;

        public PoliciesViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
