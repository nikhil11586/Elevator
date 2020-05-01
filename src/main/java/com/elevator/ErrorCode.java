package com.elevator;

public enum ErrorCode {
	E01("Overloaded"),
	E02("Timer tripped"),
	E03("Door circuit open too long");
	
	public final String label;
	
	private ErrorCode(String label) {
        this.label = label;
    }
}
