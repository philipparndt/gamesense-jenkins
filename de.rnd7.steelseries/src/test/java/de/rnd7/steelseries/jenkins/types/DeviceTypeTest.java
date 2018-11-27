package de.rnd7.steelseries.jenkins.types;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class DeviceTypeTest {
	@Test
	public void test_values() throws Exception {
		for (DeviceType deviceType : DeviceType.values()) {
			assertNotNull(deviceType.getJsonName());
		}
	}
}
