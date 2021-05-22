package cli;

import cli.handlers.ActionHandler;
import cli.handlers.ExitHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * This class is responsible for
 */
public abstract class CliMenu {

    protected Map<String, ActionHandler> handlers = initHandlers();


    protected abstract Map<String, ActionHandler> initHandlers();




    private ActionHandler exitHandler = new ExitHandler();

    /**
     * returns the list of supported options:
     * exp for main menu: students, groups, employees ....
     */
    List<String> getOptions(){
        List<String> options = new ArrayList(handlers.keySet());
        options.add("exit");
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
        }

        if(!handlers.containsKey(option)) throw new UnsupportedOperationException();
        handlers.get(option).handle();
    }

    /**
     * Tells me if the menu supports the given option
     */
    public boolean supports(String option) {
        return option.equals("exit") || handlers.containsKey(option);
    }

}
