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

import com.hemebiotech.analytics.Interface.IAnalyticsCounter;

public class AnalyticsCounter implements IAnalyticsCounter {
	private String filepath;
	public ArrayList<String> symptomsList = new ArrayList<String>();
	public TreeMap<String, Integer> symptomsCountMap = new TreeMap<String, Integer>();
	
	public AnalyticsCounter (String filepath) {
		this.filepath = filepath;
	}
	
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
		
	public void CountSymptoms() {
		Collections.sort(symptomsList);
		System.out.println(symptomsList);
		for (int i = 0; i < symptomsList.size(); i++) {
//			System.out.println(symptomsList.get(i));
			String symptom = symptomsList.get(i);
			Integer existingMapCount = symptomsCountMap.get(symptom);
			if (existingMapCount != null) 
				{symptomsCountMap.put(symptom, existingMapCount + 1);}
			else {symptomsCountMap.put(symptom, 1);}
			System.out.println(symptomsCountMap);
		}
//		System.out.println(symptomsCountMap);		
	}

	public void WriteSymptoms() {
		try {
			FileWriter writer = new FileWriter ("result.out");
			
			for (Map.Entry<String, Integer> entry : symptomsCountMap.entrySet()) {
				writer.write(entry.getKey() + "=" + String.valueOf(entry.getValue()));
			}
		
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
