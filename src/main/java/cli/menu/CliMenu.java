package cli.menu;

import cli.Cli;
import cli.CliState;
import cli.handlers.ActionHandler;
import cli.handlers.ExitHandler;
import cli.handlers.ReturnHandler;

import java.util.*;


/**
 *
 * This class is responsible for
 */
public abstract class CliMenu {

    protected Map<String, ActionHandler> handlers = initHandlers();


    protected abstract Map<String, ActionHandler> initHandlers();


    // common handlers
    private ActionHandler exitHandler = new ExitHandler();
    private ReturnHandler returnHandler = new ReturnHandler();

    /**
     * Returns the list of supported options:
     * exp for main menu: students, groups, employees ....
     * And: adds other common options like 'exit' and 'return'
     */
    public List<String> getOptions(){
        List<String> options = new ArrayList(handlers.keySet());

        // if we are in a nested menu (like student or group), then add the return option
        if(Cli.state != CliState.MAIN_MENU){
            options.add("return");
        }

        options.add("exit"); // no matter what the menu is, we always have the exit option

        return options;
    }

    /**
     * Executes the configured handler for the given option
     * exp Student menu: i give the option : 'list', and this method will call the ActionHandler
     * @param option
     */
    public void handleOption(String option) {
        if(option.equals("exit")){
            exitHandler.handle();
            return;
        }

        if(option.equals("return")){
            returnHandler.handle();
            return;
        }

        if(!handlers.containsKey(option)) throw new UnsupportedOperationException();
        handlers.get(option).handle();
    }

    /**
     * Tells me if the menu supports the given option
     */
    public boolean supports(String option) {
        return this.getOptions().contains(option);
    }

}
