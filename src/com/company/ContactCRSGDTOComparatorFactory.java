package com.company;

import java.util.*;
import java.util.stream.Stream;

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
    public static final String ENTITY_TYPE_VO_ID_FIELD = "entityTypeVO.id";
    public static final String ENTITY_TYPE_VO_DESC_FIELD = "entityTypeVO.desc";
    public static final String IDENTIFIERS_ID_TYPE_FIELD = "identifiers.idType";
    public static final String IDENTIFIERS_ID_VALUE_FIELD = "identifiers.idValue";

    public static Comparator<ContactCRSGDTO> getComparator(String compareByField, boolean ascending) {
        Comparator<ContactCRSGDTO> comparator;
        switch (compareByField) {
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
                comparator = new DateFieldComparator();
                break;
            case ENTITY_TYPE_VO_ID_FIELD:
            case ENTITY_TYPE_VO_DESC_FIELD:
                comparator = new EntityTypeVOComparator(compareByField);
                break;
            case IDENTIFIERS_ID_TYPE_FIELD:
            case IDENTIFIERS_ID_VALUE_FIELD:
                comparator = new IdentifiersComparator(compareByField, ascending);
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

        public LongFieldComparator(String field) {
            this.field = field;
        }

        @Override
        public int compare(ContactCRSGDTO c1, ContactCRSGDTO c2) {
            Long field1, field2;
            switch (field) {
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
            return compareNullable(field1, field2);
        }
    }

    public static class StringFieldComparator implements Comparator<ContactCRSGDTO> {

        private final String field;

        public StringFieldComparator(String field) {
            this.field = field;
        }

        @Override
        public int compare(ContactCRSGDTO c1, ContactCRSGDTO c2) {
            String field1, field2;
            switch (field) {
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
            return compareNullable(field1, field2);
        }
    }

    public static class DateFieldComparator implements Comparator<ContactCRSGDTO> {

        @Override
        public int compare(ContactCRSGDTO c1, ContactCRSGDTO c2) {
            Date field1 = c1.getBirthDate();
            Date field2 = c2.getBirthDate();
            return compareNullable(field1, field2);
        }
    }

    public static class EntityTypeVOComparator implements Comparator<ContactCRSGDTO> {

        private final String field;

        public EntityTypeVOComparator(String field) {
            this.field = field;
        }

        @Override
        public int compare(ContactCRSGDTO c1, ContactCRSGDTO c2) {
            EntityTypeCRSGDTO entityTypeVO1 = c1.getEntityTypeVO();
            EntityTypeCRSGDTO entityTypeVO2 = c2.getEntityTypeVO();
            return compareWithNulls(entityTypeVO1, entityTypeVO2).orElseGet(() -> {
                switch (field) {
                    case ENTITY_TYPE_VO_ID_FIELD:
                        Long id1 = entityTypeVO1.getId();
                        Long id2 = entityTypeVO2.getId();
                        return compareNullable(id1, id2);
                    case ENTITY_TYPE_VO_DESC_FIELD:
                        String desc1 = entityTypeVO1.getDesc();
                        String desc2 = entityTypeVO2.getDesc();
                        return compareNullable(desc1, desc2);
                    default:
                        throw new IllegalArgumentException();
                }
            });
        }
    }

    public static class IdentifiersComparator implements Comparator<ContactCRSGDTO> {

        private final String field;
        private final boolean ascending;

        public IdentifiersComparator(String field, boolean ascending) {
            this.field = field;
            this.ascending = ascending;
        }

        @Override
        public int compare(ContactCRSGDTO c1, ContactCRSGDTO c2) {
            List<IdentifierCRSGDTO> identifiers1 = c1.getIdentifiers();
            List<IdentifierCRSGDTO> identifiers2 = c2.getIdentifiers();
            return compareWithNullsOrEmptyCollection(identifiers1, identifiers2).orElseGet(() -> {
                switch (field) {
                    case IDENTIFIERS_ID_TYPE_FIELD:
                        Optional<Long> idType1 = findMinOrMaxIdType(identifiers1, ascending);
                        Optional<Long> idType2 = findMinOrMaxIdType(identifiers2, ascending);
                        return compareNullable(idType1.orElse(null), idType2.orElse(null));
                    case IDENTIFIERS_ID_VALUE_FIELD:
                        Optional<String> idValue1 = findMinOrMaxIdValue(identifiers1, ascending);
                        Optional<String> idValue2 = findMinOrMaxIdValue(identifiers2, ascending);
                        return compareNullable(idValue1.orElse(null), idValue2.orElse(null));
                    default:
                        throw new IllegalArgumentException();
                }
            });
        }

        private Optional<Long> findMinOrMaxIdType(List<IdentifierCRSGDTO> identifiers, boolean ascending) {
            Stream<Long> idTypes = identifiers.stream()
                    .filter(Objects::nonNull)
                    .map(IdentifierCRSGDTO::getIdType)
                    .filter(Objects::nonNull);
            return ascending ? idTypes.min(Long::compareTo) : idTypes.max(Long::compareTo);
        }

        private Optional<String> findMinOrMaxIdValue(List<IdentifierCRSGDTO> identifiers, boolean ascending) {
            Stream<String> idValues = identifiers.stream()
                    .filter(Objects::nonNull)
                    .map(IdentifierCRSGDTO::getIdValue)
                    .filter(Objects::nonNull);
            return ascending ? idValues.min(String::compareTo) : idValues.max(String::compareTo);
        }
    }

    private static <T extends Comparable<T>> int compareNullable(T field1, T field2) {
        return compareWithNulls(field1, field2).orElseGet(() -> field1.compareTo(field2));
    }

    private static <T> Optional<Integer> compareWithNulls(T field1, T field2) {
        // null last
        Optional<Integer> result = Optional.empty();
        if (null == field1) {
            result = null == field2 ? Optional.of(0) : Optional.of(1);
        } else if (null == field2) {
            result = Optional.of(-1);
        }
        return result;
    }

    private static <U, T extends Collection<U>> Optional<Integer> compareWithNullsOrEmptyCollection(T col1, T col2) {
        // null or empty collection last
        Optional<Integer> result = Optional.empty();
        if (null == col1 || col1.isEmpty()) {
            result = (null == col2 || col2.isEmpty()) ? Optional.of(0) : Optional.of(1);
        } else if (null == col2 || col2.isEmpty()) {
            result = Optional.of(-1);
        }
        return result;
    }
}
