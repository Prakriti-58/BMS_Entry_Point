package com.ngn.bms.entrypoint.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

@Configuration
public class Routefilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(Routefilter.class);

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "route";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}
	
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public Object run() throws ZuulException {
		 log.info("Inside route filter..");
	        return null;
	}
}
