package com.crlclm.lovestory.dao;

import com.crlclm.lovestory.domain.SpecialDay;
import com.crlclm.lovestory.domain.SpecialDayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpecialDayMapper {
    long countByExample(SpecialDayExample example);

    int deleteByExample(SpecialDayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SpecialDay record);

    int insertSelective(SpecialDay record);

    List<SpecialDay> selectByExample(SpecialDayExample example);

    SpecialDay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SpecialDay record, @Param("example") SpecialDayExample example);

    int updateByExample(@Param("record") SpecialDay record, @Param("example") SpecialDayExample example);

    int updateByPrimaryKeySelective(SpecialDay record);

    int updateByPrimaryKey(SpecialDay record);
}