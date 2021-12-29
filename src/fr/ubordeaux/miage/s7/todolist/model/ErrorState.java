package fr.ubordeaux.miage.s7.todolist.model;

public class ErrorState implements State{
    @Override
    public void handle(ModelTodoList model) {
        model.notifyObservers();
        System.out.println("State : " + this.getClass().getCanonicalName());
    }
}
