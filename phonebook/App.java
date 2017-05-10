package phonebook;

import phonebook.service.LoginClass;
import phonebook.service.PhoneBook;

/**
 * Created by Sasha on 16.03.2017.
 */
public class App {

    public static void main(String[] args) {

        /**
         * Entrance/Login
         */

        PhoneBook phoneBook=new PhoneBook();
        phoneBook.importData();

        LoginClass loginClass = new LoginClass();
        loginClass.basicInterfaceLogin();

        /**
         * Example/Lyamda
         */

        /*new TreeMap<Integer, String>((a, b) -> {
            return 1;
        });*/

    }
}

