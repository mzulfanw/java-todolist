import java.util.Scanner;

public class Todolist {

    public static String[] todoList =  new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodolist();
    }

    public static void showTodolist() {
        System.out.println("Current Todolist");
        for (int i = 0; i < todoList.length; i++) {
            String todo = todoList[i];
            int index = i + 1;
            if (todo != null) {
                System.out.println(index + ". " + todo);
            }
        }
    }

    public static void testShowTodolist() {
        todoList[0] = "Test aja bosq";
        showTodolist();
    }

    public static void createTodolist(String todo) {
        var isFull = true;
        for (int i = 0; i < todoList.length; i++) {
            if (todoList[i] == null) {
                isFull = false;
                break;
            }
        }

        if (isFull) {
            var temp = todoList;
            todoList = new String[todoList.length * 2];

            for (int i = 0; i < temp.length; i++) {
                todoList[i] = temp[i];
            }
        }

            for (int i = 0; i < todoList.length; i++) {
                String value = todoList[i];
                if (value == null) {
                    todoList[i] = todo;
                    break;
                }
            }

    }

    public static void testCreateTodolist() {
        var todo = "Belajar memasak";
        createTodolist(todo);
        showTodolist();
    }



    public static boolean deleteTodolist(Integer idTodolist) {
        if ((idTodolist - 1) >= todoList.length) {
            return false;
        } else if (todoList[idTodolist - 1] == null) {
            return false;
        } else {
            for (var i = (idTodolist - 1); i < todoList.length; i++) {
                if (i == todoList.length - 1) {
                    todoList[i] = null;
                } else {
                    todoList[i] = todoList[i + 1];
                }
            }
            return true;
        }
    }

    public static void testDeleteTodolist() {
        createTodolist("Test create");

        boolean b = deleteTodolist(1);

        System.out.println(b);

    }


    public static String input(String info) {
        System.out.print(info + " : ");
        return scanner.nextLine();
    }

    public static void testInput() {
        var data = input("Nama");
        System.out.println("Hi " + data);
    }

    public static void viewShowTodolist() {
      while (true) {
          showTodolist();

          System.out.println("MENU : ");
          System.out.println("1. Add");
          System.out.println("2. Delete");
          System.out.println("x. Exit");

          var input = input("Choose menu");

          if (input.equals("1")) {
              viewCreateTodolist();
          } else if (input.equals("2")) {
              viewDeleteTodolist();
          } else if (input.equals("x")) {
              break;
          }
          else {
              System.out.println("Choose not found in our menu");
          }
      }
    }

    public static void testViewShowTodolist() {
        createTodolist("Test");
        viewShowTodolist();
    }

    public static void viewCreateTodolist() {
        System.out.println("Add Todolist");

        var todo = input("Todo (x = close)");

        if (todo.equals("x")) {
            viewShowTodolist();
        } else {
            createTodolist(todo);
        }
    }

    public static void testViewCreateTodolist() {
        viewCreateTodolist();

        showTodolist();
    }

    public static void viewDeleteTodolist() {
        System.out.println("Delete Todolist");

        showTodolist();

        var todoId = input("Todo Id (x = close)");

        if (todoId.equals("x")) {
            viewShowTodolist();
        } else {
            boolean success = deleteTodolist(Integer.valueOf(todoId));

            if (!success) {
                System.out.println("Failed to delete todo id " + todoId);
            } else {
                System.out.println("Successes to delete todo id " + todoId);
            }
        }
    }

    public static void testViewDeleteTodolist() {
        createTodolist("Test");

        showTodolist();

        viewDeleteTodolist();

        showTodolist();
    }
}
