package br.ufs.dcomp.AIproject.constraints;

import java.util.ArrayList;
import java.util.List;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import br.ufs.dcomp.AIproject.domains.Schedule;
import br.ufs.dcomp.AIproject.variables.Person;

public class NotEqualConstraint implements Constraint<Person, Schedule>  {
	   
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
    
    public boolean isSatisfiedWith(Assignment<Person, Schedule> assignment) {
 
    	List<Integer> schedule1 = assignment.getValue(person1).getHours();
    	List<Integer> schedule2 = assignment.getValue(person2).getHours();
    	
    	for(Integer h1 : schedule1) {
    		for(Integer h2 : schedule2) {
    			if(h1 == h2) {
    				return false;
    			}
    		}
    	}
    	return true;
    	
	} 
}
