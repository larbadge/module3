package com.mikhalov;

import com.mikhalov.console.ConsoleMenu;
import org.flywaydb.core.Flyway;

public class Main {

    public static void main(String[] args) {

        Flyway.configure().loadDefaultConfigurationFiles().load().migrate();
        ConsoleMenu.run();
    }
}
