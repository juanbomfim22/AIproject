package br.ufs.dcomp.AIproject.constraints;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Domain;
import aima.core.search.csp.Variable;
import br.ufs.dcomp.AIproject.variables.StaffMember;

public class FreeWorkHoursConstraint<VAR extends Variable, VAL> implements Constraint<VAR, VAL> {
	private List<VAR> scope;
	private Domain<VAL> domain;
	
	public FreeWorkHoursConstraint(List<VAR> scope, Domain<VAL> domain) {	
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
		// Tem que ver se todas as pessoas tem o horario igual
		
		Map<StaffMember, Integer> memberCanWork = new HashMap<>();
		for (VAR variable : getScope()) {
			StaffMember member = (StaffMember) assignment.getValue(variable);
			Integer assignedDay = Integer.parseInt(variable.getName()); // 1 a 24
			
//			Boolean bool = Boolean.FALSE;
 			if(member.getFree().contains(assignedDay)) {
 				memberCanWork.merge(member, 1, Integer::sum);
			} 
//			if(member.getFree().contains(dayHour)) {
//				bool = Boolean.TRUE;
//			} 
//			memberCanWork.merge(member, bool, Boolean::logicalAnd);
		} 
		if(memberCanWork.size() != getDomain().size()) {
			return false;
		}
 
		for(Entry<StaffMember, Integer> entry : memberCanWork.entrySet()) {
		    StaffMember member = entry.getKey();
		    Integer freeHoursWorked = entry.getValue();
		    if(!member.getHour().equals(freeHoursWorked)) {
		    	return false;
		    }
		}

//
//		System.out.println(key + " : " + value));
//		for (StaffMember member : memberCanWork.keySet()) {
//			if(member.getName().isEmpty()) continue; 
//		    if(memberCanWork.get(member).equals()) {
//		    	return false;
//		    }
//		} 
		return true;
	}


	   
   
}
