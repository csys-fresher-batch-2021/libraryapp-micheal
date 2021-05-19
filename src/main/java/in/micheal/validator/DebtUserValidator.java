package in.micheal.validator;

import in.micheal.dao.DebtUserDetailsDAO;
import in.micheal.model.DebtUserDetail;

public class DebtUserValidator {

	private DebtUserValidator() {
		// default constructor
	}

	/**
	 * This method returns the index of specific user in debt user else returns -1
	 * 
	 * @param debtUser
	 * @return
	 */
	public static int isDebtUser(DebtUserDetail debtUser) {
		int debtUserIndex = -1;
		for (DebtUserDetail obj : DebtUserDetailsDAO.getDebtUserDetail()) {
			if (obj.getDebtUserId() == debtUser.getDebtUserId() && obj.getTakenBook().equals(debtUser.getTakenBook())) {
				debtUserIndex = DebtUserDetailsDAO.getDebtUserDetail().indexOf(obj);
			}
		}
		return debtUserIndex;

	}
}
