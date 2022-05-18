package br.ufs.dcomp.projectAI;

import java.util.Optional;

import aima.core.logic.fol.parsing.ast.Variable;
import aima.core.search.csp.Assignment;
import aima.core.search.csp.CSP;
import aima.core.search.csp.CspHeuristics;
import aima.core.search.csp.CspListener;
import aima.core.search.csp.CspSolver;
import aima.core.search.csp.FlexibleBacktrackingSolver;
import aima.core.search.csp.MinConflictsSolver;
import br.ufs.dcomp.projectAI.csp.ScheduleCSP;
import br.ufs.dcomp.projetoia.variables.Person;

public class ScheduleCSPDemo {
	public static void main(String[] args) {
		CSP<Person, Integer> csp = new ScheduleCSP();
		
		CspListener.StepCounter<Person, Integer> stepCounter = new CspListener.StepCounter<>();
		
		CspSolver<Person, Integer> solver;
		
		Optional<Assignment<Person, Integer>> solution;
		
		solver = new MinConflictsSolver<>(1000);
		solver.addCspListener(stepCounter);
		
		stepCounter.reset();
		
		System.out.println("Scheduling (Minimum Conflicts)");
		
		solution = solver.solve(csp);
		
		solution.ifPresent(System.out::println);
		System.out.println(stepCounter.getResults() + "\n");
		 
	}
}