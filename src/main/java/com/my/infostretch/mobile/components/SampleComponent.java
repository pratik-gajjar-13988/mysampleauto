package com.my.infostretch.mobile.components;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class SampleComponent extends QAFWebComponent {

	@FindBy(locator = "locator.key.for.element1")
	private QAFWebElement element1InsideComponent;
	@FindBy(locator = "locator.key.for.element2")
	private QAFWebElement element2InsideComponent;

	public SampleComponent(String locator) {
		super(locator);
	}

	public QAFWebElement getElement1InsideComponent() {
		return element1InsideComponent;
	}

	public QAFWebElement getElement2InsideComponent() {
		return element2InsideComponent;
	}

}