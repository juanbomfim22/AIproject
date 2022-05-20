package br.ufs.dcomp.AIproject;

import java.util.List;
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
import br.ufs.dcomp.AIproject.variables.Person;
import br.ufs.dcomp.AIproject.variables.Time;

public class ScheduleCSPDemo {
	public static Assignment<Time, Person> assignment = new Assignment<Time, Person>();
	public static void main(String[] args) {
		CSP<Time, Person> csp = new ScheduleCSP();
		
		CspListener.StepCounter<Time, Person> stepCounter = new CspListener.StepCounter<>();
		
		CspSolver<Time, Person> solver;
		
		Optional<Assignment<Time, Person>> solution;
		
		solver = new MinConflictsSolver<>(5000);
		solver.addCspListener(stepCounter);
		
		stepCounter.reset();
		
		System.out.println("Scheduling (Minimum Conflicts)");
		
		solution = solver.solve(csp);
		
		solution.ifPresent(System.out::println);
		
		System.out.println(stepCounter.getResults() + "\n");
		
		assignment = solution.get();
		List<Time> variables = csp.getVariables();
		
		System.out.println("             1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24");
		for(Person p: csp.getDomain(variables.get(0))) {
			if (p != null) {
				System.out.printf("%s", p);
				for(int j=0; j < 10-p.toString().length(); j++ ) {
					System.out.printf(" ");
				}
				System.out.printf(":");
				for(int i=0; i<24; i++){
					if(assignment.getValue(variables.get(i)) == p) {
						System.out.printf("  %d", 1);
					}else {
						System.out.printf("  %d", 0);
					}
				}
			}
			System.out.println();
		}
	
				
				
		 
	}
}