package cli;


import java.util.List;
import java.util.Scanner;

import model.Student;
import service.StudentService;


public class Cli3 {


    private static StudentService studentService = StudentService.getInstance();


    public static void main(String[] args) {
        int choix;

        while(true) {
            System.out.println("\n ******* MENU PRINCIPALE **********\n");

            System.out.println("\n\t 1: Gestion Eleves");
            System.out.println("\n\t 2: Gestion Groupes");
            System.out.println("\n\t 3: Gestion Activité/cours");
            System.out.println("\n\t 3: Gestion Employées");
            System.out.println("\n\t 0: Quitter l'application");
            System.out.println("\n ******* tapez votre choix **********\n");

            Scanner sc = new Scanner(System.in);

            try{
                choix = sc.nextInt();
            }catch(Exception e){
                System.out.println("Il faut donner un entier!");
                continue;

            }

            switch (choix) {

                case 1:
                    gestionEleve();
                    break;

                case 0:
                    System.out.println("byyyyeeeee");
                    System.exit(0);
                    break;
                default:
                    System.out.println("ERROR! Votre choix est invalide!");
                    break;

            }

        }

    }


    public static void gestionEleve() {
        int choix;

        System.out.println("\n ******* Gestion Eléves *******\n");

        System.out.println("\n\t 1: Ajouter Eleve");
        System.out.println("\n\t 2: Supprimer Eleve ");
        System.out.println("\n\t 3: modifier Eleve ");
        System.out.println("\n\t 4: Afficher les Eleves ");
        System.out.println("\n\t 0: Retour au menu principale");
        System.out.println("\n ******* tapez votre choix *******\n");


        Scanner sc = new Scanner(System.in);
        try{
            choix = sc.nextInt();
        }catch(Exception e){
            System.out.println("il faut donner un entier");
            return;
        }

        switch (choix) {

            case 1:
                /*
                Student s = new Student();
                System.out.println("give the name");
                String input = sc.next();
                s.setName(input);
                System.out.println("give me the lastname");
                input = sc.next();
                s.setLastname(input);
                */

                 Student s = (Student) CliUtils.createInstanceFromUserInput(Student.class);
                studentService.addStudent(s);
                break;
            case 4:
                List<Student> result =  studentService.getStudents();
                if(result.isEmpty()){
                    System.out.println("Empty list.");
                }
                for(int i =0;i<result.size();i++){
                    System.out.println( result.get(i) );
                }
                break;


            default:
                throw new IllegalStateException("Unexpected value: " + choix);
        }


    }
}