package com.wrf.springfun.controller;

import com.wrf.springfun.data.CustomerDTO;
import com.wrf.springfun.entity.Customer;
import com.wrf.springfun.repository.CustomerHibernateSearchRepository;
import com.wrf.springfun.service.BuildSearchIndex;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nargit on 15/12/2014.
 */
@RestController
public class CustomerSearchController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerSearchController.class);

	@Autowired
	private CustomerHibernateSearchRepository customerHibernateSearchRepository;

	@Autowired
	private Mapper mapper;


	// FIXME : return a list with dozer
	@RequestMapping(value = "/search/{name}", method = RequestMethod.GET)
	public CustomerDTO search(@PathVariable String name) {
		List<Customer> customers =  customerHibernateSearchRepository.findByAnyName(name);
		return mapper.map(customers.get(0), CustomerDTO.class);
	}

}
