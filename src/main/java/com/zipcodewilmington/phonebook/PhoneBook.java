package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 * Altered kinda okay by Chaz 3/12/24
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = new HashMap<>(map);
    }

    public PhoneBook() {
        this.phonebook = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        this.phonebook.put(name, Collections.singletonList(phoneNumber));
    }

    public void addAll(String name, String... phoneNumbers) {
        this.phonebook.put(name, List.of(phoneNumbers));
    }

    public void remove(String name) {
        this.phonebook.remove(name);
    }

    public Boolean hasEntry(String name, String phoneNumber) {
        if (phonebook.containsKey(name)) {
            List<String> phoneNumbers = phonebook.get(name);
            return phoneNumbers.contains(phoneNumber);
        }
        return false;
    }

    public List<String> lookup(String name) {
        return this.phonebook.getOrDefault(name , Collections.emptyList());
    }

    public String reverseLookup(String phoneNumber)  {
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
            if (entry.getValue().contains(phoneNumber)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        return new ArrayList<>(this.phonebook.keySet());

    }

    public Map<String, List<String>> getMap() {
        return this.phonebook;
    }
}
