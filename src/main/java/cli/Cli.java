package cli;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cli {

    public  static CliState state = CliState.MAIN_MENU;

    private static Map<CliState, CliMenu> handlerMapper = new HashMap();

    static{
        handlerMapper.put(CliState.MAIN_MENU, new MainMenu());
        handlerMapper.put(CliState.STUDENT_MENU, new StudentMenu());
    }


    public static void main(String[] args) {


        while(true){
            System.out.println("Please select an option");
            CliMenu currentMenu = handlerMapper.get(state);
            int i =0;
            for(String option :  currentMenu.getOptions() ){
                System.out.println(++i + ". " + option);
            }
            String userSelectedOption = getUserInput();

            if(!currentMenu.supports(userSelectedOption)){
                System.out.print("Unsupported operation: '" + userSelectedOption +"', allowed values: " );
                currentMenu.getOptions().forEach(e -> System.out.print(e + " "));
                System.out.println();
                continue;
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