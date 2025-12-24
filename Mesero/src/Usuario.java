public class Usuario {
    private int identificador;
    private String email;
    private String senha;
    private String nome;
    
    Usuario(String email, String senha, String nome) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    boolean entra(String senha) {
        if (this.senha.equals(senha)) {
            return true;
        }
        else{
            return false;
        }
    }

    boolean sai() {
        return true;
    }
}