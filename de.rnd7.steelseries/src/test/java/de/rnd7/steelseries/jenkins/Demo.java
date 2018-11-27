package de.rnd7.steelseries.jenkins;

public class Demo {
	public static void main(String[] args) {
		new JenkinsGame()
				.create()
				.setStatus(JenkinsStatus.UNKNOWN)
				.setStatus(JenkinsStatus.FAILED)
				.setStatus(JenkinsStatus.WARNING)
				.setStatus(JenkinsStatus.SUCCESSFULLY)
				.destroy();
	}
}
