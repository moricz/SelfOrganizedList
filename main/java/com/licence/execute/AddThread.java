package com.licence.execute;

import com.licence.lockfree.selfOrganizing.SelfOrganizingList;

public class AddThread extends Thread {

	
	private SelfOrganizingList sol;
	private int addable;
	
	
	public AddThread(SelfOrganizingList sol, int value){
		this.sol=sol;
		addable=value;
	}
	
	
	@Override
	public void run() {
		
		sol.add(addable);
		
		
	}
	
	@Override 
	public void start(){
		run();
	}

}
