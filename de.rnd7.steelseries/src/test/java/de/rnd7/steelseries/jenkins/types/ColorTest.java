package de.rnd7.steelseries.jenkins.types;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ColorTest {
	@Test
	public void test_colors_json() throws Exception {
		assertEquals("{\"red\":255,\"green\":0,\"blue\":0}", Color.RED.toString());
		assertEquals("{\"red\":0,\"green\":255,\"blue\":0}", Color.GREEN.toString());
		assertEquals("{\"red\":0,\"green\":0,\"blue\":255}", Color.BLUE.toString());
		assertEquals("{\"red\":255,\"green\":255,\"blue\":0}", Color.YELLOW.toString());
		assertEquals("{\"red\":255,\"green\":255,\"blue\":255}", Color.WHITE.toString());
		assertEquals("{\"red\":255,\"green\":0,\"blue\":255}", Color.PURPLE.toString());
		assertEquals("{\"red\":40,\"green\":40,\"blue\":40}", Color.GREY.toString());
	}
	
	@Test
	public void test_custom_json() throws Exception {
		assertEquals("{\"red\":1,\"green\":2,\"blue\":3}", new Color(1,2,3).toString());
	}
	
}
