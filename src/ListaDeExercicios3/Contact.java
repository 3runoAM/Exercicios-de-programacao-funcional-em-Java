package ListaDeExercicios3;

import java.util.List;

public class Contact {
    private String name;
    private List<String> phoneNumber;

    public Contact(String name, List<String> phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public List<String> getphoneNumber() {
        return phoneNumber;
    }

    public String toString() {
        return "Contact: " + name + "phone numbers: " + phoneNumber;
    }
}