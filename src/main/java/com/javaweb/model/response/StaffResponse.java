package com.javaweb.model.response;

public class StaffResponse {
    private Integer id;
    private String fullName;
    private String checked;

    public StaffResponse(Integer id, String fullName, String checked){
        this.id = id;
        this.fullName = fullName;
        this.checked = checked;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }
}
