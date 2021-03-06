package br.ufs.dcomp.AIproject.constraints;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import br.ufs.dcomp.AIproject.variables.StaffMember;
import br.ufs.dcomp.AIproject.variables.TimeBox;
import br.ufs.dcomp.AIproject.variables.WorkingGroup;

public class AllowVaccinatedConstraint<VAR extends TimeBox, VAL extends WorkingGroup> implements Constraint<VAR, VAL> {
	private List<VAR> scope;

	public AllowVaccinatedConstraint(VAR timeBox) {
		this.scope = Arrays.asList(timeBox);
	}

	@Override
	public List<VAR> getScope() {
		return scope;
	}

	@Override
	public boolean isSatisfiedWith(Assignment<VAR, VAL> assignment) {
		for(VAR variable : getScope()) {
			VAL group = assignment.getValue(variable); 
			if(group.getMembers().size() > 1) {
				for(StaffMember member : group.getMembers()) {
					if(!member.isVaccinated())
						return false;
				}
			}
		}
		return true;
	}

}
