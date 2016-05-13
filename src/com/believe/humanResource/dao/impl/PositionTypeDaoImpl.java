package com.believe.humanResource.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.believe.humanResource.base.impl.BaseDaoImpl;
import com.believe.humanResource.dao.IPositionTypeDao;
import com.believe.humanResource.po.PositionType;

@Transactional
@Repository
public class PositionTypeDaoImpl extends BaseDaoImpl<PositionType> implements IPositionTypeDao
{

}
