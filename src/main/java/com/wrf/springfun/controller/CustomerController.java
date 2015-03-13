package com.wrf.springfun.controller;

import com.wrf.springfun.data.CustomerCreateAnswer;
import com.wrf.springfun.data.CustomerDTO;
import com.wrf.springfun.entity.Customer;
import com.wrf.springfun.repository.CustomerRepository;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * Created by nargit on 15/12/2014.
 */
@RestController
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	//@Autowired
	//private CustomerRepository customerRepository;

	@Autowired
	private Mapper mapper;

	// FIXME : this is not REST !
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public CustomerCreateAnswer createCustomer(
			@RequestParam(value = "firstname") String firstName,
			@RequestParam(value = "lastname") String lastName) {
		Customer customer = new Customer(firstName, lastName);
		//Customer aCustomer = customerRepository.save(customer);
		//return new CustomerCreateAnswer(aCustomer.toString());
		return new CustomerCreateAnswer("");
	}

	@RequestMapping(value = "/customer/{lastName}", method = RequestMethod.GET)
	public CustomerDTO readCustomer(@PathVariable String lastName) {
		//List<Customer> customers = customerRepository.findByLastName(lastName);
		List<Customer> customers = Collections.EMPTY_LIST;

		if (customers.isEmpty()) {
			return null;
		}
		String plainCustomer = mapper.map(customers.get(0), String.class);
		CustomerDTO customerDTO = mapper.map(customers.get(0), CustomerDTO.class);
		return customerDTO;
	}
}
