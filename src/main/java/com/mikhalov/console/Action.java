package com.mikhalov.console;

import com.mikhalov.service.Service;

public interface Action {

    Service SERVICE = Service.getInstance();

    void execute();

}
