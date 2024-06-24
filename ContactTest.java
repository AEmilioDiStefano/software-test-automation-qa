/*
 * NAME: Andrew Emilio DiStefano
 * DATE: June 11, 2024
 * CLASS: CS-320 Software Test, Automation QA
 * ASSIGNMENT: Project One (Module 6)
 * INSTRUCTOR: Professor Omar Toledo Lopez
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

    @Test   // Test if any one of the attributes has a null value.
    void testContactNull() {
        assertThrows(NullPointerException.class, () -> {
            new Contact(null, "Default", "Default", "1234567890", "Default");
        });

        assertThrows(NullPointerException.class, () -> {
            new Contact("Default", null, "Default", "1234567890", "Default");
        });

        assertThrows(NullPointerException.class, () -> {
            new Contact("Default", "Default", null, "1234567890", "Default");
        });

        assertThrows(NullPointerException.class, () -> {
            new Contact("Default", "Default", "Default", null, "Default");
        });

        assertThrows(NullPointerException.class, () -> {
            new Contact("Default", "Default", "Default", "1234567890", null);
        });
    }

    @Test   // Test if any one of the attributes contains more characters than it should.
    void testContactWrongSize() {

        //  Checks that the unique ID does not exceed 10 characters (checks with 11 characters) when creating a contact
        assertThrows(IllegalArgumentException.class, () ->{
            new Contact("DefaultDefa", "Default", "Default", "1234567890", "Default");
        });

        //  Checks that the first name does not exceed 10 characters (checks with 11 characters) when creating a contact
        assertThrows(IllegalArgumentException.class, () ->{
            new Contact("Default", "DefaultDefa", "Default", "1234567890", "Default");
        });

        //  Checks that the last name does not exceed 10 characters (checks with 11 characters) when creating a contact
        assertThrows(IllegalArgumentException.class, () ->{
            new Contact("Default", "Default", "Default default", "1234567890", "Default");
        });

        //  Checks that the phone number does not exceed 10 digits (checks with 11 characters) when creating a contact
        assertThrows(IllegalArgumentException.class, () ->{
            new Contact("Default", "Default", "Default", "12345678901", "Default");
        });

        //  Checks that the phone number is not less than 10 digits (checks with 9 characters) when creating a contact
        assertThrows(IllegalArgumentException.class, () ->{
            new Contact("Default", "Default", "Default", "123456789", "Default");
        });

        //  Checks that the phone number does not exceed 30 digits (checks with 31 characters) when creating a contact
        assertThrows(IllegalArgumentException.class, () ->{
            new Contact("Default", "Default", "Default", "1234567890", "DefaultDefaultDefaultDefaultDef");
        });
    }

    @Test   // Make sure that getter functions retrieve the correct data from a contact.
    void testGetters() {
        Contact contact = new Contact("1234567", "Default", "Tluafed", "1234567890", "42 Wallaby Way");
        assertEquals("1234567", contact.getContactID());
        assertEquals("Default", contact.getContactFirstName());
        assertEquals("Tluafed", contact.getContactLastName());
        assertEquals("1234567890", contact.getContactPhoneNumber());
        assertEquals("42 Wallaby Way", contact.getContactHomeAddress());
    }

    @Test   // Make sure that the function for setting a contact name is functional.
    void testSetContactFirstName() {
        Contact contact = new Contact("1234567", "First", "Last", "1234567890", "Home Address");

        contact.setContactFirstName("Name");
        assertEquals("Name", contact.getContactFirstName());
    }

    @Test   // Make sure that the function for setting a contact name is functional.
    void testSetContactLastName() {
        Contact contact = new Contact("1234567", "First", "Last", "1234567890", "Home Address");

        contact.setContactLastName("Name");
        assertEquals("Name", contact.getContactLastName());
    }

    @Test   // Make sure that the function for setting a contact name is functional.
    void testSetContactPhoneNumber() {
        Contact contact = new Contact("1234567", "First", "Last", "1234567890", "Home Address");

        contact.setContactPhoneNumber("0987654321");
        assertEquals("0987654321", contact.getContactPhoneNumber());
    }

    @Test   // Test for setter functions setting an attribute to null.
    void testSettersToNull() {
        Contact contact = new Contact("1234567", "Default", "Default", "1234567890", "Default");
        assertThrows(NullPointerException.class, () ->{
            contact.setContactFirstName(null);
        });

        assertThrows(NullPointerException.class, () ->{
            contact.setContactLastName(null);
        });

        assertThrows(NullPointerException.class, () ->{
            contact.setContactPhoneNumber(null);
        });

        assertThrows(NullPointerException.class, () ->{
            contact.setContactHomeAddress(null);
        });
    }

    @Test   // Test for setter functions setting an attribute with more characters than it should have.
    void testSettersWringSize() {
        Contact contact = new Contact("1234567", "Default", "Default", "1234567890", "Default");

        //  Checks that the first name does not exceed 10 characters (checks with 11 characters) when setting a contact's first name.
        assertThrows(IllegalArgumentException.class, () ->{
            contact.setContactFirstName("DefaultDefa");
        });

        //  Checks that the last name does not exceed 10 characters (checks with 11 characters) when setting a contact's last name.
        assertThrows(IllegalArgumentException.class, () ->{
            contact.setContactLastName("DefaultDefa");
        });

        //  Checks that the phone number does not exceed 10 digits (checks with 11 digits) when setting a contact's phone number.
        assertThrows(IllegalArgumentException.class, () ->{
            contact.setContactPhoneNumber("12345678901");
        });

        //  Checks that the phone number does not contain less than 10 digits (checks with 11 digits) when setting a contact's phone number.
        assertThrows(IllegalArgumentException.class, () ->{
            contact.setContactPhoneNumber("123456789");
        });

        //  Checks that the home address does not exceed 30 characters (checks with 31 characters) when setting a contact's home address.
        assertThrows(IllegalArgumentException.class, () ->{
            contact.setContactHomeAddress("DefaultDefaultDefaultDefaultDef");
        });
    }
}