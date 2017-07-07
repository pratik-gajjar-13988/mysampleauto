package com.my.infostretch.mobile.steps.ios;

import com.my.infostretch.mobile.steps.common.IStepLib;
import static com.qmetry.qaf.automation.step.CommonStep.click;
/**
 * 
 * @author pratik.gajjar
 */
public class StepLib implements IStepLib {

	@Override
	public void backfromplaystore() {
		click("btn.back.apptore.appname");
	}

}
