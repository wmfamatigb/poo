package cli.menu;

import cli.handlers.ActionHandler;
import cli.menu.CliMenu;
import dao.impl.StudentDao;

import java.util.HashMap;
import java.util.Map;

public class GroupMenu  extends CliMenu {

    @Override
    protected Map<String, ActionHandler> initHandlers() {
        Map<String, ActionHandler> result = new HashMap<>();

        // TODO: add options and their action handlers ...

        return result;
    }
}
