package de.rnd7.steelseries.jenkins.types;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameDefinitionTest {
	@Test
	public void test_json() throws Exception {
		GameDefinition definition = new GameDefinition("jenkins-game");
		assertEquals("{\"game\":\"JENKINS-GAME\",\"game_display_name\":\"jenkins-game\",\"icon_color_id\":1}", definition.toString());
	}
}
