package tests;

import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import services.TodolistServices;
import services.TodolistServicesImpl;
import view.TodolistView;

public class TodolistViewTest {
    public static void main(String[] args) {
        showTodolist();
    }

    public static void showTodolist() {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistServices todolistServices = new TodolistServicesImpl(todolistRepository);
        TodolistView todolistView = new TodolistView(todolistServices);

        todolistServices.addTodolist("Belajar Bahasa Java OOP");
        todolistView.showTodolist();
    }

    public static void addTodolist() {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistServices todolistServices = new TodolistServicesImpl(todolistRepository);
        TodolistView todolistView = new TodolistView(todolistServices);

        todolistView.addTodolist();
        todolistView.showTodolist();
    }

    public static void removeTodolist() {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistServices todolistServices = new TodolistServicesImpl(todolistRepository);
        TodolistView todolistView = new TodolistView(todolistServices);

        todolistView.removeTodolist();
    }
}
