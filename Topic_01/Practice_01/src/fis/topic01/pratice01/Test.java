package fis.topic01.pratice01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Test {
	public static List<Student> sortStudentsList(List<Student> list){
		Collections.sort(list, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName());
			}
			
		});
		return list;
	}
	public static void main(String[] args) {
		Student student1 = new Student(1, "hanh", new Date(100000));
		Student student2 = new Student(2, "duc", new Date(200000));
		Student student3 = new Student(3, "anh", new Date(200000));
		List<Student> list = new ArrayList<Student>();
		list.add(student1);
		list.add(student2);
		list.add(student3);
		sortStudentsList(list);
		list.stream().forEach(System.out::println);
		
	}
}
