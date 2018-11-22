package de.rnd7.steelseries.jenkins.types;

import org.json.JSONObject;

public class EventDefinition extends JSONObject {
	public EventDefinition(String game, String name, ColorRangeHandler... handlers) {
		put("game", game.toUpperCase());
		put("event", name);
		put("icon_id", 1);
		put("handlers", handlers);
	
	}
}
