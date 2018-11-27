package com.zgw.pojo;

import org.springframework.stereotype.Component;

/**
 * 
 * @author domesteven
 * 2018-11-18
 * 分页的查询bean,用于分页控制，通过全局扫描@Component进行实例化
 */
@Component
public class querybean {
	/*总记录数*/
	private int count;
	/*当前页码，提供默认值*/
	private int currNum=1;
	/*每页显示的记录数，提供默认值*/
	private int pageSize=5;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCurrNum() {
		return currNum;
	}
	public void setCurrNum(int currNum) {
		this.currNum = currNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
