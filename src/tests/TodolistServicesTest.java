package tests;

import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import services.TodolistServices;
import services.TodolistServicesImpl;

public class TodolistServicesTest {
    public static void main(String[] args) {
        testRemoveTodolist();
    }

    public static void testShowTodolist() {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistServices todolistServices = new TodolistServicesImpl(todolistRepository);

        todolistServices.showTodolist();
    }

    public static void testAddTodolist() {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistServices todolistServices = new TodolistServicesImpl(todolistRepository);
        todolistServices.addTodolist("Belajar Java Dasar");
        todolistServices.addTodolist("Belajar Java Dasar OOP");
        todolistServices.addTodolist("Belajar Java Dasar SEMOGA GACORR");

        todolistServices.showTodolist();
    }

    public static void testRemoveTodolist() {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistServices todolistServices = new TodolistServicesImpl(todolistRepository);
        todolistServices.addTodolist("Belajar Java Dasar");

        todolistServices.removeTodolist(1);
    }
}
