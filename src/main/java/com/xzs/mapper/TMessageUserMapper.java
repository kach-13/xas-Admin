package com.xzs.mapper;

import com.xzs.pojo.TMessageUser;
import com.xzs.pojo.TMessageUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TMessageUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message_user
     *
     * @mbg.generated
     */
    long countByExample(TMessageUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message_user
     *
     * @mbg.generated
     */
    int deleteByExample(TMessageUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message_user
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message_user
     *
     * @mbg.generated
     */
    int insert(TMessageUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message_user
     *
     * @mbg.generated
     */
    int insertSelective(TMessageUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message_user
     *
     * @mbg.generated
     */
    List<TMessageUser> selectByExampleWithRowbounds(TMessageUserExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message_user
     *
     * @mbg.generated
     */
    List<TMessageUser> selectByExample(TMessageUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message_user
     *
     * @mbg.generated
     */
    TMessageUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message_user
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TMessageUser record, @Param("example") TMessageUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message_user
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TMessageUser record, @Param("example") TMessageUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TMessageUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TMessageUser record);
}