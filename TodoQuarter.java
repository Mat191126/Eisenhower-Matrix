import java.time.LocalDate;
import java.util.ArrayList;

/*### Class TodoQuarter

__Instance Attributes__

* `todoItems`
  - data: List
  - description: list of TodoItem objects

__Instance methods__

* ##### `TodoQuarter()`

  Constructs a *TodoQuarter* object with list of TodoItem objects

* `addItem(String title, LocalDate deadline)`

  Append *TodoItem* object to *todoItems* sorted decreasing by *deadline*.

* `removeItem(int index)`

  Removes *TodoItem* object using *index* of list *todoItems*

* `archiveItems()`

  Removes all *TodoItem* objects with a parameter *isDone* set to *true* from list *todoItems*.

* `getItem(int index)`

  Returns *TodoItem* object from *index* of list *todoItems*.

* `getItems()`

  Returns private field *todoItems*.

* `toString()`

  Returns a formatted list of *todoItems* sorted decreasing by *deadline*. There is an expecting output:

  ```1. [ ] 9-6  go to the doctor
   2. [x] 11-6 submit assignment```*/

public class TodoQuarter{

    private ArrayList<TodoItem> todoItems;

    public TodoQuarter(){
        this.todoItems = new ArrayList<>();
    }

    public void addItem(String title, LocalDate deadline){

        TodoItem todoItem = new TodoItem(title, deadline);

        todoItems.add(todoItem);
    }

    public void removeItem(int index){
        todoItems.remove(index);
    }

    public void archiveItems(){
      for(int index = 0; index < todoItems.size(); index++) {
        if(todoItems.get(index).getStatus()) {
          todoItems.remove(index);
        }       
      }
  }

    public TodoItem getItem(int index){
        return todoItems.get(index);
    }

    public ArrayList<TodoItem> getItems(){
        return todoItems;
    }

    public String toString(){
        int number = 0;
        String todoQuarterString = "";
        for (TodoItem todoItem : todoItems) {
            String todoItemString = todoItem.toString();
            number ++;
            todoQuarterString += String.format("%s. %s\n", number, todoItemString);
        }
        return todoQuarterString;
    }

    public int findLongestItem(){
      int longestItemLength = 0;
      for (TodoItem todoItem : todoItems) {
          if (todoItem.toString().length() > longestItemLength){
            longestItemLength = todoItem.toString().length();
          }
      }

      return longestItemLength;
    }
}