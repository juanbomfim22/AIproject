package br.ufs.dcomp.AIproject.variables;

import java.util.Comparator;
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
		free.sort(Comparator.naturalOrder());
		this.hour = hour;
		this.free = free; 
	}

	public Integer getHour() {
		return hour;
	}
 
	public List<Integer> getFree() {
		return free;
	}
 
    
}