package Personel.repo;

import java.util.Set;

import Personel.Utility.Utility;
import Personel.repository.entity.Department;
import static Personel.Utility.Utility.*;

public class DepartmentRepository implements IDepartment<Department>{

	@Override
	public void save(Department department) {
		Utility.deparmentList.add(department);
		
	}

	@Override
	public Set<Department> findAll() {
		return Utility.deparmentList;
	}

}
