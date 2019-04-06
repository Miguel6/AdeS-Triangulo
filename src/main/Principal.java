package main;

import exceptions.InvalidTriangleException;
import exceptions.LengthException;
import project.Triangle;

public class Principal {

	public static void main(String[] args) {
		try {
			Triangle t1 = new Triangle(2.1, 1, 3);
			t1.getTriangleTypeByAngle();
		} catch (LengthException | InvalidTriangleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
