package fr.ubordeaux.miage.s7.todolist.model;

/*
 * Tâche
 */
public class Task /*implements Comparable<Object>*/ {

	// TODO
	private Integer num;
	private static Integer count = 0;

	// Elles possèdent une description
	private String description;
	
	// Elles possèdent une priorité
	private Priorities priority;

	public Task(String description, Priorities priority) /* TODO */{
		this.num = count ++;
		System.out.println("count : " + count);
		System.out.println("id : " + this.num);
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
