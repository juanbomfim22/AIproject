package br.ufs.dcomp.AIproject.variables;

import java.util.List;

import aima.core.search.csp.Variable;

public class StaffMember extends Variable {
	private Integer hour; 
	private List<Integer> free;
	
	public StaffMember(String name) {
		super(name);
	}
	
    public StaffMember(String name, Integer hour, List<Integer> free) {
		super(name); 
		this.setHour(hour);
		this.setFree(free); 
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	public List<Integer> getFree() {
		return free;
	}

	public void setFree(List<Integer> free) {
		this.free = free;
	}
 
    
    
}