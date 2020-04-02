package com.se211.ecommerce.dto;

import com.se211.ecommerce.entity.Client;
import com.se211.ecommerce.entity.Company;
import com.se211.ecommerce.entity.User;

public class UserDTO {
    private User user;
    private Boolean isSaved;
    private Client client;
    private Company company;


    public UserDTO() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getSaved() {
        return isSaved;
    }

    public void setSaved(Boolean saved) {
        isSaved = saved;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "user=" + user +
                ", isSaved=" + isSaved +
                ", client=" + client +
                ", company=" + company +
                '}';
    }
}
