package Personel.repository.entity;

public class GeneralManager extends Personal{

	private boolean isTheOwnerOfCompany;

	public boolean isTheOwnerOfCompany() {
		return isTheOwnerOfCompany;
	}

	public void setTheOwnerOfCompany(boolean isTheOwnerOfCompany) {
		this.isTheOwnerOfCompany = isTheOwnerOfCompany;
	}

	public GeneralManager(boolean isTheOwnerOfCompany) {
		super();
		this.isTheOwnerOfCompany = isTheOwnerOfCompany;
	}

	@Override
	public String toString() {
		return "GeneralManager [isTheOwnerOfCompany=" + isTheOwnerOfCompany + ", isTheOwnerOfCompany()="
				+ isTheOwnerOfCompany() + ", getId()=" + getId() + ", getName()=" + getName() + ", getSurname()="
				+ getSurname() + ", getWage()=" + getWage() + ", getAge()=" + getAge() + ", getStartingDate()="
				+ getStartingDate() + ", getDeparment()=" + getDeparment() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
