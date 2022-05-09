package sistemaacademico.model;

import lombok.Getter;
import lombok.Setter;

public class Mensagem {
    private @Getter @Setter String texto;
    private @Getter @Setter String remetente;
    private @Getter @Setter boolean lido;

    public Mensagem(String texto, String remetente) {
        this.texto = texto;
        this.remetente = remetente;
        this.lido = false;
    }      
	
    @Override
    public String toString() {
        return getRemetente();
    }
    

}
