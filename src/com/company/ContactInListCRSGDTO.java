package com.company;

import java.util.List;

public class ContactInListCRSGDTO {

    private List<ContactCRSGDTO> contactInListVO;
    private Long totalNumberOfRows;

    public List<ContactCRSGDTO> getContactInListVO() {
        return contactInListVO;
    }

    public void setContactInListVO(List<ContactCRSGDTO> contactInListVO) {
        this.contactInListVO = contactInListVO;
    }

    public Long getTotalNumberOfRows() {
        return totalNumberOfRows;
    }

    public void setTotalNumberOfRows(Long totalNumberOfRows) {
        this.totalNumberOfRows = totalNumberOfRows;
    }
}
