package model;

public class Address {

    private Integer Id;
    private Integer customerId;
    private Integer typeId;
    private String firstLine;
    private String secondLine;
    private String thirdLine;
    private String postcode;

    public Address(Integer customerId, Integer typeId, String firstLine, String secondLine, String thirdLine, String postcode) throws IllegalArgumentException {
        this.setCustomerId(customerId);
        this.setTypeId(typeId);
        this.setFirstLine(firstLine);
        this.setSecondLine(secondLine);
        this.setThirdLine(thirdLine);
        this.setPostcode(postcode);
    }

    public Address(Integer Id, Integer customerId, Integer typeId, String firstLine, String secondLine, String thirdLine, String postcode) throws IllegalArgumentException {
        this.setId(Id);
        this.setCustomerId(customerId);
        this.setTypeId(typeId);
        this.setFirstLine(firstLine);
        this.setSecondLine(secondLine);
        this.setThirdLine(thirdLine);
        this.setPostcode(postcode);
    }

    public Integer getId() {
        return Id;
    }

    private void setId(Integer Id) {
        if ((Id == null) || (Id < 0)) {
            throw new IllegalArgumentException("Id must not be less than 0");
        }
        this.Id = Id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        if ((customerId == null) || (customerId < 0)) {
            throw new IllegalArgumentException("customerId must be less than 0");
        }
        this.customerId = customerId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        if ((typeId == null) || (typeId < 0)) {
            throw new IllegalArgumentException("typeId must not be less than 0");
        }
        this.typeId = typeId;
    }

    public String getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(String firstLine) {
        if ((firstLine == null) || firstLine.equals("") || (firstLine.length() > 200)) {
            throw new IllegalArgumentException("firstLine must be between 1 and 200 characters");
        }
        this.firstLine = firstLine;
    }

    public String getSecondLine() {
        return secondLine;
    }

    public void setSecondLine(String secondLine) {
        if ((secondLine != null) && (secondLine.length() > 200)) {
            throw new IllegalArgumentException("secondLine must be between 1 and 200 characters");
        }
        this.secondLine = secondLine;
    }

    public String getThirdLine() {
        return thirdLine;
    }

    public void setThirdLine(String thirdLine) {
        if ((thirdLine != null) && (thirdLine.length() > 200)) {
            throw new IllegalArgumentException("thirdLine must be between 1 and 200 characters");
        }
        this.thirdLine = thirdLine;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        if ((postcode == null) || postcode.equals("") || (postcode.length() > 9)) {
            throw new IllegalArgumentException("postcode must be between 1 and 9 characters");
        }
        this.postcode = postcode;
    }
}
