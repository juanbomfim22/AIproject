package br.ufs.dcomp.AIproject.domains;

import java.util.List;

public class Schedule {
	public List<Integer> hours;
	
	public Schedule(List<Integer> hours) {
		this.hours = hours;	
	}
	public List<Integer> getHours() {
		return this.hours;
	}
	
	@Override
	public String toString() {
		String str = "";
		for(int i = 1; i < 24; i++) {
			if(this.getHours().contains(i)) {
				str += "1";
			} else {
				str +="0";
			}
		}
		return str;
	}
	
}
