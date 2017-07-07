package com.qmetry.qaf.automation.support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

/**
 * The Class PickerWheelUtils is created for supporting picker wheel specific actions on iOS
 * 
 * @author amit.bhoraniya
 */
 
public class PickerWheelUtils {

	/**
	 * Gets the location X.
	 *
	 * @param me the me
	 * @return the location X
	 */
	// Gets the objects X location in pixels
	private static String getLocationX(WebElement me) {
		int x = me.getLocation().x;
		int width = (Integer.parseInt(me.getAttribute("width")) / 2) + x;
		return width + "";
	}

	/**
	 * Gets the location Y.
	 *
	 * @param me the me
	 * @return the location Y
	 */
	// Gets the objects X location in pixels
	private static String getLocationY(WebElement me) {
		int y = me.getLocation().y;
		int height = (Integer.parseInt(me.getAttribute("height")) / 2) + y;
		return height + "";
	}

	/**
	 * Swipe.
	 *
	 * @param start the start
	 * @param end the end
	 * @param up the up
	 */
	private static void swipe(String start, String end, Boolean up) {
		String direction;
		if (up) {
			direction = start + "," + (Integer.parseInt(end) + 70);
		} else {
			direction = start + "," + (Integer.parseInt(end) - 70);
		}
		Map<String, Object> params1 = new HashMap<>();
		params1.put("location", start + "," + end);
		params1.put("operation", "down");
		new WebDriverTestBase().getDriver().executeScript("mobile:touch:tap", params1);

		Map<String, Object> params2 = new HashMap<>();
		List<String> coordinates2 = new ArrayList<>();

		coordinates2.add(direction);
		params2.put("location", coordinates2);
		params2.put("auxiliary", "notap");
		params2.put("duration", "3");
		new WebDriverTestBase().getDriver().executeScript("mobile:touch:drag", params2);

		Map<String, Object> params3 = new HashMap<>();
		params3.put("location", direction);
		params3.put("operation", "up");
		new WebDriverTestBase().getDriver().executeScript("mobile:touch:tap", params3);
	}

	/**
	 * Scroll.
	 *
	 * @param me the me
	 * @param direction the direction
	 * @param times the times
	 */
	public static void scroll(QAFWebElement me, Boolean direction, int times) {
		String x = getLocationX(me);
		String y = getLocationY(me);
		int count = 1;
		while (count <= times) {
			swipe(x, y, direction);
			++count;
		}
	}

	/**
	 * Sets the text.
	 *
	 * @param value the value
	 * @param me the me
	 * @param direction the direction
	 * @param maxlimit the maxlimit
	 */
	public static void setText(String value, QAFWebElement me, Boolean direction, int... maxlimit) {
		String x = getLocationX(me);
		String y = getLocationY(me);
		int retry = (maxlimit != null && maxlimit.length > 0) ? maxlimit[0] : 60;
		int count = 1;
		while (!me.getText().contains(value) && count <= retry) {
			swipe(x, y, direction);
			++count;
		}
	}
}
