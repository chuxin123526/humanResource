package com.believe.humanResource.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.believe.humanResource.base.impl.BaseDaoImpl;
import com.believe.humanResource.dao.IPositionDao;
import com.believe.humanResource.po.Position;

@Repository
@Transactional
public class PositionDaoImpl extends BaseDaoImpl<Position> implements IPositionDao
{

}
