package Personel.repository.entity;

public class HumanResources extends Personal {

	private boolean permissiontoHire;

	public HumanResources(boolean permissiontoHire) {
		super();
		this.permissiontoHire = permissiontoHire;
	}

	public boolean isPermissiontoHire() {
		return permissiontoHire;
	}

	public void setPermissiontoHire(boolean permissiontoHire) {
		this.permissiontoHire = permissiontoHire;
	}

	@Override
	public String toString() {
		return "HumanResources [permissiontoHire=" + permissiontoHire + ", isPermissiontoHire()=" + isPermissiontoHire()
				+ ", getId()=" + getId() + ", getName()=" + getName() + ", getSurname()=" + getSurname()
				+ ", getWage()=" + getWage() + ", getAge()=" + getAge() + ", getStartingDate()=" + getStartingDate()
				+ ", getDeparment()=" + getDeparment() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
}
