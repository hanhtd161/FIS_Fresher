package fis.topic01.pratice01;

public class StudentList {
	private Student[] students = new Student[100];
	private int count = 0;
	private ISortStrategy sortStrategy;
	
	public StudentList() {
	}
	
	public void addStudent(Student student) {
		if(this.count >= 100) {
			System.out.println("StudentList is full");
		} else {
			students[this.count] = student;
			this.count +=1;
		}
	}
	
	public void removeStudent(int code) {
		int removeIndex = -1;
		
		for(int i =0; i< count ;i++) {
			if(students[i].getCode() == code) {
				students[i] = null;
				this.count --;
				removeIndex = i;
				break;
			}
		}
		
		if(removeIndex < 0) {
			System.out.println("Student doesn't exist");
			return;
		}
		
		for(int i = removeIndex; i < this.count; i++) {
			students[i] = students[i+1];
		}
		
	}
	
	public void display() {
		for(int i =0; i < count; i++) {
			System.out.println(students[i].toString());
		}
	}

	public void setSortStrategy(ISortStrategy sortStrategy) {
		this.sortStrategy = sortStrategy;
	}

	public void sort() {
		sortStrategy.sort(students, count);		
	}
	
}
