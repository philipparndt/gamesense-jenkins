package de.rnd7.steelseries.jenkins;

public class Main {
	public static void main(final String[] args) throws InterruptedException {
		if (!SteelseriesUtil.isAvailable()) {
			System.err.println("SteelSeries Engine not found.");
			return;
		}

		new JenkinsGame()
		.create()
		.red()
		.green()
		.yellow();
	}
}
