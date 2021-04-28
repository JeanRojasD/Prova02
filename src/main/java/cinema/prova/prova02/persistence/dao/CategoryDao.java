package cinema.prova.prova02.persistence.dao;

import cinema.prova.prova02.factory.ConnectionFactory;
import cinema.prova.prova02.persistence.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    private Connection connection;

    public CategoryDao(){
        this.connection = new ConnectionFactory().getConnection();
    }

    public void createCategoryTable(){
        String sql = "Create table if not exists category (" + " id int primary key auto_increment," +
                "nome varchar(50)," +
                "description varchar(50) " +
                ");";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Category findById(int id){
        String sql = "select * from category where id=?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet category = stmt.executeQuery();

            Category category1 = new Category();
            while(category.next()){

                category1.setId(category.getInt("id"));
                category1.setName(category.getString("nome"));
                category1.setDescription(category.getString("description"));

            }
            return category1;

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Category> listCategory(){

        String sql = "select * from category";

        List<Category> categoryList = new ArrayList<>();

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet categorys = stmt.executeQuery();

            while(categorys.next()){

                Category category = new Category();
                category.setId(categorys.getInt("id"));
                category.setName(categorys.getString("nome"));
                category.setDescription(categorys.getString("description"));
                categoryList.add(category);
            }
            return categoryList;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

}
