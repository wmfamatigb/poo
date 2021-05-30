package cli.handlers;


import cli.Cli;
import cli.CliState;

/**
 * For now: simply go back to the main menu.
 */
public class ReturnHandler implements ActionHandler{
    @Override
    public void handle() {
        // go back to main menu by setting the state variable.
        Cli.state = CliState.MAIN_MENU;
    }
}
