package com.example.stackrx.services.questions.service;

import com.example.stackrx.services.questions.model.Answers;
import com.example.stackrx.services.questions.model.Questions;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface IStackExchangeService {
    @GET("/2.2/questions?order=desc&sort=activity&site=stackoverflow")
    Observable<Questions> getQuestions();

    @GET("/2.2/questions/{questionID}/answers?order=desc&sort=activity&site=stackoverflow&filter=!-*f(6t0WW)1e")
    Observable<Answers> getAnswers(@Path("questionID") String questionID);

}
