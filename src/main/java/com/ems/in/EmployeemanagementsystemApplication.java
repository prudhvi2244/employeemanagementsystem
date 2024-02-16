package com.ems.in;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ems.in.entity.Employee;
import com.ems.in.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeemanagementsystemApplication implements CommandLineRunner {
	
	
	private EmployeeRepository employeeRepository;
	

	
	@Autowired
	public EmployeemanagementsystemApplication(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagementsystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("welcome to Spring Boot !");
		
		Employee emp1=new Employee();
		emp1.setEid(1);
		emp1.setEname("Prudhvi");
		emp1.setEcity("Goa");
		emp1.setEmail("prudhvi@gmail.com");
		
		Employee emp2=new Employee();
		emp2.setEid(2);
		emp2.setEname("Praveen");
		emp2.setEcity("Hyderabad");
		emp2.setEmail("praveen@gmail.com");
		
		
		Employee emp3=new Employee();
		emp3.setEid(3);
		emp3.setEname("Pavan");
		emp3.setEcity("Vizag");
		emp3.setEmail("pavan@gmail.com");
		
		Employee savedEmployee1=employeeRepository.save(emp1);
		Employee savedEmployee2=employeeRepository.save(emp3);
		Employee savedEmployee3=employeeRepository.save(emp2);
		
		
		Employee emp=employeeRepository.findById(2).get();
		
		System.out.println("Employee Details");
		System.out.println("Employee ID :"+emp.getEid());
		System.out.println("Employee Name :"+emp.getEname());
		System.out.println("Employee City :"+emp.getEcity());
		System.out.println("Employee Email :"+emp.getEmail());
		
		List<Employee> allEmployees=employeeRepository.findAll();
		
		System.out.println("-----------Displaying All Employees Details ---------------");
		
		allEmployees.stream().forEach(e->{
			System.out.println("Employee ID :"+e.getEid());
			System.out.println("Employee Name :"+e.getEname());
			System.out.println("Employee City :"+e.getEcity());
			System.out.println("Employee Email :"+e.getEmail());
		});
		
		employeeRepository.deleteById(3);
		
		
		Employee updateEmployee=employeeRepository.findById(1).get();
		updateEmployee.setEname("Raj Prudhvi");
	
		employeeRepository.save(updateEmployee);
		
	}

}
