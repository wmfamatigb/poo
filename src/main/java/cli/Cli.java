package cli;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cli {

    public  static CliState state = CliState.MAIN_MENU;
    private static Map<CliState, CliMenu> menuDictionary = new HashMap();

    static{ // static bloc because we want to initialise a static variable
        // init dictionary with all state -> menu translations
        menuDictionary.put(CliState.MAIN_MENU, new MainMenu());
        menuDictionary.put(CliState.STUDENT_MENU, new StudentMenu());
        menuDictionary.put(CliState.EMPLOYEE_MENU, new EmployeeMenu());
    }


    public static void main(String[] args) {


        while(true){
            System.out.println("Please select an option");
            CliMenu currentMenu = menuDictionary.get(state);
            int i =0;


            for(String option :  currentMenu.getOptions() ){ // a java way of iterating over a list of elements
                System.out.println(++i + ". " + option);
            }
            String userSelectedOption = getUserInput();

            if(!currentMenu.supports(userSelectedOption)){
                System.out.print("Unsupported operation: '" + userSelectedOption +"', allowed values: " );
                currentMenu.getOptions().forEach(e -> System.out.print(e + " ")); // another java way to iterate over a list of elements
                System.out.println();
                continue; // return to the begging of the loop
            }

            currentMenu.handleOption(userSelectedOption);

        }
    }


    private static String getUserInput(){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        return input;
    }

}