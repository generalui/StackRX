package com.example.stackrx.services.questions.model;

import com.google.gson.annotations.Expose;

public class AnswerItem {

    @Expose
    private Owner owner;
    @Expose
    private Boolean isAccepted;
    @Expose
    private Integer score;
    @Expose
    private Integer lastActivityDate;
    @Expose
    private Integer lastEditDate;
    @Expose
    private Integer creationDate;
    @Expose
    private Integer answerId;
    @Expose
    private Integer questionId;
    @Expose
    private String body;

    public Owner getOwner() {
        return owner;
    }

    public Boolean getIsAccepted() {
        return isAccepted;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getLastActivityDate() {
        return lastActivityDate;
    }

    public Integer getLastEditDate() {
        return lastEditDate;
    }

    public Integer getCreationDate() {
        return creationDate;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public String getBody() {
        return body;
    }
}
