package br.ufs.dcomp.projetoia.variables;

import java.util.List;

import aima.core.search.csp.Variable;

public class Person extends Variable {
	public Integer hours; 
	public List<Integer> free;
//	private List<Integer> assign;
	
    public Person(String name, Integer hours, List<Integer> free) {
		super(name); 
		this.hours = hours;
		this.free = free; 
	}

    
    
}