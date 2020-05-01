package com.elevator;

public class Utility {
	
	private static Utility _util = null;
	private int mNumberOfPassengers = 0;
	
	private Utility() {
		
	}
	
	public static Utility getInstance() {
		if(_util == null)
			_util = new Utility();
		return _util;
	}
	
	public void addPassengers(int pNumberOfPassengers) {
		mNumberOfPassengers += pNumberOfPassengers;
	}
	
	public void removePassengers(int pNumberOfPassengers) {
		mNumberOfPassengers -= pNumberOfPassengers;
	}
	
	public int calculateCurrentWeight() {
		return mNumberOfPassengers * 20;
	}

}
