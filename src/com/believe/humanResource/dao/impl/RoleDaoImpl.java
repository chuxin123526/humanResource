package com.believe.humanResource.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.believe.humanResource.base.impl.BaseDaoImpl;
import com.believe.humanResource.dao.IRoleDao;
import com.believe.humanResource.po.Role;

@Repository
@Transactional
public class RoleDaoImpl extends BaseDaoImpl<Role> implements IRoleDao
{

}
