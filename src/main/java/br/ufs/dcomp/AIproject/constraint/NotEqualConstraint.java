package br.ufs.dcomp.AIproject.constraint;

import java.util.ArrayList;
import java.util.List;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import br.ufs.dcomp.AIproject.variables.Person;

public class NotEqualConstraint implements Constraint<Person, Integer>  {
	   
    public Person person1;
    public Person person2;
	private List<Person> scope;
    
    public NotEqualConstraint(Person person1, Person person2) {
		this.person1 = person1;
		this.person2 = person2;
		scope = new ArrayList<Person>(2);
		scope.add(person1);
		scope.add(person2);
	}
    
    public List<Person> getScope() {
		return scope;
	}
    
    public boolean isSatisfiedWith(Assignment<Person, Integer> assignment) {
    	boolean conflicts = false;  
 
    	Integer time1 = assignment.getValue(person1);
    	Integer time2 = assignment.getValue(person2);
    	    	
    	return !time1.equals(time2);
	} 
}
