package de.rnd7.steelseries.jenkins.types;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameEventTest {
	@Test
	public void test_json() throws Exception {
		GameEvent event = new GameEvent("game-1", "event-1", 42);
		assertEquals("{\"game\":\"GAME-1\",\"data\":{\"value\":42},\"event\":\"event-1\"}", event.toString());
	}
}
