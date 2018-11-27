package de.rnd7.steelseries.jenkins.types;

public enum DeviceType {
    HEADSET("headset"),
    INDICATOR("indicator"),
    KEYBOARD("keyboard"),
    MOUSE("mouse"),
    RGB1ZONE("rgb-1-zone"),
    RGB2ZONE("rgb-2-zone"),
    RGB3ZONE("rgb-3-zone"),
    RGB4ZONE("rgb-4-zone"),
    RGB5ZONE("rgb-5-zone"),
    RGBPERKEYZONE("rgb-per-key-zones"),
    SCREENED("screened"),
    TACTILE("tactile");

    private final String jsonName;

    private DeviceType(String jsonName) {
        this.jsonName = jsonName;
    }

    public String getJsonName() {
		return jsonName;
	}
}
