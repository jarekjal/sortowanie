package com.company;

import java.util.*;

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
        c1.setBirthDate(new Date(2022 - 1900, Calendar.APRIL, 10));
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
        identifier3.setIdType(1666L);
        identifier3.setIdValue("5407224565500");
        ContactCRSGDTO c2 = new ContactCRSGDTO();
        c2.setEntityTypeVO(entityType2);
        c2.setIdentifiers(List.of(identifier3));
        c2.setId(22222L);
        c2.setAddress("Ogrodowa, 5, 59-220, Legnica, Polska");
        c2.setCity("Legnica");
        c2.setBirthDate(new Date(1954 - 1900, Calendar.SEPTEMBER, 17));
        c2.setExternalId(22222L);
        c2.setfName("jaroslaw");
        c2.setStreet("Ogrodowa");
        c2.setHouse("5");
        c2.setName("Dobrowolska");
        c2.setPhoneNumberValidated(1L);
        c2.setMailValidated(1L);

        // contact 3
        EntityTypeCRSGDTO entityType3 = new EntityTypeCRSGDTO();
        entityType3.setId(null/*66677L*/);
        entityType3.setDesc("jakis opis entity type 3");
        IdentifierCRSGDTO identifier4 = new IdentifierCRSGDTO();
        identifier4.setIdType(87654L);
        identifier4.setIdValue("5310014577701");
        IdentifierCRSGDTO identifier5 = new IdentifierCRSGDTO();
        identifier5.setIdType(98712L);
        identifier5.setIdValue("AB12345");
        IdentifierCRSGDTO identifier6 = new IdentifierCRSGDTO();
        identifier6.setIdType(null);
        identifier6.setIdValue("AB12345");
        ContactCRSGDTO c3 = new ContactCRSGDTO();
        c3.setEntityTypeVO(entityType3);
        List<IdentifierCRSGDTO> identifiers = new ArrayList<>();
        identifiers.add(identifier4);
        identifiers.add(null);
        identifiers.add(identifier5);
        identifiers.add(identifier6);
        identifiers.add(null);
        c3.setIdentifiers(identifiers);
        c3.setId(null/*33333L*/);
        c3.setAddress("3. Powstania Slaskiego, 3, 41-303, Dabrowa Gornicza, Polska");
        c3.setCity("Dabrowa Gornicza");
        c3.setBirthDate(new Date(1980 - 1900, Calendar.APRIL, 1));
        c3.setExternalId(33333L);
        c3.setfName("Jaroslaw");
        c3.setStreet("3. Powstania Slaskiego");
        c3.setHouse("3");
        c3.setName("Jaloszynski");
        c3.setPhoneNumberValidated(0L);
        c3.setMailValidated(1L);

        // contact 4 (only nulls)
        ContactCRSGDTO c4 = new ContactCRSGDTO();

        List<ContactCRSGDTO> contacts = new ArrayList<>();
        contacts.add(c1);
        contacts.add(c2);
        contacts.add(c3);
        contacts.add(c4);
        contacts.add(null);
        //System.out.println(contacts);

        // Sorting (conventions: nulls last, identifier comparing based on lowest id/value
        // in compared lists for ascending and highest id/value for descending)
        Comparator<ContactCRSGDTO> comparator = ContactCRSGDTOComparatorFactory
                .getComparator(ContactCRSGDTOComparatorFactory.F_NAME_FIELD, true);
        contacts.sort(Comparator.nullsLast(comparator));

        System.out.println("po sortowaniu:");
        System.out.println(contacts);

        //Paging
        int startIndex = 2;
        int count = 2;
        int page = (int) Math.ceil(startIndex/count);
        int fromIndex = count * page;
        int toIndex = fromIndex + count - 1;
        if (fromIndex >= contacts.size()) {
            fromIndex = toIndex = 0;
        } else {
            if (toIndex >= contacts.size()) {
                toIndex = contacts.size() - 1;
            }
        }
        System.out.println("po pagingu (page " + page + "):");
        System.out.println(contacts.subList(fromIndex, toIndex + 1));




    }
}
