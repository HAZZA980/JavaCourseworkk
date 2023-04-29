package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public class OverviewSelectionPane extends GridPane {
    private TextArea profile, selectedModules, reservedModules;
    private Button saveOverview;

    public OverviewSelectionPane() {
        // Set padding and gap between cells
        setPadding(new Insets(10));
        setHgap(10);
        setVgap(10);
        setAlignment(Pos.CENTER);

        // Add the UI components to the grid pane
        add(ModulesBox(), 0, 1);
    }

    public GridPane ModulesBox() {
        GridPane gp = new GridPane();
        gp.setVgap(10);
        gp.setPadding(new Insets(10));

        selectedModules = new TextArea("Selected Modules: ");
        reservedModules = new TextArea("Reserved Modules: ");
        profile = new TextArea(); // Third ListView
        
        selectedModules.setPrefHeight(200);
        reservedModules.setPrefHeight(200);
        profile.setPrefHeight(200);

        HBox hb = new HBox();
        hb.setSpacing(20); // Set the gap between the TextAreas
        hb.getChildren().addAll(selectedModules, new Region(), reservedModules); // Add a Region node with a prefWidth to create the gap
    
       
        profile.prefWidthProperty().bind(this.hgapProperty());
        profile.prefHeightProperty().bind(this.heightProperty().divide(6));
        selectedModules.prefWidthProperty().bind(this.widthProperty());
        selectedModules.prefHeightProperty().bind(this.heightProperty().divide(2));
        reservedModules.prefWidthProperty().bind(this.widthProperty());
        reservedModules.prefHeightProperty().bind(this.heightProperty().divide(2));
        
        // Add a margin of 50 pixels at the top of the HBox
        GridPane.setMargin(hb, new Insets(30, 0, 0, 0));

        // Add the TextAreas and the HBox to the grid pane
        gp.add(profile, 0, 0);
        gp.add(hb, 0, 1);
      
        // Create a new GridPane for the Save Overview button
        GridPane saveButtonPane = new GridPane();
        saveButtonPane.setAlignment(Pos.CENTER);

        saveOverview = new Button("Save Overview");
        saveOverview.setAlignment(Pos.CENTER);

        // Add the Save Overview button to the new GridPane
        saveButtonPane.add(saveOverview, 0, 0);

        // Add the new GridPane to the main grid pane with a gap of 10 pixels above it
        gp.add(saveButtonPane, 0, 2);

        return gp;
    }
    
}


