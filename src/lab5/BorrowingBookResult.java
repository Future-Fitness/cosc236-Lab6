package lab5;

public class BorrowingBookResult {
    private boolean isSuccess; // Indicates if the operation was successful
    private String borrowingMessage; // Message describing the result of the operation

    
    public BorrowingBookResult(boolean isSuccess, String borrowingMessage) {
        this.isSuccess = isSuccess;
        this.borrowingMessage = borrowingMessage;
    }

    
    public boolean isSuccess() {
        return isSuccess;
    }
    public void setSuccess(boolean success) {
        this.isSuccess = success;
    }


    public String getBorrowingMessage() {
        return borrowingMessage;
    }

   
    public void setBorrowingMessage(String borrowingMessage) {
        this.borrowingMessage = borrowingMessage;
    }
}
