package com.example.stackrx.services.questions.service;

import com.example.stackrx.services.questions.model.Questions;

import retrofit2.http.GET;
import rx.Observable;

public interface IStackExchangeService {
    @GET("/2.2/questions?order=desc&sort=activity&site=stackoverflow")
    Observable<Questions> getQuestions();
}
