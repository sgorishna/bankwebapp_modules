package com.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.webapp.dao.CustomerDao;
import com.webapp.db.DBUtill;
import com.webapp.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	private static final long serialVersionUID = 1L;

	public void create(Customer customer, String[] roles) {

		Connection connection = null;

		try {
			connection = DBUtill.getConnection();
			connection.setAutoCommit(false);

			PreparedStatement preparedStatement = connection.prepareStatement("insert into customer(name,gender,login,password,email) values (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			PreparedStatement preparedStatement2 = connection.prepareStatement("insert into customer_role(idCustomer,idRole) values (?, ?)");

			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getGender());
			preparedStatement.setString(3, customer.getLogin());
			preparedStatement.setString(4, customer.getPassword());
			preparedStatement.setString(5, customer.getEmail());
			preparedStatement.executeUpdate();

			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			generatedKeys.next();

			for (int i = 0; i < roles.length; i++) {

				preparedStatement2.setLong(1, generatedKeys.getLong(1));
				preparedStatement2.setLong(2, Long.parseLong(roles[i]));
				preparedStatement2.executeUpdate();
			}

			connection.commit();

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {

				Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.DEBUG, null, e1);
			}
			Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.DEBUG, null, e);
		} finally {
			DBUtill.closeConnection(connection);
		}

	}

	public List<Customer> findAll() {
		Connection connection = null;

		List<Customer> customerList = new ArrayList<Customer>();

		Statement stmt = null;
		ResultSet rs = null;

		try {

			connection = DBUtill.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select c.idCustomer, c.name, c.gender, c.created, c.updated, c.login, c.password, c.email, c.idRole, c.active, r.role as role from customer c left join role r on c.idRole=r.idRole  order by name");
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setIdCustomer(rs.getLong("idCustomer"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setCreated(rs.getTimestamp("created"));
				customer.setUpdated(rs.getTimestamp("updated"));
				customer.setLogin(rs.getString("login"));
				customer.setPassword(rs.getString("password"));
				customer.setEmail(rs.getString("email"));
				customer.setIdRole(rs.getInt("idRole"));
				customer.setRole(rs.getString("role"));
				customer.setActive(rs.getInt("active"));
				customerList.add(customer);
			}

		} catch (SQLException ex) {
			Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.DEBUG, null, ex);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return customerList;
	}

	public Customer findById(long IdCustomer) {

		Connection connection = null;
		Customer customer = new Customer();
		try {
			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from customer where idCustomer=?");
			preparedStatement.setLong(1, IdCustomer);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				customer.setIdCustomer(rs.getLong("idCustomer"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setCreated(rs.getTimestamp("created"));
				customer.setUpdated(rs.getTimestamp("updated"));
				customer.setLogin(rs.getString("login"));
				customer.setPassword(rs.getString("password"));
				customer.setPhoto(rs.getBytes("photo"));
				customer.setPhotoPath(rs.getString("photoPath"));
				customer.setEmail(rs.getString("email"));

				customer.setIdRole(rs.getInt("idRole"));
				customer.setActive(rs.getInt("active"));
			}
		} catch (SQLException e) {
			Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.DEBUG, null, e);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return customer;
	}

	public void delete(Customer customer) {
		Connection conn = null;
		try {
			conn = DBUtill.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("delete from customer where idCustomer= ?");
			preparedStatement.setLong(1, customer.getIdCustomer());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.DEBUG, null, e);
		} finally {
			DBUtill.closeConnection(conn);
		}
	}

	public void update(Customer customer) {
		Connection conn = null;
		try {
			conn = DBUtill.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("update customer set name=?, gender=?, updated=?, login=?, password=?, photo =?, photoPath =?, email=?, idRole=?, active=?  where idCustomer=?");

			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getGender());
			preparedStatement.setTimestamp(3, new Timestamp(new java.util.Date().getTime()));

			preparedStatement.setString(4, customer.getLogin());
			preparedStatement.setString(5, customer.getPassword());
			preparedStatement.setBytes(6, customer.getPhoto());
			preparedStatement.setString(7, customer.getPhotoPath());
			preparedStatement.setString(8, customer.getEmail());
			preparedStatement.setInt(9, customer.getIdRole());
			preparedStatement.setInt(10, customer.getActive());

			preparedStatement.setLong(11, customer.getIdCustomer());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.DEBUG, null, e);
		} finally {
			DBUtill.closeConnection(conn);
		}
	}

	public Customer findByLogin(String login) {

		Connection connection = null;
		Customer customer = new Customer();
		try {
			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from customer where login=?");
			preparedStatement.setString(1, login);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				customer.setIdCustomer(rs.getLong("idCustomer"));
				customer.setLogin(rs.getString("login"));
				customer.setPassword(rs.getString("password"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setGender(rs.getString("email"));
				customer.setCreated(rs.getTimestamp("created"));
				customer.setUpdated(rs.getTimestamp("updated"));
				customer.setPhoto(rs.getBytes("photo"));
				customer.setPhotoPath(rs.getString("photoPath"));

				customer.setIdRole(rs.getInt("idRole"));
				customer.setActive(rs.getInt("active"));
			}
		} catch (SQLException e) {
			Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.DEBUG, null, e);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return customer;

	}

	public void create(Customer customer) throws UnsupportedOperationException {

		Connection connection = null;

		try {
			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("insert into customer(name,gender,login,password,email,photo,photoPath,idRole,active) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");

			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getGender());
			preparedStatement.setString(3, customer.getLogin());
			preparedStatement.setString(4, customer.getPassword());
			preparedStatement.setString(5, customer.getEmail());
			preparedStatement.setBytes(6, customer.getPhoto());
			preparedStatement.setString(7, customer.getPhotoPath());
			preparedStatement.setInt(8, customer.getIdRole());
			preparedStatement.setInt(9, customer.getActive());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtill.closeConnection(connection);
		}

	}

	public void update(Customer customer, String[] selectedRoles) {

		Connection connection = null;
		ResultSet rs = null;
		List<String> roles = new ArrayList<String>();

		try {
			connection = DBUtill.getConnection();
			connection.setAutoCommit(false);

			PreparedStatement preparedStatement = connection.prepareStatement("update customer set name=?, gender=?, updated=?, login=?, password=?, photo =?, photoPath =?, email=?  where idCustomer=?");

			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getGender());
			preparedStatement.setTimestamp(3, new Timestamp(new java.util.Date().getTime()));

			preparedStatement.setString(4, customer.getLogin());
			preparedStatement.setString(5, customer.getPassword());
			preparedStatement.setBytes(6, customer.getPhoto());
			preparedStatement.setString(7, customer.getPhotoPath());
			preparedStatement.setString(8, customer.getEmail());
			preparedStatement.setLong(9, customer.getIdCustomer());

			preparedStatement.executeUpdate();

			PreparedStatement preparedStatement0 = connection.prepareStatement("select idRole from customer_role where idCustomer = ?");
			preparedStatement0.setLong(1, customer.getIdCustomer());
			rs = preparedStatement0.executeQuery();

			ResultSetMetaData metaData = rs.getMetaData();
			int columns = metaData.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= columns; i++) {
					String value = rs.getString(i);
					roles.add(value);
				}
			}

			String[] customerRoles = roles.toArray(new String[roles.size()]);

			for (int i = 0; i < customerRoles.length; i++) {
				PreparedStatement ps = connection.prepareStatement("delete from customer_role where idCustomer = ?  and idRole = ? ");
				ps.setLong(1, customer.getIdCustomer());
				ps.setString(2, customerRoles[i]);
				ps.executeUpdate();

			}

			PreparedStatement ps = connection.prepareStatement("insert into customer_role(idCustomer,idRole) values (?, ?)");

			for (int i = 0; i < selectedRoles.length; i++) {

				ps.setLong(1, customer.getIdCustomer());
				ps.setLong(2, Long.parseLong(selectedRoles[i]));

				ps.executeUpdate();
			}

			connection.commit();

		}

		catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {

				Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.DEBUG, null, e1);
			}
			Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.DEBUG, null, e);
		} finally {
			DBUtill.closeConnection(connection);
		}

	}

}
