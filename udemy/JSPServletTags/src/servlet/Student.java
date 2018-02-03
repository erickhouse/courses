package servlet;


public class Student {

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isGoldMember() {
        return goldMember;
    }

    public void setGoldMember(boolean goldMember) {
        this.goldMember = goldMember;
    }

    private String firstName;
    private String lastName;
    private boolean goldMember;

    public Student(String firstName, String lastName, boolean goldMember) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.goldMember = goldMember;
    }
}
