import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class ClienteModel {
    private int id;
    private String nome;
    private String numero;
    private Map<String, RegistroModel> registros;


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

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void registrarEntrada() {
        Date data = new Date();
        RegistroModel registro = new RegistroModel();
        String uuid = UUID.randomUUID().toString();
        registro.registrarEntrada(data);
        registros.put(uuid, registro);
    }

}
