package fr.ubordeaux.miage.s7.todolist.model;

/*
 * Tâche
 */
public class Task implements Comparable<Task> {

	private final Integer num;
	private static Integer count = 0;

	// Elles possèdent une description
	private final String description;
	
	// Elles possèdent une priorité
	private final Priorities priority;

	public Task(String description, Priorities priority) throws TaskException {
		if(description == null || description == "" || priority == null) throw new TaskException(Code.BAD_DESCRIPTION);
		if(description.length() <= 4) throw new TaskException(Code.TOO_SHORT_DESCRIPTION_TEXT);
		if(priority.getValue() < 1) throw new TaskException(Code.TOO_LOW_PRIORITY);
		if(priority.getValue() > 4) throw new TaskException(Code.TOO_HIGH_PRIORITY);

		this.num = count ++;
		System.out.println("count : " + count);
		System.out.println("id : " + this.num);
		this.description = description;
		this.priority = priority;
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

	public Priorities getPriority() {
		return priority;
	}

	@Override
	public int compareTo(Task task) {

		if(task.getClass() == this.getClass())
		{
			System.out.println("Comparing : task1Prio->" + this.priority.getValue() + " - task2Prio->" + task.priority.getValue());
			if(this.priority.getValue() > task.priority.getValue())
				return 1;
			else if(this.priority.getValue() < task.priority.getValue())
				return -1;

			if(this.num > task.num)
				return 1;
			else
				return -1;
		}
		System.out.println("-2");
		return -2;
	}
}
