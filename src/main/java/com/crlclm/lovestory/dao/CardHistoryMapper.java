package com.crlclm.lovestory.dao;

import com.crlclm.lovestory.domain.CardHistory;
import com.crlclm.lovestory.domain.CardHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CardHistoryMapper {
    long countByExample(CardHistoryExample example);

    int deleteByExample(CardHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardHistory record);

    int insertSelective(CardHistory record);

    List<CardHistory> selectByExample(CardHistoryExample example);

    CardHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardHistory record, @Param("example") CardHistoryExample example);

    int updateByExample(@Param("record") CardHistory record, @Param("example") CardHistoryExample example);

    int updateByPrimaryKeySelective(CardHistory record);

    int updateByPrimaryKey(CardHistory record);
}