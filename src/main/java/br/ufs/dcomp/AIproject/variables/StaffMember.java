package br.ufs.dcomp.AIproject.variables;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aima.core.search.csp.Variable;
import br.ufs.dcomp.AIproject.csp.ScheduleCSP;

public class StaffMember extends Variable {
	private Integer hour; 
	private Map<Integer, Boolean> free; 
	
	public StaffMember(String name) {
		super(name);
	}
	
    public StaffMember(String name, Integer hour, List<Integer> free) {
		super(name); 
		
		Map<Integer, Boolean> map = new HashMap<>();
		for(int h = 1; h <= ScheduleCSP.scheduleSize; h++) {
			if(free.contains(h)) {
				map.put(h, Boolean.TRUE);
			} else {
				map.put(h, Boolean.FALSE);
			}
		}
		
		this.hour = hour;
		this.free = map; 
	}

	public Integer getHour() {
		return hour;
	}
 
	public Map<Integer,Boolean> getFree() {
		return free;
	} 
}