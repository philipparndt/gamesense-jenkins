package de.rnd7.steelseries.jenkins;

import java.util.Comparator;
import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;

import de.rnd7.steelseries.jenkins.types.Color;
import de.rnd7.steelseries.jenkins.types.ColorRange;
import de.rnd7.steelseries.jenkins.types.ColorRangeHandler;
import de.rnd7.steelseries.jenkins.types.DeviceType;
import de.rnd7.steelseries.jenkins.types.Endpoints;
import de.rnd7.steelseries.jenkins.types.EventDefinition;
import de.rnd7.steelseries.jenkins.types.GameDefinition;
import de.rnd7.steelseries.jenkins.types.GameEvent;
import de.rnd7.steelseries.jenkins.types.Zone;

public class JenkinsGame {
	private static final String JENKINS_HEALTH = "JENKINS_HEALTH";

	private static final String JENKINS  = "Jenkins";

	private static final Comparator<Entry<JenkinsStatus, Color>> COMAPRATOR = Comparator
			.comparing(entry -> entry.getKey().ordinal());

	private final Map<JenkinsStatus, Color> colors = new EnumMap<>(JenkinsStatus.class);

	private DeviceType deviceType = DeviceType.MOUSE;
	private Zone zone = Zone.ALL;

	private SteelseriesUtil util;
	
	public JenkinsGame() {
		this(new SteelseriesUtil());
	}
	
	JenkinsGame(SteelseriesUtil util) {
		this.util = util;
		
		initDefaultColors();
	}
	
	private void initDefaultColors() {
		this.colors.put(JenkinsStatus.FAILED, Color.RED);
		this.colors.put(JenkinsStatus.WARNING, Color.YELLOW);
		this.colors.put(JenkinsStatus.SUCCESSFULLY, Color.GREEN);
		this.colors.put(JenkinsStatus.UNKNOWN, Color.GREY);
	}
	
	public boolean isAvailable() {
		return util.isAvailable();
	}

	public JenkinsGame setColor(JenkinsStatus status, Color color) {
		colors.put(status, color);
		
		return this;
	}
	
	public JenkinsGame setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
		
		return this;
	}
	
	public JenkinsGame setZone(Zone zone) {
		this.zone = zone;
		
		return this;
	}
	
	public JenkinsGame create() {
		createGame(JENKINS);
		createEvent();
		
		return this;
	}

	public JenkinsGame destroy() {
		util.send(Endpoints.REMOVE_GAME, new GameDefinition(JENKINS));
		
		return this;
	}
	
	public JenkinsGame heartbeat() {
		util.send(Endpoints.GAME_HEARTBEAT, new GameDefinition(JENKINS));
		
		return this;
	}
	
	public JenkinsGame setStatus(JenkinsStatus status) {
		sendGameEvent(JENKINS_HEALTH, status.ordinal());
		
		return this;
	}
	
	private void createGame(final String name) {
		util.send(Endpoints.GAME_METADATA, new GameDefinition(name));
	}
	
	private void createEvent() {
		final ColorRange[] ranges = colors.entrySet().stream()
		.sorted(COMAPRATOR)
		.map(entry -> createRange(entry.getKey(), entry.getValue()))
		.toArray(i -> new ColorRange[i]);
		
		util.send(Endpoints.BIND_GAME_EVENT, new EventDefinition(JENKINS, JENKINS_HEALTH, 
				new ColorRangeHandler(deviceType, zone, ranges)));
	}
	
	private ColorRange createRange(JenkinsStatus status, Color color) {
		final int value = status.ordinal();
		return new ColorRange(value, value, color);
	}

	private void sendGameEvent(final String eventName, final int value) {
		util.send(Endpoints.GAME_EVENT, 
				new GameEvent(JENKINS, eventName, value));
	}

}
