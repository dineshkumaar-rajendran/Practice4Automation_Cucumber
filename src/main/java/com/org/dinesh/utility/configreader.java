package com.org.dinesh.utility;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.org.dinesh.constants.FrameworkConstants;

import qa.enumer.ConfigProperties;

public final class configreader {

	private configreader() {

	}

	private static Properties prop = new Properties();
	private static final Map<String, String> ConfigMap = new HashMap();

	static {
		try {
			FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath());
			prop.load(fis);

			for (Map.Entry<Object, Object> entry : prop.entrySet()) {
				ConfigMap.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
				System.out.println(ConfigMap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String get(ConfigProperties key) throws Exception {
		if (Objects.isNull(key) || Objects.isNull(ConfigMap.get(key.name().toLowerCase()))) {
			throw new Exception("Property name " + key + " is not found please check config.properties");
		}

		return ConfigMap.get(key.name().toLowerCase());

	}

	/*
	 * public static String getValue(String key) throws Exception { if
	 * (Objects.isNull(prop.getProperty(key)) || Objects.isNull(key)) { throw new
	 * Exception("Property name" + key +
	 * "is not found please check config.properties"); } return
	 * prop.getProperty(key);
	 * 
	 * }
	 */
}
