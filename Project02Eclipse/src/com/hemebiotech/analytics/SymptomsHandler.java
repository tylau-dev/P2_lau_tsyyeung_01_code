package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.hemebiotech.analytics.Interface.ISymptomsHandler;

/**
 * Implementation of ISymptomsHandler, with the logic for reading/counting/writing
 * the content of input file
 */

public class SymptomsHandler implements ISymptomsHandler {
	private String filepath;
	public ArrayList<String> symptomsList = new ArrayList<String>();
	public TreeMap<String, Integer> symptomsCountMap = new TreeMap<String, Integer>();
	
	/**
	 * Each SymptomsHandler is assigned to one text file defined by its filepath
	 * 
	 * @param filepath string of the text file containing a list of symptoms
	 */
	public SymptomsHandler (String filepath) {
		this.filepath = filepath;
	}
	
	/**
	 * Read the file defined in file path and save content in symptomsList
	 * 
	 * @return void
	 */
	public void GetSymptoms() {
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					symptomsList.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		
	
	/**
	 * Sort and count the content of symptomsList and save the result in symptomsCountMap
	 * 
	 * @return void
	 */
	public void CountSymptoms() {
		for (int i = 0; i < symptomsList.size(); i++) {
			String symptom = symptomsList.get(i);
			Integer existingMapCount = symptomsCountMap.get(symptom);
			if (existingMapCount != null) 
				{symptomsCountMap.put(symptom, existingMapCount + 1);}
			else {symptomsCountMap.put(symptom, 1);}
		}
	}
	

	/**
	 * Write content of symptomsCountMap
	 * 
	 * @param outputFile string of the output file name
	 * @return void
	 */
	public void WriteSymptoms(String outputFile) {
		try {
			FileWriter writer = new FileWriter (outputFile);
			for (Map.Entry<String, Integer> entry : symptomsCountMap.entrySet()) {
				writer.write(entry.getKey() + "=" + String.valueOf(entry.getValue()) + "\n");
			}
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
