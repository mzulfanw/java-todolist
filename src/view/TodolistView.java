package view;

import services.TodolistServices;
import utils.InputUtils;

public class TodolistView {

    private TodolistServices todolistServices;

    public TodolistView(TodolistServices todolistServices) {
        this.todolistServices = todolistServices;
    }

    public void showTodolist() {
        while (true) {
            todolistServices.showTodolist();

            System.out.println("MENU : ");
            System.out.println("1. Add");
            System.out.println("2. Delete");
            System.out.println("x. Exit");

            var input = InputUtils.input("Choose menu");

            if (input.equals("1")) {
                addTodolist();
            } else if (input.equals("2")) {
                removeTodolist();
            } else if (input.equals("x")) {
                break;
            }
            else {
                System.out.println("Choose not found in our menu");
            }
        }
    }

    public void addTodolist() {
        System.out.println("Menambahkan Todolist");
        var todo = InputUtils.input("Todo (x = close)");

        if (todo.equals("x")) {
            showTodolist();
        } else {
            todolistServices.addTodolist(todo);
        }
    }

    public void removeTodolist() {
        System.out.println("Menghapus Todolist");

//        showTodolist();

        var todoId = InputUtils.input("Todo Id (x = close)");

        if (todoId.equals("x")) {
            showTodolist();
        } else {
            todolistServices.removeTodolist(Integer.valueOf(todoId));
        }
    }
}
