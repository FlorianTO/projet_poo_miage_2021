package fr.ubordeaux.miage.s7.todolist.controller;

import fr.ubordeaux.miage.s7.todolist.model.Code;
import fr.ubordeaux.miage.s7.todolist.model.ModelTodoList;
import fr.ubordeaux.miage.s7.todolist.model.Priorities;
import fr.ubordeaux.miage.s7.todolist.view.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonEventHandler implements EventHandler<ActionEvent> {

	private ModelTodoList model;
	private View view;

	public ButtonEventHandler(ModelTodoList model) {
		this.model = model;
	}

	public void setView(View view) {
		this.view = view;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		/*
		 * On récupère l'objet qui a émis cet événement actionEvent Il s'agit d'un
		 * bouton identifié grâce à getId(). Selon cet identifiant, on modifie le modèle
		 * en conséquence.
		 * 
		 * Si rien ne matche, on affiche l'identifiant du bouton non prévu.
		 * 
		 */
		Button button = (Button) actionEvent.getSource();
		switch (button.getId()) {

		// Bouton "Traiter une tâche..."
		case "proceeds_btn":
			model.pop();
			view.update(model);
			view.showModalWindow("Tâche à réaliser", model.getCurrentTask().getDescription(), "Tâche terminée");
			break;

		// Bouton "Ajouter la tâche..."
		case "adds_btn":
			// TODO
			if (model.getDescription() == null)
				view.showModalWindow("ERROR", Code.NOT_DEFINED.toString(), "OK");
			else if (model.getPriority() == null)
				view.showModalWindow("ERROR", Code.NOT_DEFINED.toString(), "OK");
			else if (model.getPriority().getValue() < Priorities.HIGH.getValue())
				view.showModalWindow("ERROR", Code.BAD_PRIORITY.toString(), "OK");
			else if (model.getDescription().length() < 4)
				view.showModalWindow("ERROR", Code.TOO_SHORT_DESCRIPTION_TEXT.toString(), "OK");
			else
				model.push();
			// On met à jour la vue
			view.update(model);
			break;

		// Bouton "Tâche réalisée"
		case "dialog_btn":
			view.hideModalWindow();
			break;

		// Bouton inconnu
		default:
			System.err.println("button.getId(): " + button.getId());
		}
	}

}
