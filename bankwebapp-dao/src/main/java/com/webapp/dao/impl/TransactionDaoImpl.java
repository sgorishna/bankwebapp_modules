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
			PreparedStatement preparedStatement1 = conn.prepareStatement("update account set balance=balance - ?  where account_number = ?");
			preparedStatement1.setBigDecimal(1, transaction.getAmount());
			preparedStatement1.setLong(2, transaction.getSenderAccountNumber());

			PreparedStatement preparedStatement2 = conn.prepareStatement("update account set balance=balance+ ?   where account_number = ?");
			preparedStatement2.setBigDecimal(1, transaction.getAmount());
			preparedStatement1.setLong(2, transaction.getReceiverAccountNumber());

			PreparedStatement preparedStatement3 = conn.prepareStatement("insert into transaction(idAccount_sender,idAccount_receiver,amount,comments,created) values (?, ?, ?, ?, ?)");
			preparedStatement3.setLong(1, transaction.getIdAccountSender());
			preparedStatement3.setLong(2, transaction.getIdAccountReceiver());
			preparedStatement3.setBigDecimal(3, transaction.getAmount());
			preparedStatement3.setString(4, transaction.getComments());
			preparedStatement3.setTimestamp(5, new Timestamp(new java.util.Date().getTime()));

			preparedStatement1.executeUpdate();
			preparedStatement2.executeUpdate();
			preparedStatement3.executeUpdate();

			conn.commit();

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException ex) {
				Logger.getLogger(TransactionDaoImpl.class.getName()).log(Level.DEBUG, null, ex);
			}
			Logger.getLogger(TransactionDaoImpl.class.getName()).log(Level.DEBUG, null, e);
		} finally {
			DBUtill.closeConnection(conn);
		}

	}

	public void update(Transaction object) throws UnsupportedOperationException {

		try {
			throw new UnsupportedOperationException("Not implemented yet");
		} catch (java.lang.UnsupportedOperationException e) {

			Logger.getLogger(TransactionDaoImpl.class.getName()).log(Level.DEBUG, null, e);
		}

	}

	public void delete(Transaction object) throws UnsupportedOperationException {
		try {
			throw new UnsupportedOperationException("Not implemented yet");
		} catch (java.lang.UnsupportedOperationException e) {

			Logger.getLogger(TransactionDaoImpl.class.getName()).log(Level.DEBUG, null, e);
		}

	}

	public Transaction findById(long id) throws UnsupportedOperationException {
		try {
			throw new UnsupportedOperationException("Not implemented yet");
		} catch (java.lang.UnsupportedOperationException e) {
			Logger.getLogger(TransactionDaoImpl.class.getName()).log(Level.DEBUG, null, e);
			return null;
		}
	}

	public List<Transaction> findAll() throws UnsupportedOperationException {
		try {
			throw new UnsupportedOperationException("Not implemented yet");
		} catch (java.lang.UnsupportedOperationException e) {
			Logger.getLogger(TransactionDaoImpl.class.getName()).log(Level.DEBUG, null, e);
			return Collections.emptyList();
		}
	}

	public List<Transaction> findByIdCustomer(long idCustomer) {
		Connection connection = null;

		List<Transaction> transactionList = new ArrayList<Transaction>();

		try {

			String sql = "select t.idTransaction, a.account_number as sender_acc_num, c.name as sender_name, b.account_number as receiver_acc_num,"
					+ " d.name as receiver_name, t.amount, cur.currency, t.comments, t.created from transaction t join account a on t.idAccount_sender=a.idAccount"
					+ " join account b on t.idAccount_receiver= b.idAccount join customer  c on c.idCustomer = a.idCustomer join customer d on d.idCustomer =  b.idCustomer"
					+ " join account_currency cur on a.idCurrency = cur.idAccount_currency where a.idCustomer =? " +

					" union select t.idTransaction, a.account_number as sender_acc_num, c.name as sender_name, b.account_number as receiver_acc_num,"
					+ " d.name as receiver_name, t.amount, cur.currency, t.comments, t.created from transaction t join account a on t.idAccount_sender=a.idAccount"
					+ " join account b on t.idAccount_receiver= b.idAccount join customer  c on c.idCustomer = a.idCustomer join customer d on d.idCustomer =  b.idCustomer"
					+ " join account_currency cur on a.idCurrency = cur.idAccount_currency where b.idCustomer =?  ";

			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, idCustomer);
			preparedStatement.setLong(2, idCustomer);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				Transaction transaction = new Transaction();

				transaction.setIdTransaction(rs.getLong("idTransaction"));

				transaction.setSenderAccountNumber(rs.getLong("sender_acc_num"));

				transaction.setSenderName(rs.getString("sender_name"));

				transaction.setReceiverAccountNumber(rs.getLong("receiver_acc_num"));

				transaction.setReceiverName(rs.getString("receiver_name"));

				transaction.setAmount(rs.getBigDecimal("amount"));

				transaction.setCurrency(rs.getString("currency"));

				transaction.setComments(rs.getString("comments"));

				transaction.setCreated(rs.getTimestamp("created"));

				transactionList.add(transaction);
			}

		} catch (SQLException ex) {
			Logger.getLogger(TransactionDaoImpl.class.getName()).log(Level.DEBUG, null, ex);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return transactionList;
	}

}
