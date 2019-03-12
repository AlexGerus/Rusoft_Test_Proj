package com.rusoft.task.service.interfaces;

import com.rusoft.task.module.car.Car;
import com.rusoft.task.module.client.Client;

public interface ClientService {
    Client saveClient(String firstName, int birthday, String markCar, int carProdYear);
    void deleteClient(String firstName, String markCar);
}
