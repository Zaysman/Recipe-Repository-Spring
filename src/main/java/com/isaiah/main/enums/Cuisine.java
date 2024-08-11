package com.isaiah.main.enums;

public enum Cuisine {
	
	AMERICAN("American"),
	ITALIAN("Italian"),
	CHINESE("Chinese"),
	MEXICAN("Mexican"),
	INDIAN("Indian"),
	JAPANESE("Japanese"),
	FRENCH("French"),
	THAI("Thai"),
	GREEK("Greek"),
	KOREAN("Korean");
	
	Cuisine(String cuisineName) {
		// TODO Auto-generated constructor stub
		this.cuisineName = cuisineName;
	}

	private String cuisineName;
	
	public String getCuisineName() {
		return cuisineName;
	}
	
	public String getCuisineString(int number) {
		String cuisine = new String();
		
		switch(number) {
		case 1: cuisine = AMERICAN.getCuisineName();
		break;
		case 2: cuisine = ITALIAN.getCuisineName();
		break;
		case 3: cuisine = CHINESE.getCuisineName();
		break;
		case 4: cuisine = MEXICAN.getCuisineName();
		break;
		case 5: cuisine = INDIAN.getCuisineName();
		break;
		case 6: cuisine = JAPANESE.getCuisineName();
		break;
		case 7: cuisine = FRENCH.getCuisineName();
		break;
		case 8: cuisine = THAI.getCuisineName();
		break;
		case 9: cuisine = GREEK.getCuisineName();
		break;
		case 10: cuisine = KOREAN.getCuisineName();
		break;
		}
		
		return cuisine;
	}

}
