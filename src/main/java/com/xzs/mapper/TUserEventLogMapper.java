package com.xzs.mapper;

import com.xzs.pojo.TUserEventLog;
import com.xzs.pojo.TUserEventLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TUserEventLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_event_log
     *
     * @mbg.generated
     */
    long countByExample(TUserEventLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_event_log
     *
     * @mbg.generated
     */
    int deleteByExample(TUserEventLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_event_log
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_event_log
     *
     * @mbg.generated
     */
    int insert(TUserEventLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_event_log
     *
     * @mbg.generated
     */
    int insertSelective(TUserEventLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_event_log
     *
     * @mbg.generated
     */
    List<TUserEventLog> selectByExampleWithRowbounds(TUserEventLogExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_event_log
     *
     * @mbg.generated
     */
    List<TUserEventLog> selectByExample(TUserEventLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_event_log
     *
     * @mbg.generated
     */
    TUserEventLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_event_log
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TUserEventLog record, @Param("example") TUserEventLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_event_log
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TUserEventLog record, @Param("example") TUserEventLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_event_log
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TUserEventLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_event_log
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TUserEventLog record);
}