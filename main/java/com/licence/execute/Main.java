package com.licence.execute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.licence.lockfree.selfOrganizing.SelfOrganizingList;

public class Main {

	
	public final static int MAX_THREADS=5;
	
	private volatile SelfOrganizingList sol;
	
	public static void main(String args[]) throws InterruptedException{
		
		Main main = new Main();
		main.sol=new SelfOrganizingList();
		
		long start= System.nanoTime();
		ExecutorService exec = Executors.newCachedThreadPool();
		
		for(int i=0;i<MAX_THREADS;i++){
			
			exec.execute(new AddThread(main.sol, i));
		}
		
		
		long end = System.nanoTime();
		exec.awaitTermination(10, TimeUnit.SECONDS);
		main.sol.list();
	    double seconds = (end-start)/1000000000.0;
		System.out.println("Time: "+ seconds +"s  Size: " + main.sol.size());
		
	}
	
	
}
