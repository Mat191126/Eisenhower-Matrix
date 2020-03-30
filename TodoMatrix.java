import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.HashMap;

/*### Class TodoMatrix

This is the file containing the logic of an Eisenhower todoMatrix.

__Attributes__

* `todoQuarters`

  - data: Map
  - description: contains *TodoQuarter* objects

    key: String - status of todoQuarter, value: TodoQuarter object

        possible keys of TODO quarter:
        - 'IU' means that todoQuarter contains important todoItems & urgent
        - 'IN' means that todoQuarter contains important todoItems & not urgent
        - 'NU' means that todoQuarter contains not important todoItems & urgent
        - 'NN' means that todoQuarter contains not important & not urgent todoItems


__Instance methods__

* ##### `TodoMatrix()`

  Constructs a *TodoMatrix* object with map of all possible quarters

* `getQuarters()`
  
  Returns a private filed *todoQuarters*.

* `getQuarter(String status)`

  Returns a chosen *TodoQuarter* object from a map *todoQuarters*.
  Status should be one of the possible statuses ('IU', 'IN', 'NU', 'NN').

* `addItem(String title, LocalDate deadline, boolean isImportant)`

  Adds new item to map *todoQuarters* using adequate key. You should use method *addItem* from *TodoQuarter* class.

  This method should be overloaded so as to accept two parameters only. In that case, isImportant should be `false` by default.

* `addItemsFromFile(String fileName)`

  Reads data from *fileName.csv* file and appends *TodoItem* objects to attributes *todoItems* in the properly *TodoQuarter* objects.
  Every item is written in a separate line the following format:

  `title|day-month|is_important`

  If *isImportant* is equal to false then last element is an empty string. Otherwise the last element is an arbitrary string.
  If the last element of line is an empty string, *isImportant* is equal to false - it means that the item should be assigned to a not important TODO quarter. Otherwise item should be assign to an important TODO quarter.

* `saveItemsToFile(String fileName)`

  Writes all details about TODO items to *fileName.csv* file
  Every item is written in a separate line the following format:

  `title|day-month|is_important`

  If *isImportant* contains false then the last element of line should be an empty string. Otherwise last element is an arbitrary string.

* `archiveItems()`

  Removes all *TodoItem* objects with a parameter *isDone* set to *true* from list *todoItems* in every element of dictionary *todoQuarters*

* `toString()`

  Returns a todoQuarters list (an Eisenhower todoMatrix) formatted to string.*/

public class TodoMatrix{

    private HashMap<String, TodoQuarter> todoQuarters;

    public TodoMatrix(){
        todoQuarters = new HashMap<>();
    }

    public HashMap<String, TodoQuarter> getQuarters(){
        return todoQuarters;
    }

    public TodoQuarter getQuarter(String status){
        return todoQuarters.get(status);
    }

    public void addItem(String title, LocalDate deadline, boolean isImportant){
        boolean isUrgent = false;
            if (deadline.getDayOfYear() - LocalDate.now().getDayOfYear() < 4){
                isUrgent = true;
            }

        String statusImportant = isImportant ? "I" : "N";
        String statusUrgent = isUrgent ? "U" : "N";
        String status = statusUrgent + statusImportant;

            if (todoQuarters.containsKey(status)){
                todoQuarters.get(status).addItem(title, deadline);
                return;
            }

        TodoQuarter todoQuarter = new TodoQuarter();
        todoQuarter.addItem(title, deadline);

        todoQuarters.put(status, todoQuarter);
    }

    public void addItemsFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
          String line;
          while ((line = bufferedReader.readLine()) != null) {
            String[] values = line.split("\\|");

            String[] dayMonth = values[1].split("-");

            int day = Integer.parseInt(dayMonth[0]);
            int month = Integer.parseInt(dayMonth[1]);
    
            String title = values[0];

            LocalDate deadline = LocalDate.of(2020, month, day);

            boolean isImportant = values.length > 2 ? true : false;

            addItem(title, deadline, isImportant);
          }
        } catch (Exception e) {
          System.out.println("Can't read file");
        }
      }
    
      public void saveItemsToFile(String fileName) {
        try {
          File file = new File(fileName);
          FileWriter fileWriter = new FileWriter(file);
          BufferedWriter writer = new BufferedWriter(fileWriter);
    
          for (String status : todoQuarters.keySet()) {
            TodoQuarter todoQuarter = todoQuarters.get(status);
            for (TodoItem todoItem : todoQuarter.getItems()) {
              String line = String.format("%s|%d-%d|%s\n", todoItem.getTitle(), todoItem.getDeadline().getDayOfMonth(),
                                         todoItem.getDeadline().getMonthValue(), status.charAt(0) == 'I' ? "important" : "");
              writer.write(line);
            }
          }
    
          writer.close();
        } 
        catch (Exception e) {
          System.out.println("Can't write to file");
        }
      }

    public void archiveItems(){
        for (TodoQuarter todoQuarter : todoQuarters.values()) {
            todoQuarter.archiveItems();
        }
    }

    public String toString(){
        String todoQuarterString = "";
        for (String key : todoQuarters.keySet()) {
            TodoQuarter todoQuarter = todoQuarters.get(key);
            todoQuarterString += key + "\n";
            todoQuarterString += todoQuarter.toString();
        }
        return todoQuarterString;
    }
}