package Personel.repository.entity;

public class Manager extends Personal{
	
	private boolean womanorMan;

	public boolean isWomanorMan() {
		return womanorMan;
	}

	public void setWomanorMan(boolean womanorMan) {
		this.womanorMan = womanorMan;
	}

	public Manager(boolean womanorMan) {
		super();
		this.womanorMan = womanorMan;
	}

	@Override
	public String toString() {
		return "Manager [womanorMan=" + womanorMan + ", isWomanorMan()=" + isWomanorMan() + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getSurname()=" + getSurname() + ", getWage()=" + getWage()
				+ ", getAge()=" + getAge() + ", getStartingDate()=" + getStartingDate() + ", getDeparment()="
				+ getDeparment() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
