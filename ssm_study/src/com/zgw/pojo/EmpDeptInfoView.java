package com.zgw.pojo;

import org.springframework.stereotype.Component;

import com.zgw.bean.My_emp;
/**
 * 
 * @author domesteven
 * 2018-11-18
 *将员工表和部门表连接查询的视图继承员工表,通过全局扫描@Component进行实例化
 */
@Component
public class EmpDeptInfoView extends My_emp{
	private String dName;/*部门名称*/
	private String loc;/*就职地点*/
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}

	
}
