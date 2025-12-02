package lab5.tests;

import lab5.Member;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import lab5.BorrowingService;

class TestMembersBorrowingService {
	@Test
	void TestMemberServices() {
		BorrowingService service = BorrowingService.getInstance();
		Member member1 = new Member("Member 1", service);
		Member member2 = new Member("Member 2", service);
		assertEquals(member1.getBorrowingService(),
				member2.getBorrowingService(),
				"Members have two different borrowing services");
	}
}
