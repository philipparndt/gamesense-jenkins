package de.rnd7.steelseries.jenkins.types;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ColorRangeTest {
	@Test
	public void test_red_json() throws Exception {
		ColorRange range = new ColorRange(15, 16, Color.RED);
		assertEquals("{\"high\":16,\"color\":{\"red\":255,\"green\":0,\"blue\":0},\"low\":15}", range.toString());
	}
	
	@Test
	public void test_green_json() throws Exception {
		ColorRange range = new ColorRange(15, 16, Color.GREEN);
		assertEquals("{\"high\":16,\"color\":{\"red\":0,\"green\":255,\"blue\":0},\"low\":15}", range.toString());
	}
	
	@Test
	public void test_blue_json() throws Exception {
		ColorRange range = new ColorRange(15, 16, Color.BLUE);
		assertEquals("{\"high\":16,\"color\":{\"red\":0,\"green\":0,\"blue\":255},\"low\":15}", range.toString());
	}
}
