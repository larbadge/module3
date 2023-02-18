package console;

import service.Service;

public interface Action {

    Service SERVICE = Service.getInstance();

    void execute();

}
