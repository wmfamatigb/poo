package cli;


import java.util.List;
import java.util.Scanner;

import model.Group;
import model.Student;
import service.StudentService;
import service.GroupService;

public class Cli3 {


    private static StudentService studentService = StudentService.getInstance();
    private static GroupService groupService = GroupService.getInstance();

    public static void main(String[] args) throws Exception {
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

                System.out.println("donner l'id de l'eleve ");
                String  targetStudentId = CliUtils.readUserInput();

                // see if student exists on the database
                Student student = studentService.getStudent(targetStudentId);
                if( student == null ){
                    // no student found with the given id
                    System.out.println("Pas d'eleve avec l'id fournis !");
                    return;
                }

                // if we are here, that means the student is not null
                System.out.println("Ecrire les nouvelles valeurs de l'eleve : ");
                Student newStudentVersion = (Student) CliUtils.createInstanceFromUserInput(Student.class);
                newStudentVersion.setId(student.getId());
                studentService.updateStudent(newStudentVersion);
                break;


            case 4:
                List<Student> result =  studentService.getStudents();
                if(result.isEmpty()){
                    System.out.println("liste vide .");
                }
                for(int i =0;i<result.size();i++){
                    System.out.println( result.get(i) );
                }
                break;


            default:
                throw new IllegalStateException("Valeur Erronée: " + choix);
        }


    }
    public static void gestionGroupe() throws Exception {
        int choix;

        System.out.println("\n ******* Gestion Des Groupes *******\n");

        System.out.println("\n\t 1: Ajouter un Groupe");
        System.out.println("\n\t 2: Supprimer un Groupe ");
        System.out.println("\n\t 3: Afficher les Groupe ");
        System.out.println("\n\t 4: ajouter eleve à un groupe ");
        System.out.println("\n\t 5: ajouter activité à un groupe ");
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


                Group g = new Group();
                System.out.println("give the name of the group");
                String input = sc.next();
                g.setName(input);
                groupService.addGroup(g);

                break;
            case 2:
                System.out.println("Donner l'id du groupe à supprimer");
                String grpNameinput = sc.next();
                groupService.removeGroup(grpNameinput);
                System.out.println("Groupe supprimé avec succé ...");

                break;
            case 3:
                List<Group> result =  groupService.getGroups();
                if(result.isEmpty()){
                    System.out.println("liste est vide .");
                }
                for(int i =0;i<result.size();i++){
                    System.out.println( result.get(i) );
                }

                break;
            case 4:
                System.out.println("Donner l'id de l'eleve ");
                String idinput = sc.next();
                System.out.println("Donner le nom du group ");
                String grpinput = sc.next();
                groupService.addStudentToGroup(idinput,grpinput);
                System.out.println("Eleve ajouté avec succés ...");

                break;
            case 5:
                System.out.println("Donner l'id de l'activité ");
                String activityIdInput = sc.next();
                System.out.println("Donner le nom du group ");
                String activityGroupInput = sc.next();
                groupService.addActivityToGroup(activityIdInput,activityGroupInput);
                System.out.println("Activité ajouté avec succés ...");

                break;
            default:
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