package project;

import constants.TriangleTypes;
import exceptions.InvalidTriangleException;
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

	public Triangle(double sideA, double sideB, double sideC) throws LengthException, InvalidTriangleException {
		this.validator = new Validator();
		this.setSideA(sideA);
		this.setSideB(sideB);
		this.setSideC(sideC);
		if (!this.isATriangle()) {
			throw new InvalidTriangleException("No es un triangulo valido");
		}
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

	public boolean isATriangle() {
		return (this.getSideA() + this.getSideB()) > this.getSideC()
				&& (this.getSideA() + this.getSideC()) > this.getSideB()
				&& (this.getSideB() + this.getSideC()) > this.getSideA();
	}

	public TriangleTypes getTriangleTypeBySide() throws InvalidTriangleException {
		if (this.isATriangle()) {
			if (this.isEquilateral()) {
				System.out.println("Es Equilatero");
				return TriangleTypes.EQUILATERO;
			} else if (this.isIsosceles()) {
				System.out.println("Es Isosceles");
				return TriangleTypes.ISOSCELES;
			}
			System.out.println("Es Escaleno");
			return TriangleTypes.ESCALENO;
		} else {
			throw new InvalidTriangleException("No es un triangulo valido");
		}
	}

	public TriangleTypes getTriangleTypeByAngle() throws InvalidTriangleException {
		if (this.isATriangle()) {
			return this.returnTriangleTypeByAngle();
		} else {
			throw new InvalidTriangleException("No es un triangulo valido");
		}
	}

	private TriangleTypes returnTriangleTypeByAngle() throws InvalidTriangleException {
		if (this.isATriangle()) {

			if (this.isEquilateral()) {
				return TriangleTypes.ACUTANGULO;
			}

			/**
			 * angleA, es el "opuesto" al lado a angleB, es el "opuesto" al lado b angleC,
			 * es el "opuesto" al lado c
			 */
			double angleA = Math.toDegrees(Math
					.acos((Math.pow(this.getSideA(), 2) + Math.pow(this.getSideB(), 2) - Math.pow(this.getSideC(), 2))
							/ (2 * this.getSideA() * this.getSideB())));
			double angleB = Math.toDegrees(Math
					.acos((Math.pow(this.getSideA(), 2) + Math.pow(this.getSideC(), 2) - Math.pow(this.getSideB(), 2))
							/ (2 * this.getSideA() * this.getSideC())));
			double angleC = 180 - angleA - angleB;
			if ((angleA < 180 && angleA > 90) || (angleB < 180 && angleB > 90) || (angleC < 180 && angleC > 90)) {
				return TriangleTypes.OBTUSANGULO;
			} else if (angleA == 90 || angleB == 90 || angleC == 90) {
				return TriangleTypes.RECTANGULO;
			}
			return TriangleTypes.ACUTANGULO;
		}else {
			throw new InvalidTriangleException("No es un triangulo valido");
		}

	}

	private double calculateASin(double a, double b) {
		if (a > b) {
			return Math.asin(b / a);
		}
		return Math.asin(a / b);
	}

	private boolean isScalene() {
		return this.getSideA() != this.getSideB() && this.getSideA() != this.getSideC()
				&& this.getSideB() != this.getSideC();
	}

	private boolean isIsosceles() {
		return ((this.getSideA() == this.getSideB() && this.getSideA() != this.getSideC())
				|| (this.getSideA() == this.getSideC() && this.getSideA() != this.getSideB())
				|| (this.getSideB() == this.getSideC() && this.getSideB() != this.getSideA()));
	}

	private boolean isEquilateral() {
		return this.getSideA() == this.getSideB() && this.getSideB() == this.getSideC();
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
