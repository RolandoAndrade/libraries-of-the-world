package shared.infrastructure.commands;

import shared.domain.requests.Z39CommandSet;

public class Z39Commands implements Z39CommandSet {
    @Override
    public String getBookCommand() {
        return "Get Title";
    }

    @Override
    public String getAuthorCommand() {
        return "Get Author";
    }

    @Override
    public String returnBookCommand() {
        return "Title";
    }

    @Override
    public String returnAuthorCommand() {
        return "Title";
    }
}
