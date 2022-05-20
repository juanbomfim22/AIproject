package br.ufs.dcomp.AIproject.constraints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Variable;
import br.ufs.dcomp.AIproject.variables.StaffMember;

public class RequiredWorkHoursConstraint<VAR extends Variable, VAL> implements Constraint<VAR, VAL> {
	private List<VAR> scope;
	
	public RequiredWorkHoursConstraint(List<VAR> scope) {	
		this.scope = scope;
	}
	
	@Override
	public List<VAR> getScope() {
		return scope;
	}

	@Override
	public boolean isSatisfiedWith(Assignment<VAR, VAL> assignment) {
		HashMap<StaffMember, Integer> memberAndHour = new HashMap<>();
		for (VAR variable : getScope()) {
			StaffMember member = (StaffMember) assignment.getValue(variable);
			memberAndHour.merge(member, 1, Integer::sum);
		} 
		for (StaffMember member : memberAndHour.keySet()) {
			if(member.getName().isEmpty()) continue; 
		    if(!member.getHour().equals(memberAndHour.get(member))) {
		    	return false;
		    }
		} 
		return true;
	}
	   
   
}
