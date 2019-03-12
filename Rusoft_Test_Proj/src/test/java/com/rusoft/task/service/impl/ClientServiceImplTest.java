package com.rusoft.task.service.impl;

import com.rusoft.task.module.car.Car;
import com.rusoft.task.module.client.Client;
import com.rusoft.task.repository.ClientRepository;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClientServiceImplTest {

    @Autowired
    private ClientServiceImpl clientService;

    @Autowired
    private ClientRepository clientRepository;

    private static final String clientName = "Alex";
    private static final int clientAge = 19;
    private static final String carName = "Audi";
    private static final int carProdYear = 2019;
    private Car car;
    private Client client;

    @Before
    public void setUp(){
        car = new Car(carName, carProdYear);
        car.setCarId(1L);
        client = new Client(clientName, clientAge);
    }

    @Test
    public void saveClient() {
        List<Car> listCar = new ArrayList<>();
        listCar.add(car);
        client.setListCars(listCar);
        when(clientRepository.save(client)).thenReturn(client);

        Client foundClient = clientService.saveClient(client.getClientName(), client.getClientAge(), car.getCarName(), car.getCarProdYear());

        assertEquals(client.getClientName(), foundClient.getClientName());
        assertEquals(client.getClientAge(), foundClient.getClientAge());
    }

    @Test
    public void deleteClient() {
        clientService.deleteClient(client.getClientName(), car.getCarName());
        verify(clientRepository, times(1)).delete(client);
    }

}