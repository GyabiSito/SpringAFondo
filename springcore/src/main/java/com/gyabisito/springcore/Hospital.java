package com.gyabisito.springcore;

import java.util.List;

public class Hospital {
    private String nombre;
    private List<String> departments;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getDepartments() {
        return departments;
    }

    public void setDepartments(List<String> departments) {
        this.departments = departments;
    }
}
