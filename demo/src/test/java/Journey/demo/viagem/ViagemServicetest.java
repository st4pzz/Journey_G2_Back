package Journey.demo.viagem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ViagemServiceTest {

    @Mock
    ViagemRespository viagemRespository;

    @InjectMocks
    ViagemService viagemService;

    @Test
    void verificarSeViagemExisteTest() {
        Viagem v1 = new Viagem();
        v1.setId(1);
        v1.setStatus(ViagemStatus.CONFIRMADO);
        // Set your properties for v1

        when(viagemRespository.findById(1)).thenReturn(Optional.of(v1));

        boolean resp = viagemService.verifyViagem(1) != null;

        Assertions.assertTrue(resp);
    }

    @Test
    void contabilizarViagensRealizadasTest() {
        Viagem v1 = new Viagem();
        v1.setStatus(ViagemStatus.CONFIRMADO);
        // Set your properties for v1

        Viagem v2 = new Viagem();
        v2.setStatus(ViagemStatus.ERRO);
        // Set your properties for v2

        Viagem v3 = new Viagem();
        v3.setStatus(ViagemStatus.FINALIZADO);
        // Set your properties for v3

        List<Viagem> viagens = new ArrayList<Viagem>();
        viagens.add(v1);
        viagens.add(v2);
        viagens.add(v3);

        when(viagemRespository.findAll()).thenReturn(viagens);

        int resp = viagemService.listViagems().size();

        Assertions.assertEquals(3, resp);
    }

    @Test
    void ViagemIdMotoristaEmProgressoTest() {
        Viagem v1 = new Viagem();
        v1.setId(1);
        v1.setIdMotorista("1");
        v1.setStatus(ViagemStatus.CONFIRMADO);
        // Set your properties for v1
    
        Viagem v2 = new Viagem();
        v2.setId(2);
        v2.setIdMotorista("2");
        v2.setStatus(ViagemStatus.CONFIRMADO);
        // Set your properties for v2
    
        List<Viagem> viagens = new ArrayList<Viagem>();
        viagens.add(v1);
        viagens.add(v2);
    
        when(viagemRespository.findAll()).thenReturn(viagens);

        //:)
        Integer resp = viagemService.ViagemIdMotoristaEmProgresso("1");
    
        Assertions.assertEquals(v1.getId(), resp);
    }
    

}
