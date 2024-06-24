/*
 * NAME: Andrew Emilio DiStefano
 * DATE: June 11, 2024
 * CLASS: CS-320 Software Test, Automation QA
 * ASSIGNMENT: Project One (Module 6)
 * INSTRUCTOR: Professor Omar Toledo Lopez
 */

public class Contact {
    private String contactID;   // This is our variable for the contact's unique ID.
    private String contactFirstName;   // This is our variable for the contact name.
    private String contactLastName;
    private String contactPhoneNumber;    // This is our variable for the contact description.
    private String contactHomeAddress;

    private boolean validateInput(String item, int itemLength) {
        if (item.length() > itemLength) {
            return false;
        } else {
            return true;
        }
    }

    public Contact(String contactID, String contactFirstName, String contactLastName, String contactPhoneNumber, String contactHomeAddress) {

        if (!validateInput(contactID, 10)) {
            throw new IllegalArgumentException("Contact ID must contain 10 characters or less.");
        } else {
            this.contactID = contactID;
        }

        if (!validateInput(contactFirstName, 10)) {
            throw new IllegalArgumentException("First name must contain 10 characters or less.");
        } else {
            this.contactFirstName = contactFirstName;
        }

        if (!validateInput(contactLastName, 10)) {
            throw new IllegalArgumentException("Last name must contain 10 characters or less.");
        } else {
            this.contactLastName = contactLastName;
        }

        if (!validateInput(contactPhoneNumber, 10) || contactPhoneNumber.length() < 10) {
            throw new IllegalArgumentException("Phone number must contain exactly 10 digits.");
        } else {
            this.contactPhoneNumber = contactPhoneNumber;
        }

        if (!validateInput(contactHomeAddress, 30)) {
            throw new IllegalArgumentException("Address must contain 50 characters or less.");
        } else {
            this.contactHomeAddress = contactHomeAddress;
        }
    }

    // This is our getter function for the contact's unique ID.
    public String getContactID() {
        return this.contactID;
    }

    // This is our getter function for the contact's first name.
    public String getContactFirstName() {
        return this.contactFirstName;
    }

    // This is our getter function for the contact's last name.
    public String getContactLastName() {
        return this.contactLastName;
    }

    // This is our getter function for the contact's phone number'.
    public String getContactPhoneNumber() {
        return this.contactPhoneNumber;
    }

    // This is our getter function for the contact's home address'.
    public String getContactHomeAddress() {
        return this.contactHomeAddress;
    }

    // This is our setter function for the contact's first name.
    public void setContactFirstName(String newContactFirstName) {
        // If the new ID of the contact is left empty or exceeds 10 characters, throw an error.
        // Otherwise, set user input as the new value of the 'contactFirstName' variable.
        if (!validateInput(newContactFirstName, 10)) {
            throw new IllegalArgumentException("First name must contain 10 characters or less.");
        } else {
            contactFirstName = newContactFirstName;
        }
    }

    // This is our setter function for the contact's last name'.
    public void setContactLastName(String newContactLastName) {
        // If the new contact's last name is left empty or exceeds 10 characters, throw an error.
        // Otherwise, set user input as the new value of the 'contactLastName' variable.
        if (!validateInput(newContactLastName, 10)) {
            throw new IllegalArgumentException("Last name must contain 10 characters or less.");
        } else {
            contactLastName = newContactLastName;
        }
    }

    // This is our setter function for the contact's phone number.
    public void setContactPhoneNumber(String newContactPhoneNumber) {
        // If the new contact phone number is left empty or exceeds 50 characters, throw an error.
        // Otherwise, set user input as the new value of the 'contactPhoneNumber' variable.
        if (!validateInput(newContactPhoneNumber, 10) || newContactPhoneNumber.length() < 10) {
            throw new IllegalArgumentException("Phone number must contain exactly 10 digits.");
        } else {
            contactPhoneNumber = newContactPhoneNumber;
        }
    }

    // This is our setter function for the contact's home address'.
    public void setContactHomeAddress(String newContactHomeAddress) {
        // If the new contact address is left empty or exceeds 30 characters, throw an error.
        // Otherwise, set user input as the new value of the 'contactHomeAddress' variable.
        if (!validateInput(newContactHomeAddress, 30)) {
            throw new IllegalArgumentException("Address must contain 50 characters or less.");
        } else {
            contactHomeAddress = newContactHomeAddress;
        }
    }
}