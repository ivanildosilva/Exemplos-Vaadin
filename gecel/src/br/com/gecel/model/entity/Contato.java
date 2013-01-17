/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gecel.model.entity;

/**
 *
 * @author Ivanildo
 */
public class Contato {

    private String telefoneFixo;
    private String celular;
    private String email;
    private Participante participante;

    public Contato(String telefoneFixo, String celular, String email, Participante participante) {
        this.telefoneFixo = telefoneFixo;
        this.celular = celular;
        this.email = email;
        this.participante = participante;
    }

    public Contato(String telefoneFixo, String celular, String email) {
        this.telefoneFixo = telefoneFixo;
        this.celular = celular;
        this.email = email;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.telefoneFixo != null ? this.telefoneFixo.hashCode() : 0);
        hash = 97 * hash + (this.celular != null ? this.celular.hashCode() : 0);
        hash = 97 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 97 * hash + (this.participante != null ? this.participante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contato other = (Contato) obj;
        return true;
    }

    

    @Override
    public String toString() {
        return "Contato{" + "telefoneFixo=" + telefoneFixo
                + ", celeular=" + celular
                + ", email=" + email + ", participante=" + participante + '}';
    }
}
