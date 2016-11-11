package com.mr.wang.domain.mapping;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.mr.wang.domain.model.Keyvalueitem;
import com.mr.wang.domain.utils.PagingBounds;

public interface KeyvalueitemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Keyvalueitem record);

    int insertSelective(Keyvalueitem record);

    Keyvalueitem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Keyvalueitem record);

    int updateByPrimaryKey(Keyvalueitem record);							
    
    List<Keyvalueitem> getAll(PagingBounds rowBounds);
    
    List<Keyvalueitem> getAll(RowBounds rowBounds);
    
    List<Keyvalueitem> getAll();
}