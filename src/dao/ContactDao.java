package dao;

import model.Contact;

import java.util.List;

public interface ContactDao {
    /**

     * Интерфейс описывающий основное поведение работы с различными вариантами долгострочного хранения данных.

     * (файловая система, БД и т.д.)

     */
    void saveContact(Contact contact);
    void deleteContact();
    void editContact(Contact contact);
    List<Contact> findContact(String name);
    List<Contact> showAll();
}
