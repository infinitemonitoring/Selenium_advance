package com.starquick.Listners;

import java.util.Calendar;

import org.testng.util.Strings;

import com.epam.reportportal.listeners.ListenerParameters;
import com.epam.reportportal.service.Launch;
import com.epam.reportportal.service.ReportPortal;
import com.epam.reportportal.testng.ITestNGService;
import com.epam.reportportal.testng.TestNGService;
import com.epam.reportportal.utils.properties.PropertiesLoader;
import com.epam.ta.reportportal.ws.model.launch.StartLaunchRQ;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

public class ParamOverrideTestNgService extends TestNGService implements ITestNGService {
		public ParamOverrideTestNgService() {
			super(getLaunchOverriddenProperties());
		}

		private static Supplier<Launch> getLaunchOverriddenProperties() {
			ListenerParameters parameters = new ListenerParameters(PropertiesLoader.load());
			parameters.setApiKey("my crazy uuid");
			ReportPortal reportPortal = ReportPortal.builder().withParameters(parameters).build();
			StartLaunchRQ rq = buildStartLaunch(reportPortal.getParameters());
			return new Supplier<Launch>() {
				@Override
				public Launch get() {
					return reportPortal.newLaunch(rq);
				}
			};
		}

		private static StartLaunchRQ buildStartLaunch(ListenerParameters parameters) {
			StartLaunchRQ rq = new StartLaunchRQ();
			rq.setName(parameters.getLaunchName());
			rq.setStartTime(Calendar.getInstance().getTime());
			rq.setAttributes(parameters.getAttributes());
			rq.setMode(parameters.getLaunchRunningMode());
			if (!Strings.isNullOrEmpty(parameters.getDescription())) {
				rq.setDescription(parameters.getDescription());
			}

			return rq;
		}
	}