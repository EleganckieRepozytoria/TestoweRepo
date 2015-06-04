package gita.testujemy;

import java.util.*;

public class TestujemyGita
{
	public static HashMap<String, String> stringArrayToHash(String[] strArray)
	{
		/*
		 * @brief Takes strArray as input and outputs HashMap, where even strArray entries are keys,
		 * and odd strArray entries are values to previous keys. For simplicity - without using generics.
		 * 
		 */
		HashMap<String, String> simpleHash = new HashMap<String, String>();
		
		for(int keyCounter = 0, valueCounter = 1; keyCounter < strArray.length; keyCounter +=2, valueCounter +=2)
		{
			try
			{
				simpleHash.put(strArray[keyCounter], strArray[valueCounter]);
			} 
			catch(Exception excpetion)
			{
				simpleHash.put(strArray[keyCounter], "None");
			}
				
		}
		
		return simpleHash;
	}
	
	public static String[] hashToStringArray(HashMap<String,String> strHash)
	{
		/*
		 * @brief Takes HashMap as input and outputs string array, where each string neighbours
		 * corresponds to <key -> value> entry in hashMap.
		 * Calling: TestujemyGita.hashToStringArray(TestujemyGita.stringArrayToHash(strArray)) should return
		 * string equal to strArray (take care of "None" if strArary length is odd).
		 * 
		 */
		
		//TO DO
		return null;
	}
	
	public static void main(String[] args)
	{
		String[] strArray = {"Jeden", "Dwa", "Trzy", "Cztery", "Piêæ", "Szeœæ", "Siedem"};
		HashMap<String, String> simpleHash = TestujemyGita.stringArrayToHash(strArray);
		System.out.println(simpleHash);
	}

}
