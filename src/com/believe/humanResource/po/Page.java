package com.believe.humanResource.po;

public class Page
{
	private  int requestPage = 1 ; 
	private  int pageSize = 10 ;
	private  int pageCount ;

	public int getPageSize()
	{
		return pageSize;
	}
	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}
	
	public int getPageCount()
	{
		return pageCount;
	}
	public void setPageCount(int pageCount)
	{
		this.pageCount = pageCount;
	}
	public int getRequestPage()
	{
		return requestPage;
	}
	public void setRequestPage(int requestPage)
	{
		this.requestPage = requestPage;
	}
	
	
	
	
}
