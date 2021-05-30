package cli.menu;

import cli.Cli;
import cli.CliState;
import cli.handlers.ActionHandler;

import java.util.*;

public class MainMenu extends CliMenu {

    private Map<String, ActionHandler> handlers = new HashMap<>();


    @Override
    protected Map<String, ActionHandler> initHandlers() {
        Map<String, ActionHandler> result = new HashMap<>();

        result.put("students", new ActionHandler() {
            public void handle() {
                Cli.state = CliState.STUDENT_MENU;
            }
        });

        result.put("groups", new ActionHandler() {
            public void handle() {
                Cli.state = CliState.GROUP_MENU;
            }

        });

        result.put("employee", new ActionHandler() {
            public void handle() {
                Cli.state = CliState.EMPLOYEE_MENU;
            }

        });
        result.put("activity", new ActionHandler() {
            public void handle() {
                Cli.state = CliState.ACTIVITY_MENU;
            }

        });
        return result;

    }

}
