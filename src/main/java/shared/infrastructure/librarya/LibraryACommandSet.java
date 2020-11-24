package shared.infrastructure.librarya;

import shared.domain.requests.Command;
import shared.domain.requests.CommandSet;
import shared.domain.requests.Z39CommandSet;

public class LibraryACommandSet implements CommandSet {
    private final Z39CommandSet commandSet;

    public LibraryACommandSet(Z39CommandSet commandSet){
        this.commandSet = commandSet;
    }

    @Override
    public Command getBookCommand() {
        return new Command() {
            @Override
            public String getCommand() {
                return "Pedir Libro";
            }

            @Override
            public String getGeneralCommand() {
                return commandSet.getBookCommand();
            }
        };
    }

    @Override
    public Command getAuthorCommand() {
        return new Command() {
            @Override
            public String getCommand() {
                return "Pedir Autor";
            }

            @Override
            public String getGeneralCommand() {
                return commandSet.getAuthorCommand();
            }
        };
    }

    @Override
    public Command returnBookCommand() {
        return new Command() {
            @Override
            public String getCommand() {
                return "Libro";
            }

            @Override
            public String getGeneralCommand() {
                return commandSet.returnBookCommand();
            }
        };
    }

    @Override
    public Command returnAuthorCommand() {
        return new Command() {
            @Override
            public String getCommand() {
                return "Libro";
            }

            @Override
            public String getGeneralCommand() {
                return commandSet.returnAuthorCommand();
            }
        };
    }
}
