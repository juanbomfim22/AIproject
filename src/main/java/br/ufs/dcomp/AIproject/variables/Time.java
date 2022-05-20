package br.ufs.dcomp.AIproject.variables;

import java.util.List;

import aima.core.search.csp.Variable;

public class Time extends Variable {
	//public Person person;
	public Integer time;
	
    public Time(String name, Integer time) {
		super(name); 
		this.time = time;
		//this.person = person;
	}

    
    
}