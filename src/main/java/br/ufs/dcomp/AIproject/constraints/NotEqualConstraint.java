package br.ufs.dcomp.AIproject.constraints;

import java.util.ArrayList;
import java.util.List;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import br.ufs.dcomp.AIproject.variables.StaffMember;

public class NotEqualConstraint implements Constraint<StaffMember, List<Integer>>  {
	   
    public StaffMember person1;
    public StaffMember person2;
	private List<StaffMember> scope;
    
    public NotEqualConstraint(StaffMember person1, StaffMember person2) {
		this.person1 = person1;
		this.person2 = person2;
		scope = new ArrayList<StaffMember>(2);
		scope.add(person1);
		scope.add(person2);
	}
    
    public List<StaffMember> getScope() {
		return scope;
	}
    
    public boolean isSatisfiedWith(Assignment<StaffMember, List<Integer>> assignment) {
    	boolean conflicts = false;  
 
    	List<Integer> time1 = assignment.getValue(person1);
    	List<Integer> time2 = assignment.getValue(person2);
    	
    	
    	return !time1.equals(time2);
	}
 
}
