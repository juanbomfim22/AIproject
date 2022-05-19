package br.ufs.dcomp.AIproject.csp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import aima.core.search.csp.CSP;
import aima.core.search.csp.Domain;
import br.ufs.dcomp.AIproject.constraints.NotEqualConstraint;
import br.ufs.dcomp.AIproject.domains.Schedule;

import br.ufs.dcomp.AIproject.variables.Person;

public class ScheduleCSP extends CSP<Person, Schedule>{
	
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
 
	public final List<Schedule> getPersonDomain(Person person) {
		Integer hours = person.getHours();
		List<Integer> possibleHours = person.getFree();
		
		//Gera o domínio da pessoa com base em:
		//Número de horas que a pessoa precisa
		//Horas disponíveis
		
		Integer freeHoursSize = possibleHours.size();
		List<String> possibleCombinations = new ArrayList<String>();

		for(int i = 0; i < Math.pow(2, freeHoursSize) - 1; i++) {			
		      String comb = String.format("%24s", Integer.toBinaryString(i)).replace(' ', '0');
		      possibleCombinations.add(comb);
		}
		//Escolhe as cominações com o número exato de 1's
		List<String> filteredCombinations = new ArrayList<String>();
		for(String combination : possibleCombinations) {
			Integer count = 0;
			for(int i = 0; i < combination.length(); i++) {
				if(combination.charAt(i) == '1') {
					count++;
				}
			}
			if(count == hours) {
				filteredCombinations.add(combination);
			}
			
		}
		List<Schedule> personScheduleDomain = new ArrayList<Schedule>();
		for(String combination : filteredCombinations) {
			List<Integer> hourCombination = new ArrayList<Integer>();
			for(int i = combination.length() - 1; i >= 0; i--) {
			    int index = combination.length() - 1 - i;
				if(combination.charAt(i) == '1') {
					hourCombination.add(possibleHours.get(index));
				}
			}
			personScheduleDomain.add(new Schedule(hourCombination));
		}
		
		return personScheduleDomain;
	}
	
	private static List<Person> people = Arrays.asList(ALICE, BOB, CHARLES, DAVID, EVE);
	
	public ScheduleCSP() {
		super(people);		
		for (Person person : getVariables()) {
			Domain<Schedule> personDomain = new Domain<>(this.getPersonDomain(person));
			System.out.println(person.getName() + " domain size " + this.getPersonDomain(person).size());		
			setDomain(person, personDomain);
		}
			
		System.out.println("Defined all persons possible hours");
		
		//Two persons cant work at the same hours
		for(Person p1 : people) {
			for (Person p2 : people) {
				if(!p1.getName().equals(p2.getName()))
				addConstraint(new NotEqualConstraint(p1, p2)); 
			}
		}
	}
}
