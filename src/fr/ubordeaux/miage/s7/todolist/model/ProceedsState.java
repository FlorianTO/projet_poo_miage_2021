package fr.ubordeaux.miage.s7.todolist.model;

public class ProceedsState implements State{
    @Override
    public void handle(ModelTodoList model) {
        model.notifyObservers();
        System.out.println("State : " + this.getClass().getCanonicalName());
    }
}
