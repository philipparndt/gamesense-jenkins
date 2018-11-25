package de.rnd7.steelseries.jenkins.types;

import org.json.JSONObject;

public class Color extends JSONObject {
	
	public static final Color RED = new Color(255, 0, 0);
	public static final Color GREEN = new Color(0, 255, 0);
	public static final Color BLUE = new Color(0, 0, 255);
	public static final Color YELLOW = new Color(255, 255, 0);
	public static final Color WHITE = new Color(255, 255, 255);
	public static final Color PURPLE = new Color(255, 0, 255);
	public static final Color GREY = new Color(40, 40, 40);

	public Color(int red, int green, int blue) {
		put("red", red);
		put("green", green);
		put("blue", blue);
	}
	
}
