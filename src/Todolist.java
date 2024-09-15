import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import services.TodolistServices;
import services.TodolistServicesImpl;
import view.TodolistView;

public class Todolist {
    public static void main(String[] args) {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistServices todolistServices = new TodolistServicesImpl(todolistRepository);
        TodolistView todolistView = new TodolistView(todolistServices);

        todolistView.showTodolist();
    }
}
