package fr.ubordeaux.miage.s7.todolist.model;

import fr.ubordeaux.miage.s7.todolist.view.Observer;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
}
