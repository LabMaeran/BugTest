package ModelObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import DataBase.ConnectionFactory;

public class Product {
    private int id;
    private String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Product getById(int id){
        Connection con = ConnectionFactory.getConnection();
        String findStatementString = "SELECT * FROM product WHERE id = (?)";

        ResultSet rs = null;
        PreparedStatement findStatement = null;

        Product product = new Product();
        try {
            findStatement = con.prepareStatement(findStatementString, Statement.RETURN_GENERATED_KEYS);
            rs = findStatement.executeQuery(findStatementString);
            findStatement.setInt(1, id);
            if(rs.next()) {
                product.setName(rs.getString("name"));
                product.setId(rs.getInt("idProduct"));
                product.setName(rs.getString("idCompany"));
                return product;
            }
        }
        catch(Exception e){
            System.out.println("EROARE LA INSERARE");
        }
        finally {
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(con);
        }
        return null;
    }

    public int save(){
        int status;
        Connection con = ConnectionFactory.getConnection();
        String insertStatementString = "INSERT INTO product (name) VALUES (?)";

        PreparedStatement insertStatement = null;
        try{
            insertStatement = con.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, name);
            insertStatement.execute();
            status = 1;
        }
        catch(Exception e){
            System.out.println("EROARE LA INSERARE");
            status = 0;
        }
        finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(con);
        }
        return status;
    }

    public void delete(){
        Connection con = ConnectionFactory.getConnection();
        String deleteStatementString = "DELETE FROM product WHERE id = ?";

        PreparedStatement deleteStatement = null;
        try{
            deleteStatement = con.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
            deleteStatement.setInt(1,id);

            deleteStatement.execute();
        }
        catch(Exception e){
            System.out.println("EROARE LA INSERARE");
        }
        finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(con);
        }
    }

    public void update(Product newProduct){
        Connection con = ConnectionFactory.getConnection();
        String updateStatementString = "UPDATE product SET name = ? WHERE id = ?";

        PreparedStatement updateStatement = null;
        try{
            updateStatement = con.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
            updateStatement.setString(1, newProduct.getName());

            updateStatement.execute();
        }
        catch(Exception e){
            System.out.println("EROARE LA INSERARE");
        }
        finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(con);
        }
    }
}
