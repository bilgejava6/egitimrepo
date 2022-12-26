package com.yavuzavci.entity;

import static com.yavuzavci.utility.StaticValues.*;

public abstract class BaseEntity {
    private Long id;
    private Long createDate;
    private Long updateDate;
    private boolean isActive;
    private int state;

    public BaseEntity(){
        id = idOlustur();
        createDate = sistemSaatiniAl();
        updateDate = sistemSaatiniAl();
    }

    public Long getId() {
        return id;
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

    /**
     * Yeni personel veya departman ID si alır.
     * @return {@code id} -> Yeni ID.
     */
    public long idOlustur(){
        switch(this.getClass().getSimpleName()){
            case "Departman":
                return yeniDepartmanIdAl();
            default:
                return yeniPersonelIdAl();
        }
    }
}
