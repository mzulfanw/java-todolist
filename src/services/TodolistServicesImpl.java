package services;

import entity.Todolist;
import repository.TodolistRepository;

public class TodolistServicesImpl implements TodolistServices {

    private TodolistRepository todolistRepository;

    public TodolistServicesImpl(TodolistRepository todolistRepository) {
        this.todolistRepository = todolistRepository;
    }

    @Override
    public void showTodolist() {
        Todolist[] todolist = todolistRepository.getAll();
        for (int i = 0; i < todolist.length; i++) {
            var todo = todolist[i];
            int index = i + 1;
            if (todo != null) {
                System.out.println(index + ". " + todo.getTodo());
            }
        }
    }

    @Override
    public void addTodolist(String todo) {
        Todolist todolist = new Todolist(todo);
        todolistRepository.addTodolist(todolist);
        System.out.println("Sukses menambahkan data baru " + todo);
    }

    @Override
    public void removeTodolist(Integer number) {
        boolean isSuccess = todolistRepository.removeTodolist(number);
        if (isSuccess) {
            System.out.println("Sukses menghapus todo " + number);
        } else {
            System.out.println("Gagal menghapus todo " + number);
        }
    }
}
