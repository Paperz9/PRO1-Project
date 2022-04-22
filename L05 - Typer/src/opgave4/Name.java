package opgave4;

public class Name {
    private String firstName;
    private String middleName;
    private String lastName;

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.middleName = "";
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        String fullName = firstName + " " + middleName + " " + lastName;
        if (middleName.isEmpty()) {
            middleName = "";
        }
        return fullName;
    }

    public String getUserName() {
        String un1 = firstName.substring(0, 2).toUpperCase();
        int len = middleName.length();
        String un2 = lastName.substring(lastName.length()-2).toLowerCase();
        return un1 + len + un2;
    }

    public String getInits() {
        String firstLetterFirstName = firstName.substring(0,1);
        String firstLetterLastName = lastName.substring(0,1);
        return firstLetterFirstName + firstLetterLastName;
    }

    public String getCryptoInits(int count) {
        char firstLet = firstName.charAt(0);
        firstLet += count;
        char lastLet = lastName.charAt(0);
        lastLet += count;
        return "" + firstLet + lastLet;
    }
}
