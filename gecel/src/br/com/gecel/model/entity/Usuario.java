/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gecel.model.entity;

/**
 *
 * @author Ivanildo
 */
public class Usuario {

  private int id;
  private String login;
  private String senha;
  private int ativo;
  private String nome;
  private String foto;
  private Privilegio privilegio;

  public Usuario(String nome, String login, String senha,
          String foto, int ativo, Privilegio privilegio) {
    this.nome = nome;
    this.login = login;
    this.senha = senha;
    this.foto = foto;
    this.ativo = ativo;
    this.privilegio = privilegio;
  }

  public Usuario(int id, String login, String senha, int ativo, Privilegio privilegio) {
    this.id = id;
    this.login = login;
    this.senha = senha;
    this.ativo = ativo;
    this.privilegio = privilegio;
  }

  public Usuario() {
  }

  public Usuario(String nome, String foto) {

    this.nome = nome;
    this.foto = foto;

  }

  public Usuario(int id, String nome, String foto) {

    this.id = id;
    this.nome = nome;
    this.foto = foto;

  }

  public Usuario(int id) {
    this.id = id;

  }

  public Usuario(String nome) {
    this.nome = nome;

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public int getAtivo() {
    return ativo;
  }

  public void setAtivo(int ativo) {
    this.ativo = ativo;
  }

  public Privilegio getPrivilegio() {
    return privilegio;
  }

  public void setPrivilegio(Privilegio privilegio) {
    this.privilegio = privilegio;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getFoto() {
    return foto;
  }

  public void setFoto(String foto) {
    this.foto = foto;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 41 * hash + this.id;
    hash = 41 * hash + (this.login != null ? this.login.hashCode() : 0);
    hash = 41 * hash + (this.senha != null ? this.senha.hashCode() : 0);
    hash = 41 * hash + this.ativo;
    hash = 41 * hash + (this.nome != null ? this.nome.hashCode() : 0);
    hash = 41 * hash + (this.foto != null ? this.foto.hashCode() : 0);
    hash = 41 * hash + (this.privilegio != null ? this.privilegio.hashCode() : 0);
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
    final Usuario other = (Usuario) obj;
    if (this.id != other.id) {
      return false;
    }
    if ((this.login == null) ? (other.login != null) : !this.login.equals(other.login)) {
      return false;
    }
    if ((this.senha == null) ? (other.senha != null) : !this.senha.equals(other.senha)) {
      return false;
    }
    if (this.ativo != other.ativo) {
      return false;
    }
    if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
      return false;
    }
    if ((this.foto == null) ? (other.foto != null) : !this.foto.equals(other.foto)) {
      return false;
    }
    if (this.privilegio != other.privilegio && (this.privilegio == null || !this.privilegio.equals(other.privilegio))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Usuario{" + "id=" + id + ", login=" + login
            + ", senha=" + senha + ", ativo=" + ativo
            + ", nome=" + nome + ", foto=" + foto
            + ", privilegio=" + privilegio + '}';
  }
}
