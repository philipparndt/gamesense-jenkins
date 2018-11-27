package de.rnd7.steelseries.jenkins.types;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EventDefinitionTest {
	@Test
	public void test_json() throws Exception {
		EventDefinition definition = new EventDefinition("jenkins-game", "event-1");
		assertEquals("{\"game\":\"JENKINS-GAME\",\"handlers\":[],\"event\":\"event-1\",\"icon_id\":1}", definition.toString());
	}
	
	@Test
	public void test_with_handler() throws Exception {
		EventDefinition definition = new EventDefinition("jenkins-game", "event-1", 
				new ColorRangeHandler(DeviceType.KEYBOARD, Zone.KEY_F1, new ColorRange(1, 2, Color.PURPLE)));
		
		assertEquals("{\"game\":\"JENKINS-GAME\",\"handlers\":["
				+ "{\"mode\":\"color\",\"color\":["
				+ "{\"high\":2,\"color\":{\"red\":255,\"green\":0,\"blue\":255},\"low\":1"
				+ "}],\"zone\":\"f1\",\"device-type\":\"keyboard\""
				+ "}],\"event\":\"event-1\",\"icon_id\":1}", definition.toString());
	}
}
