package fis.topic01.pratice01;

import java.util.Date;

public class MainApplication {
	public static void main(String[] args ) {
		Student student1 = new Student(1, "Hanh", new Date());
		Student student2 = new Student(2, "Duc", new Date());
		Student student3 = new Student(3, "Tran", new Date());
		
		//initialize studentList instance
		StudentList studentList = new StudentList();
		studentList.setSortStrategy(new BubbleSortStrategy());
		//studentList.setSortStrategy(new SelectionSortStrategy());
		//studentList.setSortStrategy(new InsertionSortStrategy());
		
		//add students to studentList
		studentList.addStudent(student3);
		studentList.addStudent(student2);
		studentList.addStudent(student1);
		studentList.display();
		System.out.println("--------------");
		
		//sort student
		studentList.sort();
		studentList.display();
		System.out.println("--------------");
		
		//remove student
		studentList.removeStudent(1);
		studentList.display();
		System.out.println("--------------");
		
		//Validate Form
		Form form = new Form();
		Component component1 = new Component();
		component1.setData("33-02-2022");
		component1.setValidation(new DateValidation("dd-mm-yyyy"));
		form.addComponent(component1);
		System.out.println(form.validateForm());
		
	}
}
