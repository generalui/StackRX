
package com.example.stackrx.services.questions.model;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Owner {

    @Expose
    private Integer reputation;

    @Expose
    private Integer userId;
    
    @Expose
    private String userType;

    @Expose
    private String profileImage;

    @Expose
    private String displayName;

    @Expose
    private String link;

    /**
     * 
     * @return
     *     The reputation
     */
    public Integer getReputation() {
        return reputation;
    }

    /**
     * 
     * @param reputation
     *     The reputation
     */
    public void setReputation(Integer reputation) {
        this.reputation = reputation;
    }

    /**
     * 
     * @return
     *     The userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 
     * @param userId
     *     The user_id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 
     * @return
     *     The userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 
     * @param userType
     *     The user_type
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * 
     * @return
     *     The profileImage
     */
    public String getProfileImage() {
        return profileImage;
    }

    /**
     * 
     * @param profileImage
     *     The profile_image
     */
    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    /**
     * 
     * @return
     *     The displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 
     * @param displayName
     *     The display_name
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * 
     * @return
     *     The link
     */
    public String getLink() {
        return link;
    }

    /**
     * 
     * @param link
     *     The link
     */
    public void setLink(String link) {
        this.link = link;
    }

}
