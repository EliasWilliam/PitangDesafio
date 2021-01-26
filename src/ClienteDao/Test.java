package ClienteDao;

public class Test {
    public static void main(String[] args) {

        Cliente clienteDAO = new Cliente();

        // Cria um novo registro
        Clientes cliente = new Clientes();
        cliente.setNome("Batman");
        cliente.setEmail("batmangotham@teste.com");
        cliente.setSenha("gotham");
        cliente.setDdd(81);
        cliente.setTelefone("12345678");

        clienteDAO.save(cliente);
        System.out.println("Registro Feito");

        for (Clientes c : Cliente.getClientes()) {

            System.out.println("Nome: " + c.getNome());
            System.out.println("Email: " + c.getEmail());
            System.out.println("Senha: " + c.getSenha());
            System.out.println("DDD: " + c.getDdd());
            System.out.println("Telefone: " + c.getTelefone());
        }
    }
}
