package com.my.infostretch.web.steps;

import static com.qmetry.qaf.automation.step.CommonStep.*;

import com.qmetry.qaf.automation.step.QAFTestStep;
/**
 * 
 * @author pratik.gajjar
 */
public class LandingSteps {

	@QAFTestStep(description = "I login with {username} and {password}")
	public void doLogin(String username, String password) {
		sendKeys(username, "input.username.login");
		sendKeys(password, "input.password.login");
		click("btn.submit.login");
	}

}
