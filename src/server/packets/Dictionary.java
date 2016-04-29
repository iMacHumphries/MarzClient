package server.packets;

import java.util.HashMap;

public class Dictionary {
	
	private HashMap<String, String> dictionary;
	
	public Dictionary() {
		dictionary = new HashMap<>();
	}

	public Dictionary(String[] dataArray) throws IndexOutOfBoundsException {
		this();
		for (String pair : dataArray) {
			int equalIndex = pair.indexOf("=");
			String key = pair.substring(0, equalIndex);
			String value = pair.substring(equalIndex+1, pair.length());
			dictionary.put(key, value);
		}
	}
	
	public void put(String key, String value) {
		dictionary.put(key, value);
	}
	
	public String get(String key) {
		return dictionary.get(key);
	}
	
	public boolean has(String key) {
		return dictionary.containsKey(key);
	}
	
	public String toString() {
		String result = "";     
		for (String key : dictionary.keySet()) {
			result += key + "=" + dictionary.get(key) + ",";
		}
		return result.substring(0, result.length()-1); // Remove the last comma.
	}
	
}
