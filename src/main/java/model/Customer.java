package model;

public class Customer {
	
	private Integer Id;
	private String firstName;
	private String lastname;
	private String telephone;
	private String email;
    
    public Customer(String firstName, String lastname, String telephone, String email) throws IllegalArgumentException {
        this.setFirstName(firstName);
        this.setLastname(lastname);
        this.setTelephone(telephone);
        this.setEmail(email);
    }

    public Customer(Integer Id, String firstName, String lastname, String telephone, String email) throws IllegalArgumentException {
        this.setId(Id);
        this.setFirstName(firstName);
        this.setLastname(lastname);
        this.setTelephone(telephone);
        this.setEmail(email);
    }

	public Integer getId() {
        return this.Id;
	}

    private void setId(Integer Id) {
        if ((Id == null) || (Id < 0)) {
            throw new IllegalArgumentException("Id must be positive");
        }
        this.Id = Id;
    }

	public String getFirstName() {
        return this.firstName;
	}

    public void setFirstName(String firstName) {
        if ((firstName == null) || firstName.equals("") || (firstName.length() > 50)) {
            throw new IllegalArgumentException("firstName must be between 1 and 50 characters in length");
        }
        this.firstName = firstName;
    }

	public String getLastname() {
        return this.lastname;
	}

    public void setLastname(String lastname) {
        if ((lastname == null) || lastname.equals("") || (lastname.length() > 50)) {
            throw new IllegalArgumentException("lastname must be between 1 and 50 characters in length");
        }
        this.lastname = lastname;
    }

	public String getTelephone() {
        return this.telephone;
	}

    public void setTelephone(String telephone) {
        if ((telephone == null) || telephone.equals("") || (telephone.length() > 11)) {
            throw new IllegalArgumentException("telephone must be between 1 and 11 characters in length");
        }
        this.telephone = telephone;
    }

	public String getEmail() {
        return this.email;
	}
	
	public void setEmail(String thisEmail) {
		if ((thisEmail == null) || thisEmail.equals("") || (thisEmail.length() > 50)) {
			throw new IllegalArgumentException("email must be between 1 and 50 characters in length");
		}
		this.email = thisEmail;
	}

}
