package de.rnd7.steelseries.jenkins.types;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ModeTest {
	@Test
	public void test_values() throws Exception {
		for (Mode mode : Mode.values()) {
			assertNotNull(mode.getJsonName());
		}
	}
}
