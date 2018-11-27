package de.rnd7.buildlight;

import de.rnd7.steelseries.jenkins.JenkinsGame;
import de.rnd7.steelseries.jenkins.JenkinsStatus;
import de.rnd7.steelseries.jenkins.types.Color;
import de.rnd7.steelseries.jenkins.types.DeviceType;

public class Main {

	public static void main(String[] args) {
		 JenkinsGame game = new JenkinsGame()
		 .setDeviceType(DeviceType.KEYBOARD)
		 .create()
		 .setStatus(JenkinsStatus.SUCCESSFULLY);

	}

}
