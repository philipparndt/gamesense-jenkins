package de.rnd7.steelseries.jenkins.types;

import org.json.JSONObject;

public class GameEvent extends JSONObject {
	public GameEvent(String gameName, String eventName, int value) {
		put("game", gameName.toUpperCase());
		put("event", eventName);
		
		final JSONObject data = new JSONObject();
		data.put("value", value);
		put("data", data);
	}
}
