package com.hemebiotech.analytics.Interface;

/**
 * Handler centralizing all actions done on a text file with a list of symptoms
 */

public interface ISymptomsHandler {
	void GetSymptoms ();

	void CountSymptoms();
	
	void WriteSymptoms (String outputLocation);
}
