package in.micheal.validator;

import in.micheal.dao.DebtUserDetailsDAO;
import in.micheal.dao.DebtUsersFineDAO;
import in.micheal.exception.DbException;

public class DebtUserValidator {

	private DebtUserValidator() {
		// default constructor
	}

	/**
	 * This method returns the index of specific user in debt user else returns -1
	 * 
	 * @param debtUser
	 * @return
	 * @throws DbException
	 */
	public static boolean isDebtUser(Long userId, String takenBook) throws DbException {
		boolean confirmation = false;

		Long debtUser = DebtUserDetailsDAO.findDebtUser(userId, takenBook);
		if (debtUser != null) {
			confirmation = true;

		}

		return confirmation;

	}

	/**
	 * This method is used to get the fine amount from the data base
	 * 
	 * @param userId
	 * @return
	 * @throws DbException
	 */
	public static boolean getFineAmount(long userId) throws DbException {
		boolean confirmation = true;
		Integer resultFinedAmount = DebtUsersFineDAO.getFineAmount(userId);
		if (resultFinedAmount == null || resultFinedAmount == 0) {
			confirmation = false;
		}
		return confirmation;
	}

	/**
	 * This method is used to confirm weather the user is in the data base
	 * 
	 * @param userId
	 * @return
	 * @throws DbException
	 */
	public static boolean isFinedUser(long userId) throws DbException {
		Long userid;
		boolean confirmation = false;
		userid = DebtUsersFineDAO.findUserId(userId);
		if (userid != null) {
			confirmation = true;
		}
		return confirmation;

	}

}
