package phonebook.service;

import phonebook.model.Contact;
import phonebook.model.PhoneNumber;
import phonebook.model.TypePhoneContact;
import phonebook.service.io.ExportData;
import phonebook.service.io.ImportData;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Created by oleksii on 4/8/17.
 */
public interface PhoneBookService {

	public Map<Contact,PhoneNumber> createNewContact(Contact contact, Map<String,TypePhoneContact> phoneNumber);

	public Contact editContact(Contact contact, String firstname, String lastname, String email, LocalDate birthday, String address);

	public Map<Contact,PhoneNumber> deleteContactByName(Contact contact);

	public Map<Contact,PhoneNumber> getAllContact();

	public ExportData exportData();

	public ImportData importData();

	public List<Contact> searchContactByFirstName(Map<Contact,PhoneNumber> contacts, String firstname);

	public List<Contact> searchContactByLastName(Map<Contact,PhoneNumber> contacts, String lastname);

	public List<Contact> searchContactByPartOfName(Map<Contact,PhoneNumber> contacts, String strName);

	public Map<Contact,PhoneNumber> searchContactByPhoneNumber(Map<Contact,PhoneNumber> contacts, String phoneNumber);

	public Map<Contact,PhoneNumber> searchContactByAge(Map<Contact,PhoneNumber> contacts, int startAge,int endAge);

	public String exportDataMessage();

	public String importDataMessage();
}
