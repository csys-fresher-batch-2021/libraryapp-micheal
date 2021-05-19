package in.micheal.dao;

import java.util.ArrayList;
import java.util.List;

import in.micheal.model.DebtUserDetail;

public class DebtUserDetailsDAO {
	private DebtUserDetailsDAO() {
		// default constructor
	}

	/**
	 * This method adds Debt user details to the debtUserDetails.
	 */
	private static final List<DebtUserDetail> debtUserDetails = new ArrayList<>();

	public static void addDebtUsers(DebtUserDetail obj) {
		debtUserDetails.add(obj);
	}

	/**
	 * This method returns debtUserDetails arrayList
	 * 
	 * @return
	 */
	public static List<DebtUserDetail> getDebtUserDetail() {
		return debtUserDetails;
	}
}
