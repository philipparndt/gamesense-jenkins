package de.rnd7.steelseries.jenkins.types;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZoneTest {
	@Test
	public void test_values() throws Exception {
		for (Zone zone : Zone.values()) {
			assertNotNull(zone.getJsonName());
		}
	}
}
