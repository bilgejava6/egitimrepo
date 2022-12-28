package com.aliulas.repository.entity;

import com.aliulas.utility.StaticValues;

public abstract class BaseEntity {

        Long id;
        Long createDate;
        Long updateDate;

        boolean isActive;
        int state;// 1- silinmiş ,2 dondurulmuş

        public BaseEntity() {
            this.id = StaticValues.idOlustur();
            createDate = System.currentTimeMillis();
            updateDate = System.currentTimeMillis();
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

        public boolean isIsactive() {
            return isActive;
        }

        public void setIsactive(boolean isactive) {
            this.isActive = isactive;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }
    }

