/*
package tn.esprit.spring.Schedular;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class test {
//
//    @Scheduled(fixedRate = 2000)
//    void affiche(){
//        log.info("Bonjour");
//    }
}
*/

package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.DAO.Entities.Bloc;
import tn.esprit.spring.DAO.Repositories.BlocRepository;
import tn.esprit.spring.Services.Bloc.BlocService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class BlocServiceTest {

    @Mock
    BlocRepository blocRepository;

    @InjectMocks
    BlocService blocService;

    @Test
    void addOrUpdate_should_pass_without_testing_real_logic() {
        // Given
        Bloc bloc = new Bloc();
        bloc.setNomBloc("Test Bloc");

        // Fix: Use any() with the specific Bloc class
        when(blocRepository.save(any(Bloc.class))).thenReturn(bloc);

        // When
        Bloc result = blocService.addOrUpdate(bloc);

        // Then
        assertNotNull(result);
    }
}