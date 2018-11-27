package com.zgw.bean;

import java.util.Date;
/**
 * 
 * @author domesteven
 * 2018-11-18
 *员工表的bean映射
 */
public class My_emp {
	/*员工编号*/
	private int empNo;
	/*员工姓名*/
	private String eName;
	/*员工职位*/
	private String job;
	/*员工上司*/
	private int mgr;
	/*入职日期*/
	private Date hireDate;
	/*薪资*/
	private double sal;
	/*奖金*/
	private Double comm;
	/*部门编号*/
	private int deptNo;
	@Override
	public String toString() {
		return "My_emp [empNo=" + empNo + ", eName=" + eName + ", job=" + job
				+ ", mgr=" + mgr + ", hireDate=" + hireDate + ", sal=" + sal
				+ ", comm=" + comm + ", deptNo=" + deptNo + "]";
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public Double getComm() {
		return comm;
	}
	public void setComm(Double comm) {
		this.comm = comm;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	
}
