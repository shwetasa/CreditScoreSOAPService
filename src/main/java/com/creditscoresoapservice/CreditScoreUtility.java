package com.creditscoresoapservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.creditscoresoapservice.soap.Creditscore;

@Component
public class CreditScoreUtility {
	
	private static Map<String, Creditscore> creditscoreMap = new HashMap<String,Creditscore>();
	public CreditScoreUtility(){
		Creditscore s1 = new Creditscore();
		s1.setCreditScore(720);
		s1.setSsn("15AC11");
		Creditscore s2 = new Creditscore();
		s2.setCreditScore(690);
		s2.setSsn("15HN78");
		creditscoreMap.put("15AC11", s1);
		creditscoreMap.put("15HN78", s2);
	}
	public Creditscore getCreditscore(int ssn){
		return creditscoreMap.get(ssn);
	}
	
	public static Creditscore getCreditscore(String ssn){
		Creditscore Creditscore =  creditscoreMap.get(ssn);
		return Creditscore;
	}
	
}
