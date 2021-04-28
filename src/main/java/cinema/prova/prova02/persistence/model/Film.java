package cinema.prova.prova02.persistence.model;

public class Film {

    private int id;
    private String name;
    private int minutes;
    private String diretor;
    private Category category;

    public Film(){}

    public Film(int id, String name, int minutes, String diretor, Category category) {
        this.id = id;
        this.name = name;
        this.minutes = minutes;
        this.diretor = diretor;
        this.category = category;
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

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
