package com.believe.humanResource.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.believe.humanResource.base.impl.BaseDaoImpl;
import com.believe.humanResource.dao.IPrivilegeDao;
import com.believe.humanResource.po.Privilege;

@Repository
@Transactional
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements IPrivilegeDao
{

}
