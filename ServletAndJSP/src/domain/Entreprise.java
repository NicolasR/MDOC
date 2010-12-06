package domain;

public class Entreprise extends Contact {
	
	private Integer NumSiret;
	
	

	public Entreprise() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Entreprise(String firstName, String lastName, String email,
			Integer id) {
		super(firstName, lastName, email);
		// TODO Auto-generated constructor stub
	}
	
	

	public Entreprise(String firstName, String lastName, String email,
			Integer id, Integer numSiret) {
		super(firstName, lastName, email);
		NumSiret = numSiret;
	}
	
	

	public Entreprise(Integer numSiret) {
		super();
		NumSiret = numSiret;
	}

	public Integer getNumSiret() {
		return NumSiret;
	}

	public void setNumSiret(Integer numSiret) {
		NumSiret = numSiret;
	}
	
	

}
