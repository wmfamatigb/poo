package cli;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cli {

    private static CliState state = CliState.MAIN_MENU;

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
            String userInput = getUserInput();
            if(userInput.equals("1")){
                state = CliState.STUDENT_MENU;
            }else if(userInput.equals("2")){
                state = CliState.GROUP_MENU;
            }

        }


    }

    private static void handleState(){

    }



    private static String getUserInput(){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        return input;
    }

    public static


}