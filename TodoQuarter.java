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
    
}