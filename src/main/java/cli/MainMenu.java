package cli;

import java.util.Arrays;
import java.util.List;

public class MainMenu implements  CliMenu {

    @Override
    public List<String> getOptions() {
        return Arrays.asList("students","groups","employees","activities");
    }
}
