package repository;

import entity.Todolist;

public class TodolistRepositoryImpl implements TodolistRepository{

    private Todolist[] data = new Todolist[10];

    @Override
    public Todolist[] getAll() {
        return data;
    }

    public boolean isFull() {
        var isFull = true;
        for (Todolist datum : data) {
            if (datum == null) {
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void resizeIsFull() {
        if (isFull()) {
            var temp = data;
            data = new Todolist[data.length * 2];
            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
    }

    @Override
    public void addTodolist(Todolist todolist) {
        resizeIsFull();
        for (int i = 0; i < data.length; i++) {
            var value = data[i];
            if (value == null) {
                data[i] = todolist;
                break;
            }
        }
    }

    @Override
    public boolean removeTodolist(Integer number) {
        if ((number - 1) >= data.length) {
            return false;
        } else if (data[number - 1] == null) {
            return false;
        } else {
            for (var i = (number - 1); i < data.length; i++) {
                if (i == data.length - 1) {
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
    }
}
