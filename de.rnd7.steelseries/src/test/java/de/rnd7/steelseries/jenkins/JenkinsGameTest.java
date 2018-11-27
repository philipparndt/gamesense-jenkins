package de.rnd7.steelseries.jenkins;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import de.rnd7.steelseries.jenkins.types.Color;
import de.rnd7.steelseries.jenkins.types.DeviceType;
import de.rnd7.steelseries.jenkins.types.Endpoints;
import de.rnd7.steelseries.jenkins.types.Zone;

import static org.mockito.Mockito.*;

import org.json.JSONObject;

public class JenkinsGameTest {
	@Test
	public void test_unavailable() throws Exception {
		SteelseriesUtil util = mock(SteelseriesUtil.class);
		when(util.isAvailable()).thenReturn(false);
		
		assertFalse(new JenkinsGame(util).isAvailable());
	}
	
	@Test
	public void test_available() throws Exception {
		SteelseriesUtil util = mock(SteelseriesUtil.class);
		when(util.isAvailable()).thenReturn(true);
		
		assertTrue(new JenkinsGame(util).isAvailable());
	}
	
	@Test
	public void test_create_game() throws Exception {
		SteelseriesUtil util = mock(SteelseriesUtil.class);
		when(util.isAvailable()).thenReturn(true);
		
		new JenkinsGame(util).create();

		ArgumentCaptor<JSONObject> captor = ArgumentCaptor.forClass(JSONObject.class);
		verify(util, times(1)).send(Mockito.matches(Endpoints.GAME_METADATA), captor.capture());
		
		assertEquals("{\"game\":\"JENKINS\",\"game_display_name\":\"Jenkins\",\"icon_color_id\":1}", captor.getValue().toString());
	}
	
	@Test
	public void test_create_event_game() throws Exception {
		SteelseriesUtil util = mock(SteelseriesUtil.class);
		when(util.isAvailable()).thenReturn(true);
		
		new JenkinsGame(util).create();

		ArgumentCaptor<JSONObject> captor = ArgumentCaptor.forClass(JSONObject.class);
		verify(util, times(1)).send(Mockito.matches(Endpoints.BIND_GAME_EVENT), captor.capture());
		
		assertEquals("{\"game\":\"JENKINS\",\"handlers\":[{\"mode\":\"color\",\"color\":[{\"high\":0,\"color\":{\"red\":255,\"green\":0,\"blue\":0},\"low\":0},{\"high\":1,\"color\":{\"red\":255,\"green\":255,\"blue\":0},\"low\":1},{\"high\":2,\"color\":{\"red\":0,\"green\":255,\"blue\":0},\"low\":2},{\"high\":3,\"color\":{\"red\":40,\"green\":40,\"blue\":40},\"low\":3}],\"zone\":\"all\",\"device-type\":\"mouse\"}],\"event\":\"JENKINS_HEALTH\",\"icon_id\":1}", captor.getValue().toString());
	}
	
	@Test
	public void test_custom_color() throws Exception {
		SteelseriesUtil util = mock(SteelseriesUtil.class);
		when(util.isAvailable()).thenReturn(true);
		
		new JenkinsGame(util)
		.setColor(JenkinsStatus.FAILED, Color.PURPLE)
		.create();

		ArgumentCaptor<JSONObject> captor = ArgumentCaptor.forClass(JSONObject.class);
		verify(util, times(1)).send(Mockito.matches(Endpoints.BIND_GAME_EVENT), captor.capture());
		
		assertEquals("{\"game\":\"JENKINS\",\"handlers\":[{\"mode\":\"color\",\"color\":[{\"high\":0,\"color\":{\"red\":255,\"green\":0,\"blue\":255},\"low\":0},{\"high\":1,\"color\":{\"red\":255,\"green\":255,\"blue\":0},\"low\":1},{\"high\":2,\"color\":{\"red\":0,\"green\":255,\"blue\":0},\"low\":2},{\"high\":3,\"color\":{\"red\":40,\"green\":40,\"blue\":40},\"low\":3}],\"zone\":\"all\",\"device-type\":\"mouse\"}],\"event\":\"JENKINS_HEALTH\",\"icon_id\":1}", captor.getValue().toString());
	}
	
	@Test
	public void test_activate_color() throws Exception {
		SteelseriesUtil util = mock(SteelseriesUtil.class);
		when(util.isAvailable()).thenReturn(true);
		
		new JenkinsGame(util).create().setStatus(JenkinsStatus.SUCCESSFULLY);

		ArgumentCaptor<JSONObject> captor = ArgumentCaptor.forClass(JSONObject.class);
		verify(util, times(1)).send(Mockito.matches(Endpoints.GAME_EVENT), captor.capture());
		
		assertEquals("{\"game\":\"JENKINS\",\"data\":{\"value\":2},\"event\":\"JENKINS_HEALTH\"}", captor.getValue().toString());
	}
	
	@Test
	public void test_heartbeat() throws Exception {
		SteelseriesUtil util = mock(SteelseriesUtil.class);
		when(util.isAvailable()).thenReturn(true);
		
		new JenkinsGame(util).create().heartbeat();

		ArgumentCaptor<JSONObject> captor = ArgumentCaptor.forClass(JSONObject.class);
		verify(util, times(1)).send(Mockito.matches(Endpoints.GAME_HEARTBEAT), captor.capture());
		
		assertEquals("{\"game\":\"JENKINS\",\"game_display_name\":\"Jenkins\",\"icon_color_id\":1}", captor.getValue().toString());
	}
	
	@Test
	public void test_destroy() throws Exception {
		SteelseriesUtil util = mock(SteelseriesUtil.class);
		when(util.isAvailable()).thenReturn(true);
		
		new JenkinsGame(util).create().destroy();

		ArgumentCaptor<JSONObject> captor = ArgumentCaptor.forClass(JSONObject.class);
		verify(util, times(1)).send(Mockito.matches(Endpoints.REMOVE_GAME), captor.capture());
		
		assertEquals("{\"game\":\"JENKINS\",\"game_display_name\":\"Jenkins\",\"icon_color_id\":1}", captor.getValue().toString());
	}
	
	@Test
	public void test_keyboard() throws Exception {
		SteelseriesUtil util = mock(SteelseriesUtil.class);
		when(util.isAvailable()).thenReturn(true);
		
		new JenkinsGame(util).setDeviceType(DeviceType.KEYBOARD).setZone(Zone.KEY_ESCAPE).create();

		ArgumentCaptor<JSONObject> captor = ArgumentCaptor.forClass(JSONObject.class);
		verify(util, times(1)).send(Mockito.matches(Endpoints.BIND_GAME_EVENT), captor.capture());
		
		assertEquals("{\"game\":\"JENKINS\",\"handlers\":[{\"mode\":\"color\",\"color\":[{\"high\":0,\"color\":{\"red\":255,\"green\":0,\"blue\":0},\"low\":0},{\"high\":1,\"color\":{\"red\":255,\"green\":255,\"blue\":0},\"low\":1},{\"high\":2,\"color\":{\"red\":0,\"green\":255,\"blue\":0},\"low\":2},{\"high\":3,\"color\":{\"red\":40,\"green\":40,\"blue\":40},\"low\":3}],\"zone\":\"escape\",\"device-type\":\"keyboard\"}],\"event\":\"JENKINS_HEALTH\",\"icon_id\":1}", captor.getValue().toString());
	}
}
