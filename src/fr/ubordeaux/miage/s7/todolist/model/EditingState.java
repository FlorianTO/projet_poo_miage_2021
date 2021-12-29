package fr.ubordeaux.miage.s7.todolist.model;

public class EditingState implements State{
    @Override
    public void handle(ModelTodoList model) {
        if(model.getCurrentState().getClass().getCanonicalName() == this.getClass().getCanonicalName())
            try {
                model.push();
            }catch (TaskException ex) {
                new ErrorState().handle(model);
            }
        model.notifyObservers();
        System.out.println("State : " + this.getClass().getCanonicalName());
    }
}
