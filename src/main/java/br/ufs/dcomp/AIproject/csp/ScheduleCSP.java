package br.ufs.dcomp.AIproject.csp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.paukov.combinatorics3.Generator;

import aima.core.search.csp.CSP;
import aima.core.search.csp.Domain;
import br.ufs.dcomp.AIproject.constraints.OfficeHourConstraint;
import br.ufs.dcomp.AIproject.variables.StaffMember;
import br.ufs.dcomp.AIproject.variables.TimeBox;
import br.ufs.dcomp.AIproject.variables.WorkingGroup;

public class ScheduleCSP extends CSP<TimeBox, WorkingGroup> {
	public static final Integer scheduleSize = 24;
	public static final Integer startTime = 8;
	public static final Integer endTime = 17;
	
	
	public static final StaffMember ALICE = new StaffMember("Alice", 2, Arrays.asList(4, 13, 19, 21, 22), true);
	public static final StaffMember BOB = new StaffMember("Bob", 3, Arrays.asList(6, 9, 10, 14, 15, 21), true);
	public static final StaffMember CHARLIE = new StaffMember("Charlie", 1, Arrays.asList(5, 8, 10, 13, 14, 21, 22, 23),
			false);
	public static final StaffMember DAVID = new StaffMember("David", 2, Arrays.asList(1, 3, 4, 5, 6, 7, 19, 23), true);
	public static final StaffMember EVE = new StaffMember("Eve", 4, Arrays.asList(2, 4, 7, 10, 11, 13, 14, 15, 18, 21),
			false);

	public static final List<StaffMember> people = Arrays.asList(ALICE, BOB, CHARLIE, DAVID, EVE);
	public static final List<TimeBox> variables = IntStream.rangeClosed(1, scheduleSize).boxed()
			.map(x -> new TimeBox(x + "")).collect(Collectors.toList());

	public static final List<WorkingGroup> groups = Generator.subset(people).simple().stream()
			.map(x -> new WorkingGroup(x)).collect(Collectors.toList());

	public ScheduleCSP() {
		super(variables);
 
		Domain<WorkingGroup> domain = new Domain<>(groups);

		for (TimeBox variable : getVariables()) {
			setDomain(variable, domain);
		}

//		for(TimeBox variable : getVariables()) {
//			addConstraint(new FreeWorkHoursConstraint<TimeBox, StaffMember>(variable));	
//		}
//		
//		for (TimeBox variable : getVariables()) {
//			addConstraint(new AllowVaccinatedConstraint<TimeBox, WorkingGroup>(variable));
//		}
//		addConstraint(new OfficeHourConstraint<TimeBox, WorkingGroup>(variables, startTime, endTime));
		for(TimeBox variable : getVariables()) {
			addConstraint(new OfficeHourConstraint<TimeBox, WorkingGroup>(variable, startTime, endTime));	
		}
//		addConstraint(new DependentMembersConstraint<TimeBox, StaffMember>(variables, ALICE, BOB));
//		addConstraint(new AllMustWorkRequiredHoursConstraint<TimeBox, StaffMember>(variables, domain));
	}
}
