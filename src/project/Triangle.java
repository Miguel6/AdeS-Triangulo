package project;

import exceptions.LengthException;

public class Triangle {

	private double sideA;
	private double sideB;
	private double sideC;
	private Validator validator;

	public Triangle() throws LengthException {
		this.validator = new Validator();
		this.setSideA(1);
		this.setSideB(1);
		this.setSideC(1);
	}

	public Triangle(double sideA, double sideB, double sideC) throws LengthException {
		this.validator = new Validator();
		this.setSideA(sideA);
		this.setSideB(sideB);
		this.setSideC(sideC);
	}

	public void setSideA(double length) throws LengthException {
		if (this.validator.isASideValid(length)) {
			this.sideA = length;
		} else {
			throw new LengthException("El lado A tiene que ser un numero mayor a 'CERO' ");
		}
	}

	public void setSideB(double length) throws LengthException {
		if (this.validator.isASideValid(length)) {
			this.sideB = length;
		} else {
			throw new LengthException("El lado B tiene que ser un numero mayor a 'CERO' ");
		}
	}

	public void setSideC(double length) throws LengthException {
		if (this.validator.isASideValid(length)) {
			this.sideC = length;
		} else {
			throw new LengthException("El lado C tiene que ser un numero mayor a 'CERO' ");
		}
	}

	public double getSideA() {
		return this.sideA;
	}

	public double getSideB() {
		return this.sideB;
	}

	public double getSideC() {
		return this.sideC;
	}

}
