package com.starquick.Listners;

import com.epam.reportportal.testng.BaseTestNGListener;

public class MyListener extends BaseTestNGListener {
	public MyListener() {
		super(new ParamOverrideTestNgService());
	}
}

