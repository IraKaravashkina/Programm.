package view.impl;


import services.ContactService;
import utils.ValidationUtil;
import view.CmdLineService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdLineServiceImpl implements CmdLineService {

    /**
     * Сервис реализующий логику предоставления и считывания информации в/из консоль.
     */

    private final ContactService contactService;
    private final BufferedReader br;


    public CmdLineServiceImpl(ContactService contactService) {
        this.contactService = contactService;
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void runMenu() throws IOException {
        boolean exit = true;
        while (exit) {
            showMenu();
            String line = br.readLine();
            switch (line) {
                case "1": {
                    saveContact();
                    break;
                }
                case "2": {
                    deleteContact();
                    break;
                }
                case "3": {
                    showContacts();
                    break;
                }
                case "4": {
                    editContact();
                    break;
                }
                case "0": {
                    exit = false;
                    break;
                }
                default:
                    System.out.println("Repeat");
            }
        }
    }

    private static void showMenu() {
        System.out.println("1. Save Contact");
        System.out.println("2. Delete Contact");
        System.out.println("3. Show Contacts");
        System.out.println("4. Edit Contact");
        System.out.println("0. Exit");
    }

    private void saveContact() throws IOException {
        System.out.println("Enter name");
        String name = br.readLine();
        System.out.println("Enter age");
        int age = readInt();
        contactService.saveContact(name, age);
    }

    private void deleteContact() throws IOException {
        System.out.println("Enter contact name for remove");
        String name = br.readLine();
        contactService.deleteContact(name);
    }

    private void showContacts() {
        contactService.showContacts();
    }

    private void editContact() throws IOException {

        System.out.println("Enter name of modified contact");
        String name = br.readLine();
        System.out.println("Enter new name");
        String newName = br.readLine();
        System.out.println("Enter new age");
        int newAge = readInt();
        this.contactService.editContact(name, newName, newAge);
    }

    private int readInt() throws IOException {
        try {
            String line = br.readLine();
            return ValidationUtil.checkNumber(line);
        } catch (NumberFormatException ex) {
            System.out.println("Wrong Input! You must input number");
            return readInt();
        }
    }
}
