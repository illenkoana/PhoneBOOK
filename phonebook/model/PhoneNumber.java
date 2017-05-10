package phonebook.model;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Sasha on 16.03.2017.
 */
public class PhoneNumber  implements Serializable {



    private Map<String, TypePhoneContact> phoneNumber;

    public PhoneNumber(Map<String, TypePhoneContact> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Map<String, TypePhoneContact> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Map<String, TypePhoneContact> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "phoneNumber=" + phoneNumber +
                '}';
    }
}
