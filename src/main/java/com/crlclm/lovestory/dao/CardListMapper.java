package com.crlclm.lovestory.dao;

import com.crlclm.lovestory.domain.CardList;
import com.crlclm.lovestory.domain.CardListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CardListMapper {
    long countByExample(CardListExample example);

    int deleteByExample(CardListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardList record);

    int insertSelective(CardList record);

    List<CardList> selectByExample(CardListExample example);

    CardList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardList record, @Param("example") CardListExample example);

    int updateByExample(@Param("record") CardList record, @Param("example") CardListExample example);

    int updateByPrimaryKeySelective(CardList record);

    int updateByPrimaryKey(CardList record);
}