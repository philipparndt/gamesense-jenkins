package de.rnd7.steelseries.jenkins;

public enum JenkinsStatus {
	FAILED,
	WARNING,
	SUCCESSFULLY,
	UNKNOWN;
		
	public int getValue() {
		return ordinal() * 10;
	}
}
