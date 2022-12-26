package Personel.repository.entity;

public class Servant extends Personal{

	private String dressCode;
	

	public Servant(String dressCode) {
		super();
		this.dressCode = dressCode;
	}

	public String getDressCode() {
		return dressCode;
	}

	public void setDressCode(String dressCode) {
		this.dressCode = dressCode;
	}

	@Override
	public String toString() {
		return "Servant [dressCode=" + dressCode + ", getDressCode()=" + getDressCode() + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getSurname()=" + getSurname() + ", getWage()=" + getWage()
				+ ", getAge()=" + getAge() + ", getStartingDate()=" + getStartingDate() + ", getDeparment()="
				+ getDeparment() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
