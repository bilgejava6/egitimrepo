package Personel.Utility;
import Personel.repository.entity.Personal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Personel.repository.entity.Department;


public class Utility {

	static Long id=0L;
	public static long createID()
	{
		++id;
		return id;
	}
	
	public static Set<Department> deparmentList = new HashSet<>();
	public static List<Personal> personalList = new ArrayList<>();
	
}
