package com.example.stackrx.services.questions.model;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Answers {

    @Expose
    private List<AnswerItem> items = new ArrayList<AnswerItem>();
    @Expose
    private Boolean hasMore;
    @Expose
    private Integer quotaMax;
    @Expose
    private Integer quotaRemaining;

    public List<AnswerItem> getItems() {
        return items;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public Integer getQuotaMax() {
        return quotaMax;
    }

    public Integer getQuotaRemaining() {
        return quotaRemaining;
    }
}
