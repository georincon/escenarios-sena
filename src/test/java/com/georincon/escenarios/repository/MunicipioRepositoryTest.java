package com.georincon.escenarios.repository;

import com.georincon.escenarios.model.Municipio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class MunicipioRepositoryTest {

    @Autowired
    private MunicipioRepository municipioRepository;

    @Test
    public void testCrearMunicipio() {
        Municipio municipioGuardado = municipioRepository.save(new Municipio("Bucaramanga"));
        assertThat(municipioGuardado.getId()).isGreaterThan(0);
    }

}
