package br.ufs.dcomp.AIproject.constraints;


import java.util.List;
import java.util.stream.Collectors;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Domain;
import aima.core.search.csp.Variable;
import br.ufs.dcomp.AIproject.variables.StaffMember;

public class AllStaffMembersWorkConstraint<VAR extends Variable, VAL> implements Constraint<VAR, VAL> {
	private List<VAR> scope; 
	private Domain<VAL> domain;
	
	public AllStaffMembersWorkConstraint(List<VAR> scope, Domain<VAL> domain) {	
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
		
		//		getScope().forEach(x -> 
//			System.out.print(assignment.getValue(x))
//		); 
////		if()
//		
//		return getScope()
//				.containsAll(
//					getDomain().asList()
//				);
		for(VAR variable : getScope()) {
			if(assignment.getValue(variable) == null) {
				return true;
			}
		} 
		return getScope().stream()
				.map(x -> assignment.getValue(x))
				.collect(Collectors.toList())
				.containsAll(
					getDomain()
					.asList() 						
				);
	}
}
