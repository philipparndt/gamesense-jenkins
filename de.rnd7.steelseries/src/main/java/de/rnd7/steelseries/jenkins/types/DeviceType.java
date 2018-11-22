package de.rnd7.steelseries.jenkins.types;

public enum DeviceType {
    KEYBOARD("keyboard"),
    MOUSE("mouse"),
    HEADSET("headset"),
    INDICATOR("indicator"),
    RGB1ZONE("rgb-1-zone"),
    RGB2ZONE("rgb-2-zone"),
    RGB3ZONE("rgb-3-zone"),
    RGB4ZONE("rgb-4-zone"),
    RGB5ZONE("rgb-5-zone"),
    RGBPERKEYZONE("rgb-per-key-zones"),
    TACTILE("tactile"),
    SCREENED("screened");

    private final String type;

    DeviceType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
