package shared.domain.requests;

public abstract class LibraryCommandSet implements Z39CommandSet {

    private final Z39CommandSet z39CommandSet;

    protected LibraryCommandSet(Z39CommandSet z39CommandSet) {
        this.z39CommandSet = z39CommandSet;
    }

    public String getZ39GetBookCommand() {
        return z39CommandSet.getBookCommand();
    }

    public String getZ39GetAuthorCommand() {
        return z39CommandSet.getAuthorCommand();
    }

    public abstract String getLibrary();

    public String translateCommand(String command) throws InvalidCommandException {
        if (command.equals(getBookCommand())) {
            return z39CommandSet.getBookCommand();
        } else if (command.equals(getAuthorCommand())) {
            return z39CommandSet.getAuthorCommand();
        }
        throw new InvalidCommandException();
    }
}
