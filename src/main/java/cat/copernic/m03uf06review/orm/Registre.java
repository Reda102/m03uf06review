/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.m03uf06review.orm;

import java.util.Objects;

/**
 *
 * @author Reda
 */
public class Registre {
    private int id;
    private String dni;
    private String nom;
    private String cognoms;
    private double matricula;
    private String data_naixement;
    private String familia_nombrosa;
    private String mayor_edad;

    public Registre(int id, String dni, String nom, String cognoms, double matricula, String data_naixement, String familia_nombrosa, String mayor_edad) {
        this.id = id;
        this.dni = dni;
        this.nom = nom;
        this.cognoms = cognoms;
        this.matricula = matricula;
        this.data_naixement = data_naixement;
        this.familia_nombrosa = familia_nombrosa;
        this.mayor_edad = mayor_edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public double getMatricula() {
        return matricula;
    }

    public void setMatricula(double matricula) {
        this.matricula = matricula;
    }

    public String getData_naixement() {
        return data_naixement;
    }

    public void setData_naixement(String data_naixement) {
        this.data_naixement = data_naixement;
    }

    public String getFamilia_nombrosa() {
        return familia_nombrosa;
    }

    public void setFamilia_nombrosa(String familia_nombrosa) {
        this.familia_nombrosa = familia_nombrosa;
    }

    public String getMayor_edad() {
        return mayor_edad;
    }

    public void setMayor_edad(String mayor_edad) {
        this.mayor_edad = mayor_edad;
    }

    @Override
    public String toString() {
        return "Registre{" + "id=" + id + ", dni=" + dni + ", nom=" + nom + ", cognoms=" + cognoms + ", matricula=" + matricula + ", data_naixement=" + data_naixement + ", familia_nombrosa=" + familia_nombrosa + ", mayor_edad=" + mayor_edad + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.id;
        hash = 19 * hash + Objects.hashCode(this.dni);
        hash = 19 * hash + Objects.hashCode(this.nom);
        hash = 19 * hash + Objects.hashCode(this.cognoms);
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.matricula) ^ (Double.doubleToLongBits(this.matricula) >>> 32));
        hash = 19 * hash + Objects.hashCode(this.data_naixement);
        hash = 19 * hash + Objects.hashCode(this.familia_nombrosa);
        hash = 19 * hash + Objects.hashCode(this.mayor_edad);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Registre other = (Registre) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.matricula) != Double.doubleToLongBits(other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.cognoms, other.cognoms)) {
            return false;
        }
        if (!Objects.equals(this.data_naixement, other.data_naixement)) {
            return false;
        }
        if (!Objects.equals(this.familia_nombrosa, other.familia_nombrosa)) {
            return false;
        }
        if (!Objects.equals(this.mayor_edad, other.mayor_edad)) {
            return false;
        }
        return true;
    }
    
}
