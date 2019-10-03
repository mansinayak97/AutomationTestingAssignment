package com.ssi;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Config {
	@Test
	public static String getData(String key) throws IOException{
		FileInputStream file=new FileInputStream("config.properties");
		Properties props=new Properties();
		props.load(file);
		String env=props.getProperty("Environment");
		System.out.println(env);
		file.close();
		return env;
	}
}
