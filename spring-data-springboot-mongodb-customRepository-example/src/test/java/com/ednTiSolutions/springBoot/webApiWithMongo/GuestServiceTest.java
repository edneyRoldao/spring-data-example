package com.ednTiSolutions.springBoot.webApiWithMongo;

import com.ednTiSolutions.springBoot.webApiWithMongo.model.Guest;
import com.ednTiSolutions.springBoot.webApiWithMongo.repository.GuestRepository;
import com.ednTiSolutions.springBoot.webApiWithMongo.service.GuestService;
import com.ednTiSolutions.springBoot.webApiWithMongo.service.GuestServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
public class GuestServiceTest {

    @TestConfiguration
    static class GuestServiceConfig {
        @Bean
        public GuestService guestService() {
            return new GuestServiceImpl();
        }
    }

    @Autowired
    private GuestService guestService;

    @MockBean
    private GuestRepository guestRepository;

    @Before
    public void setup() {
        Guest g = new Guest("Edney", "35", "343", new ArrayList<>());
        Mockito.when(guestRepository.findByName(g.getName())).thenReturn(g);
    }

    @Test
    public void whenValidNameGuestShouldBeFound() {
        String name = "Edney";
        Guest g = guestService.find(name);
        assertThat(g.getName()).isEqualTo(name);
    }

}
