package Journey.demo.viagem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ViagemControllertest {

    private MockMvc mockMvc;

    @InjectMocks
    private ViagemController viagemController;

    @Mock
    private ViagemService viagemService;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(viagemController)
                .build();
    }

    @Test
    void createViagem() throws Exception {
        Viagem viagem = new Viagem(); // preencha com os detalhes da viagem
        Mockito.when(viagemService.saveViagem(Mockito.any())).thenReturn(viagem);
        
        ObjectMapper om = new ObjectMapper();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/viagem")
                .contentType("application/json")
                .content(om.writeValueAsString(viagem)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String resp = result.getResponse().getContentAsString();
        Assertions.assertEquals(om.writeValueAsString(viagem), resp);
    }

    @Test
    void getViagems() throws Exception {
        Viagem viagem = new Viagem(); // preencha com os detalhes da viagem
        List<Viagem> viagems = new ArrayList<>();
        viagems.add(viagem);
        
        Mockito.when(viagemService.listViagems()).thenReturn(viagems);
        
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/viagem"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        ObjectMapper om = new ObjectMapper();

        String resp = result.getResponse().getContentAsString();
        Assertions.assertEquals(om.writeValueAsString(viagems), resp);
    }

    @Test
    void listViagemsMotorista() throws Exception {
        Integer idMotorista = 1; // insira um id de motorista válido
        Viagem v = new Viagem(); // preencha com os detalhes da viagem
        List<Viagem> viagems = new ArrayList<>();
        viagems.add(v);

        Mockito.when(viagemService.listViagemsMotorista(idMotorista)).thenReturn(viagems);

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/viagem/motorista/" + idMotorista))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        ObjectMapper om = new ObjectMapper();

        String resp = result.getResponse().getContentAsString();
        Assertions.assertEquals(om.writeValueAsString(viagems), resp);
    }
 
    @Test
    void verifyViagem() throws Exception {
        Integer viagemId = 1; // insira um id de viagem válido
        Viagem v = new Viagem(); // preencha com os detalhes da viagem
        v.setStatus(ViagemStatus.CONFIRMADO);
    
        Mockito.when(viagemService.verifyViagem(viagemId)).thenReturn(v);
    
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.put("/viagem/" + viagemId + "/verify"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    
        ObjectMapper om = new ObjectMapper();
    
        String resp = result.getResponse().getContentAsString();
        Assertions.assertEquals(om.writeValueAsString(v), resp);
    }

    
    @Test
    void cancelarViagem() throws Exception {
        Integer viagemId = 1; // insira um id de viagem válido
        Viagem v = new Viagem(); // preencha com os detalhes da viagem

        Mockito.when(viagemService.cancelarViagem(viagemId)).thenReturn(v);

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.put("/viagem/" + viagemId + "/cancel"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        ObjectMapper om = new ObjectMapper();

        String resp = result.getResponse().getContentAsString();
        Assertions.assertEquals(om.writeValueAsString(v), resp);
    }

    @Test
    void ViagemIdMotoristaEmProgresso() throws Exception {
        String idMotorista = "motorista123"; // insira um id de motorista válido
        Integer viagemId = 1; // insira um id de viagem válido

        Mockito.when(viagemService.ViagemIdMotoristaEmProgresso(idMotorista)).thenReturn(viagemId);

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/viagem/" + idMotorista + "/emProgresso"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String resp = result.getResponse().getContentAsString();
        Assertions.assertEquals(resp, viagemId.toString());
    }
}
    

        

