package br.ufs.dcomp.AIproject.constraints;

import java.util.HashMap;
import java.util.List;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Domain;
import br.ufs.dcomp.AIproject.variables.StaffMember;
import br.ufs.dcomp.AIproject.variables.TimeBox;
import br.ufs.dcomp.AIproject.variables.WorkingGroup;

public class AllMembersWorkConstraint<VAR extends TimeBox, VAL extends WorkingGroup> implements Constraint<VAR, VAL> {
	private List<VAR> scope;
	private List<StaffMember> people;

	public AllMembersWorkConstraint(List<VAR> scope, List<StaffMember> people) {
		this.scope = scope;
		this.people = people;
	}

	public List<StaffMember> getPeople() {
		return people;
	}

	@Override
	public List<VAR> getScope() {
		return scope;
	}

	@Override
	public boolean isSatisfiedWith(Assignment<VAR, VAL> assignment) {
		HashMap<StaffMember, Integer> map = new HashMap<>();
		for (VAR timeBox : getScope()) {
			VAL group = assignment.getValue(timeBox);
			for (StaffMember member : group.getMembers()) {
				map.put(member, 1);
			}
		}
		return map.size() == people.size(); // retorna se tem todas as pessoas
	}

}
