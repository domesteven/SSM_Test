package com.zgw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zgw.pojo.EmpDeptInfoView;
import com.zgw.pojo.querybean;
import com.zgw.service.EmpDeptViewService;

/**
 * 
 * @author domesteven
 * 2018-11-18
 * EmpDeptView的控制器，在spring-mvc-xml文件中通过全局扫描(@Controller)并且实例化所有的controller
 */
@Controller
@RequestMapping("/index")
public class EmpDeptViewController {
	@Resource/*定义一个全局的EmpDeptViewService*/
	private EmpDeptViewService eds;
	@Resource/*定义一个全局的querybean*/
	private querybean bean;

	/**
	 * 
	 *author domesteven
	 *2018-11-18
	 * @return List<String>
	 * 查询所有的职位
	 */
	@RequestMapping("/queryJob")
	public @ResponseBody List<String> queryJob(){
		return eds.queryJob();
	}
	/**
	 * 
	 *author domesteven
	 *2018-11-18
	 * @return List<String>
	 * 查询所有的部门名称
	 */
	@RequestMapping("/queryDeptName")
	public @ResponseBody List<String> queryDeptName(){
		return eds.queryDeptName();
	}
	/**
	 * 
	 *author domesteven
	 *2018-11-18
	 * @return
	 *List<String>
	 *查询所有的工作地点
	 */
	@RequestMapping("/queryLoc")
	public @ResponseBody List<String> queryLoc(){
		return eds.queryLoc();
	}
	/**
	 * 
	 *author domesteven
	 *2018-11-18
	 * @param currentPage 当前页面+1/-1的值，在jsp中计算后传入
	 * @param pageSize 每页显示的数据条数
	 * @param dName 查询条件中的部门名称
	 * @param job 查询条件中的职位
	 * @param loc 查询条件中的就职地点
	 * @return 
	 *Map<Object,Object>
	 *通过@ResponseBody返回map集合的json对象，包含显示的数据list ，以及querybean
	 */
	@RequestMapping("/queryViewByMap")
	public @ResponseBody Map<Object, Object> queryViewByMap(String currentPage,String pageSize,String dName,String job,String loc){
		Map<Object, Object> map1=new HashMap<Object, Object>();
		if(!"".equals(dName)){
		map1.put("dName",dName);
		}
		if(!"".equals(job)){
		map1.put("job",job);
		}
		if(!"".equals(loc)){
		map1.put("loc",loc);
		}
		int currNum=Integer.parseInt(currentPage);
		int pageSize1=Integer.parseInt(pageSize);
		bean.setCurrNum(currNum);
		bean.setPageSize(pageSize1);
		map1.put("bean", bean);
		List<EmpDeptInfoView> list=eds.queryViewByMap(map1);
		int count=eds.getCount(map1);
		bean.setCount(count);
		Map<Object, Object> map=new HashMap<Object, Object>();
		map.put("list", list);
		map.put("bean", bean);
		return map;
	}
	
	
}
