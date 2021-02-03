package com.hjay.tmall.service;

import com.hjay.tmall.po.Property;

import java.util.List;

/**
 * @author lzt
 * @date 2019/11/27 10:50
 */
public interface PropertyService extends EntityMoveService<Property> {
    void add(Property p);

    void delete(int id);

    void update(Property p);

    Property get(int id);

    List<Property> list(int cid,Property property);
}