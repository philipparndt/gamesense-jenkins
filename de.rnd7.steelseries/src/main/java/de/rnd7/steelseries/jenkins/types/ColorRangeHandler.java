package de.rnd7.steelseries.jenkins.types;

import org.json.JSONObject;

public class ColorRangeHandler extends JSONObject {
	public ColorRangeHandler(DeviceType deviceType, Zone zone, ColorRange... colorRanges) {
		put("device-type", deviceType.getJsonName());
		put("zone", zone.getJsonName());
		put("mode", Mode.COLOR.getJsonName());
		put("color", colorRanges);
	}
}
