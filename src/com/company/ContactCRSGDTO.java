package com.company;

import java.util.Date;
import java.util.List;

public class ContactCRSGDTO {

    private String address;
    private String street;
    private String house;
    private String city;
    private Date birthDate;
    private String fName;
    private String name;
    private List<IdentifierCRSGDTO> identifiers;
    private EntityTypeCRSGDTO entityTypeVO;
    private Long phoneNumberValidated;
    private Long mailValidated;
    private Long id;
    private Long externalId;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IdentifierCRSGDTO> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(List<IdentifierCRSGDTO> identifiers) {
        this.identifiers = identifiers;
    }

    public EntityTypeCRSGDTO getEntityTypeVO() {
        return entityTypeVO;
    }

    public void setEntityTypeVO(EntityTypeCRSGDTO entityTypeVO) {
        this.entityTypeVO = entityTypeVO;
    }

    public Long getPhoneNumberValidated() {
        return phoneNumberValidated;
    }

    public void setPhoneNumberValidated(Long phoneNumberValidated) {
        this.phoneNumberValidated = phoneNumberValidated;
    }

    public Long getMailValidated() {
        return mailValidated;
    }

    public void setMailValidated(Long mailValidated) {
        this.mailValidated = mailValidated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExternalId() {
        return externalId;
    }

    public void setExternalId(Long externalId) {
        this.externalId = externalId;
    }

    @Override
    public String toString() {
        return "ContactCRSGDTO{" +
                "address='" + address + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", city='" + city + '\'' +
                ", birthDate=" + birthDate +
                ", fName='" + fName + '\'' +
                ", name='" + name + '\'' +
                ", identifiers=" + identifiers +
                ", entityTypeVO=" + entityTypeVO +
                ", phoneNumberValidated=" + phoneNumberValidated +
                ", mailValidated=" + mailValidated +
                ", id=" + id +
                ", externalId=" + externalId +
                "}\n";
    }
}
