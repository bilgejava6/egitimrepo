package com.suayipgurnaz.repository.entity;

public abstract class BaseEntity {
    private Long id;
    private Long createDate;
    private Long updateDate;
    private boolean isActive;
    private int state;

    public BaseEntity() {
        this.createDate = System.currentTimeMillis();
        this.updateDate = System.currentTimeMillis();
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
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
}
