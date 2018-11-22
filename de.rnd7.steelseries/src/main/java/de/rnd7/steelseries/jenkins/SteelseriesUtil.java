package de.rnd7.steelseries.jenkins;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

public class SteelseriesUtil {

	private static String sseAdr;

	private static String getAddress() {
		if (SteelseriesUtil.sseAdr == null) {
			SteelseriesUtil.sseAdr = configFile().map(configFile -> {
				try (final BufferedReader coreProps = new BufferedReader(new FileReader(configFile))) {
					final String jsonAddressStr = coreProps.readLine();

					if (!jsonAddressStr.isEmpty()) {
						final JSONObject obj = new JSONObject(jsonAddressStr);
						return sseAdr = "http://" + obj.getString("address");
					}

				} catch (final IOException e) {
					e.printStackTrace();
				}

				return null;
			}).orElse(null);
		}
		return SteelseriesUtil.sseAdr;
	}

	private static Optional<File> configFile() {
		String corePropsFileName;
		if (System.getProperty("os.name").startsWith("Windows")) {
			corePropsFileName = System.getenv("PROGRAMDATA") + "\\SteelSeries\\SteelSeries Engine 3\\coreProps.json";
		} else {
			corePropsFileName = "/Library/Application Support/" + "SteelSeries Engine 3/coreProps.json";
		}

		return Optional.of(new File(corePropsFileName)).filter(File::exists);
	}

	public static JSONObject send(final String extraAddress, final JSONObject jsonData) {
		final String address = getAddress();
		if (address == null) {
			return new JSONObject();
		}

		try (final CloseableHttpClient httpclient = HttpClients.createDefault()) {
			final URL url = new URL(address + "/" + extraAddress);
			final StringEntity requestEntity = new StringEntity(jsonData.toString(), ContentType.APPLICATION_JSON);

			final HttpPost postMethod = new HttpPost(url.toURI());
			postMethod.setEntity(requestEntity);

			final HttpResponse response = httpclient.execute(postMethod);
			final HttpEntity entity = response.getEntity();
			try (InputStream inputStream = entity.getContent()) {
				return new JSONObject(IOUtils.toString(inputStream, StandardCharsets.UTF_8));
			}
		} catch (final Exception e) {
			return new JSONObject();
		}
	}

	public static boolean isAvailable() {
		return getAddress() != null;
	}
}
