package com.likhit.polis.ui.q_a;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.likhit.polis.R;
import com.likhit.polis.databinding.LayoutQABinding;
import com.likhit.polis.listeners.OnItemClickListener;

import java.util.List;

public class AnswersAdapter extends RecyclerView.Adapter<AnswersAdapter.AnswerViewHolder> {

    private List<String> answers;

    private OnItemClickListener<String> onItemClickListener;

    private LayoutInflater inflater;

    public AnswersAdapter(OnItemClickListener<String> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    @NonNull
    @Override
    public AnswerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (inflater == null) {
            inflater = LayoutInflater.from(viewGroup.getContext());
        }
        return new AnswersAdapter.AnswerViewHolder(inflater.inflate(R.layout.layout_q_a, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final AnswerViewHolder answerViewHolder, int i) {
        final String answer = answers.get(i);
        answerViewHolder.binding.answersTv.setText(answer);

        answerViewHolder.binding.qaCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(answer, answerViewHolder.getAdapterPosition(), v);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (answers != null && answers.size() > 0) {
            return answers.size();
        }
        return 0;
    }

    public class AnswerViewHolder extends RecyclerView.ViewHolder {

        private LayoutQABinding binding;

        public AnswerViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
