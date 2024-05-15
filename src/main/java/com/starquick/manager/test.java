package com.starquick.manager;

import java.util.HashMap;

public class test {

	
	public static void main(String[] args) {
	String abc = "My name is Faraz";
	String FABC=abc.replace(" ", "").toLowerCase();
	HashMap<Character,  Integer> map = new HashMap<>();
	
	char[] charArray = FABC.toCharArray();
	for(char c:charArray)
	if(map.containsKey(c)) {
		map.put(c, map.get(c)+1);
	}else {
		map.put(c,1);
	}
System.out.println(map);
	}

}
