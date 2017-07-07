package com.my.infostretch.mobile.steps.common;

import com.qmetry.qaf.automation.step.QAFTestStep;
/**
 * 
 * @author pratik.gajjar
 */
public interface IStepLib {

	@QAFTestStep(description = "I go back from app/play store")
	public void backfromplaystore();
}
