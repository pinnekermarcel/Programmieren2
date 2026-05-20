package lektion20.sms;

public class IllegalTelephoneNumberException extends Exception {

    public IllegalTelephoneNumberException() {

        super();
    }
    public IllegalTelephoneNumberException(String message) {
        super(message);
    }
}
