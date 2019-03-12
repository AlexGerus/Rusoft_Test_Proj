package com.rusoft.task.service.impl;

import com.rusoft.task.module.car.Car;
import com.rusoft.task.module.client.Client;
import com.rusoft.task.service.interfaces.ClientService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.rusoft.task.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client saveClient(String firstName, int age, String markCar, int carProdYear) {
        Client client = new Client();
        Car car = new Car();
        List<Client> clients = clientRepository.findAll();
        for (Client checkClient : clients) {
            if (checkClient.getClientName().equalsIgnoreCase(firstName)) {
                logger.error("Client with name " + checkClient.getClientName() + " have already saved");
                return checkClient;
            }
        }
        client.setClientName(firstName);
        client.setClientAge(age);
        car.setCarName(markCar);
        car.setCarProdYear(carProdYear);
        List<Car> listCar = new ArrayList<>();
        listCar.add(car);
        client.setListCars(listCar);
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(String firstName, String markCar) {
        try {
            Client client = clientRepository.getClientByClientName(firstName);
            for (Car car : client.getListCars()) {
                if (car.getCarName().equalsIgnoreCase(markCar)) {
                    clientRepository.delete(client);
                }
            }
        } catch (NullPointerException e) {
            logger.error("Not found client with the specified name " + e);
        }
    }

}
