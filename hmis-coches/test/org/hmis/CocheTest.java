package org.hmis;

import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestCoche {

    @ParameterizedTest(name = "{index}=> Brand: {1} / Model: {2} / Year: {3} / Price:{4}")
    @MethodSource("provideCarData")
    void verifyCarGetters(Coche car, String expectedBrand, String expectedModel, int expectedYear, int expectedPrice) {
        assertEquals(car.getMarca(), expectedBrand);
        assertEquals(car.getModelo(), expectedModel);
        assertEquals(car.getAño(), expectedYear);
        assertEquals(car.getPrecio(), expectedPrice);
    }

    static Stream<Arguments> provideCarData() {
        Coche car = new Coche("Citroen", "Xara", 2008, 2560);
        return Stream.of(
                Arguments.of(car, "Citroen", "Xara", 2008, 2560)
        );
    }
    
    @ParameterizedTest(name = "{index}=> Brand: {1} / Model: {2} / Year: {3} / Price:{4}")
    @MethodSource("provideCarDataForSetters")
    void verifyCarSetters(Coche car, String expectedBrand, String expectedModel, int expectedYear, int expectedPrice) {
        car.setMarca("Seat");
        car.setModelo("Leon");
        car.setAño(2006);
        car.setPrecio(1860);
        
        assertEquals(car.getMarca(), expectedBrand);
        assertEquals(car.getModelo(), expectedModel);
        assertEquals(car.getAño(), expectedYear);
        assertEquals(car.getPrecio(), expectedPrice);
    }

    static Stream<Arguments> provideCarDataForSetters() {
        Coche car = new Coche("Citroen", "Xara", 2008, 2560);
        return Stream.of(
                Arguments.of(car, "Seat", "Leon", 2006, 1860)
        );
    }
    
    @ParameterizedTest(name = "{0}=> {2}")
    @MethodSource("provideCarDataForEquality")
    void verifyCarEquals(Object car1, Object car2, boolean expectedResult, String name) {
       assertEquals(car1.equals(car2), expectedResult);
    }

    static Stream<Arguments> provideCarDataForEquality() {
        Coche car1 = new Coche();
        Coche car2 = new Coche();
        Coche car3 = new Coche("Toyota", "Corolla", 2022, 22000);
        Coche car4 = new Coche("Toyota", "Corolla", 2022, 22000);
        Coche car5 = new Coche ("Toyota", "Corolla", 2023, 22000);
        Coche car6 = new Coche ("Nissan", "Corolla", 2022, 22000);
        Coche car7 = new Coche ("Toyota", "Auris", 2022, 22000);
        Coche car8 = new Coche ("Toyota", "Corolla", 2022, 32000);
        String car9 = "";

        return Stream.of(
                Arguments.of(car1, car1, true, "testEqualsObject"),
                Arguments.of(car1, null, false, "testEqualsObjectNull"),
                Arguments.of(car3, car4, true, "testEqualsObjectMultiple1"),
                Arguments.of(car3, car5, false, "testEqualsObjectMultiple2"),
                Arguments.of(car3, car6, false,"testEqualsObjectMultiple3"),
                Arguments.of(car3, car7, false,"testEqualsObjectMultiple4"),
                Arguments.of(car3, car8, false,"testEqualsObjectMultiple5"),
                Arguments.of(car1, car9, false, "testEqualsObjectString")
        );
    }

}