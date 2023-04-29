package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class ReserveModulesPane extends GridPane {
	private Accordion accordion;
	private GridPane rootGPTerm1, rootGPTerm2;
	private ListView<Module> reservedT1LV, reservedT2LV, lvUnselectedTerm1Modules, lvUnselectedTerm2Modules;
	private Button t1Add, t1Remove, t1Confirm, t2Add, t2Remove, t2Confirm;
	
	public ReserveModulesPane() {
		accordion = new Accordion();
		accordion.setPrefWidth(2000);
		accordion.setPrefHeight(2000);
	}

	public HBox getAccordion() {
		TitledPane pane1 = new TitledPane("Term 1 Modules", TitlePane1());
		TitledPane pane2 = new TitledPane("Term 2 Modules", TitlePane2()); 
		accordion.getPanes().addAll(pane1, pane2);

		HBox hbox = new HBox(10, accordion);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(20));

		hbox.prefWidthProperty().bind(accordion.widthProperty());
		hbox.prefHeightProperty().bind(accordion.heightProperty());

		return hbox;
	}

//Titled Pane1
	public GridPane TitlePane1() {
		rootGPTerm1 = new GridPane();
		rootGPTerm1.setPadding(new Insets(10));
		setAlignment(Pos.CENTER);

		rootGPTerm1.add(Term1Modules(), 0, 0);
		rootGPTerm1.add(Term1ReservedModules(), 1, 0);

		return rootGPTerm1;
	}
	

	public GridPane Term1Modules() {
		GridPane gpCol1Term1 = new GridPane();
		gpCol1Term1.setVgap(10);
		gpCol1Term1.setPadding(new Insets(10));
		
		Label lblUnSelectedTerm1Mods = new Label("Unselected Term 1 Modules");
		lvUnselectedTerm1Modules = new ListView<>();
		lvUnselectedTerm1Modules.setPrefHeight(2000);
		lvUnselectedTerm1Modules.setPrefWidth(2000);
		Label note = new Label("Reserve 30 credits worth of term 1 modules");
			
		gpCol1Term1.add(lblUnSelectedTerm1Mods, 0, 0);
		gpCol1Term1.add(lvUnselectedTerm1Modules, 0, 1);
		gpCol1Term1.add(note, 0, 2);
		return gpCol1Term1;
	}
	

	public GridPane Term1ReservedModules() {
		GridPane gpCol2Term1 = new GridPane();
		gpCol2Term1.setVgap(10);
		gpCol2Term1.setPadding(new Insets(10));

		Label lblReservedT1Mods = new Label("Reserved Term 1 Modules");
		reservedT1LV = new ListView<>();
		reservedT1LV.setPrefHeight(2000);
		reservedT1LV.setPrefWidth(2000);		

		t1Add = new Button("Add");
		t1Remove = new Button("Remove");
		t1Confirm = new Button("Confirm");
		HBox btns1 = new HBox(10);
		btns1.setAlignment(Pos.CENTER);
		btns1.getChildren().addAll(t1Add, t1Remove, t1Confirm);

		gpCol2Term1.add(lblReservedT1Mods, 0, 0);
		gpCol2Term1.add(reservedT1LV, 0, 1);
		gpCol2Term1.add(btns1, 0, 2);
		return gpCol2Term1;
	}
	
//2nd TitledPane 
	public GridPane TitlePane2() {
		rootGPTerm2 = new GridPane();
		rootGPTerm2.setPadding(new Insets(10));
		setAlignment(Pos.CENTER);

		rootGPTerm2.add(Term2Modules(), 0, 0);
		rootGPTerm2.add(Term2ReservedModules(), 1, 0);

		return rootGPTerm2;
	}

	public GridPane Term2Modules() {
		GridPane gpCol1Term2 = new GridPane();
		gpCol1Term2.setVgap(10);
		gpCol1Term2.setPadding(new Insets(10));

		// Unselected Labels
		Label lblUnSelectedTerm2Mods = new Label("Unselected Term 2 Modules");
		lvUnselectedTerm2Modules = new ListView<>();
		lvUnselectedTerm2Modules.setPrefHeight(2000);
		lvUnselectedTerm2Modules.setPrefWidth(2000);
		Label note2 = new Label("Reserve 30 credits worth of term 2 modules");
		note2.setAlignment(Pos.CENTER);
		
		// Add the UI components to the unselected grid pane
		gpCol1Term2.add(lblUnSelectedTerm2Mods, 0, 0);
		gpCol1Term2.add(lvUnselectedTerm2Modules, 0, 1);
		gpCol1Term2.add(note2, 0, 2);
		return gpCol1Term2;
	}

	public GridPane Term2ReservedModules() {
		GridPane gpCol2Term2 = new GridPane();
		gpCol2Term2.setVgap(10);
		gpCol2Term2.setPadding(new Insets(10));

		// Reserved Labels
		Label lblReservedT2Mods = new Label("Reserved Term 2 Modules");
		reservedT2LV = new ListView<>();
		reservedT2LV.setPrefHeight(2000);
		reservedT2LV.setPrefWidth(2000);
		
		t2Add = new Button("Add");
		t2Remove = new Button("Remove");
		t2Confirm = new Button("Confirm");

		HBox btns2 = new HBox(10);
		btns2.setAlignment(Pos.CENTER);

		btns2.getChildren().addAll(t2Add, t2Remove, t2Confirm);

		// Add the UI components to the reserved grid pane
		gpCol2Term2.add(lblReservedT2Mods, 0, 0);
		gpCol2Term2.add(reservedT2LV, 0, 1);
		gpCol2Term2.add(btns2, 0, 2);
		return gpCol2Term2 ;
	}
	
}
