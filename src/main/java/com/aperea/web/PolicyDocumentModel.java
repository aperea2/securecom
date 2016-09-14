package com.aperea.web;

import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PolicyDocumentModel implements Serializable { 

	private static final long serialVersionUID = 1L;
	
	private String documentKey;
	private String documentSource;
	private String policyNumber;
	private String documentDate;
	public String getDocumentKey() {
		return documentKey;
	}
	public void setDocumentKey(String documentKey) {
		this.documentKey = documentKey;
	}
	public String getDocumentSource() {
		return documentSource;
	}
	public void setDocumentSource(String documentSource) {
		this.documentSource = documentSource;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getDocumentDate() {
		return documentDate;
	}
	public void setDocumentDate(String documentDate) {
		this.documentDate = documentDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PolicyDocumentModel [documentKey=").append(documentKey).append(", documentSource=")
				.append(documentSource).append(", policyNumber=").append(policyNumber).append(", documentDate=")
				.append(documentDate).append("]");
		return builder.toString();
	}
	
	
	
}