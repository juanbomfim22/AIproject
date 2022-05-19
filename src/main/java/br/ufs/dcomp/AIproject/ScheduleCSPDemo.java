package br.ufs.dcomp.AIproject;

import java.util.ArrayList;
import java.util.Optional;

import aima.core.logic.fol.parsing.ast.Variable;
import aima.core.search.csp.Assignment;
import aima.core.search.csp.CSP;
import aima.core.search.csp.CspHeuristics;
import aima.core.search.csp.CspListener;
import aima.core.search.csp.CspSolver;
import aima.core.search.csp.FlexibleBacktrackingSolver;
import aima.core.search.csp.MinConflictsSolver;
import br.ufs.dcomp.AIproject.csp.ScheduleCSP;
import br.ufs.dcomp.AIproject.domains.Schedule;
import br.ufs.dcomp.AIproject.variables.Person;

public class ScheduleCSPDemo {
	public static void main(String[] args) {
		CSP<Person, Schedule> csp = new ScheduleCSP();
		
		CspListener.StepCounter<Person, Schedule> stepCounter = new CspListener.StepCounter<>();
		
		CspSolver<Person, Schedule> solver;
		
		Optional<Assignment<Person, Schedule>> solution;
		
		solver = new MinConflictsSolver<Person, Schedule>(100000);
		
		stepCounter.reset();
		
		System.out.println("Scheduling");
		solution = solver.solve(csp);
		if(solution.isPresent()) {
			Assignment<Person, Schedule> result = solution.get();
			ArrayList<Person> people = (ArrayList<Person>) result.getVariables();
			for(Person person : people) {
				System.out.println(String.format("%10s",person.getName()) + " " + result.getValue(person).toString());

			}
		
		} else {
			System.out.println("Nao foi possível achar a solucao!");
		}
	//		solution.ifPresent(System.out::println);
//		System.out.println(stepCounter.getResults() + "\n");
		 
	}
}