    package Journey.demo.viagem;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/viagem")
    public class ViagemController {

        @Autowired
        private ViagemService viagemService;

        @PostMapping
        public Viagem createViagem(@RequestBody Viagem viagem) {
            return viagemService.saveViagem(viagem);
        }

        @GetMapping
        public List<Viagem> getViagems() {
            return viagemService.listViagems();
        }

        @GetMapping
        public List<Viagem> getViagemsMotorista(Integer idMotorista) {
            return viagemService.listViagemsMotorista(idMotorista);
        }

        @PutMapping("/{viagemId}/verify")
        public Viagem verifyViagem(@PathVariable Integer viagemId) {
            return viagemService.verifyViagem(viagemId);
        }

    }
