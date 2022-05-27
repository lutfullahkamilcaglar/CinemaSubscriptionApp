import Controller.Controller;
import InputManager.InputManager;
import InputManager.InputManagerImpl;

public class Main {
    public static void main(String[] args) {

        // dependencies
        InputManager inputManager = new InputManagerImpl();

        // creating controller
        Controller controller = new Controller(inputManager);

        // starting application
        controller.startApplication();

    }
}
