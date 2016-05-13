package com.believe.humanResource.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.believe.humanResource.base.impl.BaseDaoImpl;
import com.believe.humanResource.dao.ISalaryProjectDao;
import com.believe.humanResource.po.SalaryProject;

@Repository
@Transactional
public class SalaryProjectDaoImpl extends BaseDaoImpl<SalaryProject> implements ISalaryProjectDao
{

}
