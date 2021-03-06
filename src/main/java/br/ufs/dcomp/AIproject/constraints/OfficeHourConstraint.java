package br.ufs.dcomp.AIproject.constraints;

import java.util.Arrays;
import java.util.List;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import br.ufs.dcomp.AIproject.variables.StaffMember;
import br.ufs.dcomp.AIproject.variables.TimeBox;
import br.ufs.dcomp.AIproject.variables.WorkingGroup;

public class OfficeHourConstraint<VAR extends TimeBox, VAL extends WorkingGroup> implements Constraint<VAR, VAL> {
	private List<VAR> scope;
	private Integer startTime;
	private Integer endTime;

	public OfficeHourConstraint(VAR variable, Integer startTime, Integer endTime) {
		this.scope = Arrays.asList(variable);
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public List<VAR> getScope() {
		return scope;
	}

	@Override
	public boolean isSatisfiedWith(Assignment<VAR, VAL> assignment) {
		VAR timeBox = getScope().get(0);
		VAL group = assignment.getValue(timeBox);
		if (group.getMembers().isEmpty()) return true;

		return (startTime <= timeBox.getTime() && timeBox.getTime() <= endTime);
 
	}

}
