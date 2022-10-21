package com.xzs.mapper;

import com.xzs.pojo.TSubject;
import com.xzs.pojo.TSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TSubjectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_subject
     *
     * @mbg.generated
     */
    long countByExample(TSubjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_subject
     *
     * @mbg.generated
     */
    int deleteByExample(TSubjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_subject
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_subject
     *
     * @mbg.generated
     */
    int insert(TSubject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_subject
     *
     * @mbg.generated
     */
    int insertSelective(TSubject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_subject
     *
     * @mbg.generated
     */
    List<TSubject> selectByExampleWithRowbounds(TSubjectExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_subject
     *
     * @mbg.generated
     */
    List<TSubject> selectByExample(TSubjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_subject
     *
     * @mbg.generated
     */
    TSubject selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_subject
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TSubject record, @Param("example") TSubjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_subject
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TSubject record, @Param("example") TSubjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_subject
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TSubject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_subject
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TSubject record);
}