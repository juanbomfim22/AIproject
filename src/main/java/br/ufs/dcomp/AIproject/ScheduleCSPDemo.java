package br.ufs.dcomp.AIproject;

import java.util.Arrays;
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
import br.ufs.dcomp.AIproject.variables.WorkingGroup;

public class ScheduleCSPDemo {

	public static void main(String[] args) {
		CSP<TimeBox, WorkingGroup> csp = new ScheduleCSP();

		CspListener.StepCounter<TimeBox, WorkingGroup> stepCounter = new CspListener.StepCounter<>();

		CspSolver<TimeBox, WorkingGroup> solver;

		Optional<Assignment<TimeBox, WorkingGroup>> solution;

		solver = new MinConflictsSolver<>(100000000);
//		solver = new FlexibleBacktrackingSolver<TimeBox, StaffMember>().setAll();

		solver.addCspListener(stepCounter);

		stepCounter.reset();

		System.out.println("Scheduling (Minimum Conflicts)");

		solution = solver.solve(csp);

		solution.ifPresent(x -> (new TableList()).printResults(String.valueOf(x)));

//		solution.ifPresent(System.out::println);
//		solution.ifPresent(System.out::println);
		System.out.println(stepCounter.getResults() + "\n");

	}
}