package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.Interface.IAnalyticsCounter;

public class AnalyticsCounter implements IAnalyticsCounter {
	private String filepath;
	public ArrayList<String> readerResult = new ArrayList<String>();
	public Map<String, Integer> SymptomsCountList = new HashMap<String, Integer>();
	
	public AnalyticsCounter (String filepath) {
		this.filepath = filepath;
	}
	
	public void GetSymptoms() {
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					readerResult.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		
	public void CountSymptoms() {
		for (int i = 0; i < readerResult.size(); i++) {
			String symptom = readerResult.get(i);
			Integer existingMapCount = SymptomsCountList.get(readerResult.get(i));
			if (existingMapCount != null) 
				{SymptomsCountList.put(symptom, existingMapCount + 1);}
			else {SymptomsCountList.put(symptom, 1);}					
		}
		System.out.println(SymptomsCountList);		
	}

	public void WriteSymptoms() {
		try {
			FileWriter writer = new FileWriter ("result.out");
			
			for (Map.Entry<String, Integer> entry : SymptomsCountList.entrySet()) {
				writer.write(entry.getKey() + "=" + String.valueOf(entry.getValue()));
			}
		
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
