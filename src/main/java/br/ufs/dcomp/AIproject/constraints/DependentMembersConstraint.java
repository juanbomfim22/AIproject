package br.ufs.dcomp.AIproject.constraints;

import java.util.Arrays;
import java.util.List;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import br.ufs.dcomp.AIproject.variables.StaffMember;
import br.ufs.dcomp.AIproject.variables.TimeBox;

public class DependentMembersConstraint<VAR extends TimeBox, VAL extends StaffMember> implements Constraint<VAR, VAL> {
	private List<VAR> scope;
	private VAL member1;
	private VAL member2;


	// membro1 depende de membro2
	public DependentMembersConstraint(List<VAR> all, VAL member1, VAL member2) {
		this.scope = all;
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
			VAL member = assignment.getValue(timeBox);
			if(member == null) continue;
				
			if(member.equals(member2)) {
				member2WorkedHours++;
			}  
			if(member.equals(member1) && member2WorkedHours != member2.getHour())
					return false;
		}
		return true;
	}

}
