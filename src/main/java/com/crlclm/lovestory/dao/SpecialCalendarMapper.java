package com.crlclm.lovestory.dao;

import com.crlclm.lovestory.domain.SpecialCalendar;
import com.crlclm.lovestory.domain.SpecialCalendarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpecialCalendarMapper {
    long countByExample(SpecialCalendarExample example);

    int deleteByExample(SpecialCalendarExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SpecialCalendar record);

    int insertSelective(SpecialCalendar record);

    List<SpecialCalendar> selectByExample(SpecialCalendarExample example);

    SpecialCalendar selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SpecialCalendar record, @Param("example") SpecialCalendarExample example);

    int updateByExample(@Param("record") SpecialCalendar record, @Param("example") SpecialCalendarExample example);

    int updateByPrimaryKeySelective(SpecialCalendar record);

    int updateByPrimaryKey(SpecialCalendar record);
}