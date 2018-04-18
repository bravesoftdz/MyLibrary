package by.htp.library.dao;

import java.util.List;
import java.util.Map;

import by.htp.library.bean.Employee;
import by.htp.library.bean.Visiters;

public interface EmployeeDao {

	Map<String, List<Employee>> readAllEmployee();
	void createEmployee(Employee employee);
	void updateEmployee(Employee employee);
	void deleteEmployee(Employee entity);
	Map<String, List<Employee>> findEmployee(Employee entity);
	List<Employee> createXLS(Employee entity);
	List<Employee> selectEmployeeId(Employee entity);	
	Map<String, List<Employee>> entranceUser(Employee employee);	
	Map<String, List<Employee>> selectAccountEmployeeId(Employee employee);
	void writeVisiters(Visiters visiters);

}
