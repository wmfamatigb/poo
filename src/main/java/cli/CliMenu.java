package cli;

import cli.handlers.ActionHandler;
import cli.handlers.ExitHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class CliMenu {

    protected Map<String, ActionHandler> handlers = initHandlers();
    abstract Map<String, ActionHandler> initHandlers();
    private ActionHandler exitHandler = new ExitHandler();

    List<String> getOptions(){
        List<String> options = new ArrayList(handlers.keySet());
        options.add("exit");
        return options;
    }

    public void handleOption(String option) {
        if(option.equals("exit")){
            exitHandler.handle();
        }

        if(!handlers.containsKey(option)) throw new UnsupportedOperationException();
        handlers.get(option).handle();
    }

    public boolean supports(String option) {
        return option.equals("exit") || handlers.containsKey(option);
    }

}
