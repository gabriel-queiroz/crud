package com.gabriel.crud.model;

import java.util.Objects;

public class CreatorItem {
    private String name;
    private String role;
    private String resourceURI;


    public CreatorItem() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatorItem creator = (CreatorItem) o;
        return Objects.equals(name, creator.name) && Objects.equals(role, creator.role) && Objects.equals(resourceURI, creator.resourceURI);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, role, resourceURI);
    }
}
