/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gecel.model.entity;

import java.util.Date;

/**
 *
 * @author Ivanildo
 */
public class Participante {

  private int id;
  private String nome;
  private String sobreNome;
  private String sexo;
  private Date nascimento;
  private String curso;
  private String matricula;
  private String projeto;
  private String rg;
  private String cpf;
  private String observacao;
  private String foto;
  private Date cadastro;
  private Usuario criador;
  private int ativo;
  private Endereco endereco;
  private Contato contato;

  public Participante(String nome, String sobreNome, String sexo, Date nascimento,
          String curso, String matricula, String projeto, String rg, String cpf,
          String observacao, String foto, Date cadastro, Usuario criador, int ativo) {
    this.nome = nome;
    this.sobreNome = sobreNome;
    this.sexo = sexo;
    this.nascimento = nascimento;
    this.curso = curso;
    this.matricula = matricula;
    this.projeto = projeto;
    this.rg = rg;
    this.cpf = cpf;
    this.observacao = observacao;
    this.foto = foto;
    this.cadastro = cadastro;
    this.criador = criador;
    this.ativo = ativo;
  }

  public Participante(String matricula, String nome, String sobreNome, String sexo,
          Date nascimento, String curso, String projeto, String rg, String cpf,
          String observacao, String foto, Date cadastro, int ativo, Endereco endereco,
          Contato contato, Usuario criador) {
    this.matricula = matricula;
    this.nome = nome;
    this.sobreNome = sobreNome;
    this.sexo = sexo;
    this.nascimento = nascimento;
    this.curso = curso;
    this.projeto = projeto;
    this.rg = rg;
    this.cpf = cpf;
    this.observacao = observacao;
    this.foto = foto;
    this.cadastro = cadastro;
    this.ativo = ativo;
    this.endereco = endereco;
    this.contato = contato;
    this.criador = criador;
  }

  public Participante(String nome, String sobreNome, String sexo,
          Date nascimento, String curso, String projeto, String rg, String cpf,
          String observacao, Date cadastro) {
    this.nome = nome;
    this.sobreNome = sobreNome;
    this.sexo = sexo;
    this.nascimento = nascimento;
    this.curso = curso;
    this.projeto = projeto;
    this.rg = rg;
    this.cpf = cpf;
    this.observacao = observacao;
    this.cadastro = cadastro;

  }

  public Participante(String matricula) {
    this.matricula = matricula;
  }

  public Participante(int id) {
    this.id = id;
  }

  public Participante() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSobreNome() {
    return sobreNome;
  }

  public void setSobreNome(String sobreNome) {
    this.sobreNome = sobreNome;
  }

  public Date getNascimento() {
    return nascimento;
  }

  public void setNascimento(Date nascimento) {
    this.nascimento = nascimento;
  }

  public String getCurso() {
    return curso;
  }

