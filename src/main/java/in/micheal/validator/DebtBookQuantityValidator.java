package in.micheal.validator;

import in.micheal.dao.DebtUserDetailsDAO;

public class DebtBookQuantityValidator {
	private DebtBookQuantityValidator() {
		// default constructor
	}

	public static int validateBookQuantity(int bookQuantity, int debtBookIndex) {
		return (DebtUserDetailsDAO.getDebtUserDetail().get(debtBookIndex).getTekenBookQuantity()) - bookQuantity;
	}
}
