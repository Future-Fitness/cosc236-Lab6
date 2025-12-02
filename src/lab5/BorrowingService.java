package lab5;

public class BorrowingService implements BorrowingServiceAPI{
	BorrowingBookResult result;
	boolean isSuccess=true;
	String borrowingMessage;
	
	private static BorrowingService instance; 
	private int borrowingLimit; 
	public BorrowingService() { 
	borrowingLimit = 3;
	}
	@Override
	// Here you can implement logic to check if the book is available to
	// borrow and if the member can borrow it
	//(e.g., item limit, member status).
	public BorrowingBookResult borrowBook(Member member, Book book) {
		
		if(member.getBorrowedBooks().size()>=3) {// customer has more than 3 borrowed books
			return new BorrowingBookResult(false, "The member has exceeded their borrowing limit.");
		}
		if(!book.getIsAvailable()) {
			for(Book a : member.getBorrowedBooks()) {
				if(book.getTitle().equals(a.getTitle())) {
					return new BorrowingBookResult(false, "The book is already borrowed by the same member.");
				}
			}
			return new BorrowingBookResult(false, "The book is currently borrowed by another member.");
		}
	    book.setIsAvailable(false);          
	    String message = "Book '" + book.getTitle() + "' was successfully borrowed by member '" + member.getName() + "'.";
	    return new BorrowingBookResult(true, message);
	}
		@Override
		public BorrowingBookResult returnBook(Member member, Book book) {
		// Implement logic to handle returning a book
			if (member.getBorrowedBooks() == null || member.getBorrowedBooks().isEmpty()) {
			    return new BorrowingBookResult(false, "No books are currently borrowed by member: '" + member.getName() + "'.");
			}
			for(Book a : member.getBorrowedBooks()) {
				if(book.getTitle().equals(a.getTitle())) { //if the member actually borrowed the book
					
				    book.setIsAvailable(true); 
					return new BorrowingBookResult(true, "Book '" + book.getTitle() + "' was successfully returned by member '" + member.getName() + "'.");
				}
				
			}
			
			return new BorrowingBookResult(false, "Book '" + book.getTitle() + "' was not found in the member's borrowed books for member: '" + member.getName() + "'.");
			
		}
		public static BorrowingService getInstance() {
			// TODO Auto-generated method stub
			if (instance == null) {
	            instance = new BorrowingService(); 
	        }

			return instance;
		}


}
