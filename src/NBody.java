
/**
 * @author YOUR NAME THE STUDENT IN 201
 * 
 * Simulation program for the NBody assignment
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class NBody {

	/**
	 * Read the specified file and return the radius
	 * 
	 * @param fname is name of file that can be open
	 * @return the radius stored in the file
	 * @throws FileNotFoundException if fname cannot be open
	 */
	public static double readRadius(String fname) throws FileNotFoundException {
		Scanner s = new Scanner(new File(fname));

		s.nextInt();

		double rad = s.nextDouble();

		s.close();

		return rad;
	}

	/**
	 * Read all data in file, return array of Celestial Bodies
	 * read by creating an array of Body objects from data read.
	 * 
	 * @param fname is name of file that can be open
	 * @return array of Body objects read
	 * @throws FileNotFoundException if fname cannot be open
	 */
	public static CelestialBody[] readBodies(String fname) throws FileNotFoundException {

		Scanner s = new Scanner(new File(fname));

		int nb = s.nextInt(); // # bodies to be read
		s.nextDouble();

		CelestialBody[] ret = new CelestialBody[nb];

		for (int k = 0; k < nb; k++) {
			double xp = s.nextDouble();
			double yp = s.nextDouble();
			double xv = s.nextDouble();
			double yv = s.nextDouble();
			double mass = s.nextDouble();
			String name = s.next();
			ret[k] = new CelestialBody(xp, yp, xv, yv, mass, name);

		}

		s.close();

		return ret;
	}

	public static void main(String[] args) throws FileNotFoundException {
		double totalTime = 2000000.0;
		double dt = 25000.0;

		String fname = "./data/planets.txt";

		if (args.length > 2) {
			totalTime = Double.parseDouble(args[0]);
			dt = Double.parseDouble(args[1]);
			fname = args[2];
		}

		CelestialBody[] bodies = readBodies(fname);
		double radius = readRadius(fname);

		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-radius, radius);
		StdDraw.picture(0, 0, "images/starfield.jpg");

		// run simulation until over

		for (double t = 0.0; t < totalTime; t += dt) {

			double[] xforces = new double[bodies.length];
			double[] yforces = new double[bodies.length];
			// TODO: create double arrays xforces and yforces
			// to hold forces on each body

			// TODO: in loop, calculate netForcesX and netForcesY and store in
			// arrays xforces and yforces for each object in bodies

			for (int k = 0; k < bodies.length; k++) {
				xforces[k] = bodies[k].calcNetForceExertedByX(bodies);
				yforces[k] = bodies[k].calcNetForceExertedByY(bodies);
			}

			// TODO: loop over all bodies and call update
			// with dt and corresponding xforces and yforces arrays

			for (int k = 0; k < bodies.length; k++) {
				bodies[k].update(dt, xforces[k], yforces[k]);
			}

			StdDraw.clear();
			StdDraw.picture(0, 0, "images/starfield.jpg");

			// TODO: loop over all bodies and call draw on each one

			for (CelestialBody b : bodies) {
				b.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);

		}

		// prints final values after simulation

		System.out.printf("%d\n", bodies.length);
		System.out.printf("%.2e\n", radius);
		for (int i = 0; i < bodies.length; i++) {
			System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
					bodies[i].getX(), bodies[i].getY(),
					bodies[i].getXVel(), bodies[i].getYVel(),
					bodies[i].getMass(), bodies[i].getName());
		}
	}
}