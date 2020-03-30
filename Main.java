import java.time.LocalDate;

public class Main{
   
    public static void main(String[] args) {
        
        TodoQuarter todoQuarter = new TodoQuarter();
        
        todoQuarter.addItem("a", LocalDate.now());
        todoQuarter.addItem("b", LocalDate.now());
        System.out.println(todoQuarter.toString());
    }
}