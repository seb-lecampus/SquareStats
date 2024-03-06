package le.campus.squarestats;

import jakarta.validation.constraints.NotBlank;
import le.campus.squarestats.data_objects.MatchResultEntity;
import le.campus.squarestats.data_objects.MatchResultRepository;
import le.campus.squarestats.data_objects.PlayerEntity;
import le.campus.squarestats.data_objects.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.StreamSupport;

@RestController
public class MatchController {
    @Autowired
    MatchResultRepository matchRepo;

    @Autowired
    PlayerRepository playerRepo;

    @PostMapping("/Match")
    public void addMatchResult(@RequestBody addMatchResult_in body){
        PlayerEntity winner = playerRepo.findPlayerEntityByPseudo(body.winner);
        PlayerEntity loser = playerRepo.findPlayerEntityByPseudo(body.loser);

        if(winner == null)
            playerRepo.save(new PlayerEntity(body.winner()));
        if(loser == null)
            playerRepo.save(new PlayerEntity(body.loser()));

        matchRepo.save(
                new MatchResultEntity(
                        playerRepo.findPlayerEntityByPseudo(body.winner),
                        playerRepo.findPlayerEntityByPseudo(body.loser))
        );
    }

    @GetMapping("/Matches")
    public Iterable<matchDTO> getMatchesResult(){
        return StreamSupport.stream(matchRepo.findAll().spliterator(), false).map(e-> new matchDTO(e.getWinner().getPseudo(), e.getLoser().getPseudo())).toList();
    }

    @GetMapping("/Players")
    public Iterable<playerDTO> getPlayers(){
        return StreamSupport.stream(playerRepo.findAll().spliterator(), false).map(e-> new playerDTO(e.getPseudo())).toList();
    }

    @GetMapping("/test")
    public void test(){

    }

    public record addMatchResult_in(@NotBlank String winner, @NotBlank String loser){}
    public record playerDTO(String name){}
    public record matchDTO(String winner, String loser){}
}
