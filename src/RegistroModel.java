import java.util.Date;
import java.util.UUID;

public class RegistroModel {
    private String id;
    private Date entrada;
    private Date saida;


    public void registrarEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public void registrarSaida(Date saida) {
        this.saida = saida;
    }

    public Date getEntrada(String uuid) {
        this.id = uuid;
        return entrada;
    }

    public Date getSaida() {
        return saida;
    }


    
}
