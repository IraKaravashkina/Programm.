package view.controllers;


import dao.impl.DBContactDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Contact;
import services.ContactService;
import services.impl.FSContactServiceImpl;

public class MainController {

    private ContactService contactService;

    public MainController() {
        this.contactService = new FSContactServiceImpl(new DBContactDao());
    }

    @FXML
    private TextField inputName;

    @FXML
    private TextField inputAge;

    @FXML
    private Button createButton;

    @FXML
    private TableView<Contact> table;

    @FXML
    private TableColumn<Contact, String> nameColumn;

    @FXML
    private TableColumn<Contact, Integer> ageColumn;

    public void createContact() {
        String name = inputName.getText();
        String age = inputAge.getText();
        contactService.createContact(name, new Integer(age));
    }

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        table.setItems(contactService.showContacts());
    }
}
