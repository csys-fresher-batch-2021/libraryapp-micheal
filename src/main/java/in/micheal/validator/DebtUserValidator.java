package in.micheal.validator;

import in.micheal.dao.DebtUserDetailsDAO;
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
}
