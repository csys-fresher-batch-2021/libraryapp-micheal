package in.micheal.model;

public class BookDetail {
	private String bookName;
	private int bookQuantity;

	public void setName(String bookName) {
		this.bookName = bookName;
	}

	public void setQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}

	public String getName() {
		return bookName;
	}

	public int getQuantity() {
		return bookQuantity;
	}

}
