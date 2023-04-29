package view;

import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Course;
import model.RunPlan;
import model.Module;

public class CreateSelectModulesPane extends GridPane{

    private Label unselectedLabel;
    private ListView<Module> unselectedListView;
    private Button addT1Button;
    private Button removeT1Button;
    private Label term1;

    private Label unselectedLabel2;
    private ListView<Module> unselectedListView2;
    private Button addT2Button;
    private Button removeT2Button;
    private Label term2;
    
    private Label yearLongMods;
    private ListView<Module> yearLongListView;
    private Label term1Label, term2Label;
    private ListView<Module> term1ListView, term2ListView;
    
    private Label currentCredits1, currentCredits2;
    private TextField credits1, credits2;
    
    private Button reset, submit;

    public CreateSelectModulesPane() {
        // Set padding and gap between cells
        setPadding(new Insets(10));
        setHgap(10);
        setVgap(10);
        setAlignment(Pos.CENTER);

        // Add the UI components to the grid pane
        add(createUnselectedModulesUI(), 0, 0);
        add(createSelectedModulesUI(), 1, 0);
    }

    private GridPane createUnselectedModulesUI() {
        // Term 1 Label Modules
        unselectedLabel = new Label("Unselected Term 1 Modules:");
        unselectedListView = new ListView<>();
        addT1Button = new Button("Add");
        removeT1Button = new Button("Remove");
        term1 = new Label("Term 1");
        //Term 2 Modules
        unselectedLabel2 = new Label("Unselected Term 2 Modules:");
        unselectedListView2 = new ListView<>();
        addT2Button = new Button("Add");
        removeT2Button = new Button("Remove");
        term2 = new Label("Term 2");

        // Set the list view to grow and shrink with the parent grid pane
        unselectedListView.prefWidthProperty().bind(this.widthProperty());
        unselectedListView.prefHeightProperty().bind(this.heightProperty());

        // Set the list view to grow and shrink with the parent grid pane
        unselectedListView2.prefWidthProperty().bind(this.widthProperty());
        unselectedListView2.prefHeightProperty().bind(this.heightProperty());
        
        // Create the grid pane to hold the unselected modules section
        GridPane unselectedGridPane = new GridPane();
        unselectedGridPane.setVgap(10);
        unselectedGridPane.setPadding(new Insets(10));

        // Create an HBox container for the buttons
		HBox buttonsContainer = new HBox(10, term1, addT1Button, removeT1Button);
		buttonsContainer.setAlignment(Pos.CENTER);
		HBox buttonsContainer2 = new HBox(10, term2, addT2Button, removeT2Button);
		buttonsContainer2.setAlignment(Pos.CENTER);
		
		currentCredits1 = new Label("Current Term 1 Credits");
		credits1 = new TextField();
		
		HBox credits = new HBox(50, currentCredits1, credits1);
		credits.setAlignment(Pos.CENTER);
		
	    reset = new Button("Reset");
		HBox rese = new HBox(500, reset);	    		
        rese.setAlignment(Pos.BOTTOM_RIGHT);
        
        // Add the UI components to the unselected grid pane
        unselectedGridPane.add(unselectedLabel, 0, 0);
        unselectedGridPane.add(unselectedListView, 0, 1);
        unselectedGridPane.add(buttonsContainer, 0, 2);     
     	unselectedGridPane.add(unselectedLabel2, 0, 3);
        unselectedGridPane.add(unselectedListView2, 0, 4);
        unselectedGridPane.add(buttonsContainer2, 0, 5);
        unselectedGridPane.add(credits, 0, 6);
        unselectedGridPane.add(rese, 0, 8);

        return unselectedGridPane;
    }

    private GridPane createSelectedModulesUI() {
        // Create the UI components for the selected modules section
        yearLongMods = new Label("Selected Year Long Modules:");
        yearLongListView = new ListView<>();
        term1Label = new Label("Selected Term 1 Modules:");
        term1ListView = new ListView<>();

        term2Label = new Label("Selected Term 2 Modules:");
        term2ListView = new ListView<>();

        // Set the list views to grow and shrink with the parent grid pane
        yearLongListView.prefWidthProperty().bind(this.widthProperty());
        yearLongListView.prefHeightProperty().bind(this.heightProperty().divide(3));
        term1ListView.prefWidthProperty().bind(this.widthProperty());
        term1ListView.prefHeightProperty().bind(this.heightProperty().divide(2));
        term2ListView.prefWidthProperty().bind(this.widthProperty());
        term2ListView.prefHeightProperty().bind(this.heightProperty().divide(2));

        // Create the grid pane to hold the selected modules section
        GridPane selectedGridPane = new GridPane();
        selectedGridPane.setVgap(10);
        selectedGridPane.setPadding(new Insets(10));

    	currentCredits2 = new Label("Current Term 2 Credits");
		credits2 = new TextField();
		
		HBox credits = new HBox(50, currentCredits2, credits2);
		credits.setAlignment(Pos.CENTER);
				
	    submit = new Button("Submit");
	    HBox sub = new HBox(500, submit);	    		
	    sub.setAlignment(Pos.BOTTOM_LEFT);
		
        // Add the UI components to the selected grid pane
        selectedGridPane.add(yearLongMods, 0, 0);
        selectedGridPane.add(yearLongListView, 0, 1);
        selectedGridPane.add(term1Label, 0, 2);
        selectedGridPane.add(term1ListView, 0, 3);
        selectedGridPane.add(term2Label, 0, 4);
        selectedGridPane.add(term2ListView, 0, 5);
        selectedGridPane.add(credits, 0, 6);
        selectedGridPane.add(sub, 0, 8);
        
        return selectedGridPane;
    }
       
      /* public void getTerm1Mods() {
    	   Course[] compSciCourses = getCompSciCourses();
    	   for (Course module : compSciCourses) {
    	       if (module.getDelivery() == RunTime.TERM_1) {
    	           unselectedListView.getItems().add(course);
    	       }
    	   }
       }*/
    
    
}