package br.com.etecia.ajudaai;

public class Servicos {

    private String descricao;

    private int imagem;

    public Servicos(String descricao, int imagem) {
        this.descricao = descricao;
        this.imagem = imagem;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
