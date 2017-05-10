package phonebook.service.io;

import phonebook.model.Contact;
import phonebook.model.PhoneNumber;
import phonebook.model.TypePhoneContact;

import java.io.*;
import java.util.Map;

/**
 * Created by Sasha on 16.03.2017.
 */
public class ExportData implements Serializable {
    private static final char SEPARATOR= ';';
    private static final char SEPARATOR_NUMBER= '#';

    public void exportPhoneBookAllContacts(Map<Contact, PhoneNumber> contacts)  {

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Contact,PhoneNumber> phonebook : contacts.entrySet() ) {
            System.out.println(phonebook.getKey());
            Contact c = phonebook.getKey();
            sb.append(c.getFirstname()).append(SEPARATOR).append(c.getLastname()).append(SEPARATOR).append(c.getEmail()).append(SEPARATOR).append(c.getBirthday()).append(SEPARATOR).append(c.getAddress()).append(SEPARATOR);
            // тут я получаю из текущего контакта получаю объект Телефонный номео
            PhoneNumber pH =  phonebook.getValue();
            //у объекта телефонный номер я вызываю метод, который возвращает мне мапу содержащую пару тип телефона и номер телефона и помещаю данную мапу в нашу переменную
            Map<String,TypePhoneContact> mapPN = pH.getPhoneNumber();

            // что такое мапа? мапа это массив содержащй два поля ключ и значение В данном случае у меня ключ - телефонный номер строовый, а значепние тип телефонного номера
            for (Map.Entry<String,TypePhoneContact> numberPhone : mapPN.entrySet() )
            {
                sb.append(numberPhone.getValue()).append(":").append(numberPhone.getKey()).append(SEPARATOR_NUMBER);
            }
             sb.append("\n");
        }

        File file = new File("Data.txt");
        try(FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
        )
        {
            pw.print(sb.toString());
            System.out.println("Changes were saved in Data.txt ;)");
        }catch(IOException e){
            e.printStackTrace();
        }

        storeStateSeriazable(contacts);
    }


    public void storeStateSeriazable(Map<Contact, PhoneNumber> contacts) {
        try (
                FileOutputStream fos = new FileOutputStream("temp.out");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            System.out.println("Changes were saved in temp.out)");
            oos.writeObject(contacts);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
