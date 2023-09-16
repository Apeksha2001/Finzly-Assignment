package com.finzly.fxtrading.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.fxtrading.entity.CurrencyPair;

/**
 * Repository for managing CurrencyPair entities in the database.
 */
@Repository
public class CurrencyPairDao {

	@Autowired
	SessionFactory sessionFactory;

	public List<CurrencyPair> getAllCurrencyPair() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(CurrencyPair.class);
		return criteria.list();
	}

	public String addCurrencyPair(CurrencyPair currencyPairObj) {
		Session session = sessionFactory.openSession();
		session.save(currencyPairObj);
		session.beginTransaction().commit();
		return "Currency Pair details saved successfully";
	}

	public String updateCurrencyPair(double convertedRate, String currencyPair1) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(CurrencyPair.class);
		criteria.add(Restrictions.eq("currencyPair", currencyPair1));
		List<CurrencyPair> currencyPairs = criteria.list();

		if (!currencyPairs.isEmpty()) {
			CurrencyPair currencyPair2 = currencyPairs.get(0);
			currencyPair2.setExchangeRate(convertedRate);
			session.update(currencyPair2);
			session.beginTransaction().commit();
			return "Currency pair exchange rate updated successfully";
		} else {
			return "Currency pair not found for update";
		}
	}

	public boolean delteCurrencyPair(String currencyPair) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(CurrencyPair.class);
		List<CurrencyPair> currencyPairs = (criteria.add(Restrictions.eq("currencyPair", currencyPair))).list();
		if (currencyPairs.isEmpty()) {
			return false;
		}
		session.delete(currencyPairs.get(0));
		session.beginTransaction().commit();
		return true;
	}

}
