package com.volkangenel.odev.repository.entity;

public class BaseEntity {

    Long createDate;
    Long updateDate;
    boolean isActive;
    int state;

    public BaseEntity() {
        createDate = System.currentTimeMillis();
        updateDate = System.currentTimeMillis();
    }

    public BaseEntity(Long createDate, Long updateDate, boolean isActive, int state) {
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.isActive = isActive;
        this.state = state;
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
        isActive = active;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}
