package com.webapp.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.webapp.dao.ExchangeRateDao;
import com.webapp.db.DBUtill;
import com.webapp.model.Account;
import com.webapp.model.ExchangeRate;

public class ExchangeRateDaoImpl implements ExchangeRateDao {

	
	private static final long serialVersionUID = 1L;

	public void create(ExchangeRate object) {
		// TODO Auto-generated method stub

	}

	public void update(ExchangeRate exchangeRate) {
		Connection conn = null;
		try {
			conn = DBUtill.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("update exchangeRates set buy=?, sell = ?  where idCurrency=?");

			preparedStatement.setBigDecimal(1, exchangeRate.getBuy());
			preparedStatement.setBigDecimal(2, exchangeRate.getSell());
			preparedStatement.setLong(3, exchangeRate.getIdCurrency());
			

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.DEBUG, null, e);
		} finally {
			DBUtill.closeConnection(conn);
		}

	}

	public void delete(ExchangeRate object) {
		// TODO Auto-generated method stub

	}

	public ExchangeRate findById(long id) {
		
		Connection connection = null;
		ExchangeRate exchangeRate = new ExchangeRate();
		try {
			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select a.currency , e.idCurrency, e.buy, e.sell from exchangeRates e left join account_currency a on a.idAccount_currency = e.idCurrency where e.idCurrency = ?");
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				exchangeRate.setIdCurrency(rs.getLong("idCurrency"));
				exchangeRate.setCurrency(rs.getString("currency"));
				
				exchangeRate.setBuy(rs.getBigDecimal("buy"));
				exchangeRate.setSell(rs.getBigDecimal("sell"));
				
			}
		} catch (SQLException e) {
			Logger.getLogger(ExchangeRateDaoImpl.class.getName()).log(Level.DEBUG, null, e);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return exchangeRate;
	}

	public List<ExchangeRate> findAll() {

		Connection connection = null;

		List<ExchangeRate> exchangeRateList = new ArrayList<ExchangeRate>();

		Statement stmt = null;
		ResultSet rs = null;

		try {

			connection = DBUtill.getConnection();
			stmt = connection.createStatement();
			rs = stmt
					.executeQuery("select a.currency as currency, e.idCurrency, e.buy, e.sell from exchangeRates e left join account_currency a on a.idAccount_currency = e.idCurrency");
			while (rs.next()) {
				ExchangeRate exchangeRate = new ExchangeRate();
				exchangeRate.setIdCurrency(rs.getLong("idCurrency"));
				exchangeRate.setCurrency(rs.getString("currency"));
				
				exchangeRate.setBuy(rs.getBigDecimal("buy"));
				exchangeRate.setSell(rs.getBigDecimal("sell"));
				exchangeRateList.add(exchangeRate);
			}

		} catch (SQLException ex) {
			Logger.getLogger(ExchangeRateDaoImpl.class.getName()).log(Level.DEBUG,
					null, ex);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return exchangeRateList;
	}

	
}
