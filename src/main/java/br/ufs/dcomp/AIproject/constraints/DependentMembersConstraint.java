package br.ufs.dcomp.AIproject.constraints;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Domain;
import br.ufs.dcomp.AIproject.variables.StaffMember;
import br.ufs.dcomp.AIproject.variables.TimeBox;
import br.ufs.dcomp.AIproject.variables.WorkingGroup;

public class DependentMembersConstraint<VAR extends TimeBox, VAL extends WorkingGroup> implements Constraint<VAR, VAL> {
	private List<VAR> scope; 
	private List<StaffMember> members;
	private StaffMember member1;
	private StaffMember member2;
	
	public DependentMembersConstraint(List<VAR> scope, StaffMember member1, StaffMember member2) {	
		this.scope = scope; 
		this.member1 = member1;
		this.member2 = member2;
	}
	
	@Override
	public List<VAR> getScope() {
		return scope;
	}

	@Override
	public boolean isSatisfiedWith(Assignment<VAR, VAL> assignment) {
		Integer member2WorkedHours = 0;

		for(VAR timeBox : getScope()) { 
			VAL group = assignment.getValue(timeBox);
			boolean dependentOnGroup = group.getMembers().contains(member1);
			boolean normalOnGroup = group.getMembers().contains(member2);

			if(group.getMembers().isEmpty()) continue; 
			
			if(!dependentOnGroup && normalOnGroup) {
				member2WorkedHours++;
			}  
			
			if(dependentOnGroup && member2WorkedHours != member2.getHour())
					return false;
		}
		return true;
	}      
}
