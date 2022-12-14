package com.xzs.mapper;

import com.xzs.pojo.TexamPaperAnswer;
import com.xzs.pojo.TexamPaperAnswerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TexamPaperAnswerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_exam_paper_answer
     *
     * @mbg.generated
     */
    long countByExample(TexamPaperAnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_exam_paper_answer
     *
     * @mbg.generated
     */
    int deleteByExample(TexamPaperAnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_exam_paper_answer
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_exam_paper_answer
     *
     * @mbg.generated
     */
    int insert(TexamPaperAnswer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_exam_paper_answer
     *
     * @mbg.generated
     */
    int insertSelective(TexamPaperAnswer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_exam_paper_answer
     *
     * @mbg.generated
     */
    List<TexamPaperAnswer> selectByExampleWithRowbounds(TexamPaperAnswerExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_exam_paper_answer
     *
     * @mbg.generated
     */
    List<TexamPaperAnswer> selectByExample(TexamPaperAnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_exam_paper_answer
     *
     * @mbg.generated
     */
    TexamPaperAnswer selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_exam_paper_answer
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TexamPaperAnswer record, @Param("example") TexamPaperAnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_exam_paper_answer
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TexamPaperAnswer record, @Param("example") TexamPaperAnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_exam_paper_answer
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TexamPaperAnswer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_exam_paper_answer
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TexamPaperAnswer record);
}