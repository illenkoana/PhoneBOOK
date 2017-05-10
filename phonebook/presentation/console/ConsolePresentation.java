package phonebook.presentation.console;

import phonebook.model.Contact;
import phonebook.model.TypePhoneContact;
import phonebook.service.PhoneBook;
import phonebook.service.PhoneBookService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by oleksii on 4/8/17.
 */
public class ConsolePresentation {

	private PhoneBookService phoneBookService;

	public ConsolePresentation(PhoneBookService phoneBookService) {
		this.phoneBookService = phoneBookService;
	}

	public void getConsolePresentation(){

		System.out.println(showMenuBar().toString());

		PhoneBook phoneBook=new PhoneBook();

		Map<String,TypePhoneContact> phonenumber= new HashMap<>();
		phonenumber.put("+380973806263",TypePhoneContact.HOME);
		phonenumber.put("+180973806263",TypePhoneContact.WORK);
		phonenumber.put("+389911111111",TypePhoneContact.MOBILE);
		Map<String,TypePhoneContact> phonenumber1= new HashMap<>();
		phonenumber1.put("+389911116111",TypePhoneContact.MOBILE);
		Map<String,TypePhoneContact> phonenumber3= new HashMap<>();
		phonenumber3.put("+380000000001", TypePhoneContact.MOBILE);

		while(1==1) {
			System.out.println("Enter number: ");
			Scanner userSelection = new Scanner(System.in);
			String phoneBookService = userSelection.nextLine();

			switch (phoneBookService) {
				case "1": {
					phoneBook.searchContactByFirstName(phoneBook.getContacts(), "Anastasiia");
					phoneBook.searchContactByFirstName(phoneBook.getContacts(), "Sindy");
				}
				case "2":
					phoneBook.searchContactByLastName(phoneBook.getContacts(), "Frog");
				case "3":
					phoneBook.searchContactByPartOfName(phoneBook.getContacts(), "rog");
				case "4":
					phoneBook.searchContactByPhoneNumber(phoneBook.getContacts(), "+380973806263");
				case "5":
					phoneBook.searchContactByAge(phoneBook.getContacts(), 10, 30);
				case "6": {
					phoneBook.createNewContact(new Contact("Illienko","Anastasiia","illenkoanastasia1986@gmail.com",LocalDate.of(1972,12,1) ,"48 Street"), phonenumber);
					phoneBook.createNewContact(new Contact("Begemot","Cat","Begemot@Cat.us",LocalDate.of(1980,12,5) ,"33 Street"), phonenumber1);
					phoneBook.createNewContact(new Contact("Crazy","Frog","Crazy@Frog.us",LocalDate.of(1992,3,5) ,"31 Street"), phonenumber1);
					phoneBook.createNewContact(new Contact("First","Flower","First@Flower.us", LocalDate.of(2003,12,3) ,"30 Street"), phonenumber3);
				}
				case "7":
					phoneBook.editContact(new Contact("Illienko","Anastasiia","illenkoanastasia1986@gmail.com",LocalDate.of(1972,12,1) ,"48 Street"), "Sindy", "Crawford", "contact@crawford.us", LocalDate.of(1972, 1, 1), "84 Street");
				case "8":
					phoneBook.deleteContactByName( new Contact("Begemot","Cat","Begemot@Cat.us",LocalDate.of(1980,12,5) ,"33 Street"));
				case "9":
					phoneBook.getAllContact();
				case "10": {
					phoneBook.exportDataMessage();
					phoneBook.exportData();
				}
				case "11": {
					phoneBook.importDataMessage();
					phoneBook.importData();
				}
				case "12":
					System.exit(0);
				default:
					System.out.println("Enter number!)");
			}
		}

	}

	private String showMenuBar(){
		return  "|-----------------------------------|\n" +
		        "|Search contact by first name   = 1 |\n" +
				"|Search contact by last name    = 2 |\n" +
				"|Search contact by part name    = 3 |\n" +
				"|Search contact by phone number = 4 |\n" +
				"|Search contact by age          = 5 |\n" +
				"|Create new contact             = 6 |\n" +
				"|Edit contact                   = 7 |\n" +
				"|Delete contact     			= 8 |\n" +
				"|Get all contacts   			= 9 |\n" +
				"|Export data        			= 10|\n" +
				"|Import data        		 	= 11|\n" +
				"|Exit               		 	= 12|\n" +
				"|-----------------------------------|\n";
	}

}
