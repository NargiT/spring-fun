package com.wrf.springfun.service;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * Created by nargit on 28/01/2015.
 */
@Component
public class BuildSearchIndex implements ApplicationListener {
	private static final Logger logger = LoggerFactory.getLogger(BuildSearchIndex.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void onApplicationEvent(ApplicationEvent applicationEvent) {
		try {
			FullTextEntityManager fullTextEntityManager =
					Search.getFullTextEntityManager(entityManager);
			fullTextEntityManager.createIndexer().startAndWait();
		}
		catch (InterruptedException e) {
			logger.error("An error occurred trying to build the search index: ", e);
		}
	}
}
