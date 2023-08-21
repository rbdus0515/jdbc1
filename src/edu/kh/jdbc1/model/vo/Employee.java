package edu.kh.jdbc1.model.vo;

public class Employee {
	
	private String empName;
	private String jabName;
	private int salary;
	private int annualIncome;
	
	private String hireDate;
	private char gender; // 남자는 M 여자는 F
	
	
	public Employee() {}

	public Employee(String empName, String jabName, int salary, int annualIncome) {
		super();
		this.empName = empName;
		this.jabName = jabName;
		this.salary = salary;
		this.annualIncome = annualIncome;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getEmpName() {
		return empName;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getJabName() {
		return jabName;
	}

	public void setJabName(String jabName) {
		this.jabName = jabName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(int annualIncome) {
		this.annualIncome = annualIncome;
	}

	@Override
	public String toString() {
		return empName + " / " + jabName + " / " + salary + " / "
				+ annualIncome;
	}
	
	

	
}
