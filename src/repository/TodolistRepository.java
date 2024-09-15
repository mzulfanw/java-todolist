package repository;

import entity.Todolist;

public interface TodolistRepository {
    Todolist[] getAll();

    void addTodolist(Todolist todolist);

    boolean removeTodolist(Integer number);
}
