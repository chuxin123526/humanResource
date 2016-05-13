package com.believe.humanResource.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class HumanResource
{	
	private int id ; 
	private String number ; 
	private String name ; 
	private String sex ; 
	private String email ; 
	private String qq ; 
	private String phoneNumber ;
	private String mobilePhoneNumber ;
	private String address ;
	private String country ; 
	private String birthAddress ; 
	private Date birthDate ; 
	private String religion ; 
	private String political ;
	private String identityCard ; 
	private int age ; 
	private String education; 
	private String major ; 
	private String nation ; 
	private String bank ; 
	private String account ; 
	private String speciality ; 
	private String interest ; 
	private String resume ; 
	private String familyRelationship ; 
	private String remark ; 
	private String imageURL ; 
	private Date addTime ; 
	private String status ;
	private String approveIdea ; 
	private String postCode ; 
	
	private User user ; //登记人
	
	private Organazation organazation1 ; //一级机构
	private Organazation organazation2 ; //二级机构
	private Organazation organazation3 ; //三级机构
	
	private PositionType positionType ; //职位分类
	private Position position ; //职位
	private PositionTitle positionTitle ; //职称
	
	private SalaryStandard salaryStandard ; //该人力资源的薪酬标准
	
	private Set<SalaryPersonal> salaryPersonals = new HashSet<SalaryPersonal>() ; 
	
	
	
	public Set<SalaryPersonal> getSalaryPersonals()
	{
		return salaryPersonals;
	}
	public void setSalaryPersonals(Set<SalaryPersonal> salaryPersonals)
	{
		this.salaryPersonals = salaryPersonals;
	}
	public String getPostCode()
	{
		return postCode;
	}
	public void setPostCode(String postCode)
	{
		this.postCode = postCode;
	}
	public String getMobilePhoneNumber()
	{
		return mobilePhoneNumber;
	}
	public void setMobilePhoneNumber(String mobilePhoneNumber)
	{
		this.mobilePhoneNumber = mobilePhoneNumber;
	}
	public String getBirthAddress()
	{
		return birthAddress;
	}
	public void setBirthAddress(String birthAddress)
	{
		this.birthAddress = birthAddress;
	}
	public Date getBirthDate()
	{
		return birthDate;
	}
	public void setBirthDate(Date birthDate)
	{
		this.birthDate = birthDate;
	}
	public String getReligion()
	{
		return religion;
	}
	public void setReligion(String religion)
	{
		this.religion = religion;
	}
	public String getPolitical()
	{
		return political;
	}
	public void setPolitical(String political)
	{
		this.political = political;
	}
	public String getIdentityCard()
	{
		return identityCard;
	}
	public void setIdentityCard(String identityCard)
	{
		this.identityCard = identityCard;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public String getEducation()
	{
		return education;
	}
	public void setEducation(String education)
	{
		this.education = education;
	}
	public String getMajor()
	{
		return major;
	}
	public void setMajor(String major)
	{
		this.major = major;
	}
	public User getUser()
	{
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	public PositionType getPositionType()
	{
		return positionType;
	}
	public void setPositionType(PositionType positionType)
	{
		this.positionType = positionType;
	}
	public Position getPosition()
	{
		return position;
	}
	public void setPosition(Position position)
	{
		this.position = position;
	}
	public PositionTitle getPositionTitle()
	{
		return positionTitle;
	}
	public void setPositionTitle(PositionTitle positionTitle)
	{
		this.positionTitle = positionTitle;
	}
	public SalaryStandard getSalaryStandard()
	{
		return salaryStandard;
	}
	public void setSalaryStandard(SalaryStandard salaryStandard)
	{
		this.salaryStandard = salaryStandard;
	}
	public String getApproveIdea()
	{
		return approveIdea;
	}
	public void setApproveIdea(String approveIdea)
	{
		this.approveIdea = approveIdea;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getQq()
	{
		return qq;
	}
	public void setQq(String qq)
	{
		this.qq = qq;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getCountry()
	{
		return country;
	}
	public void setCountry(String country)
	{
		this.country = country;
	}
	public String getNation()
	{
		return nation;
	}
	public void setNation(String nation)
	{
		this.nation = nation;
	}
	public String getBank()
	{
		return bank;
	}
	public void setBank(String bank)
	{
		this.bank = bank;
	}
	public String getAccount()
	{
		return account;
	}
	public void setAccount(String account)
	{
		this.account = account;
	}
	public String getSpeciality()
	{
		return speciality;
	}
	public void setSpeciality(String speciality)
	{
		this.speciality = speciality;
	}
	public String getInterest()
	{
		return interest;
	}
	public void setInterest(String interest)
	{
		this.interest = interest;
	}
	public String getResume()
	{
		return resume;
	}
	public void setResume(String resume)
	{
		this.resume = resume;
	}
	public String getFamilyRelationship()
	{
		return familyRelationship;
	}
	public void setFamilyRelationship(String familyRelationship)
	{
		this.familyRelationship = familyRelationship;
	}
	public String getRemark()
	{
		return remark;
	}
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	public String getImageURL()
	{
		return imageURL;
	}
	public void setImageURL(String imageURL)
	{
		this.imageURL = imageURL;
	}
	public Date getAddTime()
	{
		return addTime;
	}
	public void setAddTime(Date addTime)
	{
		this.addTime = addTime;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public String getNumber()
	{
		return number;
	}
	public void setNumber(String number)
	{
		this.number = number;
	}
	public Organazation getOrganazation1()
	{
		return organazation1;
	}
	public void setOrganazation1(Organazation organazation1)
	{
		this.organazation1 = organazation1;
	}
	public Organazation getOrganazation2()
	{
		return organazation2;
	}
	public void setOrganazation2(Organazation organazation2)
	{
		this.organazation2 = organazation2;
	}
	public Organazation getOrganazation3()
	{
		return organazation3;
	}
	public void setOrganazation3(Organazation organazation3)
	{
		this.organazation3 = organazation3;
	}

	
	
		
}	
