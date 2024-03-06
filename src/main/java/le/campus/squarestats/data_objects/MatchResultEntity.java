package le.campus.squarestats.data_objects;

import jakarta.persistence.*;

@Entity
public class MatchResultEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_match;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_winner", referencedColumnName = "id_player")
    private PlayerEntity winner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_loser", referencedColumnName = "id_player")
    private PlayerEntity loser;

    public MatchResultEntity(PlayerEntity winner, PlayerEntity loser) {
        this.winner = winner;
        this.loser = loser;
    }

    public MatchResultEntity() {

    }

    public int getId_match() {
        return id_match;
    }

    public void setId_match(int id_match) {
        this.id_match = id_match;
    }

    public PlayerEntity getWinner() {
        return winner;
    }

    public void setWinner(PlayerEntity winner) {
        this.winner = winner;
    }

    public PlayerEntity getLoser() {
        return loser;
    }

    public void setLoser(PlayerEntity loser) {
        this.loser = loser;
    }
}