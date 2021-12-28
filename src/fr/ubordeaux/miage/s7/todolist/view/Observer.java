package fr.ubordeaux.miage.s7.todolist.view;


import fr.ubordeaux.miage.s7.todolist.model.Observable;

public interface Observer {
    void update(Observable observable);
}
