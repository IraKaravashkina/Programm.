package services;


import javafx.collections.ObservableList;
import model.Contact;

public interface ContactService {

    /**

     * Сервис бизнес логики который описывает основные действия над доменными моделями - Контактами.

     */

    void createContact(String name, int phone);
    void deleteContact(String name);
    List<Contact> findContact(String name);
    ObservableList<Contact> showContacts();
    void editContact(String oldName, String newName, int newAge);
}
