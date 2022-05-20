package br.ufs.dcomp.AIproject.constraints;

import java.util.HashMap;
import java.util.List;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Domain;
import br.ufs.dcomp.AIproject.variables.StaffMember;
import br.ufs.dcomp.AIproject.variables.TimeBox;

public class AllMustWorkRequiredHoursConstraint<VAR extends TimeBox, VAL extends StaffMember> implements Constraint<VAR, VAL> {
	private List<VAR> scope;
	private Domain<VAL> domain;
	
	public AllMustWorkRequiredHoursConstraint(List<VAR> scope, Domain<VAL> domain) {	
		this.scope = scope;
		this.domain = domain;
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
		for(VAL member : getDomain()) {
			map.put(member, 0);
		}
		for(VAR timeBox : getScope()) {
			VAL member = assignment.getValue(timeBox);
			if(member != null)
				map.put(member, map.get(member)+1);
		}
		
		for (StaffMember member : getDomain()) {
			if(member != null && member.getHour() != map.get(member)) 
				return false;
		} 
		return true;
	}      
}
