public class Program {
}
        import javafx.application.Application;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.cell.PropertyValueFactory;
        import javafx.stage.Stage;

public class Program extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/scenes/mainScene.fxml"));
        primaryStage.setTitle("Contact Book");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

//
//	@FXML
//	public void initialize() {
//		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//		ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
//
//		tableView.setItems(contactService.showContacts());
//	}
}