package cinema.prova.prova02.persistence.dao;

import cinema.prova.prova02.factory.ConnectionFactory;
import cinema.prova.prova02.persistence.model.Category;
import cinema.prova.prova02.persistence.model.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDao {

    private Connection connection;

    public FilmeDao(){
        this.connection = new ConnectionFactory().getConnection();
    }

    public void createFilmTable(){
        String sql = "Create table if not exists film ( id int primary key auto_increment," +
                "nome varchar(50)," +
                "minutes integer," +
                "diretor varchar(50)," +
                "idCategory int," +
                "foreign key (idCategory) references category(id) " +
                ");";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Film> listFilms(){

        String sql = "select * from film";

        List<Film> filmsList = new ArrayList<>();

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet films = stmt.executeQuery();

            while(films.next()){

                Film film = new Film();
                film.setId(films.getInt("id"));
                film.setName(films.getString("nome"));
                film.setMinutes(films.getInt("minutes"));
                film.setDiretor(films.getString("diretor"));

                CategoryDao categoryDao = new CategoryDao();
                Category category = categoryDao.findById(films.getInt("idCategory"));
                film.setCategory(category);

                filmsList.add(film);
            }
            return filmsList;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

}
