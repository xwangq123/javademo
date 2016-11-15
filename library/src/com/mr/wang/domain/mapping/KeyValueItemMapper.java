package com.mr.wang.domain.mapping;

import com.mr.wang.domain.model.KeyValueItem;

public interface KeyValueItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KeyValueItem record);

    int insertSelective(KeyValueItem record);

    KeyValueItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KeyValueItem record);

    int updateByPrimaryKey(KeyValueItem record);
}