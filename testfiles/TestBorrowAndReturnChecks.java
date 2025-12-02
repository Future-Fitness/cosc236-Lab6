package lab5.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.BorrowingService;
import lab5.Ebook;
import lab5.Member;
import lab5.PaperBook;

public class TestBorrowAndReturnChecks {
	
	Member member1;
	Member member2;
	
	PaperBook book1 = new PaperBook("Harry Potter");
	Ebook book2 = new Ebook("Lord of The Rings");
	PaperBook book3 = new PaperBook("Percy Jackson");
	Ebook book4 = new Ebook("James And The Giant Peach");

	private BorrowingService service = BorrowingService.getInstance();
	BorrowingService borrowingService = new BorrowingService();
	
	@BeforeEach
	void setUp() throws Exception {
		member1 = new Member("Jane",service); // flush borrowedBook array 
		member2 = new Member("Jimmy",service);   // flush borrowedBook array 
		book1.setIsAvailable(true);
		book2.setIsAvailable(true);
		book3.setIsAvailable(true);
		book4.setIsAvailable(true);
	}
	
	@Test
	void exceededBorrowLimit() {
		System.out.println("Borrow limit Test:");
		member1.borrowBook(book1);
		member1.borrowBook(book2);
		member1.borrowBook(book3);
		member1.borrowBook(book4);
	}
	
	@Test
	void bookAlreadyBorrowed() {
		System.out.println("Book already borrowed Test:");
		member1.borrowBook(book1);
		
		member1.borrowBook(book1);
		member2.borrowBook(book1);
		
	}
	
	@Test
	void borrowABook() {
		System.out.println("Borrow Test:");
		member1.borrowBook(book1);
		member2.borrowBook(book3);
		//assertEquals(borrowingService.borrowBook(member1,book1), false, "Should be false");
	}
	
	@Test
	void returnABook() {
		System.out.println("Return Test:");
		member1.borrowBook(book2);
		member1.returnBook(book2);
		//assertEquals(borrowingService.returnBook(member2,book2), false, "Should be false");
	}
	
	@Test
	void noBookToReturn() {
		System.out.println("No books to borrow Test:");
		member2.returnBook(book3);
	}
	
	@Test
	void returnBookNotFound() {
		System.out.println("Return book not found Test:");
		member2.borrowBook(book1);
		member2.returnBook(book3);
	}
}
