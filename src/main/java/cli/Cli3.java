package cli;



import java.util.Scanner;

import model.Student;
import service.StudentService;


public class  Cli3 {





        private static StudentService studentService = StudentService.getInstance();


        public static void main(String[] args) {
                int choix;

                do {
                        System.out.println("\n ******* MENU PRINCIPALE **********\n");

                        System.out.println("\n\t 1: Gestion Eleves");
                        System.out.println("\n\t 2: Gestion Groupes");
                        System.out.println("\n\t 3: Gestion Activité/cours");
                        System.out.println("\n\t 3: Gestion Employées");
                        System.out.println("\n\t 0: Quitter l'application");
                        System.out.println("\n ******* tapez votre choix **********\n");

                        Scanner sc = new Scanner(System.in);
                        choix = sc.nextInt();
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

                } while (choix != 1);

        }


        public static void gestionEleve() {
                int choix;

                        System.out.println("\n ******* Gestion Eléves *******\n");

                        System.out.println("\n\t 1: Ajouter Eleve");
                        System.out.println("\n\t 2: Supprimer Eleve ");
                        System.out.println("\n\t 2: modifier Eleve ");
                        System.out.println("\n\t 2: Afficher Eleve ");
                        System.out.println("\n\t 0: Retour au menu principale");
                        System.out.println("\n ******* tapez votre choix *******\n");


                        Scanner sc = new Scanner(System.in);
                        choix = sc.nextInt();

                        switch (choix) {

                                case 1:
                                        Student s = new Student();
                                        studentService.addStudent(s);
                                        break;

                                default:
                                        throw new IllegalStateException("Unexpected value: " + choix);
                        }




        }
}