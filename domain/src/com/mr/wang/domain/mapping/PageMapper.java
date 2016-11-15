package com.mr.wang.domain.mapping;

import com.mr.wang.domain.model.Page;

public interface PageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Page record);

    int insertSelective(Page record);

    Page selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Page record);

    int updateByPrimaryKey(Page record);
}