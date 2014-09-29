package model;


public class Account {

    private Integer Id;
    private Integer customerId;
    private Integer addressId;
    private String username;
    private String password;
    private String createdDate;

    public Account(Integer Id, Integer customerId, Integer addressId, String username, String password, String createdDate) throws IllegalArgumentException{
        this.setId(Id);
        this.setCustomerId(customerId);
        this.setAddressId(addressId);
        this.setUsername(username);
        this.setPassword(password);
        this.setCreatedDate(createdDate);
    }

    public Account(Integer customerId, Integer addressId, String username, String password, String createdDate) throws IllegalArgumentException{
        this.setCustomerId(customerId);
        this.setAddressId(addressId);
        this.setUsername(username);
        this.setPassword(password);
        this.setCreatedDate(createdDate);
    }

    public Integer getId() {
        return Id;
    }

    private void setId(Integer Id) {
        if ((Id == null) || (Id < 0)) {
            throw new IllegalArgumentException("Id must be positive");
        }
        this.Id = Id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        if ((customerId == null) || (customerId < 0)) {
            throw new IllegalArgumentException("customerId must be positive");
        }
        this.customerId = customerId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        if ((addressId == null) || (addressId < 0)) {
            throw new IllegalArgumentException("addressId must be positive");
        }
        this.addressId = addressId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if ((username == null) || username.equals("") || (username.length() > 50)) {
            throw new IllegalArgumentException("username must be between 1 and 50 characters");
        }
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if ((password == null) || password.equals("") || (password.length() > 50)) {
            throw new IllegalArgumentException("password must be between 1 and 50 characters");
        }
        this.password = password;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        if ((createdDate == null) || createdDate.equals("") || (!createdDate.matches("^\\d{4}\\-\\d{2}\\-\\d{2}$"))) {
            throw new IllegalArgumentException("createdDate must be in format YYYY-MM-DD");
        }
        this.createdDate = createdDate;
    }
}
