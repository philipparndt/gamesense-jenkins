package de.rnd7.steelseries.jenkins.types;

public enum Mode {
    COLOR("color"),
    COUNT("count"),
    PERCENT("percent");

    private final String jsonName;

    private Mode(String jsonName) {
        this.jsonName = jsonName;
    }

    public String getJsonName() {
		return jsonName;
	}
}
