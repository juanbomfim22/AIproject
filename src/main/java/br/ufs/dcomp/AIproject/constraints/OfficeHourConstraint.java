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

	// membro1 depende de membro2
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
		for(VAR timeBox : getScope()) { 
			VAL member = assignment.getValue(timeBox);
			if(member.getMembers().size() == 0) continue;
			
			if(!(startTime <= timeBox.getTime() && timeBox.getTime() <= endTime))
				return false;
		}
		return true;
	}


}
