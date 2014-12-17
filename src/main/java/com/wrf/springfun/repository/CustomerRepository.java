package com.wrf.springfun.repository;

/**
 * Created by nargit on 15/12/2014.
 */
import java.util.List;

import com.wrf.springfun.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);
}