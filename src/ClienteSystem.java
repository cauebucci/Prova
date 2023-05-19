import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static javax.swing.JOptionPane.*;

 
public class ClienteSystem {
    private static Map<Integer,ClienteModel> clientes = new HashMap<>(); // Cria uma lista de clientes
    private static int idCliente = 0; // Define o ID do cliente, para que ele seja de ordem crescente

    public void cadastrarCliente(String nome, String numero) { // Método para cadastrar um cliente
        ClienteModel cliente = new ClienteModel(); // Cria um objeto do tipo cliente

        idCliente++; // Aumenta o ID do cliente

        cliente.setId(idCliente); // Seta o ID do cliente
        cliente.setNome(nome); // Seta o nome do cliente
        cliente.setNumero(numero); // Seta o número do cliente

        clientes.put(idCliente, cliente); // Insere o cliente a lista de clientes

    }

    public void menuCadastro() { // Método para abrir um menu para o cadastro de cliente 
        String nome = showInputDialog("Qual o seu nome? "); // Coleta o nome do cliente
        String telefone = showInputDialog("Qual o seu telefone?"); // Coleta o número do cliente

        cadastrarCliente(nome, telefone); // Utiliza o método para cadastrar o cliente

        showMessageDialog(null, "Cadastrado com sucesso!"); // Informa uma mensagem de sucesso
    }

    public ClienteModel getCliente(int id) { // Método para pegar um cliente específico pelo ID
        if(!clientes.containsKey(id)) { // Verifica se o ID não existe
            return null; // Caso não exista, ele retorna como nulo
        }else {
            ClienteModel cliente = clientes.get(id); // Se existir, ele pega o cliente e guarda em um novo objeto
            return cliente; // Retorna o cliente
        }
    }

    public List<ClienteModel> getAllClientes() { // Método para retornar uma lista com todos os clientes
        return new ArrayList<>(clientes.values()); // Cria a lista de clientes e retorna
    }

    public void menuListarClientes() { // Método para abrir uma interface com uma lista de todos os clientes
        List<ClienteModel> todosClientes = getAllClientes(); // Utiliza o método para pegar uma lista com todos clientes e salvar em uma lista
        String str = "Lista de Clientes:"; // Inicia uma string para salvar os dados dos clientes
        for (ClienteModel cliente : todosClientes) { // Utiliza um looping para pegar as informações de cada um dos clientes para concatenar na String
            str +="\n" + cliente.getId() + ":\n";
            str += "  Nome:" + cliente.getNome();
            str += "  Telefone:  " + cliente.getNumero();
        }
        str += "Quantidade de Clientes: " + idCliente; //Pega o número total de clientes pelo ID dele
        showMessageDialog(null, str); // Abre uma inteface com os dados concatenados
    }

    public boolean deletarCliente(int id) { // Método para excluir um cliente a partir do ID dele
        if(clientes.containsKey(id)) { // Verifica se o cliente existe
            clientes.remove(id); // Se existir, remove o cliente da lista
            idCliente--; // Diminiu um ID 
            return true; // Retorna 'true' informando que foi excluido com sucesso
        }else {
            return false; // Retorna 'false' informando que não foi possivel deletar
        }
     }

}
