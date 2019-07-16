package com.lansrod.java.mockito.car;

/**
 * 
 * @author Omran TOUJANI
 *
 *         Copyright 2018 Omran TOUJANI: This example is about starting a car.
 *         It contains mainly a Car class, that contains two methods addFuel(int
 *         fuel) and start(). It contains also a public static class Engine.
 * 
 */

public class Car {

	private final Engine engine;

	private int fuel;

	public Car(Engine engine) {
		this.engine = engine;
	}

	public void addFuel(int fuel) {
		if (fuel < 0) {
			throw new IllegalArgumentException("Can't add negative fuel");
		}
		this.fuel += fuel;
	}

	public void start() {
		if (fuel <= 0) {
			throw new RuntimeException("Empty tank!");
		}
		engine.start();
	}

	public static class Engine {

		public void start() {
			System.out.println("Engine start");
		}
	}

}
