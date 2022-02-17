package com.hemebiotech.analytics;

public class Main {
	public static void main(String[] args) throws Exception {
		
		final String fileLocation = "symptoms.txt";
		
		AnalyticsCounter analyticsReader = new AnalyticsCounter(fileLocation);
		analyticsReader.GetSymptoms();
		analyticsReader.CountSymptoms();
		analyticsReader.WriteSymptoms();
		
	}
}
