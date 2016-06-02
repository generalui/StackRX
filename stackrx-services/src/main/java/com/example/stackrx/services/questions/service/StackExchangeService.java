package com.example.stackrx.services.questions.service;


import com.example.stackrx.services.questions.model.Answers;
import com.example.stackrx.services.questions.model.Questions;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.schedulers.Schedulers;

public class StackExchangeService {

    private static final String ENDPOINT = "https://api.stackexchange.com";

    private final IStackExchangeService mStackExchangeService;

    public StackExchangeService() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        Gson gsonCamelCase = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create(gsonCamelCase))
                .build();

        mStackExchangeService = retrofit.create(IStackExchangeService.class);
    }

    /**
     * GET list of questions
     *
     * @return List of questions
     */
    public Observable<Questions> getQuestions() {
        return mStackExchangeService.getQuestions();
    }

    public Observable<Answers> getAnswers(String questionID) {
        return mStackExchangeService.getAnswers(questionID);
    }
}
