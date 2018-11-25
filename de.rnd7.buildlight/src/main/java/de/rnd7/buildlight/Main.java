package de.rnd7.buildlight;

import de.rnd7.steelseries.jenkins.JenkinsGame;
import de.rnd7.steelseries.jenkins.JenkinsStatus;

public class Main {

	public static void main(String[] args) {
		JenkinsGame game = new JenkinsGame()
				.create()
				.setStatus(JenkinsStatus.FAILED);
	}

}
