package br.ufs.dcomp.AIproject.constraints;

import java.util.HashMap;
import java.util.List;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Domain;
import br.ufs.dcomp.AIproject.variables.StaffMember;
import br.ufs.dcomp.AIproject.variables.TimeBox;
import br.ufs.dcomp.AIproject.variables.WorkingGroup;

public class AllMustWorkRequiredHoursConstraint<VAR extends TimeBox, VAL extends WorkingGroup> implements Constraint<VAR, VAL> {
	private List<VAR> scope;
	private Domain<VAL> domain;
	private List<StaffMember> members;
	
	public AllMustWorkRequiredHoursConstraint(List<VAR> scope, Domain<VAL> domain, List<StaffMember> members) {	
		this.scope = scope;
		this.domain = domain;
		this.members = members;
	}
	
	public Domain<VAL> getDomain() {
		return domain;
	}
	
	@Override
	public List<VAR> getScope() {
		return scope;
	}

	@Override
	public boolean isSatisfiedWith(Assignment<VAR, VAL> assignment) {
		HashMap<StaffMember, Integer> map = new HashMap<>();
		
		for(StaffMember member : members) {
			map.put(member, 0);
		}
		
		for(VAR timeBox : getScope()) {
			WorkingGroup value = assignment.getValue(timeBox);
			for(StaffMember member: value.getMembers())
				if(member != null)
					map.put(member, map.get(member)+1);
		}
		
		for (StaffMember member : members) {
			if(member != null && member.getHour() != map.get(member)) 
				return false;
		} 
		return true;
	}      
}
