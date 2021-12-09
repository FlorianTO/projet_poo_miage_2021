package fr.ubordeaux.miage.s7.todolist.model;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ModelTodoList implements TodoList /* TODO */ {

	// Liste de priorité de tâches
	private PriorityQueue<Task> tasks;

	// Description de la tâche en cours d'édition
	private String description;

	// Priorité de la tâche en cours d'édition
	private Priorities priority;

	// La tâche actuellement réalisée (null si aucune)
	private Task currentTask;

	// TODO
	private int numTask;

	/*
	 * Constructeur du modèle
	 */
	public ModelTodoList() {
		// On initialise la liste des tâches en indiquant
		// - La capacité initiale de 31 (elle augmentera automatiquement si besoin)
		// - La comparaison appliquée entre deux tâches
		tasks = new PriorityQueue<Task>(31, new Comparator<Task>() {
			@Override
			public int compare(Task task1, Task task2) {
				return 0;
			}
		});

		// On initialise la priorité de la tâche en cours d'édition
		// à medium
		priority = Priorities.MEDIUM;
		
	}

	/*
	 * Donne la taille de la liste des tâches à faire
	 */
	public int size() {
		return tasks.size();
	}

	/*
	 * Modifie la description de la tâche en cours d'édition
	 */
	public void setDescription(String description) {
		this.description = description;
		System.out.println("Model: description: " + this.getDescription());
	}

	/*
	 * Modifie la priorité de la tâche en cours d'édition
	 */
	public void setPriority(Priorities priority) {
		this.priority = priority;
		System.out.println("Model: priority: " + this.priority);
	}

	/*
	 * Ajoute la tâche en cours d'édition à la liste des tâches à faire
	 */
	private void push(Task task) /* TODO */ {
		tasks.add(task);
		// TODO
	}
	public void push() /* TODO */ {
		// TODO
		push(new Task(numTask++, getDescription(), priority));
		System.out.println("Model: push(): " + size());
	}

	/*
	 * Supprime la tâche la plus prioritaire de la liste de tâches Cette tâche est
	 * la tâche courante
	 */
	@Override
	public void pop() {
		System.out.println("Model: pop(): " + this);
		currentTask = tasks.poll();
	}

	/*
	 * Récupère la liste des tâches
	 */
	// TODO
	public PriorityQueue<Task> getTasks() {
		return tasks;
	}

	/*
	 * Donne la priorité de la tâche en cours d'édition
	 */
	public Priorities getPriority() {
		return priority;
	}

	/*
	 * Donne la tâche actuellement réalisée
	 */
	public Task getCurrentTask() {
		return currentTask;
	}

	/*
	 * Fournit la tâche actuellement réalisée
	 */
	public void setCurrentTask(Task currentTask) {
		this.currentTask = currentTask;
	}

	/*
	 * Donne la description de la tâche en cours d'édition
	 */
	public String getDescription() {
		return description;
	}

}
