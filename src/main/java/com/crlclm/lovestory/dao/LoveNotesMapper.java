package com.crlclm.lovestory.dao;

import com.crlclm.lovestory.domain.LoveNotes;
import com.crlclm.lovestory.domain.LoveNotesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoveNotesMapper {
    long countByExample(LoveNotesExample example);

    int deleteByExample(LoveNotesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LoveNotes record);

    int insertSelective(LoveNotes record);

    List<LoveNotes> selectByExample(LoveNotesExample example);

    LoveNotes selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LoveNotes record, @Param("example") LoveNotesExample example);

    int updateByExample(@Param("record") LoveNotes record, @Param("example") LoveNotesExample example);

    int updateByPrimaryKeySelective(LoveNotes record);

    int updateByPrimaryKey(LoveNotes record);
}