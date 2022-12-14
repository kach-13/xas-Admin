package com.xzs.mapper;

import com.xzs.pojo.TUserToken;
import com.xzs.pojo.TUserTokenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TUserTokenMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_token
     *
     * @mbg.generated
     */
    long countByExample(TUserTokenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_token
     *
     * @mbg.generated
     */
    int deleteByExample(TUserTokenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_token
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_token
     *
     * @mbg.generated
     */
    int insert(TUserToken record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_token
     *
     * @mbg.generated
     */
    int insertSelective(TUserToken record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_token
     *
     * @mbg.generated
     */
    List<TUserToken> selectByExampleWithRowbounds(TUserTokenExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_token
     *
     * @mbg.generated
     */
    List<TUserToken> selectByExample(TUserTokenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_token
     *
     * @mbg.generated
     */
    TUserToken selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_token
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TUserToken record, @Param("example") TUserTokenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_token
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TUserToken record, @Param("example") TUserTokenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_token
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TUserToken record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_token
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TUserToken record);
}