package com.epam.reportportal.testng;

import com.epam.reportportal.service.ReportPortal;
import com.epam.reportportal.utils.MemoizingSupplier;

import java.util.function.Supplier;

/**
 * Backward-compatible version of Listeners with version prior to 3.0.0
 * Allows to have as many listener instances as needed.
 * The best approach is to have only one instance
 */
public class ReportPortalTestNGListener extends BaseTestNGListener {

	/* static instance with lazy init */
	public static final Supplier<ITestNGService> SERVICE =
			new MemoizingSupplier<>(() -> new TestNGService(ReportPortal.builder().build()));

	public ReportPortalTestNGListener() {
		super(SERVICE.get());
	}

}