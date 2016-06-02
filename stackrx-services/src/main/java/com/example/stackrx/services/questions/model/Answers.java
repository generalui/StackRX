
package com.example.stackrx.services.questions.model;

import com.google.gson.annotations.Expose;

import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Answers {

    @Expose
    private List<AnswerItem> items;

    @Expose
    private Boolean hasMore;

    @Expose
    private Integer quotaMax;

    @Expose
    private Integer quotaRemaining;

    /**
     * 
     * @return
     *     The items
     */
    public List<AnswerItem> getItems() {
        return items;
    }

    /**
     * 
     * @param items
     *     The items
     */
    public void setItems(List<AnswerItem> items) {
        this.items = items;
    }

    /**
     * 
     * @return
     *     The hasMore
     */
    public Boolean getHasMore() {
        return hasMore;
    }

    /**
     * 
     * @param hasMore
     *     The has_more
     */
    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    /**
     * 
     * @return
     *     The quotaMax
     */
    public Integer getQuotaMax() {
        return quotaMax;
    }

    /**
     * 
     * @param quotaMax
     *     The quota_max
     */
    public void setQuotaMax(Integer quotaMax) {
        this.quotaMax = quotaMax;
    }

    /**
     * 
     * @return
     *     The quotaRemaining
     */
    public Integer getQuotaRemaining() {
        return quotaRemaining;
    }

    /**
     * 
     * @param quotaRemaining
     *     The quota_remaining
     */
    public void setQuotaRemaining(Integer quotaRemaining) {
        this.quotaRemaining = quotaRemaining;
    }

}
