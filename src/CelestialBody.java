
/**
 * Celestial Body class for NBody
 * Modified from original Planet class
 * used at Princeton and Berkeley
 * 
 * @author ola
 *
 *         If you add code here, add yourself as @author below
 *
 *
 */
public class CelestialBody {

	private double myXPos;
	private double myYPos;
	private double myXVel;
	private double myYVel;
	private double myMass;
	private String myFileName;

	/**
	 * Create a Body from parameters
	 * 
	 * @param xp       initial x position
	 * @param yp       initial y position
	 * @param xv       initial x velocity
	 * @param yv       initial y velocity
	 * @param mass     of object
	 * @param filename of image for object animation
	 */
	public CelestialBody(double xp, double yp, double xv,
			double yv, double mass, String filename) {
		this.myXPos = xp;
		this.myYPos = yp;
		this.myXVel = xv;
		this.myYVel = yv;
		this.myMass = mass;
		this.myFileName = filename;

	}

	/**
	 *
	 * @return
	 */
	public double getX() {

		return this.myXPos;
	}

	/**
	 *
	 * @return
	 */
	public double getY() {
		return this.myYPos;
	}

	/**
	 * Accessor for the x-velocity
	 * 
	 * @return the value of this object's x-velocity
	 */
	public double getXVel() {
		return this.myXVel;
	}

	/**
	 * Return y-velocity of this Body.
	 * 
	 * @return value of y-velocity.
	 */
	public double getYVel() {
		return this.myYVel;
	}

	/**
	 *
	 * @return
	 */
	public double getMass() {
		return this.myMass;
	}

	/**
	 *
	 * @return
	 */
	public String getName() {
		return this.myFileName;
	}

	/**
	 * Return the distance between this body and another
	 * 
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */
	public double calcDistance(CelestialBody b) {
		double retSq = (this.myXPos - b.myXPos) * (this.myXPos - b.myXPos)
				+ (this.myYPos - b.myYPos) * (this.myYPos - b.myYPos);
		return Math.sqrt(retSq);
	}

	public double calcForceExertedBy(CelestialBody b) {
		double G = 6.67 * 1e-11;
		double force = G * (this.myMass * b.myMass) / (this.calcDistance(b) * this.calcDistance(b));
		return force;
	}

	public double calcForceExertedByX(CelestialBody b) {
		double forceX = this.calcForceExertedBy(b) * (b.myXPos - this.myXPos) / this.calcDistance(b);
		return forceX;
	}

	public double calcForceExertedByY(CelestialBody b) {
		double forceY = this.calcForceExertedBy(b) * (b.myYPos - this.myYPos) / this.calcDistance(b);
		return forceY;
	}

	public double calcNetForceExertedByX(CelestialBody[] bodies) {
		double sum = 0.0;
		for (CelestialBody b : bodies) {
			if (!b.equals(this)) {
				sum += this.calcForceExertedByX(b);
			}
		}
		return sum;
	}

	public double calcNetForceExertedByY(CelestialBody[] bodies) {
		double sum = 0.0;
		for (CelestialBody b : bodies) {
			if (!b.equals(this)) {
				sum += this.calcForceExertedByY(b);
			}
		}
		return sum;
	}

	public void update(double deltaT, double xforce, double yforce) {
		double xAccel = xforce / this.myMass;
		double yAccel = yforce / this.myMass;
		double nvx = this.myXVel + deltaT * xAccel;
		double nvy = this.myYVel + deltaT * yAccel;
		double nx = this.myXPos + deltaT * nvx;
		double ny = this.myYPos + deltaT * nvy;
		this.myXPos = nx;
		this.myYPos = ny;
		this.myXVel = nvx;
		this.myYVel = nvy;

	}

	/**
	 * Draws this planet's image at its current position
	 */
	public void draw() {
		StdDraw.picture(myXPos, myYPos, "images/" + myFileName);
	}
}
