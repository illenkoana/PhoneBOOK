package phonebook.service;

import phonebook.model.Contact;
import phonebook.model.PhoneNumber;
import phonebook.model.TypePhoneContact;
import phonebook.service.io.ExportData;
import phonebook.service.io.ImportData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.stream.Collectors.toList;

/**
 * Created by Sasha on 16.03.2017.
 */
public class PhoneBook implements PhoneBookService {

    private Map<Contact,PhoneNumber> contacts = new HashMap<>();

    public PhoneBook(Contact contact) {

    }

    public PhoneBook() {
    }

    public Map<Contact, PhoneNumber> getContacts() {
        return contacts;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "contacts=" + contacts +
                '}';
    }

    public Map<Contact,PhoneNumber> createNewContact(Contact contact, Map<String,TypePhoneContact> phoneNumber)
    {
        PhoneNumber phonenumber = new PhoneNumber(phoneNumber);
        getContacts().put(contact, phonenumber);
        return getContacts();
    }

    public Contact editContact(Contact contact, String firstname, String lastname, String email, LocalDate birthday, String address)
    {
        if (firstname!=null) contact.setFirstname(firstname);
        if (lastname!=null) contact.setLastname(lastname);
        if (email!=null) contact.setEmail(email);
        if (birthday!=null) contact.setBirthday(birthday);
        if (address!=null) contact.setAddress(address);
        return contact;
    }

    public Map<Contact,PhoneNumber> deleteContactByName(Contact contact)
    {
        getContacts().remove(contact);
        return getContacts();
    }


    public Map<Contact,PhoneNumber> getAllContact()
    {
        System.out.println(getContacts().toString());
        return getContacts();
    }


    public ExportData exportData() {
        ExportData exportData= new ExportData();
        exportData.exportPhoneBookAllContacts(getContacts());
        return exportData;
    }

    public ImportData importData() {
        ImportData importData= new ImportData();
        importData.importPhoneBookAllContacts(getContacts());
        return importData;
    }

    public List<Contact> searchContactByFirstName(Map<Contact,PhoneNumber> contacts, String firstname)
    {
        return contacts.keySet().stream()
                .filter(c -> c.getFirstname().toUpperCase().equals(firstname.toUpperCase()))
                .peek(System.out::println)
                .collect(toList());
    }

    public List<Contact> searchContactByLastName(Map<Contact,PhoneNumber> contacts, String lastname)
    {
        return contacts.keySet().stream()
            .filter(c -> c.getFirstname().toUpperCase().equals(lastname.toUpperCase()))
            .peek(System.out::println)
            .collect(toList());
    }

    public List<Contact> searchContactByPartOfName(Map<Contact,PhoneNumber> contacts, String strName)
    {
        if (true)
            return contacts.keySet().stream()
                .filter(c -> c.getLastname().toUpperCase().equals(strName.toUpperCase()))
                .peek(System.out::println)
                .collect(toList());

        if (true)
            return contacts.keySet().stream()
                .filter(c -> c.getFirstname().toUpperCase().equals(strName.toUpperCase()))
                .peek(System.out::println)
                .collect(toList());
        return null;
    }

    public Map<Contact,PhoneNumber> searchContactByPhoneNumber(Map<Contact,PhoneNumber> contacts, String phoneNumber)
    {
        for (Contact c : contacts.keySet())
        {
            PhoneNumber ph = contacts.get(c);
            Map<String,TypePhoneContact> phoneNumbers = ph.getPhoneNumber();
            phoneNumbers.keySet().stream()
                    .filter(s -> s.equals(phoneNumber))
                    .peek(System.out::println)
                    .collect(toList());
        }
        return contacts;
    }

    public Map<Contact,PhoneNumber> searchContactByAge(Map<Contact,PhoneNumber> contacts, int startAge,int endAge)
    {
        if (endAge > 150 || endAge < 0 || startAge < 0 || startAge > 150) {
            Runnable runnable1 = () -> {
                AtomicReference<Runnable> runnable = new AtomicReference<>(() -> System.out.println("Try again! Uncorrect difference"));
            };
            return contacts;
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();

        for (Contact contact:contacts.keySet())
        {
            int diff = localDate.getYear() - contact.getBirthday().getYear();
            contacts.keySet().stream()
                        .filter(c -> diff >= startAge && diff <= endAge)
                        .peek(System.out::println)
                        .collect(toList());
        }
             return contacts;
    }

    public String exportDataMessage(){
        return "Data had extracted";
    }

    public String importDataMessage(){
        return "Data had imported";
    }

}
