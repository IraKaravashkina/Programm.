package services;

public class ContactService {
}
        import programm.model.Contact;
        import javafx.collections.ObservableList;

public interface ContactService {

    /**

     * Сервис бизнес логики который описывает основные действия над доменными моделями - Контактами.

     */

    void createContact(String name, int phone);
    void deleteContact(String name);

    ObservableList<Contact> showContacts();
    void editContact(String oldName, String newName, int newAge);
}