package br.ufs.dcomp.AIproject.csp;

import java.util.Arrays;
import java.util.List;

import aima.core.search.csp.CSP;
import aima.core.search.csp.Domain;
import br.ufs.dcomp.AIproject.constraint.NotEqualConstraint;
import br.ufs.dcomp.AIproject.variables.Person;

public class ScheduleCSP extends CSP<Person, Integer>{
	
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

	public static final List<Integer> availableTimes = Arrays
			.asList(1,2,3,4,5,6,7,8,9,10,11,12,
					13,14,15,16,17,18,19,20,21,22,23,24);
 
	private static List<Person> people = Arrays.asList(ALICE, BOB, CHARLES, DAVID, EVE);
	
	public ScheduleCSP() {
		super(people);
		Domain<Integer> time = new Domain<Integer>(availableTimes);
		
		for (Person person : getVariables())
			setDomain(person, time);
		
//		for(Person p1 : people) {
//			for (Person p2 : people) {
//				addConstraint(new NotEqualConstraint(p1, p2)); 
//			}
//		}
	}
    
}
