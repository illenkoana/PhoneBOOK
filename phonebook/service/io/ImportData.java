package phonebook.service.io;

import phonebook.model.Contact;
import phonebook.model.PhoneNumber;
import phonebook.model.TypePhoneContact;

import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Sasha on 16.03.2017.
 */
public class ImportData implements Serializable{

    private static final char SEPARATOR= ';';

    public void importPhoneBookAllContacts(Map<Contact, PhoneNumber> contacts)  {

        File f = new File("Data.txt");
        if (f.exists()) {
            try (Scanner s = new Scanner(f);
                 FileOutputStream fos = new FileOutputStream("temp.out");
                 ObjectOutputStream oos = new ObjectOutputStream(fos);
                ) {
                while (s.hasNextLine()) {
                    String line = s.nextLine();

                    String[] arrayString = line.split(";");
                    if (arrayString.length != 6) {
                        throw new IllegalArgumentException("Incorrect string! " + line);
                    }
                    Contact currentContact = new Contact(arrayString[0],arrayString[1],arrayString[2],LocalDate.parse((String) arrayString[3]),arrayString[4]);

                    Map<String,TypePhoneContact> phonenumber1= new HashMap<>();
                    String[] arrayNumbers = arrayString[5].split("#");
                    for (int i = 0; i < arrayNumbers.length; i++) {

                        String[] arrayNumber = arrayNumbers[i].split(":");
                        if (!arrayNumber[0].isEmpty()) {
                            phonenumber1.put(arrayNumber[1],TypePhoneContact.valueOf(arrayNumber[0]));
                        }
                    }
                    PhoneNumber phonenumber = new PhoneNumber(phonenumber1);
                    contacts.put(currentContact,phonenumber);
                }
                oos.writeObject(contacts);
                oos.flush();
                oos.close();

            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void storeStateDeseriazable(Map<Contact, PhoneNumber> contacts)
    {

    }


}
