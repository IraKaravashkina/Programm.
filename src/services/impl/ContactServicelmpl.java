package services.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Contact;
import services.ContactService;


    public class ContactServiceImpl implements ContactService {

        /**
         * Реализация ContactService которая использует Map для хранения данных.
         */

        private final ObservableList<Contact> contactList;

        public ContactServiceImpl() {
            this.contactList = FXCollections.observableArrayList();
        }

        @Override
        public void saveContact(String name, int phone) {
            contactList.add(new Contact(name, phone));
        }

        @Override
        public void deleteContact(String name) {
//        contactList.remove(name);
        }

        @Override
        public ObservableList<Contact> showContacts() {
            return contactList;
        }

        @Override
        public void editContact(String name, String newName, int newAge) {
//        Contact contact = contactList.get(name);
//        contact.setName(newName);
//        contact.setAge(newAge);
        }
    }

