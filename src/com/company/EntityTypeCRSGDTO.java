package com.company;

public class EntityTypeCRSGDTO implements Comparable<EntityTypeCRSGDTO> {

    private Long id;
    private String desc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public int compareTo(EntityTypeCRSGDTO other) {
        if (other == null || getId() == null) {
            return -1;
        } else {
            return Long.compare(getId(), other.getId());
        }
    }

    @Override
    public String toString() {
        return "EntityTypeCRSGDTO{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                '}';
    }
}
