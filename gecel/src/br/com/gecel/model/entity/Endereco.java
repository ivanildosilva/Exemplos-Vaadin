/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gecel.model.entity;

/**
 *
 * @author Ivanildo
 */
public class Endereco {

    private int id;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private int cep;
    private String complemento;
    private String uf;
    private Participante participante;

    public Endereco(String logradouro, String numero, String bairro,
            String cidade, int cep, String complemento,String uf) {

        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.complemento = complemento;
        this.uf = uf;
    }

    public Endereco(String logradouro, String numero, String bairro,
            String cidade, int cep, String complemento, String uf, Participante participante) {

        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.complemento = complemento;
        this.uf = uf;
        this.participante = participante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
        hash = 59 * hash + (this.logradouro != null ? this.logradouro.hashCode() : 0);
        hash = 59 * hash + (this.numero != null ? this.numero.hashCode() : 0);
        hash = 59 * hash + (this.bairro != null ? this.bairro.hashCode() : 0);
        hash = 59 * hash + (this.cidade != null ? this.cidade.hashCode() : 0);
        hash = 59 * hash + this.cep;
        hash = 59 * hash + (this.uf != null ? this.uf.hashCode() : 0);
        hash = 59 * hash + (this.complemento != null ? this.complemento.hashCode() : 0);
        hash = 59 * hash + (this.participante != null ? this.participante.hashCode() : 0);
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
        final Endereco other = (Endereco) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.logradouro == null) ? (other.logradouro != null)
                : !this.logradouro.equals(other.logradouro)) {
            return false;
        }
        if ((this.numero == null) ? (other.numero != null)
                : !this.numero.equals(other.numero)) {
            return false;
        }
        if ((this.bairro == null) ? (other.bairro != null)
                : !this.bairro.equals(other.bairro)) {
            return false;
        }
        if ((this.cidade == null) ? (other.cidade != null)
                : !this.cidade.equals(other.cidade)) {
            return false;
        }
        if (this.cep != other.cep) {
            return false;
        }
        if ((this.uf == null) ? (other.uf != null) : !this.uf.equals(other.uf)) {
            return false;
        }
        if ((this.complemento == null) ? (other.complemento != null)
                : !this.complemento.equals(other.complemento)) {
            return false;
        }
        if (this.participante != other.participante && (this.participante == null
                || !this.participante.equals(other.participante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", logradouro=" + logradouro
                + ", numero=" + numero + ", bairro=" + bairro
                + ", cidade=" + cidade + ", cep=" + cep + ", uf=" + uf
                + ", complemento=" + complemento + ", participante=" + participante + '}';
    }
}
