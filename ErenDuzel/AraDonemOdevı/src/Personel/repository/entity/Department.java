package Personel.repository.entity;

import java.util.List;

public class Department {

	private String name;
	private int numberOfStaff;
	private List<Personal> departmentStaffList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfStaff() {
		return numberOfStaff;
	}

	public void setNumberOfStaff(int numberOfStaff) {
		this.numberOfStaff = numberOfStaff;
	}

	public List<Personal> getDepartmentStaffList() {
		return departmentStaffList;
	}

	public void setDepartmentStaffList(List<Personal> departmentStaffList) {
		this.departmentStaffList = departmentStaffList;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", numberOfStaff=" + numberOfStaff + ", departmentStaffList="
				+ departmentStaffList + "]";
	}

}
