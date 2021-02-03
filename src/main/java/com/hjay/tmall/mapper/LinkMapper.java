package com.hjay.tmall.mapper;

import cn.lzt.tmall.po.*;
import com.hjay.tmall.po.LinkExample;
import com.hjay.tmall.po.Link;

import java.util.List;

public interface LinkMapper extends EntityMoveMapper<Link> {
    int deleteByPrimaryKey(Integer id);

    int insert(Link record);

    int insertSelective(Link record);

    List<Link> selectByExample(LinkExample example);

    Link selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Link record);

    int updateByPrimaryKey(Link record);
}