package com.rusoft.task.controllers;

import com.rusoft.task.module.client.Client;
import com.rusoft.task.service.interfaces.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/client")
@Api(value = "ClientController", description = "REST Apis related to Client and Car Entity")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @ApiOperation(value = "Add Client in the System ", response = Iterable.class, tags = "addClients")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })

    @RequestMapping("/add-client")
    public ResponseEntity<Client> addClient(@RequestParam String firstName,
                                            @RequestParam int age,
                                            @RequestParam String markCar,
                                            @RequestParam int birthdayCar) {
        return ResponseEntity.ok(clientService.saveClient(firstName, age, markCar, birthdayCar));
    }

    @RequestMapping("/remove-client")
    @ApiOperation(value = "Remove client from the System ", response = Client.class, tags = "removeClient")
    public ResponseEntity removeClient(@RequestParam String firstName,
                                       @RequestParam String markCar) {
        clientService.deleteClient(firstName, markCar);
        return ResponseEntity.ok("Client removed");
    }
}
