package model;

public class AddressType {

    private Integer Id;
    private String description;

    public AddressType(Integer Id, String description) {
        this.setId(Id);
        this.setDescription(description);
    }

    public AddressType(String description) {
        this.setDescription(description);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if ((description != null) && (description.length() > 200)) {
            throw new IllegalArgumentException("description must be between 1 and 200 characters");
        }
        this.description = description;
    }
}
