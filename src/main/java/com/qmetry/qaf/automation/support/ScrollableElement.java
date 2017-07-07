
/**
 * @author pratik.gajjar
 *
 */

package com.qmetry.qaf.automation.support;

import java.util.Map;

import org.openqa.selenium.remote.Response;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;

/**
 * The Class ScrollableElement  is created as generic solution for scrolling to element automatically if not present in visible screen
 */
public class ScrollableElement extends QAFWebComponent {

	int predefattemnt;

	/**
	 * Instantiates a new scrollable element.
	 *
	 * @param locator the locator of the element to be present on visible screen
	 */
	public ScrollableElement(String locator) {
		super(locator);
		predefattemnt = 10;
	}

	/**
	 * Instantiates a new scrollable element.
	 *
	 * @param parent the parent element locator in dom
	 * @param locator the locator of the element to be present on visible screen
	 */
	public ScrollableElement(QAFExtendedWebElement parent, String locator) {
		super(parent, locator);
		predefattemnt = 10;
	}

	/**
	 * Instantiates a new scrollable element.
	 *
	 * @param locator the locator of the element to be present on visible screen
	 * @param predefattempt the scrolling attempts to be made to find element if not visible/present
	 */
	public ScrollableElement(String locator, int predefattempt) {
		super(locator);
		this.predefattemnt = predefattempt;
	}

	/**
	 * Execute.
	 *
	 * @param command the command
	 * @param parameters the parameters
	 * @return the response
	 */
	@Override
	protected Response execute(String command, Map<String, ?> parameters) {
		if (command.equalsIgnoreCase("isElementDisplayed")) {
			return super.execute(command, parameters);
		}
		try {
			boolean up = true;
			int attempt = 0;
			while (!(isPresent() && isDisplayed()) && attempt < predefattemnt) {
				if (up) {
					DriverUtils.getAppiumDriver().swipe(400,600,400,200,2);
				} else {
					DriverUtils.getAppiumDriver().swipe(400,200,400,600,2);
				}
				attempt++;
				if (attempt == (int) Math.floor(predefattemnt / 3))
					up = false;

			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return super.execute(command, parameters);
	}

}
