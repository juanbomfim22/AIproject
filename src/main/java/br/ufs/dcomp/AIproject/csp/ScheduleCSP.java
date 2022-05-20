package br.ufs.dcomp.AIproject.csp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import aima.core.search.csp.CSP;
import aima.core.search.csp.Domain;
import br.ufs.dcomp.AIproject.constraints.AllStaffMembersWorkConstraint;
import br.ufs.dcomp.AIproject.constraints.FreeWorkHoursConstraint;
import br.ufs.dcomp.AIproject.constraints.RequiredWorkHoursConstraint;
import br.ufs.dcomp.AIproject.variables.StaffMember;
import br.ufs.dcomp.AIproject.variables.TimeBox;

public class ScheduleCSP extends CSP<TimeBox, StaffMember>{
	/*
	 * Variável: Person
	 * Domínio: 
	 * 
	 */
	private static final Integer scheduleSize = 24;
	public static final StaffMember ALICE = new StaffMember("Alice", 2, Arrays.asList(4,13,19,21,22));
	public static final StaffMember BOB = new StaffMember("Bob", 3, Arrays.asList(6, 9, 10, 14, 15, 21));
	public static final StaffMember CHARLIE = new StaffMember("Charlie", 1, Arrays.asList(5,8,10,13,14,21,22,23));
	public static final StaffMember DAVID = new StaffMember("David", 2, Arrays.asList(1,3,4,5,6,7,19,23));
	public static final StaffMember EVE = new StaffMember("Eve", 4, Arrays.asList(2,4,7,10,11,13,14,15,18,21));
	public static final StaffMember EMPTY = new StaffMember("", 0, Arrays.asList());

	public static final List<TimeBox> variables = constructArrayOfVariables();
	
	private static List<TimeBox> constructArrayOfVariables() {
		List<TimeBox> vars = new ArrayList<>();
		for(int i = 1; i <= scheduleSize; i++) {
			vars.add(new TimeBox(i+"")); // Os horários são 1 a 24 e esse é o nome deles
		}
		return vars;
 
	}
	 
	public static void print(Object x) {
		System.out.println("OI");
	}
	
	public ScheduleCSP() {
		super(variables);
		
		Domain<StaffMember> domain = new Domain<>(
				Arrays.asList(ALICE, BOB, CHARLIE, DAVID, EVE, EMPTY)
		);
		
		Domain<StaffMember> domainWithoutEmpty = new Domain<>(
				Arrays.asList(ALICE, BOB, CHARLIE, DAVID, EVE)
		);
		
		for(TimeBox variable : getVariables()) {
			setDomain(variable, domain);
		}
		
		// As duas constraints de baixo nao funcionam juntas... DEMORA MUITO
		// DEMORA MUITO AS 3 juntas, mas se der sorte, retorna
		// A ordem importa?
//		addConstraint(new AllStaffMembersWorkConstraint<TimeBox, StaffMember>(variables, domainWithoutEmpty));
		addConstraint(new RequiredWorkHoursConstraint<TimeBox, StaffMember>(variables));
//		addConstraint(new FreeWorkHoursConstraint<TimeBox, StaffMember>(variables, domainWithoutEmpty));
	}
    
}
