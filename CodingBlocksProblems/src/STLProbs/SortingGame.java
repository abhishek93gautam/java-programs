package STLProbs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Eve",78));
		employees.add(new Employee("Bob",99));
		employees.add(new Employee("Suzy",86));
		employees.add(new Employee("Alice",86));
		
		SalaryComaparator salaryCompare = new SalaryComaparator();
		Collections.sort(employees,salaryCompare);
		
		for(Employee employee : employees)
		{
			System.out.println("Name: "+employee.name + " Salary: "+employee.salary);
		}
	}

}

class Employee
{
	String name;
	int salary;
	Employee()
	{
		
	}
	Employee(String name,int salary)
	{
		this.name=name;
		this.salary=salary;
	}
}


class SalaryComaparator implements Comparator<Employee>
{
	public int compare(Employee e1,Employee e2)
	{
		if(e1.salary < e2.salary)
		{
			return 1;
		}
		else if(e1.salary > e2.salary)
		{
			return -1;
		}
		else {
			return e1.name.compareTo(e2.name);
		}
	}
}