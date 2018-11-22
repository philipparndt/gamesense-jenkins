package de.rnd7.steelseries.jenkins.types;

import org.json.JSONObject;

public class ColorRange extends JSONObject {

	public ColorRange(int low, int high, Color color) {
		put("low", low);
		put("high", high);
		put("color", color);
	}
	
}
