package be.mikedhoore.VBexamen;

public class UserException extends Exception {
    public UserException() {
        super("Detected an empty string!");
    }
}
