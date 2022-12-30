package Personel.repository.entity;

import Personel.Utility.Utility;

public class BaseEntity {
	Long id;
	Long createDate;
	Long updateDate;
	int state;

	public BaseEntity() {
		this.id = Utility.createID();
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
