package model;
/**
 *
 * @author Angelo-KabyLake
 */
public abstract class BaseModel {
    String id;
    String nomTable;

    public BaseModel(String id, String nomTable) {
        this.id = id;
        this.nomTable = nomTable;
    }
    public BaseModel(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomTable() {
        return nomTable;
    }

    public void setNomTable(String nomTable) {
        this.nomTable = nomTable;
    }
    
}
