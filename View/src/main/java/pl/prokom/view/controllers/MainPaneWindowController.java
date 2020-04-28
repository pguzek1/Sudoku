package pl.prokom.view.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import pl.prokom.view.menu.MainPaneWindow;

import java.io.IOException;

public class MainPaneWindowController extends MainPaneWindow {
    /**
     * Basic Pane instance.
     */
    @FXML
    private Pane mainPaneWindow;

    public MainPaneWindowController() { }

    public void setApplication(Pane mainPaneWindow) {
        this.mainPaneWindow = mainPaneWindow;
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
    public void initialize() throws IOException {
        loadLanguageController();
        loadDiffucultyButtonContoller();
        loadSudokuBoardController();
    }

    public void loadLanguageController() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/fxml/LanguageChoiceButtons.fxml"));
        Pane anchor = loader.load();
        languageChoiceButtonsController = loader.getController();
        languageChoiceButtonsController.setParentController(this);

        this.mainPaneWindow.getChildren().add(anchor);
    }

    public void loadDiffucultyButtonContoller() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/fxml/DifficultyLevelButtons.fxml"));
        Pane anchor = loader.load();
        difficultyLevelButtonsController = loader.getController();
        difficultyLevelButtonsController.setParentController(this);

        this.mainPaneWindow.getChildren().add(anchor);
    }

    public void loadSudokuBoardController() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/fxml/SudokuBoardGridPane.fxml"));
        Pane anchor = loader.load();
        sudokuBoardController = loader.getController();
        sudokuBoardController.setParentController(this);

        this.mainPaneWindow.getChildren().add(anchor);
    }
}
