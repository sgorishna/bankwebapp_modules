package com.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.webapp.dao.TransactionDao;
import com.webapp.db.DBUtill;
import com.webapp.model.Transaction;

public class TransactionDaoImpl implements TransactionDao {

	private static final long serialVersionUID = 1L;

	public void create(Transaction transaction) {

		Connection conn = null;
		try {
			conn = DBUtill.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement preparedStatement1 = conn
					.prepareStatement("update account set balance=balance - ?  where account_number = ?");
			preparedStatement1.setBigDecimal(1, transaction.getAmount());
			preparedStatement1.setString(2,
					transaction.getSenderAccountNumber());

			PreparedStatement preparedStatement2 = conn
					.prepareStatement("update account set balance=balance+ ?   where account_number = ?");
			preparedStatement2.setBigDecimal(1, transaction.getAmount());
			preparedStatement1.setString(2,
					transaction.getReceiverAccountNumber());

			PreparedStatement preparedStatement3 = conn
					.prepareStatement("insert into transaction(idAccount_sender,idAccount_receiver,amount,comments,created) values (?, ?, ?, ?, ?)");
			preparedStatement3.setLong(1, transaction.getIdAccountSender());
			preparedStatement3.setLong(2, transaction.getIdAccountReceiver());
			preparedStatement3.setBigDecimal(3, transaction.getAmount());
			preparedStatement3.setString(4, transaction.getComments());
			preparedStatement3.setTimestamp(5, new Timestamp(
					new java.util.Date().getTime()));

			preparedStatement1.executeUpdate();
			preparedStatement2.executeUpdate();
			preparedStatement3.executeUpdate();

			conn.commit();

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException ex) {
				Logger.getLogger(TransactionDaoImpl.class.getName()).log(
						Level.DEBUG, null, ex);
			}
			Logger.getLogger(TransactionDaoImpl.class.getName()).log(
					Level.DEBUG, null, e);
		} finally {
			DBUtill.closeConnection(conn);
		}

	}

	public void update(Transaction object) throws UnsupportedOperationException {

		try {
			throw new UnsupportedOperationException("Not implemented yet");
		} catch (java.lang.UnsupportedOperationException e) {

			Logger.getLogger(TransactionDaoImpl.class.getName()).log(
					Level.DEBUG, null, e);
		}

	}

	public void delete(Transaction object) throws UnsupportedOperationException {
		try {
			throw new UnsupportedOperationException("Not implemented yet");
		} catch (java.lang.UnsupportedOperationException e) {

			Logger.getLogger(TransactionDaoImpl.class.getName()).log(
					Level.DEBUG, null, e);
		}

	}

	public Transaction findById(long id) throws UnsupportedOperationException {
		try {
			throw new UnsupportedOperationException("Not implemented yet");
		} catch (java.lang.UnsupportedOperationException e) {
			Logger.getLogger(TransactionDaoImpl.class.getName()).log(
					Level.DEBUG, null, e);
			return null;
		}
	}

	public List<Transaction> findAll() throws UnsupportedOperationException {
		try {
			throw new UnsupportedOperationException("Not implemented yet");
		} catch (java.lang.UnsupportedOperationException e) {
			Logger.getLogger(TransactionDaoImpl.class.getName()).log(
					Level.DEBUG, null, e);
			return Collections.emptyList();
		}
	}

	public List<Transaction> findByIdCustomer(long idCustomer) {
		Connection connection = null;

		List<Transaction> transactionList = new ArrayList<Transaction>();

		try {

			String sql = "select idTransaction, senderName,senderAccNum, receiverName, receiverAccNum, amount, currency, comments, t.created from transaction t left join account a on a.idAccount = t.idAccount_sender left join account b on b.idAccount = t.idAccount_receiver where a.idCustomer =? or b.idCustomer =?";

			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setLong(1, idCustomer);
			preparedStatement.setLong(2, idCustomer);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				Transaction transaction = new Transaction();

				transaction.setIdTransaction(rs.getLong("idTransaction"));

				transaction.setSenderAccountNumber(rs
						.getString("senderAccNum"));

				transaction.setSenderName(rs.getString("senderName"));

				transaction.setReceiverAccountNumber(rs
						.getString("receiverAccNum"));

				transaction.setReceiverName(rs.getString("receiverName"));

				transaction.setAmount(rs.getBigDecimal("amount"));

				transaction.setCurrency(rs.getString("currency"));

				transaction.setComments(rs.getString("comments"));

				transaction.setCreated(rs.getTimestamp("created"));

				transactionList.add(transaction);
			}

		} catch (SQLException ex) {
			Logger.getLogger(TransactionDaoImpl.class.getName()).log(
					Level.DEBUG, null, ex);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return transactionList;
	}

	public void topUpBalance(Transaction transaction) {

		Connection conn = null;
		try {
			conn = DBUtill.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement preparedStatement = conn
					.prepareStatement("update account set balance=balance+ ?, updated =?   where account_number = ?");
			preparedStatement.setBigDecimal(1, transaction.getAmount());
			preparedStatement.setTimestamp(2, new Timestamp(
					new java.util.Date().getTime()));
			preparedStatement.setString(3,
					transaction.getReceiverAccountNumber());

			PreparedStatement preparedStatement2 = conn
					.prepareStatement("insert into transaction(idAccount_sender,idAccount_receiver,amount, senderAccNum, receiverAccNum, senderName, receiverName, currency,comments,created) values (?, ?, ?, ?, ?, ?, ?, ?, ?,?)");
			preparedStatement2.setLong(1, transaction.getIdAccountSender());
			preparedStatement2.setLong(2, transaction.getIdAccountReceiver());
			preparedStatement2.setBigDecimal(3, transaction.getAmount());
			preparedStatement2.setString(4,
					transaction.getSenderAccountNumber());
			preparedStatement2.setString(5,
					transaction.getReceiverAccountNumber());
			preparedStatement2.setString(6, transaction.getSenderName());
			preparedStatement2.setString(7, transaction.getReceiverName());
			preparedStatement2.setString(8, transaction.getCurrency());
			preparedStatement2.setString(9, transaction.getComments());
			preparedStatement2.setTimestamp(10, new Timestamp(
					new java.util.Date().getTime()));
			

			preparedStatement.executeUpdate();
			preparedStatement2.executeUpdate();

			conn.commit();

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException ex) {
				Logger.getLogger(TransactionDaoImpl.class.getName()).log(
						Level.DEBUG, null, ex);
			}
			Logger.getLogger(TransactionDaoImpl.class.getName()).log(
					Level.DEBUG, null, e);
		} finally {
			DBUtill.closeConnection(conn);
		}

	}

	public void withdrawBalance(Transaction transaction) {

		Connection conn = null;
		try {
			conn = DBUtill.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement preparedStatement = conn
					.prepareStatement("update account set balance=balance+?, updated =?   where account_number = ?");
			preparedStatement.setBigDecimal(1, transaction.getAmount());
			preparedStatement.setTimestamp(2, new Timestamp(
					new java.util.Date().getTime()));
			preparedStatement.setString(3,
					transaction.getReceiverAccountNumber());

			PreparedStatement preparedStatement2 = conn
					.prepareStatement("insert into transaction(idAccount_sender,idAccount_receiver,amount, senderAccNum, receiverAccNum, senderName, receiverName, currency,comments,created) values (?, ?, ?, ?, ?, ?, ?, ?, ?,?)");
			preparedStatement2.setLong(1, transaction.getIdAccountSender());
			preparedStatement2.setLong(2, transaction.getIdAccountReceiver());
			preparedStatement2.setBigDecimal(3, transaction.getAmount());
			preparedStatement2.setString(4,
					transaction.getSenderAccountNumber());
			preparedStatement2.setString(5,
					transaction.getReceiverAccountNumber());
			preparedStatement2.setString(6, transaction.getSenderName());
			preparedStatement2.setString(7, transaction.getReceiverName());
			preparedStatement2.setString(8, transaction.getCurrency());
			preparedStatement2.setString(9, transaction.getComments());
			preparedStatement2.setTimestamp(10, new Timestamp(
					new java.util.Date().getTime()));

			preparedStatement.executeUpdate();
			preparedStatement2.executeUpdate();

			conn.commit();

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException ex) {
				Logger.getLogger(TransactionDaoImpl.class.getName()).log(
						Level.DEBUG, null, ex);
			}
			Logger.getLogger(TransactionDaoImpl.class.getName()).log(
					Level.DEBUG, null, e);
		} finally {
			DBUtill.closeConnection(conn);
		}

	}

	public List<Transaction> findByIdAccount(long idAccount) {

		Connection connection = null;

		List<Transaction> transactionList = new ArrayList<Transaction>();

		try {

			String sql = "select idTransaction, senderName,senderAccNum, receiverName, receiverAccNum, amount, currency, comments, t.created from transaction t where idAccount_sender = ? or idAccount_receiver =?";

			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setLong(1, idAccount);
			preparedStatement.setLong(2, idAccount);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				Transaction transaction = new Transaction();

				transaction.setIdTransaction(rs.getLong("idTransaction"));

				transaction.setSenderAccountNumber(rs
						.getString("senderAccNum"));

				transaction.setSenderName(rs.getString("senderName"));

				transaction.setReceiverAccountNumber(rs
						.getString("receiverAccNum"));

				transaction.setReceiverName(rs.getString("receiverName"));

				transaction.setAmount(rs.getBigDecimal("amount"));

				transaction.setCurrency(rs.getString("currency"));

				transaction.setComments(rs.getString("comments"));

				transaction.setCreated(rs.getTimestamp("created"));

				transactionList.add(transaction);
			}

		} catch (SQLException ex) {
			Logger.getLogger(TransactionDaoImpl.class.getName()).log(
					Level.DEBUG, null, ex);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return transactionList;
	}

	public List<Transaction> transferredFundsByIdAccount(long idAccount) {
		
		Connection connection = null;

		List<Transaction> transactionList = new ArrayList<Transaction>();

		try {

			String sql = " select idTransaction, senderName,senderAccNum, receiverName, receiverAccNum, amount, currency, comments, t.created from transaction t where idAccount_sender = ?";

			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setLong(1, idAccount);
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				Transaction transaction = new Transaction();

				transaction.setIdTransaction(rs.getLong("idTransaction"));

				transaction.setSenderAccountNumber(rs
						.getString("senderAccNum"));

				transaction.setSenderName(rs.getString("senderName"));

				transaction.setReceiverAccountNumber(rs
						.getString("receiverAccNum"));

				transaction.setReceiverName(rs.getString("receiverName"));

				transaction.setAmount(rs.getBigDecimal("amount"));

				transaction.setCurrency(rs.getString("currency"));

				transaction.setComments(rs.getString("comments"));

				transaction.setCreated(rs.getTimestamp("created"));

				transactionList.add(transaction);
			}

		} catch (SQLException ex) {
			Logger.getLogger(TransactionDaoImpl.class.getName()).log(
					Level.DEBUG, null, ex);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return transactionList;	
		
	}

	public List<Transaction> receivedFundsByIdAccount(long idAccount) {
		
		
		Connection connection = null;

		List<Transaction> transactionList = new ArrayList<Transaction>();

		try {

			String sql = " select idTransaction, senderName,senderAccNum, receiverName, receiverAccNum, amount, currency, comments, t.created from transaction t where idAccount_receiver = ?";

			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setLong(1, idAccount);
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				Transaction transaction = new Transaction();

				transaction.setIdTransaction(rs.getLong("idTransaction"));

				transaction.setSenderAccountNumber(rs
						.getString("senderAccNum"));

				transaction.setSenderName(rs.getString("senderName"));

				transaction.setReceiverAccountNumber(rs
						.getString("receiverAccNum"));

				transaction.setReceiverName(rs.getString("receiverName"));

				transaction.setAmount(rs.getBigDecimal("amount"));

				transaction.setCurrency(rs.getString("currency"));

				transaction.setComments(rs.getString("comments"));

				transaction.setCreated(rs.getTimestamp("created"));

				transactionList.add(transaction);
			}

		} catch (SQLException ex) {
			Logger.getLogger(TransactionDaoImpl.class.getName()).log(
					Level.DEBUG, null, ex);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return transactionList;	
		
		
	}

	public void transferFunds(Transaction transaction) {
		
		Connection conn = null;
		try {
			conn = DBUtill.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement preparedStatement = conn
					.prepareStatement("update account set balance=balance+ ?, updated =?   where account_number = ?");
			preparedStatement.setBigDecimal(1, transaction.getAmountAfterConversion());
			preparedStatement.setTimestamp(2, new Timestamp(
					new java.util.Date().getTime()));
			preparedStatement.setString(3,
					transaction.getReceiverAccountNumber());

			
			PreparedStatement preparedStatement3 = conn
					.prepareStatement("update account set balance=balance- ?, updated =?   where account_number = ?");
			preparedStatement3.setBigDecimal(1, transaction.getAmount());
			preparedStatement3.setTimestamp(2, new Timestamp(
					new java.util.Date().getTime()));
			preparedStatement3.setString(3,
					transaction.getSenderAccountNumber());
			
			PreparedStatement preparedStatement2 = conn
					.prepareStatement("insert into transaction(idAccount_sender,idAccount_receiver,amount, senderAccNum, receiverAccNum, senderName, receiverName, currency,comments,created) values (?, ?, ?, ?, ?, ?, ?, ?, ?,?)");
			preparedStatement2.setLong(1, transaction.getIdAccountSender());
			preparedStatement2.setLong(2, transaction.getIdAccountReceiver());
			preparedStatement2.setBigDecimal(3, transaction.getAmount());
			preparedStatement2.setString(4,
					transaction.getSenderAccountNumber());
			preparedStatement2.setString(5,
					transaction.getReceiverAccountNumber());
			preparedStatement2.setString(6, transaction.getSenderName());
			preparedStatement2.setString(7, transaction.getReceiverName());
			preparedStatement2.setString(8, transaction.getCurrency());
			preparedStatement2.setString(9, transaction.getComments());
			preparedStatement2.setTimestamp(10, new Timestamp(
					new java.util.Date().getTime()));
			

			preparedStatement.executeUpdate();
			preparedStatement3.executeUpdate();
			preparedStatement2.executeUpdate();

			conn.commit();

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException ex) {
				Logger.getLogger(TransactionDaoImpl.class.getName()).log(
						Level.DEBUG, null, ex);
			}
			Logger.getLogger(TransactionDaoImpl.class.getName()).log(
					Level.DEBUG, null, e);
		} finally {
			DBUtill.closeConnection(conn);
		}
		
	}

}
