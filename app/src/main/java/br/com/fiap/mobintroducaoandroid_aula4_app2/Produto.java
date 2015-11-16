package br.com.fiap.mobintroducaoandroid_aula4_app2;

/**
 * Created by michelfernandes on 07/08/15.
 */
public class Produto {

    private String nome;
    private float preco;

    public Produto(String nome, float preco){
        this.nome=nome;
        this.preco=preco;
    }

    public String getNome(){
        return nome;
    }

    public float getPreco(){
        return preco;
    }

    public String toString(){
        return nome + "="+preco;
    }

}
