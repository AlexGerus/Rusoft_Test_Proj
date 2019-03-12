package com.rusoft.task.module.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rusoft.task.module.car.Car;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="clients")
public class Client {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(name = "client_name", unique = true)
    @ApiModelProperty(notes = "Name of the Client",name="clientName",required=true,value="test name")
    private String clientName;

    @Column(name = "client_age")
    @ApiModelProperty(notes = "Age of the Client",name="clientAge",required=true,value="test age")
    private int clientAge;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Car.class)
    @JoinTable(name = "cars_list_with_client",
                joinColumns = {@JoinColumn(name = "client_id", foreignKey = @ForeignKey(name = "FK_CLIENT_LIST"))},
                inverseJoinColumns = {@JoinColumn(name = "car_id", foreignKey = @ForeignKey(name = "FK_CAR_LIST"))})
    @JsonIgnore
    private List<Car> listCars = new ArrayList<>();

    public Client() {
    }

    public Client(String clientName) {
        this.clientName = clientName;
    }

    public Client(String clientName, int clientAge) {
        this.clientName = clientName;
        this.clientAge = clientAge;
    }

    public Client(String clientName, int clientAge, List<Car> listCars) {
        this.clientName = clientName;
        this.clientAge = clientAge;
        this.listCars = listCars;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getClientAge() {
        return clientAge;
    }

    public void setClientAge(int clientAge) {
        this.clientAge = clientAge;
    }

    public List<Car> getListCars() {
        return listCars;
    }

    public void setListCars(List<Car> listCars) {
        this.listCars = listCars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return clientAge == client.clientAge &&
                Objects.equals(clientId, client.clientId) &&
                Objects.equals(clientName, client.clientName) &&
                Objects.equals(listCars, client.listCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, clientName, clientAge, listCars);
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", clientName='" + clientName + '\'' +
                ", clientAge=" + clientAge +
                '}';
    }

}