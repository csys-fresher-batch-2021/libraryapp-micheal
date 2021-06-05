package in.micheal.dao;

import in.micheal.constants.MessageConstants;
import in.micheal.exception.DbException;
import in.micheal.model.BookDetail;
import in.micheal.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDetailsDAO {
	private BookDetailsDAO() {
		// default constructor
	}

	static String quantity = "quantity";

	/**
	 * This method adds Books to DataBase
	 * 
	 * @param obj
	 * @throws DbException
	 */
	public static void addBooks(BookDetail obj) throws DbException {
		PreparedStatement pst = null;
		Connection connection = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "insert into lib_book_details_db (bookname , quantity) values (?,?)";// performance faster
			pst = connection.prepareStatement(sql);
			pst.setString(1, obj.getName());
			pst.setInt(2, obj.getQuantity());
			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException(MessageConstants.ERROR_MESSAGE);
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method returns the parametered book if it has orElse returns null
	 * 
	 * @param bookName
	 * @return
	 * @throws DbException
	 */

	public static List<BookDetail> findBook(String bookName) throws DbException {
		List<BookDetail> searchResults = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select * from lib_book_details_db where bookname=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, bookName);

			rs = pst.executeQuery();
			while (rs.next()) {
				String name = rs.getString("bookname");
				int quants = rs.getInt(quantity);

				BookDetail books = new BookDetail();
				books.setName(name);
				books.setQuantity(quants);
				searchResults.add(books);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException(MessageConstants.ERROR_MESSAGE);
		} finally {

			ConnectionUtil.close(rs, pst, con);
		}
		return searchResults;
	}

	/**
	 * This method updates the book quantity of the given book with given quantity
	 * 
	 * @param bookName
	 * @param bookQuantity
	 * @return
	 * @throws DbException
	 */
	public static boolean updateBookQuantity(String bookName, int bookQuantity) throws DbException {
		boolean confirmation = false;
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "update lib_book_details_db set quantity = ? where bookname = ?";
			pst = con.prepareStatement(sql);

			pst.setInt(1, bookQuantity);
			pst.setString(2, bookName);
			pst.executeUpdate();

			confirmation = true;
		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException(MessageConstants.ERROR_MESSAGE);
		} finally {
			ConnectionUtil.close(pst, con);
		}
		return confirmation;

	}

	/**
	 * This method returns Books which are related to the given book name
	 * 
	 * @param bookName
	 * @return
	 * @throws DbException
	 */
	public static List<BookDetail> searchBook(String bookName) throws DbException {
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = null;
		List<BookDetail> searchResults = new ArrayList<>();
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select * from lib_book_details_db where bookname like ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, "%" + bookName + "%");

			rs = pst.executeQuery();
			while (rs.next()) {
				String name = rs.getString("bookname");
				int quants = rs.getInt(quantity);

				BookDetail books = new BookDetail();
				books.setName(name);
				books.setQuantity(quants);
				searchResults.add(books);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException(MessageConstants.ERROR_MESSAGE);
		} finally {
			ConnectionUtil.close(rs, pst, con);
		}
		return searchResults;
	}

	/**
	 * This method is used to get quantity of the given book
	 * 
	 * @param bookName
	 * @return
	 * @throws DbException
	 */
	public static int getBookQuantity(String bookName) throws DbException {
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = null;
		int bookQuantity = 0;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select quantity from lib_book_details_db where bookname=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, bookName);

			rs = pst.executeQuery();

			while (rs.next()) {
				bookQuantity = rs.getInt(quantity);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException(MessageConstants.ERROR_MESSAGE);
		} finally {
			ConnectionUtil.close(rs, pst, con);
		}

		return bookQuantity;

	}

	/**
	 * This method is used to delete all records from the Database ,CAUTION:Highly
	 * sensible code
	 * 
	 * @throws DbException
	 */
	public static void deleteAllRecords() throws DbException {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "delete from lib_book_details_db";
			pst = con.prepareStatement(sql);
			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException(MessageConstants.ERROR_MESSAGE);
		} finally {
			ConnectionUtil.close(pst, con);
		}

	}

	
}
