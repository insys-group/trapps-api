package com.insys.trapps.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.insys.trapps.model.Business;
import com.insys.trapps.service.BusinessService;

/**
 * {@link BusinessController} for PersoneelServices.
 *
 * @author Kris Krishna
 * @since 1.0.0
 **/
@RestController
@RequestMapping("/businesses")
public class BusinessController {

    @Autowired
    BusinessService businessService;

    /**
     * @return List of Businesses
     */
    @RequestMapping(value = { "", "/" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Business>> listBusinesses() {
	// return Arrays.asList(businessRepository.findAll());

	List<Business> list = businessService.listBusinesses();

	return new ResponseEntity<List<Business>>(list, HttpStatus.OK);
    }

    /**
     * @param request
     * @return the business created
     * @throws Exception
     */
    @RequestMapping(value = { "", "/" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Business> createBusiness(@RequestBody Business request) throws Exception {

	Business business = businessService.createBusiness(request);
	HttpHeaders responseHeaders = new HttpHeaders();
	URI newBusinessUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		.buildAndExpand(business.getBusinessId()).toUri();
	responseHeaders.setLocation(newBusinessUri);

	return new ResponseEntity<Business>(business, responseHeaders, HttpStatus.CREATED);

    }

}