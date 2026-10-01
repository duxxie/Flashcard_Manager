package org.flashCardManager.app;

import org.flashCardManager.context.ApplicationContext;
import org.flashCardManager.controller.common.Result;
import org.flashCardManager.model.dto.userDto.UserRequestCreate;
import org.flashCardManager.model.dto.userDto.UserRequestLogin;
import org.flashCardManager.model.dto.userDto.UserResponse;
import org.flashCardManager.util.LogUtil;
import org.flashCardManager.view.ApplicationView;
import org.flashCardManager.view.ErrorDetailsView;
import org.flashCardManager.view.InputHelper;

public class Application {

    private final ApplicationContext context;

    public Application(ApplicationContext context) {
        this.context = context;
    }

    public void runApplication() {
        int opMenuHome;
        do {
            ApplicationView.menuHome();
            opMenuHome = InputHelper.lerOpcaoInt("Escolha uma acao: ");
            tratarOpMenuHome(opMenuHome);
        } while (opMenuHome != 0);
        InputHelper.encerrarInput();
    }

    private void tratarOpMenuHome(int opMenuHome) {
        switch (opMenuHome) {
            case 1 -> executarLogin();
            case 2 -> executarCadastro();
            case 0 -> LogUtil.log("Saindo...");
            default -> LogUtil.log("Escolha uma acao valida!");
        }
    }

    private void executarLogin() {
        String email = InputHelper.lerString("Digite o email: ");
        String password = InputHelper.lerString("Digite a senha: ");

        Result<UserResponse> result = context.authController()
                .authenticate(new UserRequestLogin(email, password));

        if (result.success()) {
            context.userApp().acoesUser(result.data());
        } else {
            ErrorDetailsView.show(result.errorType(), result.errorMessage());
        }
    }

    private void executarCadastro() {
        String name = InputHelper.lerString("Digite seu nome: ");
        String email = InputHelper.lerString("Digite o seu email: ");
        String password = InputHelper.lerString("Digite uma senha: ");

        Result<UserResponse> result = context.userController()
                .create(new UserRequestCreate(name, email, password));

        if (result.success()) {
            context.userApp().acoesUser(result.data());
        } else {
            ErrorDetailsView.show(result.errorType(), result.errorMessage());
        }
    }
}