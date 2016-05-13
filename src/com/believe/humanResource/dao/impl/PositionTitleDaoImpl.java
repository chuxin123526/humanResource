package com.believe.humanResource.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.believe.humanResource.base.impl.BaseDaoImpl;
import com.believe.humanResource.dao.IPositionTitleDao;
import com.believe.humanResource.po.PositionTitle;

@Repository
@Transactional
public class PositionTitleDaoImpl extends BaseDaoImpl<PositionTitle> implements IPositionTitleDao 
{

}
