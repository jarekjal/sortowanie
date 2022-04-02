package com.company;

import java.util.Comparator;
import java.util.Date;

public class ContactCRSGDTOComparatorFactory {

    public static final String ID_FIELD = "id";
    public static final String EXTERNAL_ID_FIELD = "externalId";
    public static final String PHONE_NUMBER_VALIDATED_FIELD = "phoneNumberValidated";
    public static final String MAIL_VALIDATED_FIELD = "mailValidated";
    public static final String ADDRESS_FIELD = "address";
    public static final String STREET_FIELD = "street";
    public static final String HOUSE_FIELD = "house";
    public static final String CITY_FIELD = "city";
    public static final String F_NAME_FIELD = "fName";
    public static final String NAME_FIELD = "name";
    public static final String BIRTH_DATE_FIELD = "birthDate";

    public static Comparator<ContactCRSGDTO> getComparator(String compareByField, boolean ascending) {
        Comparator<ContactCRSGDTO> comparator;
        switch (compareByField){
            case ID_FIELD:
            case EXTERNAL_ID_FIELD:
            case PHONE_NUMBER_VALIDATED_FIELD:
            case MAIL_VALIDATED_FIELD:
                comparator = new LongFieldComparator(compareByField);
                break;
            case ADDRESS_FIELD:
            case STREET_FIELD:
            case HOUSE_FIELD:
            case CITY_FIELD:
            case F_NAME_FIELD:
            case NAME_FIELD:
                comparator = new StringFieldComparator(compareByField);
                break;
            case BIRTH_DATE_FIELD:
                comparator = new DateFieldComparator(compareByField);
                break;
            default:
                return null;
        }
        if (!ascending) {
            comparator = comparator.reversed();
        }
        return comparator;
    }


    public static class LongFieldComparator implements Comparator<ContactCRSGDTO> {

        private final String field;

        public LongFieldComparator(String field){
            this.field = field;
        }

        @Override
        public int compare(ContactCRSGDTO c1, ContactCRSGDTO c2) {
            Long field1, field2;
            switch (field){
                case ID_FIELD:
                    field1 = c1.getId();
                    field2 = c2.getId();
                    break;
                case EXTERNAL_ID_FIELD:
                    field1 = c1.getExternalId();
                    field2 = c2.getExternalId();
                    break;
                case PHONE_NUMBER_VALIDATED_FIELD:
                    field1 = c1.getPhoneNumberValidated();
                    field2 = c2.getPhoneNumberValidated();
                    break;
                case MAIL_VALIDATED_FIELD:
                    field1 = c1.getMailValidated();
                    field2 = c2.getMailValidated();
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            // null last
            if(null == field1) {
                return null == field2 ? 0 : 1;
            }
            else if(null == field2) {
                return -1;
            }
            return field1.compareTo(field2);
        }
    }

    public static class StringFieldComparator implements Comparator<ContactCRSGDTO> {

        private final String field;

        public StringFieldComparator(String field){
            this.field = field;
        }

        @Override
        public int compare(ContactCRSGDTO c1, ContactCRSGDTO c2) {
            String field1, field2;
            switch (field){
                case ADDRESS_FIELD:
                    field1 = c1.getAddress();
                    field2 = c2.getAddress();
                    break;
                case STREET_FIELD:
                    field1 = c1.getStreet();
                    field2 = c2.getStreet();
                    break;
                case HOUSE_FIELD:
                    field1 = c1.getHouse();
                    field2 = c2.getHouse();
                    break;
                case CITY_FIELD:
                    field1 = c1.getCity();
                    field2 = c2.getCity();
                    break;
                case F_NAME_FIELD:
                    field1 = c1.getfName();
                    field2 = c2.getfName();
                    break;
                case NAME_FIELD:
                    field1 = c1.getName();
                    field2 = c2.getName();
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            // null last
            if(null == field1) {
                return null == field2 ? 0 : 1;
            }
            else if(null == field2) {
                return -1;
            }
            return field1.compareTo(field2);
        }
    }

    public static class DateFieldComparator implements Comparator<ContactCRSGDTO> {

        private final String field;

        public DateFieldComparator(String field){
            this.field = field;
        }

        @Override
        public int compare(ContactCRSGDTO c1, ContactCRSGDTO c2) {
            Date field1, field2;
            switch (field){
                case BIRTH_DATE_FIELD:
                    field1 = c1.getBirthDate();
                    field2 = c2.getBirthDate();
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            // null last
            if(null == field1) {
                return null == field2 ? 0 : 1;
            }
            else if(null == field2) {
                return -1;
            }
            return field1.compareTo(field2);
        }
    }

}
