package shared.domain.requests;

import java.io.Serializable;

public interface Response extends Serializable {
    <Book> Book getBody();

    String getCommand();

    void setCommand(String command);
}
