package com.aperea.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.csc.fsg.bpo.services.policydoc.PolicyDocServices;
import com.csc.fsg.bpo.services.policydoc.PolicyDocServicesPortType;
import com.csc.fsg.bpo.services.policydoc.WsFault_Exception;
import com.csc.fsg.bpo.services.policydoc.xsd.Credentials;
import com.csc.fsg.bpo.services.policydoc.xsd.GetDocumentListRequest;
import com.csc.fsg.bpo.services.policydoc.xsd.ObjectFactory;

@ManagedBean
@ViewScoped
public class PolicyDocumentViewBean {

	@ManagedProperty(value = "#{documentRepo}")
	private PolicyDocServicesPortType documentRepo;

	private List<PolicyDocumentModel> policyDocumentModelList = new ArrayList<PolicyDocumentModel>();
	
	private PolicyDocumentModel selectedPolicyDocumentModel = new PolicyDocumentModel();
	
    private ObjectFactory factory = new ObjectFactory();	
    
    private Date fromDate;
    
    @PostConstruct
	public void init() {
		setFromDate(new Date());//testing
	}

    public void fetchDocuments(){
    	FacesContext fc = FacesContext.getCurrentInstance();

    	GetDocumentListRequest request = buildSearchRequest();
    	
    	policyDocumentModelList = new ArrayList<PolicyDocumentModel>();

    }
    
	private GetDocumentListRequest buildSearchRequest() {
		
		GetDocumentListRequest request = factory.createGetDocumentListRequest();
		request.setClient("gafg");
		request.setPolicyNumber("");
		request.setCredentials(buildCredentials());
		request.setSearchDateBegin(toXMLDate(getFromDate()));
		request.setSearchDateEnd(toXMLDate(getFromDate()));
		//request.setSearchSystem(value);???
		return request;
	}

	private Credentials buildCredentials() {
		Credentials credentials = new Credentials();
		credentials.setUserDomain("bpo");
		credentials.setUserId("bpouser1");
		credentials.setPassword("JU9c!+m054G");		
		return credentials;
	}
	
private static final String dateFormat = "MM/dd/yyyy";
	
	private XMLGregorianCalendar toXMLDate(final Date date)  {
		try {
			if (date==null) return null;
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(date);
			final XMLGregorianCalendar gc =   DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			gc.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
			return gc;
		} catch (DatatypeConfigurationException e) {
			throw new RuntimeException(e);
		}
	}

	public PolicyDocServicesPortType getDocumentRepo() {
		return documentRepo;
	}

	public void setDocumentRepo(PolicyDocServicesPortType documentRepo) {
		this.documentRepo = documentRepo;
	}



	public List<PolicyDocumentModel> getPolicyDocumentModelList() {
		return policyDocumentModelList;
	}

	public void setPolicyDocumentModelList(List<PolicyDocumentModel> policyDocumentModelList) {
		this.policyDocumentModelList = policyDocumentModelList;
	}

	public PolicyDocumentModel getSelectedPolicyDocumentModel() {
		return selectedPolicyDocumentModel;
	}

	public void setSelectedPolicyDocumentModel(PolicyDocumentModel selectedPolicyDocumentModel) {
		this.selectedPolicyDocumentModel = selectedPolicyDocumentModel;
	}

	public ObjectFactory getFactory() {
		return factory;
	}

	public void setFactory(ObjectFactory factory) {
		this.factory = factory;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

    

}
