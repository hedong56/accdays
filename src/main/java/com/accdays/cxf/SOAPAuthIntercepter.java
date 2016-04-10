package com.accdays.cxf;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;

public class SOAPAuthIntercepter extends AbstractPhaseInterceptor<SoapMessage> {
	

	public SOAPAuthIntercepter(String phase) {
		super(phase);
	}

	@Override
	public void handleMessage(SoapMessage arg0) throws Fault {
		// TODO Auto-generated method stub
		
	}

}
