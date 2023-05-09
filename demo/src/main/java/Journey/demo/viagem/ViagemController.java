package Journey.demo.viagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viagem")
public class ViagemController {

    @Autowired
    private ViagemService viagemService;

    @CrossOrigin
    @PostMapping
    public Viagem createViagem(@RequestBody Viagem viagem) {
        return viagemService.saveViagem(viagem);
    }
    @CrossOrigin
    @GetMapping
    public List<Viagem> getViagems() {
        return viagemService.listViagems();
    }

    @CrossOrigin
    @GetMapping("/motorista/{idMotorista}")
    public List<Viagem> getViagemsMotorista(@PathVariable Integer idMotorista) {
        return viagemService.listViagemsMotorista(idMotorista);
    }

    @CrossOrigin
    @PutMapping("/{viagemId}/verify")
    public Viagem verifyViagem(@PathVariable Integer viagemId) {
        return viagemService.verifyViagem(viagemId);
    }

}
