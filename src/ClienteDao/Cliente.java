package ClienteDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Cliente {

    public void save(Clientes clientes){

        String sql = "INSERT INTO clientes(nome, email, senha, ddd, telefone)" +
                " VALUES(?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {

            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, clientes.getNome());
            pstm.setString(2, clientes.getEmail());
            pstm.setString(3, clientes.getSenha());
            pstm.setInt(4, clientes.getDdd());
            pstm.setString(5, clientes.getTelefone());


            pstm.execute();

        } catch (Exception e) {

            e.printStackTrace();
        }finally{



            try{
                if(pstm != null){

                    pstm.close();
                }

                if(conn != null){
                    conn.close();
                }

            }catch(Exception e){

                e.printStackTrace();
            }
        }
    }
    public void removeById(int id){

        String sql = "DELETE FROM clientes WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.execute();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{

            try{
                if(pstm != null){

                    pstm.close();
                }

                if(conn != null){
                    conn.close();
                }

            }catch(Exception e){

                e.printStackTrace();
            }
        }
    }
    public void update(Clientes clientes){

        String sql = "UPDATE clientes SET nome = ?, email = ?, senha = ?, ddd = ?, telefone = ?" +
                " WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, clientes.getNome());
            pstm.setString(2, clientes.getEmail());
            pstm.setString(3, clientes.getSenha());
            pstm.setInt(4, clientes.getDdd());
            pstm.setString(5, clientes.getTelefone());


            pstm.execute();

        } catch (Exception e) {

            e.printStackTrace();
        }finally{



            try{
                if(pstm != null){

                    pstm.close();
                }

                if(conn != null){
                    conn.close();
                }

            }catch(Exception e){

                e.printStackTrace();
            }
        }
    }
    public static List<Clientes> getClientes(){

        String sql = "SELECT * FROM clientes";

        List<Clientes> clientes = new ArrayList<Clientes>();

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();


            while(rset.next()){

                Clientes cliente = new Clientes();


                cliente.setId(rset.getInt("id"));

                cliente.setNome(rset.getString("nome"));

                cliente.setEmail(rset.getString("email"));

                cliente.setSenha(rset.getString("senha"));

                cliente.setDdd(rset.getInt("ddd"));

                cliente.setTelefone(rset.getString("telefone"));

                clientes.add(cliente);
            }
        } catch (Exception e) {

            e.printStackTrace();
        }finally{

            try{

                if(rset != null){

                    rset.close();
                }

                if(pstm != null){

                    pstm.close();
                }

                if(conn != null){
                    conn.close();
                }

            }catch(Exception e){

                e.printStackTrace();
            }
        }

        return clientes;
    }
}
