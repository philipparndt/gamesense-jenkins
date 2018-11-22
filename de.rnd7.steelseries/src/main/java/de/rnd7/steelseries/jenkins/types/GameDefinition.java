package de.rnd7.steelseries.jenkins.types;

import org.json.JSONObject;

public class GameDefinition extends JSONObject {
	public GameDefinition(String name) {
		put("game", name.toUpperCase());
		put("game_display_name", name);
		put("icon_color_id", 1);
	}
}
