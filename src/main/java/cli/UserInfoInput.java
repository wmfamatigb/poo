package cli;

import model.Entity;
import model.Group;
import model.Student;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class UserInfoInput {




    public static Object readUserInput( Class<?> cls) throws Exception{

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
        if(!(result instanceof  Entity)) return result;
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
    }


    public static void main(String[] args)  throws  Exception{
        Group s = (Group)  readUserInput(Group.class);
        System.out.println(s);
    }



}
