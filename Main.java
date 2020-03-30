import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Main {

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String takeInputfromUser(String messageForUser) throws IOException {
        System.out.print(messageForUser);
        String userAnswer = reader.readLine();
        return userAnswer;
    }

    public static void userMenu(TodoMatrix todoMatrix) throws IOException {
        String fileName = "EisenhowerMatrix.txt";

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                         + "|                         M   E   N   U                             |\n"
                         + "|-------------------------------------------------------------------|\n"
                         + "|1- add item               |6- load from file                       |\n"
                         + "|2- mark item              |7- save to file                         |\n"
                         + "|3- unmark item            |8- show chosen status                   |\n"
                         + "|4- remove item            |9- show Eisenhower Matrix               |\n"
                         + "|5- archive list           |E- EXIT                                 |\n"
                         + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

        String userOption = takeInputfromUser("Choose your option: ");
        clearScreen();
        switch (userOption) {
            case "1":
                String itemTitle = takeInputfromUser("Enter title of todoItem: ");

                String userItemDeadline = takeInputfromUser("Enter deadline (day-month): ");
                String[] itemDeadlineDayMonth = userItemDeadline.split("-");
                int day = Integer.parseInt(itemDeadlineDayMonth[0]);
                int month = Integer.parseInt(itemDeadlineDayMonth[1]);
                LocalDate itemDeadline = LocalDate.of(2020, month, day);

                boolean isImportant = false;
                String questionIfImportant = takeInputfromUser("Is it importatnt? T/n: ");
                if (questionIfImportant.equals("T") || questionIfImportant.equals("t")){
                    isImportant = true;
                }
                todoMatrix.addItem(itemTitle, itemDeadline, isImportant);
                userMenu(todoMatrix);
                break;

            case "2":
                System.out.println(todoMatrix.toString());
                try{
                    String statusFromUser = takeInputfromUser("Choose quarter name (UI/NI/UN/NN): ");
                    String indexFromUser = takeInputfromUser("Enter number of item to mark: ");
                    int indexFromUserInteger = Integer.parseInt(indexFromUser);
                    if (indexFromUserInteger -1 >= todoMatrix.getQuarter(statusFromUser).getItems().size()){
                        System.out.println("There is no index as entered");
                        userMenu(todoMatrix);
                    }
                    todoMatrix.getQuarter(statusFromUser).getItem(indexFromUserInteger - 1).mark();
                }
                catch (NullPointerException e){
                    System.out.println("Wrong quarter name");
                }
                userMenu(todoMatrix);
                break;

            case "3":
                System.out.println(todoMatrix.toString());
                try{
                String statusFromUserB = takeInputfromUser("Choose quarter name (UI/NI/UN/NN): ");
                String indexFromUserB = takeInputfromUser("Enter number of item to unmark: ");
                int indexFromUserIntegerB = Integer.parseInt(indexFromUserB);
                if (indexFromUserIntegerB -1 >= todoMatrix.getQuarter(statusFromUserB).getItems().size()){
                    System.out.println("There is no index as entered");
                    userMenu(todoMatrix);
                }
                todoMatrix.getQuarter(statusFromUserB).getItem(indexFromUserIntegerB - 1).unmark();
                }
                catch (NullPointerException e){
                    System.out.println("Wrong quarter name");
                }
                userMenu(todoMatrix);
                break;

            case "4":
                System.out.println(todoMatrix.toString());
                try{
                String statusFromUserC = takeInputfromUser("Choose quarter name (UI/NI/UN/NN): ");
                String indexFromUserC = takeInputfromUser("Enter number of item to remove: ");
                int indexFromUserIntegerC = Integer.parseInt(indexFromUserC);
                if (indexFromUserIntegerC -1 >= todoMatrix.getQuarter(statusFromUserC).getItems().size()){
                    System.out.println("There is no index as entered");
                    userMenu(todoMatrix);
                }
                todoMatrix.getQuarter(statusFromUserC).removeItem(indexFromUserIntegerC - 1);
                }
                catch (NullPointerException e){
                    System.out.println("Wrong quarter name");
                }
                userMenu(todoMatrix);
                break;

            case "5":
                todoMatrix.archiveItems();
                userMenu(todoMatrix);
                break;

            case "6":
                todoMatrix.addItemsFromFile(fileName);
                userMenu(todoMatrix);
                break;

            case "7":
                todoMatrix.saveItemsToFile(fileName);
                userMenu(todoMatrix);
                break;

            case "8":
                try{
                    String statusFromUserD = takeInputfromUser("Choose quarter name (UI/NI/UN/NN): ");
                    System.out.println("\nStatus: " + statusFromUserD);
                    System.out.println(todoMatrix.getQuarter(statusFromUserD).toString());
                }
                catch (NullPointerException e){
                    System.out.println("Wrong quarter name");
                }
                userMenu(todoMatrix);
                break;

            case "9":
                System.out.println(todoMatrix.toString());
                userMenu(todoMatrix);
                break;

            case "E":
                break;
        }
    }
   
    public static void main(String[] args) throws IOException {
        
        TodoMatrix todoMatrix = new TodoMatrix();
        userMenu(todoMatrix);
    }
}