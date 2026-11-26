package entities;

/**
 * Représente un client de la banque.
 */
public class Client {


	// =========================
    // ATTRIBUTS
    // =========================
	
	private int id;
    private String firstName;
    private String lastName;
    
    // =========================
    // CONSTRUCTEUR
    // =========================    
    
    public Client(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
    
    // =========================
    // ACCESSEURS
    // =========================
    
	public int getId() {
		return id;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	// =========================
    // MÉTHODES
    // =========================
	
    @Override
	public String toString() {
		return "Client [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
