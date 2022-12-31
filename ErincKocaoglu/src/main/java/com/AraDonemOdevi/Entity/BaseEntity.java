package com.AraDonemOdevi.Entity;

import static com.AraDonemOdevi.Utility.PersonelUtility.*;

public class BaseEntity {

    Long id;
    Long createDate;
    Long updateDate;
    boolean isActive;
    int state;

    public BaseEntity() {
        this.id=idOlustur();
        this.createDate = System.currentTimeMillis();
        this.updateDate = System.currentTimeMillis();
    }

    public BaseEntity(Long id, Long createDate, Long updateDate, boolean isActive, int state) {
        super();
        this.id = idOlustur();
        this.createDate = System.currentTimeMillis();
        this.updateDate = System.currentTimeMillis();
        this.isActive = isActive;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Long getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Long updateDate) {
        this.updateDate = updateDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
