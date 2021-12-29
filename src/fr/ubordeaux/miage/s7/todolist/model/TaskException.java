package fr.ubordeaux.miage.s7.todolist.model;

public class TaskException extends Exception{

    Code code;

    public TaskException(Code code) {
        this.code = code;
    }

    public void displayMessage() {
        switch (code) {
            case BAD_DESCRIPTION -> System.out.println("TaskException : description ou priorité nulle");
            case TOO_SHORT_DESCRIPTION_TEXT -> System.out.println("TaskException : description trop courte");
            case TOO_LOW_PRIORITY -> System.out.println("TaskException : priorité inférieure à 1");
            case TOO_HIGH_PRIORITY -> System.out.println("TaskException : priorité supérieure à 4");
            case ALREADY_EXISTS -> System.out.println("TaskException : tâche déjà enregistrée");
            default -> {
            }
        }
    }
}