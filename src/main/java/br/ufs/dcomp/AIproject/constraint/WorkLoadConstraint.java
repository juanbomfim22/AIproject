package br.ufs.dcomp.AIproject.constraint;

import java.util.List;
import java.util.HashMap;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Domain;
import aima.core.search.csp.Variable;
import br.ufs.dcomp.AIproject.variables.Person;
import br.ufs.dcomp.AIproject.variables.Time;

public class WorkLoadConstraint<VAR extends Time, VAL extends Person> implements Constraint<VAR, VAL>  {
	
	private List<VAR> scope;
	private Domain<VAL> domain;
	public HashMap<Person, Integer> hash;
	
	public WorkLoadConstraint(List<VAR> scope, Domain<VAL> domain) {	
		this.scope = scope;
		this.domain = domain;
		this.hash = new HashMap<Person,Integer>();
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
		for (Person p: domain)
			if(p != null)
				hash.put(p, 0);
		
		for(VAR t: getScope())
			if(assignment.getValue(t) != null)
				hash.put(assignment.getValue(t), hash.get(assignment.getValue(t))+1);

		for(Person p: domain)
			if(p != null && p.hours != hash.get(p))
				return false;
		
		return true;
	}
}