  public void setCurso(String curso) {
    this.curso = curso;
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public String getProjeto() {
    return projeto;
  }

  public void setProjeto(String projeto) {
    this.projeto = projeto;
  }

  public String getRg() {
    return rg;
  }

  public void setRg(String rg) {
    this.rg = rg;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getFoto() {
    return foto;
  }

  public void setFoto(String foto) {
    this.foto = foto;
  }

  public Date getCadastro() {
    return cadastro;
  }

  public void setCadastro(Date cadastro) {
    this.cadastro = cadastro;
  }

  public String getObservacao() {
    return observacao;
  }

  public void setObservacao(String observacao) {
    this.observacao = observacao;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  public Contato getContato() {
    return contato;
  }

  public void setContato(Contato contato) {
    this.contato = contato;
  }

  public Usuario getCriador() {
    return criador;
  }

  public void setCriador(Usuario criador) {
    this.criador = criador;
  }

  public String getSexo() {
    return sexo;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }

  public int getAtivo() {
    return ativo;
  }

  public void setAtivo(int ativo) {
    this.ativo = ativo;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 59 * hash + this.id;
    hash = 59 * hash + (this.nome != null ? this.nome.hashCode() : 0);
    hash = 59 * hash + (this.sobreNome != null ? this.sobreNome.hashCode() : 0);
    hash = 59 * hash + (this.sexo != null ? this.sexo.hashCode() : 0);
    hash = 59 * hash + (this.nascimento != null ? this.nascimento.hashCode() : 0);
    hash = 59 * hash + (this.curso != null ? this.curso.hashCode() : 0);
    hash = 59 * hash + (this.matricula != null ? this.matricula.hashCode() : 0);
    hash = 59 * hash + (this.projeto != null ? this.projeto.hashCode() : 0);
    hash = 59 * hash + (this.rg != null ? this.rg.hashCode() : 0);
    hash = 59 * hash + (this.cpf != null ? this.cpf.hashCode() : 0);
    hash = 59 * hash + (this.observacao != null ? this.observacao.hashCode() : 0);
    hash = 59 * hash + (this.foto != null ? this.foto.hashCode() : 0);
    hash = 59 * hash + (this.cadastro != null ? this.cadastro.hashCode() : 0);
    hash = 59 * hash + (this.criador != null ? this.criador.hashCode() : 0);
    hash = 59 * hash + this.ativo;
    hash = 59 * hash + (this.endereco != null ? this.endereco.hashCode() : 0);
    hash = 59 * hash + (this.contato != null ? this.contato.hashCode() : 0);
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
    final Participante other = (Participante) obj;
    if (this.id != other.id) {
      return false;
    }
    if ((this.nome == null) ? (other.nome != null)
            : !this.nome.equals(other.nome)) {
      return false;
    }
    if ((this.sobreNome == null) ? (other.sobreNome != null)
            : !this.sobreNome.equals(other.sobreNome)) {
      return false;
    }
    if ((this.sexo == null) ? (other.sexo != null) : !this.sexo.equals(other.sexo)) {
      return false;
    }
    if (this.nascimento != other.nascimento && (this.nascimento == null
            || !this.nascimento.equals(other.nascimento))) {
      return false;
    }
    if ((this.curso == null) ? (other.curso != null) : !this.curso.equals(other.curso)) {
      return false;
    }
    if ((this.matricula == null) ? (other.matricula != null)
            : !this.matricula.equals(other.matricula)) {
      return false;
    }
    if ((this.projeto == null) ? (other.projeto != null) : !this.projeto.equals(other.projeto)) {
      return false;
    }
    if ((this.rg == null) ? (other.rg != null) : !this.rg.equals(other.rg)) {
      return false;
    }
    if ((this.cpf == null) ? (other.cpf != null) : !this.cpf.equals(other.cpf)) {
      return false;
    }
    if ((this.observacao == null) ? (other.observacao != null)
            : !this.observacao.equals(other.observacao)) {
      return false;
    }
    if ((this.foto == null) ? (other.foto != null) : !this.foto.equals(other.foto)) {
      return false;
    }
    if (this.cadastro != other.cadastro && (this.cadastro == null
            || !this.cadastro.equals(other.cadastro))) {
      return false;
    }
    if (this.criador != other.criador && (this.criador == null
            || !this.criador.equals(other.criador))) {
      return false;
    }
    if (this.ativo != other.ativo) {
      return false;
    }
    if (this.endereco != other.endereco && (this.endereco == null
            || !this.endereco.equals(other.endereco))) {
      return false;
    }
    if (this.contato != other.contato && (this.contato == null
            || !this.contato.equals(other.contato))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Participante{" + "id=" + id + ", nome=" + nome
            + ", sobreNome=" + sobreNome + ", sexo=" + sexo
            + ", nascimento=" + nascimento + ", curso=" + curso
            + ", matricula=" + matricula + ", projeto=" + projeto
            + ", rg=" + rg + ", cpf=" + cpf + ", observacao=" + observacao
            + ", foto=" + foto + ", cadastro=" + cadastro
            + ", criador=" + criador + ", ativo=" + ativo
            + ", endereco=" + endereco + ", contato=" + contato + '}';
  }
}
