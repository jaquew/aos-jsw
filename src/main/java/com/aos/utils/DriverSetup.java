package com.aos.utils;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DriverSetup {
	public AppiumDriver<MobileElement> driverSetup() throws Exception {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("DeviceName", "Celular");
		dc.setCapability("udid", "8S00Q7103011ZN1199R00HP");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "9");
		dc.setCapability("appPackage", "com.Advantage.aShopping");
		dc.setCapability("appActivity", "com.Advantage.aShopping.SplashActivity");
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		
		AppiumDriver<MobileElement> driver = new AppiumDriver<MobileElement>(url,dc);
		return driver;
		
	}

}
