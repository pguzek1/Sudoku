package pl.prokom.view.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import pl.prokom.model.board.SudokuBoardLevel;
import pl.prokom.view.menu.MainPaneWindow;

public class MainPaneWindowController extends MainPaneWindow implements Initializable{
    /**
     * Basic Pane instance.
     */
    @FXML
    private Pane mainPaneWindow;

    /**
     * Reference to class, that controls difficulty level buttons- DifficultyLevelButtonsController.
     */
    @FXML
    private DifficultyLevelButtonsController difficultyLevelsController;

    /**
     * Reference to class, which controls language choice buttons - LanguageChoiceButtonsController.
     */
    @FXML
    private LanguageChoiceButtonsController languageChoiceController;

    /**
     * Reference to class, which controls SudokuBoard - SudokuBoardController.
     */
    @FXML
    private SudokuBoardController sudokuGridController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sudokuGridController.initSudokuCells(SudokuBoardLevel.EASY);
        sudokuGridController.setParentController(this);
        languageChoiceController.setParentController(this);
        difficultyLevelsController.setParentController(this);
    }
}
