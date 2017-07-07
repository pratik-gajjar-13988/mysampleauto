package com.qmetry.qaf.automation.support;

import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

/**
 * The Class DriverUtils  is created as utility to serve various driver at runtime
 * 
 * @author pratik.gajjar
 */
@SuppressWarnings("rawtypes")
public class DriverUtils {

	/**
	 * Gets the appium driver.
	 *
	 * @return the appium driver
	 */
	public static AppiumDriver getAppiumDriver() {
		return (AppiumDriver) getDriver().getUnderLayingDriver();
	}

	/**
	 * Gets the IOS driver.
	 *
	 * @return the IOS driver
	 */
	public static IOSDriver getIOSDriver() {
		return (IOSDriver) getAppiumDriver();
	}

	/**
	 * Gets the android driver.
	 *
	 * @return the android driver
	 */
	public static AndroidDriver getAndroidDriver() {
		return (AndroidDriver) getAppiumDriver();
	}

	/**
	 * Gets the driver.
	 *
	 * @return the driver
	 */
	public static QAFExtendedWebDriver getDriver() {
		return new WebDriverTestBase().getDriver();
	}

	/**
	 * Checks if is running on IOS.
	 *
	 * @return true, if is running on IOS
	 */
	public static boolean isRunningOnIOS() {
		return (null != getDriver().getCapabilities().getCapability("platformName"))
				&& getDriver().getCapabilities().getCapability("platformName").toString().toLowerCase().contains("ios");
	}

	/**
	 * Checks if is running on android.
	 *
	 * @return true, if is running on android
	 */
	public static boolean isRunningOnAndroid() {
		return (null != getDriver().getCapabilities().getCapability("platformName")) && getDriver().getCapabilities()
				.getCapability("platformName").toString().toLowerCase().contains("android");

	}

}
