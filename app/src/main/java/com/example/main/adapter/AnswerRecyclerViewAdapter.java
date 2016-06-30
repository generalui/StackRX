package com.example.main.adapter;


import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.stackrx.R;
import com.example.stackrx.services.questions.model.AnswerItem;
import com.example.stackrx.services.questions.model.QuestionItem;

import java.util.ArrayList;
import java.util.List;

public class AnswerRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<AnswerItem> answers = new ArrayList<>();
    private String ownerDisplayName;
    private String body;
    private int score;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ItemHolder) holder).bind();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setItemList(@Nullable List<AnswerItem> itemList) {
        answers.clear();
        if (itemList != null) {
            answers.addAll(itemList);
        }
    }

    private static class ItemHolder extends RecyclerView.ViewHolder {

        public TextView mOwnerDisplayNameTextView;
        public TextView mBodyTextView;
        public TextView mScoreTextView;

        private ItemHolder(View itemView) {
            super(itemView);
//            mQuestionText = (TextView) itemView.findViewById(R.id.item_question_question_text_view);
//            mViewAnswersButton = (Button) itemView.findViewById(R.id.item_question_view_answers_button);
        }

        public void bind(AnswerItem item) {
            mOwnerDisplayNameTextView.setText(item.getOwner().getDisplayName());
            //todo convert from html
            mBodyTextView.setText(item.getBody());
            //mScoreTextView.setText();
        }
    }
}
