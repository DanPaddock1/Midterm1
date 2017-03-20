package com.cisc181.core;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cisc181.eNums.eTitle;

public class Staff_Test {

	static ArrayList<Staff> staffList = new ArrayList<Staff>();
	
	@BeforeClass
	public static void setup() throws PersonException, ParseException{

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Staff s1 = new Staff("George", "William", "Bush", sdf.parse("21/12/1985"), "15 Christiana Drive",
				"732-184-1951", "GeorgeBush@Yahoo.net", "10am-2pm", 3, 500.50, sdf.parse("13/12/2004"), eTitle.MR);
		
		Staff s2 = new Staff("Henry", "Bob", "Clay", sdf.parse("20/01/1965"), "15 Delaware Avenue",
				"701-193-1811", "HenryClay@Yahoo.net", "9am-1pm", 3, 300.50, sdf.parse("13/12/2008"), eTitle.MR);
		
		Staff s3 = new Staff("Nancy", "Meredith", "Pelosi", sdf.parse("10/04/1995"), "15 Washington Road",
				"104-581-8311", "NancyPelosi@Yahoo.net", "9pm-1am", 3, 900.40, sdf.parse("09/03/2005"), eTitle.MRS);
		
		Staff s4 = new Staff("Rick", "Nick", "Perry", sdf.parse("14/01/1959"), "15 Hampshire Drive",
				"130-138-8531", "Perry@Yahoo.net", "9pm-10pm", 3, 500.90, sdf.parse("11/11/2008"), eTitle.MR);
		
		Staff s5 = new Staff("Mary", "Wendy", "Washington", sdf.parse("21/01/1955"), "15 England Avenue",
				"194-318-9511", "Wendy@Yahoo.net", "12pm-3pm", 3, 800.30, sdf.parse("15/12/2002"), eTitle.MS);
	
		staffList.add(s1);
		staffList.add(s2);
		staffList.add(s3);
		staffList.add(s4);
		staffList.add(s5);
		
	}

	@Test
	public void test() {
		
		// Real average salary : 600.52
		double avgSal = 0;
		for(Staff staff : staffList){
			avgSal += staff.getSalary();
		}
		avgSal /= staffList.size();
	    assertEquals(avgSal, 600.52, 0.01);
	}	
	
	@Test(expected= PersonException.class)
	public void test2() throws PersonException, ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Staff s1 = new Staff("Mary", "Wendy", "Washington", sdf.parse("21/01/1900"), "15 England Avenue",
				"194-318-950011", "Wendy@Yahoo.net", "12pm-3pm", 3, 800.30, sdf.parse("15/12/2002"), eTitle.MS);
		
	}
	
}
