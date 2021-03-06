package services;


import javafx.collections.ObservableList;
import model.Contact;

public interface ContactService {

    /**

     * Сервис бизнес логики который описывает основные действия над доменными моделями - Контактами.

     */

    void saveContact(String name, int phone);
    void deleteContact(String name);
    ObservableList<Contact> showContacts();
    void editContact(String oldName, String newName, int newAge);
}
