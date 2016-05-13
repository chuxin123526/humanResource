package com.believe.humanResource.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.believe.humanResource.dao.IHumanResourceDao;
import com.believe.humanResource.dao.impl.HumanResourceDaoImpl;
import com.believe.humanResource.po.HumanResource;
import com.believe.humanResource.po.Page;
import com.believe.humanResource.service.IHumanResourceService;

@Service
@Transactional
public class HumanResourceServiceImpl implements IHumanResourceService
{
	@Resource
	private IHumanResourceDao humanResourceDaoImpl ;


	@Override
	public List<HumanResource> list() throws Exception
	{
		return this.humanResourceDaoImpl.findAll() ;
	}

	@Override
	public void add(HumanResource entity) throws Exception
	{
		this.humanResourceDaoImpl.add(entity);
	}

	@Override
	public void delete(int id) throws Exception
	{
		this.humanResourceDaoImpl.deleteById(id);
	}

	@Override
	public void update(HumanResource entity) throws Exception
	{
		HumanResource humanResource = this.getById(entity.getId()) ; 
		humanResource.setPositionTitle(entity.getPositionTitle());
		humanResource.setName(entity.getName());
		humanResource.setSex(entity.getSex());
		humanResource.setEmail(entity.getEmail());
		humanResource.setPhoneNumber(entity.getPhoneNumber());
		humanResource.setQq(entity.getQq());
		humanResource.setMobilePhoneNumber(entity.getMobilePhoneNumber());
		humanResource.setAddress(entity.getAddress());
		humanResource.setPostCode(entity.getPostCode());
		humanResource.setCountry(entity.getCountry());
		humanResource.setBirthAddress(entity.getBirthAddress());
		humanResource.setBirthDate(entity.getBirthDate());
		humanResource.setNation(entity.getNation());
		humanResource.setReligion(entity.getReligion());
		humanResource.setPolitical(entity.getPolitical());
		humanResource.setIdentityCard(entity.getIdentityCard());
		humanResource.setAge(entity.getAge());
		humanResource.setEducation(entity.getEducation());
		humanResource.setMajor(entity.getMajor());
		humanResource.setBank(entity.getBank());
		humanResource.setAccount(entity.getAccount());
		humanResource.setSpeciality(entity.getSpeciality());
		humanResource.setInterest(entity.getInterest());
		humanResource.setResume(entity.getResume());
		humanResource.setFamilyRelationship(entity.getFamilyRelationship());
		humanResource.setRemark(entity.getRemark());
		humanResource.setSalaryStandard(entity.getSalaryStandard());
		
	}

	@Override
	public HumanResource getById(int id) throws Exception
	{
		return this.humanResourceDaoImpl.getById(id) ;
	}

	public IHumanResourceDao getHumanResourceDaoImpl()
	{
		return humanResourceDaoImpl;
	}

	public void setHumanResourceDaoImpl(IHumanResourceDao humanResourceDaoImpl)
	{
		this.humanResourceDaoImpl = humanResourceDaoImpl;
	}

	@Override
	public List<HumanResource> unApproveList() throws Exception
	{
		return this.humanResourceDaoImpl.unApproveList() ; 
	}

	@Override
	public void approve(HumanResource entity) throws Exception
	{
		HumanResource humanResource = this.getById(entity.getId()) ; 
		humanResource.setPositionTitle(entity.getPositionTitle());
		humanResource.setName(entity.getName());
		humanResource.setSex(entity.getSex());
		humanResource.setEmail(entity.getEmail());
		humanResource.setPhoneNumber(entity.getPhoneNumber());
		humanResource.setQq(entity.getQq());
		humanResource.setMobilePhoneNumber(entity.getMobilePhoneNumber());
		humanResource.setAddress(entity.getAddress());
		humanResource.setPostCode(entity.getPostCode());
		humanResource.setCountry(entity.getCountry());
		humanResource.setBirthAddress(entity.getBirthAddress());
		humanResource.setBirthDate(entity.getBirthDate());
		humanResource.setNation(entity.getNation());
		humanResource.setReligion(entity.getReligion());
		humanResource.setPolitical(entity.getPolitical());
		humanResource.setIdentityCard(entity.getIdentityCard());
		humanResource.setAge(entity.getAge());
		humanResource.setEducation(entity.getEducation());
		humanResource.setMajor(entity.getMajor());
		humanResource.setBank(entity.getBank());
		humanResource.setAccount(entity.getAccount());
		humanResource.setSpeciality(entity.getSpeciality());
		humanResource.setInterest(entity.getInterest());
		humanResource.setResume(entity.getResume());
		humanResource.setFamilyRelationship(entity.getFamilyRelationship());
		humanResource.setRemark(entity.getRemark());
		humanResource.setSalaryStandard(entity.getSalaryStandard());
		humanResource.setStatus("已审核");
		humanResource.setApproveIdea(entity.getApproveIdea());
	}

	@Override
	public List<HumanResource> pageList(Page page) throws Exception
	{
		return this.humanResourceDaoImpl.pageList(page) ; 
	}

	@Override
	public List<HumanResource> unApproveList(Page page) throws Exception
	{
		return this.humanResourceDaoImpl.unApprovePageList(page) ; 
	}

	@Override
	public List<HumanResource> approveList() throws Exception
	{
		return this.humanResourceDaoImpl.approvedList() ; 
	}

	
	

}
