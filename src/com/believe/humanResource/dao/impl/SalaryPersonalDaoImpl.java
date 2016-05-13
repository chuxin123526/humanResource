package com.believe.humanResource.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.believe.humanResource.base.impl.BaseDaoImpl;
import com.believe.humanResource.dao.ISalaryPersonalDao;
import com.believe.humanResource.po.SalaryPersonal;

@Repository
@Transactional
public class SalaryPersonalDaoImpl extends BaseDaoImpl<SalaryPersonal> implements ISalaryPersonalDao
{
	
}
