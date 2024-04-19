package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {

    private String myNumber;

    public List<Contact> myContacts ;


    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        myContacts = new ArrayList<>();
    }

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact){

        if(contact == null || contact.getName() == null || contact.getPhoneNumber() == null) {
            return false;
        }

        if(findContact(contact.getName()) >= 0) {
            return false;
        }
        return this.myContacts.add(contact);

    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int oldContactIndex = findContact(oldContact);

        if(oldContactIndex < 0) {
            return false;
        }
        myContacts.set(oldContactIndex, newContact);
        return true;

    }

    public boolean removeContact(Contact contact) {

        if(myContacts.contains(contact)) {
            myContacts.remove(contact);
            return true;
        }
        return false;

    }

    public int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }



    public int findContact(String name) {
        for (int i=0 ; i< this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if(contact.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }






    public Contact queryContact(String name) {
        int index = findContact(name);
        if(index <= 0) {
            return null;
        }
        return this.myContacts.get(index);

    }



    public void printContact() {
        for (int i=0 ; i< myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            System.out.println((i+1)+". " + contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }









}
