package de.rnd7.steelseries.jenkins.types;

import org.json.JSONObject;

public class ColorRangeHandler extends JSONObject {
	public ColorRangeHandler(DeviceType deviceType, Zone zone, ColorRange... colorRanges) {
		put("device-type", DeviceType.MOUSE.getType());
		put("zone", Zone.ALL.getZone());
		put("mode", Mode.COLOR.getMode());
		put("color", colorRanges);
	}
}
