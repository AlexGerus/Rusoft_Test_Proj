package com.rusoft.task.module.car;
import com.rusoft.task.module.client.Client;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="cars")
public class Car {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @Column(name = "car_name")
    @ApiModelProperty(notes = "Name of the Car",name="carName",required=true,value="test name")
    private String carName;

    @Column(name = "car_prod_year")
    @ApiModelProperty(notes = "ProdYear of the Car",name="carProdYear",required=true,value="test age")
    private int carProdYear;

    public Car() {
    }

    public Car(String carName) {
        this.carName = carName;
    }

    public Car(String carName, int carProdYear) {
        this.carName = carName;
        this.carProdYear = carProdYear;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getCarProdYear() {
        return carProdYear;
    }

    public void setCarProdYear(int carProdYear) {
        this.carProdYear = carProdYear;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carName='" + carName + '\'' +
                ", carProdYear=" + carProdYear +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return carName != null ? carName.equals(car.carName) : car.carName == null;
    }

    @Override
    public int hashCode() {
        return carName != null ? carName.hashCode() : 0;
    }

}
