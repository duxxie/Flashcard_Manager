package org.flashCardManager;

import org.flashCardManager.app.Application;
import org.flashCardManager.context.ApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext();
        new Application(context).runApplication();
    }
}