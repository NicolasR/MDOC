package domain;

/**
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 * Conctact de type Entreprise
 */
public class Entreprise extends Contact {
	
	/**
	 * Numéro SIRET
	 */
	private Integer NumSiret;
	
	
	/**
	 * Constructeur
	 */
	public Entreprise() {
		super();
	}

	/**
	 * Renvoie le numéro SIRET
	 * @return le numéro SIRET
	 */
	public Integer getNumSiret() {
		return NumSiret;
	}

	/**
	 * Définie le numéro SIRET
	 * @param numSiret le nouveau numéro SIRET
	 */
	public void setNumSiret(Integer numSiret) {
		NumSiret = numSiret;
	}

}
