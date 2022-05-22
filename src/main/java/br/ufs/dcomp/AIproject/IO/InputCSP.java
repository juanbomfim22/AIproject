package br.ufs.dcomp.AIproject.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.ufs.dcomp.AIproject.variables.StaffMember;

public class InputCSP {
	Integer startTime;
	Integer endTime;
	List<StaffMember> people = new ArrayList<>();

	public InputCSP() {
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(read);

		// Start time
		Integer startTime = 0;

		while (true) {
			System.out.println("Enter start time (0-24): ");
			try {
				startTime = Integer.parseInt(in.readLine());
			} catch (NumberFormatException e) {
				System.out.println("Type a valid integer.");
				continue;
			} catch (IOException e) {
				System.out.println("IO ERROR");
				continue;
			}
			if (startTime < 0 || startTime > 24) {
				System.out.println("Enter a valid start time.");
			} else {
				this.startTime = startTime;
				break;
			}
		}

		// End time
		Integer endTime = 0;

		while (true) {
			System.out.println("Enter the end time, it needs to be after the start time (" + startTime + "-24): ");
			try {
				endTime = Integer.parseInt(in.readLine());

			} catch (NumberFormatException e) {
				System.out.println("Type a valid integer.");
				continue;

			} catch (IOException e) {
				System.out.println("IO ERROR");
				continue;
			}
			if (endTime < 0 || endTime > 24 || endTime <= startTime) {
				System.out.println("Enter a valid start time.");
			} else {
				this.endTime = endTime;
				break;
			}
		}

		// Number of people
		Integer staffSize = 0;

		while (true) {
			System.out.println("Enter staff size, it must be have at least one person: ");
			try {
				staffSize = Integer.parseInt(in.readLine());

			} catch (NumberFormatException e) {
				System.out.println("Type a valid integer.");
				continue;

			} catch (IOException e) {
				System.out.println("IO ERROR");
				continue;

			}
			if (staffSize < 1) {
				System.out.println("Enter a valid number.");
			} else {
				break;
			}
		}
		for (int i = 0; i < staffSize; i++) {
			addStaffMember(i + 1);
		}
		System.out.println("Members can work from " + startTime + " to " + endTime);
		for (StaffMember person : people) {
			System.out.print("Number: " + (people.indexOf(person) + 1) + " | ");
			System.out.print("Name: " + person.getName() + " | ");
			System.out.print("Workload: " + person.getHour() + " | ");
			if (person.isVaccinated()) {
				System.out.print("Vaccinated: YES | ");
			} else {
				System.out.print("Vaccinated: NO | ");
			}
			System.out.print("Free hours: ");
			Map<Integer, Boolean> free = person.getFree();
			for (int i = 0; i < 24; i++) {
				if (free.get(i) != null) {
					if (free.get(i)) {
						System.out.print(i + " ");
					}
				}
			}
			System.out.println();
		}
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Boolean add = false;
		System.out.println("Add priorities (Y - Yes | N - No)?");
		while (true) {
			String resp = "";
			resp = sc.nextLine();
			if (resp.charAt(0) == 'Y') {
				add = true;
				break;
			} else if (resp.charAt(0) == 'N') {
				add = false;
				break;
			} else {
				System.out.println("Type a valid response.");
			}
		}
		this.addDependecies();
	}

	private void addStaffMember(Integer staffNumber) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		// Member name
		String staffName = "";
		while (true) {
			System.out.println("Enter staff name (" + staffNumber + "):");
			staffName = sc.nextLine();
			if (staffName.length() < 1) {
				System.out.println("Enter a valid name.");
			} else {
				break;
			}
		}

		// Hours of Work
		Integer hours = 0;
		while (true) {
			System.out.println("Enter staff work load:");
			try {
				hours = Integer.parseInt(sc.nextLine());

			} catch (NumberFormatException e) {
				System.out.println("Type a valid integer.");
				continue;
			}
			if (hours < 0) {
				System.out.println("Enter a valid number of hours.");
			} else {
				break;
			}
		}

		// Free hours
		List<Integer> free = new ArrayList<>();
		System.out.println("Enter the hours the member can work (-1 to end):");
		while (true) {
			Integer newHour = 0;
			try {
				newHour = Integer.parseInt(sc.nextLine());

			} catch (NumberFormatException e) {
				System.out.println("Type a valid integer.");
				continue;
			}
			if (newHour == -1) {
				break;
			} else if (newHour < 0 || newHour > 24) {
				System.out.println("Enter a valid hour.");

			} else {
				free.add(newHour);
			}
		}
		// Vaccinated
		Boolean vaccinated = false;
		System.out.println("Enter if this member is vaccinated (Y - Yes | N - No):");
		while (true) {
			String resp = "";
			resp = sc.nextLine();
			if (resp.charAt(0) == 'Y') {
				vaccinated = true;
				break;
			} else if (resp.charAt(0) == 'N') {
				vaccinated = false;
				break;
			} else {
				System.out.println("Type a valid response.");
			}
		}
		StaffMember newMember = new StaffMember(staffName, hours, free, vaccinated);
		List<StaffMember> people = this.people;
		people.add(newMember);
		this.people = people;
	}

	public void addDependecies() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		List<StaffMember> people = this.getPeople();

		System.out.println("Enter who has to wait for whom, use the 'Number' value (-1 to skip/end):");
		while (true) {
			Integer person = 0, dependent = 0;
			try {
				dependent = Integer.parseInt(sc.nextLine());
				if (dependent == -1) {
					break;
				}
				person = Integer.parseInt(sc.nextLine());
				if (person == -1) {
					break;
				}

			} catch (NumberFormatException e) {
				System.out.println("Type a valid integers.");
				continue;
			}

			if (person >= 1 && person <= people.size() && dependent >= 1 && dependent <= people.size()) {
				if (person != dependent) {
					System.out.println(people.get(dependent - 1).getName() + " depends on "
							+ people.get(person - 1).getName() + " work.");
					people.get(dependent - 1).addDependency(people.get(person - 1));
				} else {
					System.out.println("Number must be different.");
					continue;
				}
			} else {
				System.out.println("Number must be between 1 and " + people.size());
			}
		}
	}

	public Integer getStartTime() {
		return startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	public Integer getEndTime() {
		return endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	public List<StaffMember> getPeople() {
		return people;
	}

	public void setPeople(List<StaffMember> people) {
		this.people = people;
	}

}
