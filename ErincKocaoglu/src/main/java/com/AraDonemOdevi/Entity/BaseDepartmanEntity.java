package com.AraDonemOdevi.Entity;


public class BaseDepartmanEntity {

    Long createDate;
    Long updateDate;
    boolean isActive;
    int state;

    public BaseDepartmanEntity() {
        this.createDate = System.currentTimeMillis();
        this.updateDate = System.currentTimeMillis();
    }

    public BaseDepartmanEntity(Long id, Long createDate, Long updateDate, boolean isActive, int state) {
        super();
        this.createDate = System.currentTimeMillis();
        this.updateDate = System.currentTimeMillis();
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
        this.isActive = active;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
