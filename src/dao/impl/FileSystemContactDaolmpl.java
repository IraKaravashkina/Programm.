package dao.impl;


import dao.ContactDao;
import model.Contact;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileSystemContactDaoImpl implements ContactDao {

    /**

     * Сервис работы с файловой системой. Преобразует модели в/из данные хранимые на жестком диске.

     */
    private static final File FILE = new File("data");
    public FileSystemContactDaoImpl() {
    }

    //TODO исправить логику так, что бы файл не пересоздавался а дополнялся.

    @Override
    public void saveContact(Contact contact) {
        try (PrintWriter writer = new PrintWriter(
                new BufferedWriter(new FileWriter(FILE)))) {
            writer.println(contact);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteContact() {
    }

    @Override
    public void editContact(Contact newContact){
        if (!contactList.isEmpty()) contactList.clear();

        readFile();

        int index = findIndexOfElement(newContact.getId());
        if (index > -1 ) contactList.set(index, newContact);

        if (FILE.delete()) {
            writeCollectionToFile();
        }
    }

    @Override
    public List<Contact> showAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
