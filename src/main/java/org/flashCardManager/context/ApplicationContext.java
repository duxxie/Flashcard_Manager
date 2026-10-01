package org.flashCardManager.context;

import org.flashCardManager.app.AppFactory;
import org.flashCardManager.app.UserApp;
import org.flashCardManager.controller.AuthController;
import org.flashCardManager.controller.ControllerFactory;
import org.flashCardManager.controller.UserController;
import org.flashCardManager.factory.*;
import org.flashCardManager.service.ServiceFactory;

public class ApplicationContext {

    private final UserController userController;
    private final AuthController authController;
    private final UserApp userApp;

    public ApplicationContext() {
        RepositoryFactory repoFactory = new RepositoryFactory(RepositoryFactory.StorageType.JSON);
        ServiceFactory serviceFactory = new ServiceFactory(repoFactory);
        ControllerFactory controllerFactory = new ControllerFactory();
        AppFactory appFactory = new AppFactory();

        // Repositórios
        var userRepository    = repoFactory.createUserRepository();
        var deckRepository    = repoFactory.createDeckRepository();
        var cardRepository    = repoFactory.createCardRepository();
        var meaningRepository = repoFactory.createMeaningRepository();
        var exampleRepository = repoFactory.createExampleRepository();

        // Services
        var userService    = serviceFactory.createUserService(userRepository);
        var deckService    = serviceFactory.createDeckService(deckRepository, cardRepository);
        var cardService    = serviceFactory.createCardService(cardRepository, deckRepository);
        var meaningService = serviceFactory.createMeaningService(meaningRepository, cardRepository);
        var exampleService = serviceFactory.createExampleService(exampleRepository, meaningRepository);
        var authService    = serviceFactory.createAuthService(userRepository);

        // Controllers
        var userController    = controllerFactory.createUserController(userService);
        var deckController    = controllerFactory.createDeckController(deckService);
        var cardController    = controllerFactory.createCardController(cardService);
        var meaningController = controllerFactory.createMeaningController(meaningService);
        var exampleController = controllerFactory.createExampleController(exampleService);
        var authController    = controllerFactory.createAuthController(authService);

        // Apps
        var meaningApp = appFactory.createMeaningApp(meaningController);
        var cardApp    = appFactory.createCardApp(cardController, meaningApp);
        var deckApp    = appFactory.createDeckApp(deckController, cardApp);
        this.userApp   = appFactory.createUserApp(userController, deckApp);

        this.userController = userController;
        this.authController = authController;
    }

    public UserController userController() { return userController; }
    public AuthController authController() { return authController; }
    public UserApp userApp()               { return userApp; }
}