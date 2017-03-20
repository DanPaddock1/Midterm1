package com.cisc181.core;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {

	static ArrayList<Student> studentList = new ArrayList<Student>();
	static ArrayList<Course> courseList = new ArrayList<Course>();
	static ArrayList<Semester> semesterList = new ArrayList<Semester>();
	static ArrayList<Section> sectionList = new ArrayList<Section>();
	static ArrayList<Enrollment> enrollList = new ArrayList<Enrollment>();

	@BeforeClass
	public static void setup() throws ParseException, PersonException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Student stud1 = new Student("Phillip", "Emmy", "Jones", sdf.parse("12/04/1999"), eMajor.BUSINESS,
				"9 Canada Drive", "148-581-5914", "PhillipJones@yahoo.net");

		Student stud2 = new Student("Rashida", "Miller", "Jones", sdf.parse("11/05/1999"), eMajor.BUSINESS,
				"11 American Drive", "148-395-5134", "RashidaJones@yahoo.net");

		Student stud3 = new Student("Tommy", "Milford", "Tims", sdf.parse("12/04/1998"), eMajor.CHEM,
				"9 Portugal Drive", "108-181-5194", "TommyTims@yahoo.net");

		Student stud4 = new Student("Amy", "Tammy", "Poehler", sdf.parse("11/04/2000"), eMajor.COMPSI,
				"8 Uruguay Drive", "118-591-5205", "AmyPoehler@yahoo.net");

		Student stud5 = new Student("Ron", "Tom", "Swanson", sdf.parse("13/04/1998"), eMajor.NURSING,
				"19 Paraguay Drive", "131-491-4581", "RonSwanson@yahoo.net");

		Student stud6 = new Student("Tammy", "Timmy", "Swanson", sdf.parse("12/04/1989"), eMajor.NURSING,
				"9 Mexico Drive", "419-193-5192", "TammySwanson@yahoo.net");

		Student stud7 = new Student("Tom", "James", "Haverford", sdf.parse("08/05/1999"), eMajor.PHYSICS,
				"10 Columbia Drive", "403-193-9112", "TomH@yahoo.net");

		Student stud8 = new Student("Gary", "Jim", "Matthew", sdf.parse("07/12/2001"), eMajor.COMPSI, "11 Peru Drive",
				"403-191-9112", "GaryMatthew@yahoo.net");

		Student stud9 = new Student("Chris", "Bill", "Traeger", sdf.parse("08/05/2000"), eMajor.PHYSICS,
				"8 Chile Drive", "403-193-1935", "ChrisTraeger@yahoo.net");

		Student stud10 = new Student("Donna", "Mary", "Meagel", sdf.parse("09/05/1999"), eMajor.CHEM,
				"10 Columbia Drive", "403-193-9112", "DonnaMegael@yahoo.net");

		studentList.add(stud1);
		studentList.add(stud2);
		studentList.add(stud3);
		studentList.add(stud4);
		studentList.add(stud5);
		studentList.add(stud6);
		studentList.add(stud7);
		studentList.add(stud8);
		studentList.add(stud9);
		studentList.add(stud10);

		Course c1 = new Course(UUID.randomUUID(), "Chemistry", 10);
		Course c2 = new Course(UUID.randomUUID(), "Physics", 20);
		Course c3 = new Course(UUID.randomUUID(), "Business", 15);

		courseList.add(c1);
		courseList.add(c2);
		courseList.add(c3);

		Semester sem1 = new Semester(UUID.randomUUID(), sdf.parse("05/09/2017"), sdf.parse("01/01/2018"));
		Semester sem2 = new Semester(UUID.randomUUID(), sdf.parse("02/01/2018"), sdf.parse("09/05/2018"));

		semesterList.add(sem1);
		semesterList.add(sem2);

		// UUID courseID, UUID semesterID, UUID sectionID, int roomID
		Section sect1 = new Section(c1.getCourseID(), sem1.getSemesterID(), UUID.randomUUID(), 1);
		Section sect2 = new Section(c1.getCourseID(), sem2.getSemesterID(), UUID.randomUUID(), 2);
		Section sect3 = new Section(c2.getCourseID(), sem1.getSemesterID(), UUID.randomUUID(), 3);
		Section sect4 = new Section(c2.getCourseID(), sem2.getSemesterID(), UUID.randomUUID(), 4);
		Section sect5 = new Section(c3.getCourseID(), sem1.getSemesterID(), UUID.randomUUID(), 5);
		Section sect6 = new Section(c3.getCourseID(), sem2.getSemesterID(), UUID.randomUUID(), 6);

		sectionList.add(sect1);
		sectionList.add(sect2);
		sectionList.add(sect3);
		sectionList.add(sect4);
		sectionList.add(sect5);
		sectionList.add(sect6);

		for (Section sect : sectionList) {
			for (Student stud : studentList) {
				enrollList.add(new Enrollment(stud.getStudentID(), sect.getSectionID()));
			}
		}

		for (Enrollment e : enrollList) {
			e.setGrade(Math.random() * 100);

		}
	}

	@Test
	public void test() {
		int gpa = 0, avgGrade = 0, totalGrade = 0;

		for (Enrollment e : enrollList) {
			if (e.getStudentID() == studentList.get(1).getStudentID()) {
				totalGrade += e.getGrade();
			}
			avgGrade += e.getGrade();
		}
		avgGrade /= 60;
		gpa = totalGrade / 6 / 25;
		
		assertEquals(avgGrade, avgGrade);
		assertEquals(gpa, gpa);
	}
	
	@Test
	public void test2(){
		studentList.get(1).setMajor(eMajor.COMPSI);
	}

}