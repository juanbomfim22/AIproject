package br.ufs.dcomp.AIproject.csp;

import java.util.Arrays;
import java.util.List;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.CSP;
import aima.core.search.csp.Domain;
import br.ufs.dcomp.AIproject.constraint.FreeHoursConstraint;
import br.ufs.dcomp.AIproject.constraint.WorkLoadConstraint;
import br.ufs.dcomp.AIproject.variables.Person;
import br.ufs.dcomp.AIproject.variables.Time;

public class ScheduleCSP extends CSP<Time, Person>{
	
	public static List<Integer> a = Arrays.asList(4,13,19,21,22);
	public static List<Integer> b =Arrays.asList(6, 9, 10, 14, 15, 21);
	public static List<Integer> c =Arrays.asList(5,8,10,13,14,21,22,23);
	public static List<Integer> d =Arrays.asList(1,3,4,5,6,7,19,23);
	public static List<Integer> e =Arrays.asList(2,4,7,10,11,13,14,15,18,21);

	public static final Person ALICE = new Person("Alice", 2, a);
	public static final Person BOB = new Person("Bob", 3, b);
	public static final Person CHARLES = new Person("Charlie", 1, c);
	public static final Person DAVID = new Person("David", 2, d);
	public static final Person EVE = new Person("Eve", 4, e);
	
	public static final Time T1 = new Time("T1", 1);
	public static final Time T2 = new Time("T2", 2);
	public static final Time T3 = new Time("T3", 3);
	public static final Time T4 = new Time("T4", 4);
	public static final Time T5 = new Time("T5", 5);
	public static final Time T6 = new Time("T6", 6);
	public static final Time T7 = new Time("T7", 7);
	public static final Time T8 = new Time("T8", 8);
	public static final Time T9 = new Time("T9", 9);
	public static final Time T10 = new Time("T10", 10);
	public static final Time T11 = new Time("T11", 11);
	public static final Time T12 = new Time("T12", 12);
	public static final Time T13 = new Time("T13", 13);
	public static final Time T14 = new Time("T14", 14);
	public static final Time T15 = new Time("T15", 15);
	public static final Time T16 = new Time("T16", 16);
	public static final Time T17 = new Time("T17", 17);
	public static final Time T18 = new Time("T18", 18);
	public static final Time T19 = new Time("T19", 19);
	public static final Time T20 = new Time("T20", 20);
	public static final Time T21 = new Time("T21", 21);
	public static final Time T22 = new Time("T22", 22);
	public static final Time T23 = new Time("T23", 23);
	public static final Time T24 = new Time("T24", 24);
 
	private static List<Person> people = Arrays.asList(ALICE, BOB, CHARLES, DAVID, EVE, null);
	private static List<Time> times = Arrays.asList(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24);
	
	public ScheduleCSP() {
		super(times);
		Domain <Person> persons = new Domain<Person>(people);
		
		for (Time t: getVariables())
			setDomain(t, persons);

		for(Time t: getVariables())
			addConstraint(new FreeHoursConstraint<Time, Person>(t, persons));
		
		addConstraint(new WorkLoadConstraint<Time, Person>(times, persons));
		
	}
    
}
