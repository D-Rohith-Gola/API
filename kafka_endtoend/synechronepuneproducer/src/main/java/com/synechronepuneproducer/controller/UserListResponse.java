package com.synechronepuneproducer.controller;

import jakarta.xml.bind.annotation.*;
import java.util.List;

import com.synechronepuneproducer.entity.Employee;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserListResponse {

    @XmlElement(name = "user")
    private List<Employee> users;

    public UserListResponse() {}

    public UserListResponse(List<Employee> users) {
        this.users = users;
    }

    public List<Employee> getUsers() {
        return users;
    }

    public void setUsers(List<Employee> users) {
        this.users = users;
    }
}
