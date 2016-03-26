package com.licence.lockfree;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.licence.lockfree.selfOrganizing.SelfOrganizingList;

import TrialSuite.TrialSuite;



public class TestCase1  {

	SelfOrganizingList sol;
	Long start=(long)0,end=(long)0;
	 int i=0;
	 static Long len=(long) 0;
	 TrialSuite ts=new TrialSuite();
	@BeforeTest
	protected void setUp() throws Exception {
		
		
		sol=new SelfOrganizingList();
		
		System.gc();
		start= System.nanoTime();
		
		sol.add(5);
		sol.add(5);
		sol.add(5);
		sol.add(5);
		sol.add(5);
		sol.add(7);
	}

	@AfterTest
	protected void tearDown() throws Exception {
		end = System.nanoTime();
		
		sol.list();
	    double seconds = (end-start)/1000000000.0;
		System.out.println("Time: "+ seconds +"s  Size: " + sol.size());
	
	//	System.out.println(ts.histogram());
	}
	
	
	
	
	@Test(threadPoolSize = 10, invocationCount = 50, timeOut=10000)
	public void test2(){
		
		
		sol.add(10);
		
		
		//sol.remove(10);
	
		
		//for(i=0;i<2;i++)
	//	sol.search(7);
	
	//	long end =System.currentTimeMillis();
	//	ts.addTrial(TestCase1.len++,start,end);
		
	}
	
	

}
