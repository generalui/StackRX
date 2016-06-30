package com.example.main.fragment;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.main.adapter.AnswerRecyclerViewAdapter;
import com.example.stackrx.R;
import com.example.stackrx.services.questions.model.AnswerItem;
import com.example.stackrx.services.questions.model.Answers;
import com.example.stackrx.services.questions.model.Owner;
import com.example.stackrx.services.questions.model.QuestionItem;
import com.example.stackrx.services.questions.model.Questions;
import com.example.stackrx.services.questions.service.StackExchangeService;

import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Fragment for displaying answers to a Stack Overflow question
 */
public class AnswersFragment extends StackRXBaseFragment {
    public final static String QUESTION_ID = "questionID";
    public final static String ANSWERS_FRAGMENT_BACKSTACK_ID = "answersFragment";

    RecyclerView recyclerView;
    AnswerRecyclerViewAdapter adapter;

    public static AnswersFragment newInstance(QuestionItem item) {
        AnswersFragment fragment = new AnswersFragment();
        int questionId = item.getQuestionId();
        Bundle args = new Bundle();
        args.putInt(QUESTION_ID, questionId);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(QUESTION_ID)) {
            apiGetAnswers(getArguments().getInt(QUESTION_ID));
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void addSubscription(Subscription subscription) {
        super.addSubscription(subscription);
    }

    @Override
    public StackExchangeService getStackExchangeDAO() {
        return super.getStackExchangeDAO();
    }

    private void apiGetAnswers(int questionId) {
        addSubscription(
                getStackExchangeDAO().getAnswers(questionId)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Answers>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
//                                Toast.makeText(mContext, mContext.getString(R.string.service_error),
//                                        Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onNext(Answers answers) {
                                adapter.setItemList(answers.getItems());
                            }
                        }));
    }


}
