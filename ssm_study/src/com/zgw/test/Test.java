package com.zgw.test;


import java.io.InputStream;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class Test {
		public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		InputStream in=Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(in);
		SqlSession session=sessionFactory.openSession();
		//查询所有员工 xml中不需要配置parameterType
//		List<My_emp> list=session.selectList("My_emp.queryAllEmp");
//		for (My_emp my_emp : list) {
//			System.out.println(my_emp);
//		}
		//根据名字查询员工，select中需要配置parameterType的值为string /java.lang.String
//		List<My_emp> list=session.selectList("My_emp.getEmpByEname","%J%");
//		for (My_emp my_emp : list) {
//			System.out.println(my_emp);
//		}
		//通过map映射对查询
//		Map<Object, Object> map=new HashMap<Object, Object>();
//		map.put("eName", "steven");
//		map.put("empNo", 7369);
//		List<My_emp> list=session.selectList("My_emp.getEmpByempNoAndEname",map);
//		for (My_emp my_emp : list) {
//			System.out.println(my_emp);
//		}
		//通过日期查询
//		String sdate="2018-9-12";
//		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
//		Date date=sf.parse(sdate);
//		My_emp emp=session.selectOne("My_emp.getEmpByDate",date);
//		System.out.println(emp);
		
	}
}
