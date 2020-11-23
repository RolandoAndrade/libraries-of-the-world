package shared.infrastructure.z39;

import shared.domain.Z39CommandSet;

public class Z39Commands implements Z39CommandSet {
    @Override
    public String getBookCommand() {
        return "Get Title";
    }

    @Override
    public String getAuthorCommand() {
        return "Get Author";
    }
}
