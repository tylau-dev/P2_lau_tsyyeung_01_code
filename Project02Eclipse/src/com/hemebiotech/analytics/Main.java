package com.hemebiotech.analytics;

public class Main {
	public static void main(String[] args) throws Exception {
		
		SymptomsHandler symptomsAnalytics = new SymptomsHandler(args[0]);
		symptomsAnalytics.GetSymptoms();
		symptomsAnalytics.CountSymptoms();
		symptomsAnalytics.WriteSymptoms("result.out");	
	}
}

