package domain;

/**
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 * Numéro de téléphone d'un contact
 */
public class PhoneNumber {
	
	/**
	 * Identifiant du numéro de téléphone
	 */
	private Long id;
	
	/**
	 * Type de numéro 
	 */
	private String phoneKind;
	
	
	/**
	 * Numéro de téléphone
	 */
	private String phoneNumber;
	
	
	/**
	 * Contact associé au numéro
	 */
	private Contact contact;
	
	/**
	 * Constructeur
	 * @param phoneKind type de numéro
	 * @param phoneNumber le numéro de téléphone
	 */
	public PhoneNumber(String phoneKind, String phoneNumber, Contact contact) {
		super();
		//this.id = id;
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
		this.contact = contact;
	}

	/**
	 * Constructeur vide
	 */
	public PhoneNumber() {
	}

	/**
	 * Renvoie l'identifiant du numéro de téléphone
	 * @return l'identifiant du numéro
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Définie l'identifiant du numéro de téléphone
	 * @param id nouvel identifiant du numéro
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Renvoie le type du numéro de téléphone
	 * @return le type du numéro de téléphone
	 */
	public String getPhoneKind() {
		return phoneKind;
	}

	/**
	 * Définie le type du numéro de téléphone
	 * @param phoneKind le type de numéro de téléphone
	 */
	public void setPhoneKind(String phoneKind) {
		this.phoneKind = phoneKind;
	}

	/**
	 * Renvoie le numéro de téléphone
	 * @return le numéro de téléphone
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Définie le numéro de téléphone
	 * @param phoneNumber le nouveau numéro de téléphone
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Renvoie le contact associé au numéro de téléphone
	 * @return le contact associé au numéro de téléphone
	 */
	public Contact getContact() {
		return contact;
	}

	/**
	 * Définie le contact associé au numéro de téléphone
	 * @param contact le contact associé au numéro de téléphone
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
