package pl.prokom.view.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class MainPaneWindowController {
    /**
     * Basic Pane instance.
     */
    @FXML
    private Pane mainPaneWindow;

    public MainPaneWindowController() {
//        this.mainPaneWindow = mainPaneWindow;
    }

    /**
     * Reference to class, which controls difficulty level buttons - DifficultyLevelButtonsController.
     */
    @FXML
    private DifficultyLevelButtonsController difficultyLevelButtonsController;

    /**
     * Reference to class, which controls language choice buttons - LanguageChoiceButtonsController.
     */
    @FXML
    private LanguageChoiceButtonsController languageChoiceButtonsController;

    /**
     * Reference to class, which controls SudokuBoard - SudokuBoardController.
     */
    @FXML
    private SudokuBoardController sudokuBoardController;

    @FXML
    public void initialize(){
        difficultyLevelButtonsController = new DifficultyLevelButtonsController(this);
        languageChoiceButtonsController = new LanguageChoiceButtonsController(this);
        sudokuBoardController = new SudokuBoardController(this);
    }
}
