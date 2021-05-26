package in.micheal.model;

import java.util.Date;

public class DebtUserDetail {
	private long debtUserId;
	private Date takenDate;
	private String takenBook;
	private int tekenBookQuantity;

	public long getDebtUserId() {
		return debtUserId;
	}

	public void setDebtUserId(long debtUserId) {
		this.debtUserId = debtUserId;
	}

	public Date getTakenDate() {
		return takenDate;
	}

	public void setTakenDate(Date date) {

		this.takenDate = date;
	}

	public String getTakenBook() {
		return takenBook;
	}

	public void setTakenBook(String takenBook) {
		this.takenBook = takenBook;
	}

	public int getTekenBookQuantity() {
		return tekenBookQuantity;
	}

	public void setTekenBookQuantity(int tekenBookQuantity) {
		this.tekenBookQuantity = tekenBookQuantity;
	}

}
