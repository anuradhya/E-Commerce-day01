import java.util.ArrayList;

class Student{
	String name;
	int marks;
	
	public Student(String name,int marks){
		this.name=name;
		this.marks=marks;
	}
}
public class StudentAverage{
	public static void main(String[] args){
		ArrayList<Student> students=new ArrayList<>();
		
		students.add(new Student("Anu",85));
		students.add(new Student("Gima",90));
		students.add(new Student("Bingu",86));
		students.add(new Student("Dula",70));
		students.add(new Student("Manuka",64));
		
		int totalMarks=0;
		for(Student s:students){
			totalMarks+=s.marks;
		}
		
		double averageMarks=(double) totalMarks/students.size();
		System.out.println("Average marks of student: " + averageMarks);
	}
}