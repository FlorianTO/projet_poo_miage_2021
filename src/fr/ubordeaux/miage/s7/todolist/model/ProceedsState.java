package fr.ubordeaux.miage.s7.todolist.model;

public class ProceedsState implements State{
    @Override
    public void handle(ModelTodoList model) {
        model.pop();
        model.notifyObservers();
        model.setState(this);
        System.out.println("State : " + this.getClass().getCanonicalName());
    }
}
