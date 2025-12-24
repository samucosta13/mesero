public class Atendente extends Usuario {
    Atendente(String email, String senha, String nome) {
        super(email, senha, nome);
        this.setIdentificador(2);
    }
}
