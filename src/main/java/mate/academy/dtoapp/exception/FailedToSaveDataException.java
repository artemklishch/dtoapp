package mate.academy.dtoapp.exception;

public class FailedToSaveDataException extends RuntimeException {
    public FailedToSaveDataException(String message) {
        super(message);
    }
}
