package cli;

import model.Entity;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Scanner;

/**
 * Utility class
 */
public class CliUtils {


    /**
     * Like scanf() in C.  => read variables from user.
     * rayen chniti
     * @return
     */
    public static String readUserInput(){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        return input;
    }


    /**
     * Given a certain class as input (Student, Group, Activity ...),
     * This method will create a new instance of that class and read all the properties from the user input,
     * then return the instance.
     * Implementation is based on java reflection API.
     */
    public static Object createInstanceFromUserInput( Class<?> cls) {
        try{
            cls.getFields();

            Object result = cls.getDeclaredConstructor().newInstance();

            // read user input for the target class
            Scanner sc = new Scanner(System.in);
            Method[] methods = cls.getDeclaredMethods();
            for(Method m : methods){
                if(m.getName().startsWith("set")){

                    if(m.getParameterTypes()[0].equals(List.class)) continue;
                    String fieldName =  m.getName().substring(3);
                    System.out.println("plz give me the " + fieldName + ": " );
                    String input = sc.next();
                    m.invoke(result, input);
                }
            }

            // read user input for the entity class
            if(!(result instanceof Entity)) return result;
            for(Method m : Entity.class.getDeclaredMethods()){
                if(m.getName().startsWith("set")){

                    if(m.getName().toLowerCase().equals("setid")) continue;
                    if(m.getName().toLowerCase().contains("address")) continue;

                    String fieldName =  m.getName().substring(3);
                    System.out.println("plz give me the " + fieldName + ": " );
                    String input = sc.next();
                    m.invoke(result, input);
                }
            }

            return result;
        }catch (Exception e){
            return null;
        }
    }


    /**
     * printf ______\n
     */
    public static void addMargin(){
        System.out.println("__________________________________________________________________________________");
        System.out.println();
    }

}
