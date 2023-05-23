package org.hmis;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class JsonReaderTest {

	JsonReader JR = new JsonReader();
	
	@Test
	void testLeerCochesJSON() throws IOException {
		String ruta = "data/coches.json";
		Coche[] coches = JsonReader.leerCochesJSON(ruta);
		assertEquals(4, coches.length);
	}

	@Test
	void testLeerCochesJSONprimero() throws IOException {
		String ruta = "data/coches.json";
		Coche primero = new Coche("Toyota", "Corolla", 2022, 22000);
		Coche[] coches = JsonReader.leerCochesJSON(ruta);
		assertEquals(primero, coches[0]);
		assertTrue(primero.equals(coches[0]));
		assertTrue(coches[0].equals(primero));
	}

	@Test
	void testLeerCochesJSONFileNotFound() {
		String ruta = "ruta/inexistente.json";
		assertThrows(IOException.class, () -> JsonReader.leerCochesJSON(ruta));
	}

	@Test
	void testLeerCochesJSONInvalidJson() {
		String ruta = "data/invalid.json";
		assertThrows(IOException.class, () -> JsonReader.leerCochesJSON(ruta));
	}

	@Test
	void testLeerCochesJSONNullPath() {
		assertThrows(IllegalArgumentException.class, () -> JsonReader.leerCochesJSON(null));
	}
}
