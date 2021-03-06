package com.example.main.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.main.adapter.QuestionRecyclerViewAdapter;
import com.example.stackrx.R;
import com.example.stackrx.services.questions.model.QuestionItem;
import com.example.stackrx.services.questions.model.Questions;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class QuestionsFragment extends StackRXBaseFragment {


    //region INJECTED CLASSES ----------------------------------------------------------------------
    //endregion

    //region INJECTED VIEWS ------------------------------------------------------------------------

    @BindView(R.id.question_fragment_question_recycler_view)
    RecyclerView mQuestionsRecyclerView;

    //endregion


    //region LOCAL CONSTANTS -----------------------------------------------------------------------
    //endregion


    //region FIELDS --------------------------------------------------------------------------------

    private Context mContext;

    private QuestionRecyclerViewAdapter mQuestionRecyclerViewAdapter;

    //endregion


    //region CONSTRUCTOR ---------------------------------------------------------------------------
    //endregion


    //region LIFE CYCLE METHODS --------------------------------------------------------------------


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity().getBaseContext();
        mQuestionRecyclerViewAdapter = new QuestionRecyclerViewAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.questions_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Setup recycler view
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mQuestionsRecyclerView.setHasFixedSize(true);
        mQuestionsRecyclerView.setLayoutManager(layoutManager);
        mQuestionsRecyclerView.setAdapter(mQuestionRecyclerViewAdapter);

        addSubscription(mQuestionRecyclerViewAdapter.getQuestionItemSelected()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<QuestionItem>() {
                    @Override
                    public void call(QuestionItem item) {
                        onQuestionItemSelected(item);
                    }
                }));
    }

    @Override
    public void onResume() {
        super.onResume();
        apiGetQuestions();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mQuestionsRecyclerView.setAdapter(null);
        mQuestionsRecyclerView.setLayoutManager(null);
    }

    //endregion


    //region WIDGET --------------------------------------------------------------------------------
    //endregion


    //region LISTENERS -----------------------------------------------------------------------------
    //endregion


    //region EVENTS --------------------------------------------------------------------------------
    //endregion


    //region LOCAL METHODS -------------------------------------------------------------------------

    private void onQuestionItemSelected(QuestionItem item) {
        Log.i("TAG", "question item selected: " + item.getTitle());
        //todo: implement me
    }

    private void apiGetQuestions() {
        addSubscription(getQuestionsDAO().getQuestions()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Questions>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(mContext, mContext.getString(R.string.service_error),
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(Questions questions) {
                        mQuestionRecyclerViewAdapter.setItemList(questions.getItems());
                        mQuestionRecyclerViewAdapter.notifyDataSetChanged();
                    }
                }));
    }

    //endregion


    //region ACCESSORS -----------------------------------------------------------------------------
    //endregion


    //region INNER CLASSES -------------------------------------------------------------------------
    //endregion


    //region CLASS METHODS -------------------------------------------------------------------------
    //endregion

}
