package br.ufs.dcomp.AIproject;

import java.util.Optional;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.CSP;
import aima.core.search.csp.CspListener;
import aima.core.search.csp.CspSolver;
import aima.core.search.csp.FlexibleBacktrackingSolver;
import aima.core.search.csp.MinConflictsSolver;
import br.ufs.dcomp.AIproject.csp.ScheduleCSP;
import br.ufs.dcomp.AIproject.variables.StaffMember;
import br.ufs.dcomp.AIproject.variables.TimeBox;

public class ScheduleCSPDemo {
	public static String formatOutput(String x) {
		String p =  x.replaceAll("Eve", "E").replaceAll("David", "D").replaceAll("Charlie", "C").replaceAll("Bob", "B").replaceAll("Alice","A");
		return String.join("\n13",p.split(", 13"));
	}
	
	public static void main(String[] args) {
		CSP<TimeBox, StaffMember> csp = new ScheduleCSP();
		
		CspListener.StepCounter<TimeBox, StaffMember> stepCounter = new CspListener.StepCounter<>();
		
		CspSolver<TimeBox, StaffMember> solver;
		
		Optional<Assignment<TimeBox, StaffMember>> solution;
		
		solver = new MinConflictsSolver<>(100000000);
//		solver = new FlexibleBacktrackingSolver<TimeBox, StaffMember>().setAll();
		
		solver.addCspListener(stepCounter);
		
		stepCounter.reset();
		
		
		
		System.out.println("Scheduling (Minimum Conflicts)");
		
		solution = solver.solve(csp);
		
		
		
		solution.ifPresent(x -> System.out.println(formatOutput(String.valueOf(x))));

//		solution.ifPresent(System.out::println);
//		solution.ifPresent(System.out::println);
		System.out.println(stepCounter.getResults() + "\n");
		 
	}
}