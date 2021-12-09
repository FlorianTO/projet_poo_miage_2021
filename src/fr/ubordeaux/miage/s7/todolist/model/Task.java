package fr.ubordeaux.miage.s7.todolist.model;

/*
 * Tâche
 */
public class Task /*implements Comparable<Object>*/ {

	// TODO
	Integer num;

	// Elles possèdent une description
	String description;
	
	// Elles possèdent une priorité
	Priorities priority;

	public Task(Integer num, String description, Priorities priority) /* TODO */{
		this.num = num;
		this.description = description;
		this.priority = priority;
		// TODO
	}

	/*
	 * Représentation d'une tâche sous forme de chaine
	 */
	@Override
	public String toString() {
		return description + " (" + priority.getText() + ")";
	}

	/*
	 * Donne la description d'une règle
	 */
	public String getDescription() {
		return description;
	}

}
