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

}