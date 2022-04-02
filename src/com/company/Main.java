package com.company;

import java.util.*;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        // contact 1
        EntityTypeCRSGDTO entityType1 = new EntityTypeCRSGDTO();
        entityType1.setId(63521L);
        entityType1.setDesc("entityTypeDesc");
        IdentifierCRSGDTO identifier1 = new IdentifierCRSGDTO();
        identifier1.setIdType(87654L);
        identifier1.setIdValue("8004124567001");
        IdentifierCRSGDTO identifier2 = new IdentifierCRSGDTO();
        identifier2.setIdType(66654L);
        identifier2.setIdValue("4706104445001");
        ContactCRSGDTO c1 = new ContactCRSGDTO();
        c1.setEntityTypeVO(entityType1);
        c1.setIdentifiers(List.of(identifier1, identifier2));
        c1.setId(11111L);
        c1.setAddress("Kilinskiego, 12, 59-220, Legnica, Polska");
        c1.setCity("Legnica");
        c1.setBirthDate(new Date(2022-1900, Calendar.APRIL, 10));
        c1.setExternalId(0L);
        c1.setfName("Jarek");
        c1.setStreet("Kilinskiego");
        c1.setHouse("12");
        c1.setName("Dobrowolska");
        c1.setPhoneNumberValidated(1L);
        c1.setMailValidated(0L);

        // contact 2
        EntityTypeCRSGDTO entityType2 = new EntityTypeCRSGDTO();
        entityType2.setId(34521L);
        entityType2.setDesc("jakis opis entity type 2");
        IdentifierCRSGDTO identifier3 = new IdentifierCRSGDTO();
        identifier3.setIdType(87654L);
        identifier3.setIdValue("5407224565500");
        ContactCRSGDTO c2 = new ContactCRSGDTO();
        c2.setEntityTypeVO(entityType2);
        c2.setIdentifiers(List.of(identifier3));
        c2.setId(22222L);
        c2.setAddress("Ogrodowa, 5, 59-220, Legnica, Polska");
        c2.setCity("Legnica");
        c2.setBirthDate(new Date(1954-1900, Calendar.SEPTEMBER, 17));
        c2.setExternalId(22222L);
        c2.setfName("Grazyna");
        c2.setStreet("Ogrodowa");
        c2.setHouse("5");
        c2.setName("Dobrowolska");
        c2.setPhoneNumberValidated(1L);
        c2.setMailValidated(1L);

        // contact 3
        EntityTypeCRSGDTO entityType3 = new EntityTypeCRSGDTO();
        entityType3.setId(66677L);
        entityType3.setDesc("jakis opis entity type 3");
        IdentifierCRSGDTO identifier4 = new IdentifierCRSGDTO();
        identifier4.setIdType(87654L);
        identifier4.setIdValue("5310014577701");
        IdentifierCRSGDTO identifier5 = new IdentifierCRSGDTO();
        identifier5.setIdType(98712L);
        identifier5.setIdValue("AB12345");
        ContactCRSGDTO c3 = new ContactCRSGDTO();
        c3.setEntityTypeVO(entityType3);
        c3.setIdentifiers(List.of(identifier4, identifier5));
        c3.setId(null/*33333L*/);
        c3.setAddress("3. Powstania Slaskiego, 3, 41-303, Dabrowa Gornicza, Polska");
        c3.setCity("Dabrowa Gornicza");
        c3.setBirthDate(new Date(1980-1900, Calendar.APRIL, 1));
        c3.setExternalId(33333L);
        c3.setfName("Jaroslaw");
        c3.setStreet("3. Powstania Slaskiego");
        c3.setHouse("3");
        c3.setName("Jaloszynski");
        c3.setPhoneNumberValidated(0L);
        c3.setMailValidated(1L);

        List<ContactCRSGDTO> contacts = new ArrayList<>();
        contacts.add(c1); contacts.add(c2); contacts.add(c3); contacts.add(null);
        System.out.println(contacts);

//        Comparator<ContactCRSGDTO> compareByEntityTypeVOAsc = (a, b) -> a.getEntityTypeVO().compareTo(b.getEntityTypeVO());

        Comparator<ContactCRSGDTO> comparator = ContactCRSGDTOComparatorFactory
                .getComparator(ContactCRSGDTOComparatorFactory.BIRTH_DATE_FIELD, true);
        contacts.sort(Comparator.nullsLast(comparator));



        System.out.println("po sortowaniu: ");
        System.out.println(contacts);
    }
}