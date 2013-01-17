/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gecel.model.entity;

/**
 *
 * @author Ivanildo
 */
public class Privilegio {

  private int id;
  private String descricao;

  public Privilegio(int id, String descricao) {
    this.id = id;
    this.descricao = descricao;
  }

  public Privilegio(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 53 * hash + this.id;
    hash = 53 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
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
    final Privilegio other = (Privilegio) obj;
    if (this.id != other.id) {
      return false;
    }
    if ((this.descricao == null) ? (other.descricao != null)
            : !this.descricao.equals(other.descricao)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Privilegio{" + "id=" + id + ", descricao=" + descricao + '}';
  }
}
