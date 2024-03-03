package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	
	private static final String GET_EMPS_BY_DESGS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN (?,?,?) ORDER BY JOB";
	
	@Autowired
	private DataSource ds;

	@Override
	public List<Employee> getEmployeesByDesgs(String desg1, String desg2, String desg3) throws Exception {
		
		
			 System.out.println("EmployeeDAOImpl.getEmployeesByDesgs()::ds class name::"+ds.getClass());
			 List<Employee> list= null;
			 //get pool jdbc con object
			 try(Connection con=ds.getConnection();
					 //create PreparedStatement obj
					 PreparedStatement ps= con.prepareStatement(GET_EMPS_BY_DESGS)){
				 //set values of query params
				 ps.setString(1, desg1); ps.setString(2, desg2); ps.setString(3, desg3);
				 //execute the query
				 try(ResultSet rs= ps.executeQuery()){
					 //copy the records of ResultSets obj to List<Employee> obj
					 list = new ArrayList();
					 while(rs.next()) {
						 //copy each record of rs to Employee obj
						 Employee emp= new Employee();
						 emp.setEmpno(rs.getInt(1));
						 emp.setEname(rs.getString(2));
						 emp.setDesg(rs.getString(3));
						 emp.setSalary(rs.getDouble(4));
						 emp.setDeptno(rs.getInt(5));
						 //add Employee object to list collection
						 list.add(emp);
						 }  //while
				 }//try2 with resources
			 }//try1 with resources
			 
			 catch(Exception e) {
				 e.printStackTrace();
				 throw e;   //exception propogation
			 }//catch
			 
			 
		return list;
	}

}
