package Personel.repository.entity;

public class TechnicalPersonal extends Personal{

	private boolean extraWorkHours;

	public boolean isExtraWorkHours() {
		return extraWorkHours;
	}

	public void setExtraWorkHours(boolean extraWorkHours) {
		this.extraWorkHours = extraWorkHours;
	}

	public TechnicalPersonal(boolean extraWorkHours) {
		super();
		this.extraWorkHours = extraWorkHours;
	}

	@Override
	public String toString() {
		return "TechnicalPersonal [extraWorkHours=" + extraWorkHours + ", isExtraWorkHours()=" + isExtraWorkHours()
				+ ", getId()=" + getId() + ", getName()=" + getName() + ", getSurname()=" + getSurname()
				+ ", getWage()=" + getWage() + ", getAge()=" + getAge() + ", getStartingDate()=" + getStartingDate()
				+ ", getDeparment()=" + getDeparment() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}
