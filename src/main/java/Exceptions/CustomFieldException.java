package Exceptions;

public class CustomFieldException extends Exception{
    private String message;

    public CustomFieldException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
