package com.creditscoresoapservice;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.creditscoresoapservice.soap.GetCreditScoreRequest;
import com.creditscoresoapservice.soap.GetCreditScoreResponse;

@Endpoint
public class CreditScoreEndpoint {
	private static final String NAMESPACE_URI = "http://creditscoresoapservice.com/soap";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCreditScoreRequest")
	@ResponsePayload
	public GetCreditScoreResponse getCreditScore(@RequestPayload GetCreditScoreRequest request) {
		GetCreditScoreResponse response = new GetCreditScoreResponse();
		response.setCreditscore(CreditScoreUtility.getCreditscore(request.getSsn()));
		return response;
	}
}
