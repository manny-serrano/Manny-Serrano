

/**
 * Celestial Body class for NBody
 * Modified from original Planet class
 * used at Princeton and Berkeley
 * @author ola
 * 
 *
 * If you add code here, add yourself as @author below
 *@author Emmanuel Serrano
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
	 * @param xp initial x position
	 * @param yp initial y position
	 * @param xv initial x velocity
	 * @param yv initial y velocity
	 * @param mass of object
	 * @param filename of image for object animation
	 */
	public CelestialBody(double xp, double yp, double xv,
			             double yv, double mass, String filename){
		myXPos = xp;
		myYPos = yp;
		myXVel = xv;
		myYVel = yv;
		myMass = mass;
		myFileName = filename;


	}

	/**
	 *
	 * @return
	 */
	public double getX() {
		// TODO: complete method
		return myXPos;
	}

	/**
	 *
	 * @return
	 */
	public double getY() {
		// TODO: complete method
		return myYPos;
	}

	/**
	 * Accessor for the x-velocity
	 * @return the value of this object's x-velocity
	 */
	public double getXVel() {
		// TODO: complete method
		return myXVel;
	}
	/**
	 * Return y-velocity of this Body.
	 * @return value of y-velocity.
	 */
	public double getYVel() {
		// TODO: complete method
		return myYVel;
	}

	/**
	 *
	 * @return
	 */
	public double getMass() {
		// TODO: complete method
		return myMass;
	}

	/**
	 *
	 * @return
	 */
	public String getName() {
		// TODO: complete method
		return myFileName;
	}

	/**
	 * Return the distance between this body and another
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */
	public double calcDistance(CelestialBody b) {
		// TODO: r^2 = dx^2 + dy^2

		double distance = Math.sqrt(((b.getX() - myXPos)*(b.getX() - myXPos)) + ((b.getY()-myYPos)*(b.getY()-myYPos)) );
		return distance;
	}

	public double calcForceExertedBy(CelestialBody b) {
		double distance = calcDistance(b);
		double force = (6.67*1e-11)*((myMass *b.getMass())/(distance*distance));
		return force;
	}

	public double calcForceExertedByX(CelestialBody b) {
		double forceex = calcForceExertedBy(b)* ((b.getX() - myXPos)) / calcDistance(b);
		return forceex;
	}
	public double calcForceExertedByY(CelestialBody b) {
		double forceex = calcForceExertedBy(b)* ((b.getY() - myYPos)) / calcDistance(b);
		return forceex;
	}

	public double calcNetForceExertedByX(CelestialBody[] bodies) {
		double sum = 0;

		for(CelestialBody body: bodies) {
			if(!body.equals(this)) {
				sum += calcForceExertedByX(body);
			}
		}

		return sum;
	}

	public double calcNetForceExertedByY(CelestialBody[] bodies) {
		double sum = 0;
		for(CelestialBody body: bodies) {
			if(!body.equals(this)) {
				sum += calcForceExertedByY(body);
			}
		}

		return sum;
	}

	public void update(double deltaT, 
			           double xforce, double yforce) {
		double ax = xforce / myMass;
		double ay = yforce / myMass;

		double nvx = myXVel + deltaT * ax;
		double nvy = myYVel + deltaT * ay;

		double nx = myXPos + deltaT * nvx;
		double ny = myYPos + deltaT * nvy;

		this.myXPos = nx;
		this.myYPos = ny;
		this.myXVel = nvx;
		this.myYVel = nvy;
	}

	/**
	 * Draws this planet's image at its current position
	 */
	public void draw() {
		StdDraw.picture(myXPos,myYPos,"images/"+myFileName);
	}
}
