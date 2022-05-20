package br.ufs.dcomp.AIproject.constraint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Domain;
import aima.core.search.csp.Variable;
import br.ufs.dcomp.AIproject.variables.Person;
import br.ufs.dcomp.AIproject.variables.Time;

public class FreeHoursConstraint<VAR extends Time, VAL extends Person> implements Constraint<VAR, VAL>  {
	
	private VAR scope;
	private Domain<VAL> domain;
	public VAL p;
	public VAR var;
	
	public FreeHoursConstraint(VAR scope, Domain<VAL> domain) {	
		this.scope = scope;
		this.domain = domain;
		this.p = null;
		this.var = null;
	}
	
	public Domain<VAL> getDomain() {
		return domain;
	}
	
	@Override
	public List<VAR> getScope() {
		return Arrays.asList(scope);
	}

	@Override
	public boolean isSatisfiedWith(Assignment<VAR, VAL> assignment) {
		Integer flag = 0;
		for (VAR t : getScope())
			var = t;
			p = assignment.getValue(var);
			if (p == null)
				return true;
			for(Integer free_hour : p.free)
				if (free_hour == var.time)
					flag = 1;
			if (flag == 0) {
				return false;
			}
			flag = 0;
		
		return true;
	}
}
