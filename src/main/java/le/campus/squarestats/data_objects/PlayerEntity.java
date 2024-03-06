package le.campus.squarestats.data_objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_player;

    private String pseudo;

    public PlayerEntity(String winner) {
        this.pseudo = winner;
    }

    public PlayerEntity() {

    }

    public int getId_player() {
        return id_player;
    }

    public void setId_player(int id_player) {
        this.id_player = id_player;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
}