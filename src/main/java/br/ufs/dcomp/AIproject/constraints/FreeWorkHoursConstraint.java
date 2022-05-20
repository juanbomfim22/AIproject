package br.ufs.dcomp.AIproject.constraints;

import java.util.Arrays;
import java.util.List;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import br.ufs.dcomp.AIproject.variables.StaffMember;
import br.ufs.dcomp.AIproject.variables.TimeBox;

public class FreeWorkHoursConstraint<VAR extends TimeBox, VAL extends StaffMember> implements Constraint<VAR, VAL> {
	private List<VAR> scope;

	public FreeWorkHoursConstraint(VAR member) {
		this.scope = Arrays.asList(member);
	}

	@Override
	public List<VAR> getScope() {
		return scope;
	}

	@Override
	public boolean isSatisfiedWith(Assignment<VAR, VAL> assignment) {
		VAR time = getScope().get(0);
		VAL member = assignment.getValue(time);
		if (member == null) return true;
		return member.getFree().get(time.getTime()).booleanValue();
	}

}
