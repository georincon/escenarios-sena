package com.georincon.escenarios.repository;

import com.georincon.escenarios.model.Patrocinador;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class PatrocinadorRepositoryTest {

    @Autowired
    private PatrocinadorRepository patrocinadorRepository;

    @Test
    public void testCrearPatrocinador() {
        Patrocinador patrocinadorGuardado = patrocinadorRepository.save(new Patrocinador("91296304","Geovani Rincon","Calle 17 # 29-57 apto 301 San Alonso","3043730066","Natural","georincon@gmail.com"));
        assertThat(patrocinadorGuardado.getId()).isGreaterThan(0);
    }

}
