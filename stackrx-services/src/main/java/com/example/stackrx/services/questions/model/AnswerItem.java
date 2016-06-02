package com.example.stackrx.services.questions.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnswerItem {

    @Expose
    private Owner owner;

    @Expose
    private Boolean isAccepted;

    @Expose
    private Integer score;

    @Expose
    private Integer answerId;

    @Expose
    private Integer questionId;

    @Expose
    private String title;

    @Expose
    private String body;


    public Owner getOwner() {
        return owner;
    }

    public Boolean getAccepted() {
        return isAccepted;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
