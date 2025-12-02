package lab5.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test; 

import lab5.BorrowingService;

public class TestSingleton {

    @Test
    public void testSingleton() {
        BorrowingService service1 = BorrowingService.getInstance();
        BorrowingService service2 = BorrowingService.getInstance();
        
        // Ensure both references point to the same instance
        assertEquals(service1, service2, "Two Singleton instances detected");
    }
}
