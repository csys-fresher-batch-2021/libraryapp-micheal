package in.micheal.model;

import java.time.LocalDate;

public class DebtUserDetail {
	private long debtUserId;
	private LocalDate takenDate;
	private String takenBook;
	private int tekenBookQuantity;

	public long getDebtUserId() {
		return debtUserId;
	}

	public void setDebtUserId(long debtUserId) {
		this.debtUserId = debtUserId;
	}

	public LocalDate getTakenDate() {
		return takenDate;
	}

	public void setTakenDate(LocalDate date) {
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
