package connector;

public class Profile {
	private PersonalInformation personInf = new PersonalInformation();
	private OwnerInformation ownerInf = new OwnerInformation();
	private Vehicle vechicleInfo = new Vehicle();
	private Address addressInf = new Address();
	private Crime crimeInf = new Crime();
	
	public Profile() {};
	
	public Profile(PersonalInformation personInf, OwnerInformation ownerInf, Vehicle vechicleInfo, Address addressInf, Crime crimeInf) {
		super();
		this.personInf = personInf;
		this.ownerInf = ownerInf;
		this.vechicleInfo = vechicleInfo;
		this.addressInf = addressInf;
		this.crimeInf = crimeInf;
	}

	public PersonalInformation getPersonInf() {
		return personInf;
	}

	public void setPersonInf(PersonalInformation personInf) {
		this.personInf = personInf;
	}

	public OwnerInformation getOwnerInf() {
		return ownerInf;
	}

	public void setOwnerInf(OwnerInformation ownerInf) {
		this.ownerInf = ownerInf;
	}

	public Vehicle getVechicleInfo() {
		return vechicleInfo;
	}

	public void setVechicleInfo(Vehicle vechicleInfo) {
		this.vechicleInfo = vechicleInfo;
	}

	public Address getAddressInf() {
		return addressInf;
	}

	public void setAddressInf(Address addressInf) {
		this.addressInf = addressInf;
	}

	public Crime getCrimeInf() {
		return crimeInf;
	}

	public void setCrimeInf(Crime crimeInf) {
		this.crimeInf = crimeInf;
	}
	
}
