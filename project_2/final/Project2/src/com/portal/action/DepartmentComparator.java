package com.portal.action;

import java.util.Comparator;

public class DepartmentComparator implements Comparator {
	public int compare(Employee e1, Employee e2) {
		return e1.getDepartment().compareTo(e2.getDepartment());
	}

	@Override
	public int compare(Object arg0, Object arg1) {
		return 0;
	}
}