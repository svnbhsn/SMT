package view;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Controllerklasse für die FXML Datei fxMain
 */
public class ControllerMain {

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private CheckBox cbFacebook;

    @FXML
    private CheckBox cbTwitter;

    @FXML
    private Button btnChooseHashtag;

    @FXML
    private Button btnRandomHashtag;

    @FXML
    private Button btnRandmDateTime;

    @FXML
    private Button btnSavePost;

    @FXML
    private Button btnResetFields;

    @FXML
    private TextArea taMessage;

    @FXML
    private TextArea taHashtags;

    @FXML
    private ListView<?> lvFBGruppen;

    @FXML
    private Label lbRestChar;

    @FXML
    private DatePicker dpDate;

    @FXML
    private TextField tfTime;

    @FXML
    private ComboBox<?> cbFBGruppen;

    @FXML
    private ToggleButton tbActivate;

    @FXML
    private Button btnPicture;

    @FXML
    private Label lbStatus;

    @FXML
    private Label lbFilename;

    @FXML
    private TableView<?> tvPosts;

    @FXML
    private TableColumn<?, ?> tcText1;

    @FXML
    private TableColumn<?, ?> tcDate1;

    @FXML
    private TableColumn<?, ?> tcPlatform1;

    @FXML
    private TableColumn<?, ?> tcReaction1;

    @FXML
    private TableColumn<?, ?> tcPostAction1;

    @FXML
    private Button btnPostPrev;

    @FXML
    private Button btnPostNext;

    @FXML
    private TableView<?> tvHashtags;

    @FXML
    private TableColumn<?, ?> tcTheme1;

    @FXML
    private TableColumn<?, ?> tcList1;

    @FXML
    private TableColumn<?, ?> tcHashAction1;

    @FXML
    private Button btnHashPrev;

    @FXML
    private Button btnHashNext;

    @FXML
    private Button btnNewList;

    @FXML
    private TextField btnFBUsername;

    @FXML
    private TextField btnFBPasswort;

    @FXML
    private TextField btnFBToken;

    @FXML
    private TextField btnFBKey;

    @FXML
    private TextField ConsumerKey;

    @FXML
    private TextField ConsumerSecret;

    @FXML
    private TextField AccessToken;

    @FXML
    private TextField AccessTokenSecret;

    @FXML
    private Button btnSaveSettings;

    File selectedFile;


    /**
     * Diese Methode &ouml;ffnet ein kleines Fenster, in welcher der Benutzer Hashtags ausw&auml;hlen kann.
     *
     * @param event Buttonclick
     * @throws IOException Wenn die fxml nicht ge&ouml;ffnet werden kann
     */
    @FXML
    void ShowHashtags(ActionEvent event) throws IOException {
        try {
            Stage MainStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = loader.load(getClass().getResource("fxTableHashtags.fxml").openStream());
            Scene scene = new Scene(root);
            MainStage.setTitle("SMT - Social Media Tool: Hashtags");
            MainStage.setScene(scene);
            MainStage.setX(400);
            MainStage.setY(300);
            MainStage.show();

        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }

    /**
     * Diese Methode leert alle Felder und den Upload Bereich auf der Oberfl&auml;che "Neuer Posts"
     *
     * @param event Klick auf den Button "Zur&uuml;cksetzen"
     */
    @FXML
    void clearFields(ActionEvent event) {
        // Leere die gesamten Felder
        taMessage.clear();
        taHashtags.clear();
        dpDate.getEditor().clear();
        tfTime.clear();

        // Entferne die Datei aus dem File Objekt
        selectedFile = null;
        lbFilename.setText("Keine Bild oder Film ausgewählt");
    }

    /**
     * Diese Methode erm&ouml;glicht das Uploaden von Dateien
     * Die Beschr&auml;nkung liegt bei Bild- und Videodateien.
     */
    @FXML
    void MediaChooser() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Bild oder Video anhängen");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG Format", "*.jpg"),
                new FileChooser.ExtensionFilter("JPEG Format", "*.jpeg"),
                new FileChooser.ExtensionFilter("GIF Format", "*.gif"),
                new FileChooser.ExtensionFilter("PNG Format", "*.png"),
                new FileChooser.ExtensionFilter("AVI (AVI-Video)", "*.avi"),
                new FileChooser.ExtensionFilter("MOV (QuickTime-Video)", "*.mov"),
                new FileChooser.ExtensionFilter("MP4 (MPEG-4-Video)", "*.mp4"),
                new FileChooser.ExtensionFilter("MPEG (MPEG-Video)", "*.mpeg"),
                new FileChooser.ExtensionFilter("WMV (Windows Media-Video)", "*.wmv"),
                new FileChooser.ExtensionFilter("OGG (Ogg Media-Format)", "*.ogg")
        );
        Stage stage = (Stage) anchorpane.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {

            lbFilename.setText(selectedFile.getName());
        } else {
            lbFilename.setText("Keine Bild oder Film ausgewählt");
        }

    }

    @FXML
    void createNewHashList(ActionEvent event) {
        // Neue Hashtabelle einfügen
    }

    @FXML
    void postAutomatic(ActionEvent event) {

        if (tbActivate.isSelected()) {
            System.out.println("Automatisierung ist aktiviert");
        } else {
            System.out.println("Automatisierung ist deaktiviert");
        }
    }

    @FXML
    void postEntry(ActionEvent event) {
        // Speichert einen neuen Post in die Datenbank
    }

    @FXML
    void randomDate(ActionEvent event) {
        // Syamala
    }

    @FXML
    void randomTime(ActionEvent event) {
        // Syamala
    }

    @FXML
    void randomHashtags(ActionEvent event) {
        // Holt sich Hashtags aus der Datenbank. Anzahl undefiniert.
    }

    @FXML
    void saveSettings(ActionEvent event) {
        // Speichert die Accountdaten der Profile
    }

    @FXML
    void initialize() {
        // DB starten?

    }
}