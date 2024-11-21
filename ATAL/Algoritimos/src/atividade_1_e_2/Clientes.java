package atividade_1_e_2;

public class Clientes {
    String nome;
    Boolean vip;

    public Clientes(String nome, Boolean vip) {
        this.nome = nome;
        this.vip = vip;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "nome='" + nome + '\'' +
                ", vip=" + vip +
                '}';
    }
}

