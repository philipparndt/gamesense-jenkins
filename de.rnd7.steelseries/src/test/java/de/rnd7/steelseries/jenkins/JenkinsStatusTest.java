package de.rnd7.steelseries.jenkins;

import static org.junit.Assert.*;

import org.junit.Test;

public class JenkinsStatusTest {
	@Test
	public void test_ranges() throws Exception {
		assertEquals(0, JenkinsStatus.FAILED.getValue());
		assertEquals(10, JenkinsStatus.WARNING.getValue());
		assertEquals(20, JenkinsStatus.SUCCESSFULLY.getValue());
		assertEquals(30, JenkinsStatus.UNKNOWN.getValue());
	}
}
