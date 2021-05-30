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
            System.out.println("\n\t 4: Gestion Employées");
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
                case 2:
                    gestionGroupe();
                    break;

                case 3:
                    gestionActivity();
                    break;

                case 4:
                    gestionEmployee();
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
            case 2:
                System.out.println("Donner l'id de l'eleve à supprimer");
                String input = sc.next();
                studentService.removeStudent(input);
                System.out.println("Eleve supprimé avec succé ...");
                break;

            case 3:
                System.out.println("Donner l'id de l'eleve à modifier");
                String id =sc.next();
                String  targetStudentId = CliUtils.readUserInput();

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
    public static void gestionGroupe(){
        int choix;

        System.out.println("\n ******* Gestion Des Groupes *******\n");

        System.out.println("\n\t 1: Ajouter un Groupe");
        System.out.println("\n\t 2: Supprimer un Groupe ");
        System.out.println("\n\t 3: modifier un Groupe ");
        System.out.println("\n\t 4: Afficher les Groupe ");
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
                //System.out.println("Lahdha haw jitek");

                break;
            case 2:
               // System.out.println("Lahdha haw jitek");

                break;
            case 3:
               // System.out.println("Lahdha haw jitek");

                break;
            case 4:
                //System.out.println("Lahdha haw jitek");

                break;
        }

    }
    public static void gestionActivity(){
        int choix;

        System.out.println("\n ******* Gestion Des Activités *******\n");

        System.out.println("\n\t 1: Ajouter Activités");
        System.out.println("\n\t 2: Supprimer Activités ");
        System.out.println("\n\t 3: modifier Activités ");
        System.out.println("\n\t 4: Afficher Activités ");
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
               // System.out.println("Lahdha haw jitek");

                break;
            case 2:
               // System.out.println("Lahdha haw jitek");

                break;
            case 3:
               // System.out.println("Lahdha haw jitek");

                break;
            case 4:
                //System.out.println("Lahdha haw jitek");

                break;
        }
    }
    public static void gestionEmployee(){
        int choix;

        System.out.println("\n ******* Gestion Des Employées *******\n");

        System.out.println("\n\t 1: Ajouter Employé");
        System.out.println("\n\t 2: Supprimer Employé ");
        System.out.println("\n\t 3: modifier Employé ");
        System.out.println("\n\t 4: Afficher les Employé ");
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
                //System.out.println("Lahdha haw jitek");

                break;
            case 2:
                //System.out.println("Lahdha haw jitek");

                break;
            case 3:
                //System.out.println("Lahdha haw jitek");

                break;
            case 4:
                //System.out.println("Lahdha haw jitek");

                break;
        }
    }


}