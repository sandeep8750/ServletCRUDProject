package in.ineuron.dao;

import in.ineuron.dto.Employee;

public interface IEmployeeDao {
	public String insert(Employee employee);
	public String Delete(Employee e );
}
