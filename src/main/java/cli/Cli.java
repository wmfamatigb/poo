package cli;


import cli.menu.*;

import java.util.HashMap;
import java.util.Map;

public class Cli {

    public  static CliState state = CliState.MAIN_MENU;
    private static Map<CliState, CliMenu> menuDictionary = new HashMap();

    static{ // static bloc because we want to initialise a static variable
        // init dictionary with all state -> menu translations
        menuDictionary.put(CliState.MAIN_MENU, new MainMenu());
        menuDictionary.put(CliState.STUDENT_MENU, new StudentMenu());
        menuDictionary.put(CliState.EMPLOYEE_MENU, new EmployeeMenu());
        menuDictionary.put(CliState.GROUP_MENU, new GroupMenu());
        menuDictionary.put(CliState.ACTIVITY_MENU, new ActivityMenu());
    }


    public static void main(String[] args) {


        while(true){
            System.out.println("Please select an option");
            CliMenu currentMenu = menuDictionary.get(state);

            for(String option :  currentMenu.getOptions() ){ // a java way of iterating over a list of elements
                System.out.println( "* " + option);
            }
            String userSelectedOption = CliUtils.readUserInput();

            if(!currentMenu.supports(userSelectedOption)){
                System.out.print("Unsupported operation: '" + userSelectedOption +"', allowed values: " );
                currentMenu.getOptions().forEach(e -> System.out.print(e + " ")); // another java way to iterate over a list of elements
                System.out.println();
                CliUtils.addMargin();
                continue; // return to the begging of the loop
            }

            currentMenu.handleOption(userSelectedOption);
            CliUtils.addMargin();
        }
    }




}