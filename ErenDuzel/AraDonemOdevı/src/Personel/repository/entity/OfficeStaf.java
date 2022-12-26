package Personel.repository.entity;

public class OfficeStaf extends Personal {

	private int cubicNumber;

	public OfficeStaf(int cubicNumber) {
		super();
		this.cubicNumber = cubicNumber;
	}

	public int getCubicNumber() {
		return cubicNumber;
	}

	public void setCubicNumber(int cubicNumber) {
		this.cubicNumber = cubicNumber;
	}

	@Override
	public String toString() {
		return "OfficeStaf [cubicNumber=" + cubicNumber + ", getCubicNumber()=" + getCubicNumber() + ", getId()="
				+ getId() + ", getName()=" + getName() + ", getSurname()=" + getSurname() + ", getWage()=" + getWage()
				+ ", getAge()=" + getAge() + ", getStartingDate()=" + getStartingDate() + ", getDeparment()="
				+ getDeparment() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
}
