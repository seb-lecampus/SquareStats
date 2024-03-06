package le.campus.squarestats.data_objects;

import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<PlayerEntity, Integer> {
    PlayerEntity findPlayerEntityByPseudo(String pseudo);
}
