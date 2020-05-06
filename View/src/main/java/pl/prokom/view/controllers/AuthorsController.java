package pl.prokom.view.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.Locale;
import java.util.ResourceBundle;

public class AuthorsController {
    @FXML
    private Label authorsInfo;

    private MainPaneWindowController mainPaneWindowController;

    public AuthorsController() {}

    public void setParentController(MainPaneWindowController mainPaneWindowController) {
        this.mainPaneWindowController = mainPaneWindowController;
    }

    @FXML
    public void initialize() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("pl.prokom.view.bundles.Authors", Locale.getDefault());
        int numer = Integer.parseInt(resourceBundle.getString("AuthorNumbers"));
        StringBuilder authors = new StringBuilder();
        for(int i=1; i<=numer; i++) {
            authors.append(resourceBundle.getString("Author" + i));
            if(i != numer) {
                authors.append("\n");
            }
        }
        authorsInfo.setText(authors.toString());
    }
}