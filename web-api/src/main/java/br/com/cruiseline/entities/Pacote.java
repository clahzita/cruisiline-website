package br.com.cruiseline.entities;

public class Pacote {
  private int maximo;
  private int capacidade;
  private int id;
  private String nome;
  
  public int getMaximo() {
    return maximo;
  }
  
  public void setMaximo(int maximo) {
    this.maximo = maximo;
  }
  
  public int getCapacidade() {
    return capacidade;
  }
  public void setCapacidade(int capacidade) {
    this.capacidade = capacidade;
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
  
  
}