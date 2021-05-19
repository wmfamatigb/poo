package cli;

import java.util.Arrays;
import java.util.List;

public class StudentMenu implements  CliMenu{
    @Override
    public List<String> getOptions() {
        return Arrays.asList("add","remove","update","list");
    }
}
