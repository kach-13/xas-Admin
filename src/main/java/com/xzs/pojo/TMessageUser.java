package com.xzs.pojo;

import java.util.Date;

public class TMessageUser {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_message_user.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_message_user.message_id
     *
     * @mbg.generated
     */
    private Integer messageId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_message_user.receive_user_id
     *
     * @mbg.generated
     */
    private Integer receiveUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_message_user.receive_user_name
     *
     * @mbg.generated
     */
    private String receiveUserName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_message_user.receive_real_name
     *
     * @mbg.generated
     */
    private String receiveRealName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_message_user.readed
     *
     * @mbg.generated
     */
    private Boolean readed;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_message_user.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_message_user.read_time
     *
     * @mbg.generated
     */
    private Date readTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message_user
     *
     * @mbg.generated
     */
    public TMessageUser(Integer id, Integer messageId, Integer receiveUserId, String receiveUserName, String receiveRealName, Boolean readed, Date createTime, Date readTime) {
        this.id = id;
        this.messageId = messageId;
        this.receiveUserId = receiveUserId;
        this.receiveUserName = receiveUserName;
        this.receiveRealName = receiveRealName;
        this.readed = readed;
        this.createTime = createTime;
        this.readTime = readTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message_user
     *
     * @mbg.generated
     */
    public TMessageUser() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_message_user.id
     *
     * @return the value of t_message_user.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_message_user.id
     *
     * @param id the value for t_message_user.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_message_user.message_id
     *
     * @return the value of t_message_user.message_id
     *
     * @mbg.generated
     */
    public Integer getMessageId() {
        return messageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_message_user.message_id
     *
     * @param messageId the value for t_message_user.message_id
     *
     * @mbg.generated
     */
    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_message_user.receive_user_id
     *
     * @return the value of t_message_user.receive_user_id
     *
     * @mbg.generated
     */
    public Integer getReceiveUserId() {
        return receiveUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_message_user.receive_user_id
     *
     * @param receiveUserId the value for t_message_user.receive_user_id
     *
     * @mbg.generated
     */
    public void setReceiveUserId(Integer receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_message_user.receive_user_name
     *
     * @return the value of t_message_user.receive_user_name
     *
     * @mbg.generated
     */
    public String getReceiveUserName() {
        return receiveUserName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_message_user.receive_user_name
     *
     * @param receiveUserName the value for t_message_user.receive_user_name
     *
     * @mbg.generated
     */
    public void setReceiveUserName(String receiveUserName) {
        this.receiveUserName = receiveUserName == null ? null : receiveUserName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_message_user.receive_real_name
     *
     * @return the value of t_message_user.receive_real_name
     *
     * @mbg.generated
     */
    public String getReceiveRealName() {
        return receiveRealName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_message_user.receive_real_name
     *
     * @param receiveRealName the value for t_message_user.receive_real_name
     *
     * @mbg.generated
     */
    public void setReceiveRealName(String receiveRealName) {
        this.receiveRealName = receiveRealName == null ? null : receiveRealName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_message_user.readed
     *
     * @return the value of t_message_user.readed
     *
     * @mbg.generated
     */
    public Boolean getReaded() {
        return readed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_message_user.readed
     *
     * @param readed the value for t_message_user.readed
     *
     * @mbg.generated
     */
    public void setReaded(Boolean readed) {
        this.readed = readed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_message_user.create_time
     *
     * @return the value of t_message_user.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_message_user.create_time
     *
     * @param createTime the value for t_message_user.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_message_user.read_time
     *
     * @return the value of t_message_user.read_time
     *
     * @mbg.generated
     */
    public Date getReadTime() {
        return readTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_message_user.read_time
     *
     * @param readTime the value for t_message_user.read_time
     *
     * @mbg.generated
     */
    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }
}