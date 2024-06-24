/*
 * NAME: Andrew Emilio DiStefano
 * DATE: June 11, 2024
 * CLASS: CS-320 Software Test, Automation QA
 * ASSIGNMENT: Project One (Module 6)
 * INSTRUCTOR: Professor Omar Toledo Lopez
 */

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    String pendingContactID;
    Contact pendingContact;

    // This map will represent our list of contacts.
    public Map<String, Contact> contacts = new HashMap<String, Contact>();

    public Contact getContact(String contactID) {
        Contact contact = new Contact("1234567", "Default", "Default", "1234567890", "42 Wallaby Way");
        if (!contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("There is no contact with that ID.");
        } else {
            contact = contacts.get(contactID);
        }
        return contact;
    }

    // This function creates a contact object.
    public void createContact(String contactID, String contactFirstName, String contactLastName, String contactPhoneNumber, String contactHomeAddress) {
        // Create a new contact.
        Contact contact = new Contact(contactID, contactFirstName, contactLastName, contactPhoneNumber, contactHomeAddress);
        pendingContactID = contactID;
        pendingContact = contact;
    }

    // This function adds a contact object to the 'contacts' map.
    public void addContact(String contactID) {
        if (!contacts.containsKey(pendingContactID)) {
            contacts.put(pendingContactID, pendingContact);
        }
    }

    // This function removes a contact object from the 'contacts' map.
    public void removeContact(String contactID) {
        Contact contact = new Contact(contactID, "1234567", "Default", "1234567890", "42 Wallaby Way");
        if (!contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("There is no contact with that ID.");
        } else {
            contacts.remove(contact.getContactID());
        }
    }

    // There is no function to change a contact ID because the contact ID should not be updatable,
    // as specified in requirements.

    // This function changes a contact's first name.
    public void updateContactFirstName(String newContactFirstName, String contactID) {
        Contact contact = new Contact("1234567", "Default", "Default", "1234567890", "42 Wallaby Way");
        if (!contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("There is no contact with that ID.");
        } else {
            contact.setContactFirstName(newContactFirstName);
            contacts.put(contactID, contact);
        }
    }

    // This function changes a contact's last name.
    public void updateContactLastName(String newContactLastName, String contactID) {
        Contact contact = new Contact("1234567", "Default", "Default", "1234567890", "42 Wallaby Way");
        if (!contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("There is no contact with that ID.");
        } else {
            contact.setContactLastName(newContactLastName);
            contacts.put(contactID, contact);
        }
    }

    // This function changes a contact's phone number'.
    public void updateContactPhoneNumber(String newContactPhoneNumber, String contactID) {
        Contact contact = new Contact("1234567", "Default", "Default", "1234567890", "42 Wallaby Way");
        if (!contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("There is no contact with that ID.");
        } else {
            contact.setContactPhoneNumber(newContactPhoneNumber);
            contacts.put(contactID, contact);
        }
    }

    // This function changes a contact's home address'.
    public void updateContactHomeAddress(String newContactHomeAddress, String contactID) {
        Contact contact = new Contact("1234567", "Default", "Default", "1234567890", "42 Wallaby Way");
        if (!contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("There is no contact with that ID.");
        } else {
            contact.setContactHomeAddress(newContactHomeAddress);
            contacts.put(contactID, contact);
        }
    }

}