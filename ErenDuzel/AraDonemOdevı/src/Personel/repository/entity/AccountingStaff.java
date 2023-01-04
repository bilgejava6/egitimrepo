package Personel.repository.entity;

public class AccountingStaff extends Personal{

	private boolean permissionToAllAccounts;

	public boolean isPermissionToAllAccounts() {
		return permissionToAllAccounts;
	}

	public void setPermissionToAllAccounts(boolean permissionToAllAccounts) {
		this.permissionToAllAccounts = permissionToAllAccounts;
	}

	public AccountingStaff(boolean permissionToAllAccounts) {
		super();
		this.permissionToAllAccounts = permissionToAllAccounts;
	}

	@Override
	public String toString() {
		return "AccountingStaff [permissionToAllAccounts=" + permissionToAllAccounts + ", isPermissionToAllAccounts()="
				+ isPermissionToAllAccounts() + ", getId()=" + getId() + ", getName()=" + getName() + ", getSurname()="
				+ getSurname() + ", getWage()=" + getWage() + ", getAge()=" + getAge() + ", getStartingDate()="
				+ getStartingDate() + ", getDeparment()=" + getDeparment() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
}
