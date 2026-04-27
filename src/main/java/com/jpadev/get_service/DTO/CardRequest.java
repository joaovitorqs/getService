package com.jpadev.get_service.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CardRequest {

    @NotBlank(message = "Name not blank.")
    @Size(max = 100)
    private String nameClient;

    @NotBlank(message = "Contact not blank.")
    @Pattern(regexp = "\\d{11}", message = "Contact information must contain 11 digits.")
    private String contact;

    @NotBlank(message = "Title not blank.")
    @Size(max = 120)
    private String title;

    @NotBlank(message = "Description not blank.")
    @Size(max = 500)
    private String description;

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
