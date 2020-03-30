import java.time.LocalDate;

/*### Class TodoItem

__Attributes__

* `title`
  - data: String
  - description: title of todoItem

* `deadline`
  - data: LocalDate object
  - description: deadline of todoItem, year is always set to *2018*

* `isDone`
  - data: boolean
  - description: contains true if TODO item is done, otherwise contains false.  Default value is false

__Instance methods__

* ##### `TodoItem(String title, LocalDate deadline)`

  Constructs a ToDoItem object

* `getTitle()`

  Getter for the * title * field

* `getDeadline()`

  Getter for the * deadline * field

* `mark()`

  Sets the object's * isDone * attribute to True

* `unmark()`

  Sets the object's * isDone * attribute to False

* `toString()`

  Returns a formatted string with details about todoItem.
  Format of deadline is 'day-month'

  Expecting output for example done item:

  `[x] 12-6 submit assignment`

  Expecting output for example undone item:

  `[ ] 28-6 submit assignment`*/


public class TodoItem{

    private String title;
    private LocalDate deadline;
    private boolean isDone;

    public TodoItem(String title, LocalDate deadline){
        this.title = title;
        this.deadline = deadline;
        isDone = false;
    }

    public String getTitle(){
        return title;
    }
    public LocalDate getDeadline(){
        return deadline;
    }
    public boolean getStatus(){
        return isDone;
    }

    public void mark(){
        isDone = true;
    }
    public void unmark(){
        isDone = false;
    }

    public String toString(){
        String markCharacter = isDone ? "x" : " ";
        int day = deadline.getDayOfMonth();
        int month = deadline.getMonthValue();
        String todoItemString = String.format("[%s] %s-%s %s", markCharacter, day, month, title);
        return todoItemString;
    }
}