/*
 * NAME: Andrew Emilio DiStefano
 * DATE: June 11, 2024
 * CLASS: CS-320 Software Test, Automation QA
 * ASSIGNMENT: Project One (Module 6)
 * INSTRUCTOR: Professor Omar Toledo Lopez
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ContactServiceTest {

    @Test   // Make sure that a contact can be referenced by its ID number.
    void testGetContact() {
        ContactService service = new ContactService();
        service.createContact("1234567", "Default", "Default", "1234567890", "42 Wallaby Way");
        service.addContact("1234567");
        assertEquals("1234567", service.contacts.get("1234567").getContactID());
    }

    @Test   // Make sure contacts can be added to the 'contacts' map.
    void testCreateContact() {
        ContactService service = new ContactService();
        service.createContact("8675309", "Default", "Default", "1234567890", "42 Wallaby Way");
        service.addContact("8675309");
        assertNotNull(service.pendingContactID);
        assertNotNull(service.pendingContact);
    }

    @Test   // Make sure that contacts created with null attributes throw an error.
    void testCreateContactWithNullAttribute() {
        ContactService service = new ContactService();
        assertThrows(NullPointerException.class, () ->{
            service.createContact(null, "Default", "Default", "1234567890", "42 Wallaby Way");
        });

        assertThrows(NullPointerException.class, () ->{
            service.createContact("1234567", null, "Default", "1234567890", "42 Wallaby Way");
        });

        assertThrows(NullPointerException.class, () ->{
            service.createContact("1234567", "Default", null, "1234567890", "42 Wallaby Way");
        });

        assertThrows(NullPointerException.class, () ->{
            service.createContact("1234567", "Default", "Default", null, "42 Wallaby Way");
        });

        assertThrows(NullPointerException.class, () ->{
            service.createContact("1234567", "Default", "Default", "1234567890", null);
        });
    }

    @Test   // Make sure that contacts created with attributes which do not meet size specifications throw an error.
    void testCreateContactWithAttributeWrongSize() {
        ContactService service = new ContactService();
        //  Checks that the contact's unique ID does not exceed 10 characters (checks with 11 characters) when a contact is created.
        assertThrows(IllegalArgumentException.class, () ->{
            service.createContact("12345678901", "Default", "Default", "1234567890", "42 Wallaby Way");
        });

        //  Checks that the contact's first name does not exceed 10 characters (checks with 11 characters) when a contact is created.
        assertThrows(IllegalArgumentException.class, () ->{
            service.createContact("8675309", "DefaultDefa", "Default", "1234567890", "42 Wallaby Way");
        });

        //  Checks that the contact's last name does not exceed 10 characters (checks with 11 characters) when a contact is created.
        assertThrows(IllegalArgumentException.class, () ->{
            service.createContact("8675309", "Default", "DefaultDefa", "1234567890", "42 Wallaby Way");
        });

        //  Checks that the contact's phone number does not exceed 10 digits (checks with 11 digits) when a contact is created.
        assertThrows(IllegalArgumentException.class, () ->{
            service.createContact("8675309", "Default", "Default", "12345678901", "42 Wallaby Way");
        });

        //  Checks that the contact's phone number does not contain less than 10 digits (checks with 11 digits) when a contact is created.
        assertThrows(IllegalArgumentException.class, () ->{
            service.createContact("8675309", "Default", "Default", "123456789", "42 Wallaby Way");
        });

        //  Checks that the contact's home address does not exceed 30 characters (checks with 31 characters) when a contact is created.
        assertThrows(IllegalArgumentException.class, () ->{
            service.createContact("8675309", "Default", "Default", "1234567890", "DefaultDefaultDefaultDefaultDef");
        });
    }

    @Test   // Make sure that a created contact can be successfully added to the 'contacts' map.
    void testAddContact() {
        ContactService service = new ContactService();
        service.createContact("8675309", "Default", "Default", "1234567890", "42 Wallaby Way");
        service.addContact("8675309");
        assertEquals(service.contacts.get("8675309").getContactID(), service.pendingContactID);
    }

    @Test
    void testAddContactAlreadyExists() {
        ContactService service = new ContactService();
        service.createContact("8675309", "Default", "Default", "1234567890", "42 Wallaby Way");
        service.addContact("8675309");
        service.createContact("8675309", "Default", "Default", "1234567890", "42 Wallaby Way");
        service.addContact("8675309");
    }

    @Test   // Make sure that contacts can be successfully removed from the 'contacts' map.
    void testRemoveContact() {
        ContactService service = new ContactService();
        service.createContact("550", "Default", "Default", "1234567890", "42 Wallaby Way");
        service.addContact("550");
        service.removeContact("550");
        assertThrows(IllegalArgumentException.class, () ->{
            service.getContact("550");
        });
    }

    @Test   // Make sure that the removal of a contact which is not in the 'contacts' map throws an error.
    void removeContactNotFound() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () ->{
            service.removeContact("110010101");
        });
    }

    @Test   // Make sure that a contact's first name can be updated.
    void testUpdateContactFirstName() {
        ContactService service = new ContactService();
        service.createContact("1234567", "Default", "Default", "1234567890", "42 Wallaby Way");
        service.addContact("1234567");
        service.updateContactFirstName("Name", "1234567");
        assertEquals("Name", service.getContact("1234567").getContactFirstName(), "Contact's first name was not updated.");
    }

    @Test   // Make sure that a contact's last name can be updated.
    void testUpdateContactLastName() {
        ContactService service = new ContactService();
        service.createContact("1234567", "Default", "Default", "1234567890", "42 Wallaby Way");
        service.addContact("1234567");
        service.updateContactLastName("Name", "1234567");
        assertEquals("Name", service.getContact("1234567").getContactLastName(), "Contact's last name was not updated.");
    }

    @Test   // Make sure that a contact's phone number can be updated.
    void testUpdateContactPhoneNumber() {
        ContactService service = new ContactService();
        service.createContact("1234567", "Default", "Default", "1234567890", "42 Wallaby Way");
        service.addContact("1234567");
        service.updateContactPhoneNumber("6108675309", "1234567");
        assertEquals("6108675309", service.getContact("1234567").getContactPhoneNumber(), "Contact's phone number was not updated.");
    }

    @Test   // Make sure that a contact's home address can be updated.
    void testUpdateHomeAddress() {
        ContactService service = new ContactService();
        service.createContact("1234567", "Default", "Default", "1234567890", "42 Wallaby Way");
        service.addContact("1234567");
        service.updateContactHomeAddress("1134 Elm Street", "1234567");
        assertEquals("1134 Elm Street", service.getContact("1234567").getContactHomeAddress(), "Contact's home address was not updated.");
    }

    @Test   // Make sure that the attempted update of the first name of a contact which is not in the 'contacts' map throws an error.
    void testUpdateContactNameNotFound() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () ->{
            service.updateContactFirstName("0987654321", "Default");
        });
    }

    @Test   // Make sure that the attempted update of the last name of a contact which is not in the 'contacts' map throws an error.
    void testUpdateContactLastNameNotFound() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () ->{
            service.updateContactLastName("0987654321", "Default");
        });
    }

    @Test   // Make sure that the attempted update of the phone number of a contact which is not in the 'contacts' map throws an error.
    void testUpdateContactPhoneNumberNotFound() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () ->{
            service.updateContactPhoneNumber("0987654321", "1234567890");
        });
    }

    @Test   // Make sure that the attempted update of the home address of a contact which is not in the 'contacts' map throws an error.
    void testUpdateContactHomeAddressNotFound() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () ->{
            service.updateContactHomeAddress("0987654321", "Default address");
        });
    }
}