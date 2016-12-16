package utils.exception;

/**
 * Created by Doing on 2016/12/16 0016.
 */
public class DBInternalException extends RuntimeException {
    public DBInternalException(String message) {
        super(message);
    }

    public DBInternalException(String message, Throwable cause) {
        super(message, cause);
    }
}
