package de.rnd7.steelseries.jenkins;

import de.rnd7.steelseries.jenkins.types.Color;
import de.rnd7.steelseries.jenkins.types.ColorRange;
import de.rnd7.steelseries.jenkins.types.ColorRangeHandler;
import de.rnd7.steelseries.jenkins.types.Endpoints;
import de.rnd7.steelseries.jenkins.types.EventDefinition;
import de.rnd7.steelseries.jenkins.types.GameDefinition;
import de.rnd7.steelseries.jenkins.types.GameEvent;

public class JenkinsGame {
	private static final String JENKINS_HEALTH = "JENKINS_HEALTH";

	private static final String JENKINS  = "Jenkins";

	
	public JenkinsGame() {
	}
	
	public JenkinsGame create() {
		createGame(JENKINS);
		createEvent();
		
		return this;
	}

	public JenkinsGame destroy() {
		SteelseriesUtil.send(Endpoints.REMOVE_GAME, new GameDefinition(JENKINS));
		
		return this;
	}
	
	public JenkinsGame sendHearbeat() {
		SteelseriesUtil.send(Endpoints.GAME_HEARTBEAT, new GameDefinition(JENKINS));
		
		return this;
	}
	
	public JenkinsGame red() {
		sendGameEvent(JENKINS_HEALTH, 5);
		
		return this;
	}

	public JenkinsGame yellow() {
		sendGameEvent(JENKINS_HEALTH, 15);
		
		return this;
}

	public JenkinsGame green() {
		sendGameEvent(JENKINS_HEALTH, 25);
		
		return this;
	}
	
	private void createGame(final String name) {
		SteelseriesUtil.send(Endpoints.GAME_METADATA, new GameDefinition(JENKINS));
	}
	
	private void createEvent() {
		EventDefinition event = new EventDefinition(JENKINS, JENKINS_HEALTH, new ColorRangeHandler(
				new ColorRange(0, 10, Color.RED), 
				new ColorRange(11, 20, Color.YELLOW), 
				new ColorRange(21, 30, Color.GREEN)));
		
		SteelseriesUtil.send(Endpoints.BIND_GAME_EVENT, event);
	}

	private void sendGameEvent(final String eventName, final int value) {
		SteelseriesUtil.send(Endpoints.GAME_EVENT, 
				new GameEvent(JENKINS, JENKINS_HEALTH, value));
	}

}
