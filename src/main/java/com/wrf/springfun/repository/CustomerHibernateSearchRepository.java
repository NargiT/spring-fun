package com.wrf.springfun.repository;

import com.wrf.springfun.entity.Customer;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by nargit on 31/01/2015.
 */
@Repository
@Transactional
public class CustomerHibernateSearchRepository {

	// Spring will inject here the entity manager object
	@PersistenceContext
	private EntityManager entityManager;

	public List<Customer> findByAnyName(String name) {
		// get the full text entity manager
		FullTextEntityManager fullTextEntityManager =
				Search.getFullTextEntityManager(entityManager);

		// create the query using Hibernate Search query DSL
		QueryBuilder queryBuilder =
				fullTextEntityManager.getSearchFactory()
						.buildQueryBuilder().forEntity(Customer.class).get();

		// a very basic query by keywords
		Query query =
				queryBuilder
						.keyword()
						.onFields("lastname", "firstname")
						.matching(name)
						.createQuery();

		// wrap Lucene query in an Hibernate Query object
		FullTextQuery jpaQuery =
				fullTextEntityManager.createFullTextQuery(query, Customer.class);

		// execute search and return results (sorted by relevance as default)
		@SuppressWarnings("unchecked")
		List results = jpaQuery.getResultList();

		return results;
	}


}
