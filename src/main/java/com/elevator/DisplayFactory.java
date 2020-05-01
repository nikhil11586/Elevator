package com.elevator;

public class DisplayFactory {

	public static Display _getDisplay(String pError) {
		return new ErrorDisplay(pError);
	}
	
	public static Display _getDisplay(String pMessage, Direction pDirection) {
		return new MessageDisplay(pMessage, pDirection);
	}
}
