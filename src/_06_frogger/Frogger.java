package _06_frogger;

import java.util.Random;

import processing.core.PApplet;
import processing.core.PImage;

public class Frogger extends PApplet {
	static final int WIDTH = 800;
	static final int HEIGHT = 600;
	Random ran = new Random();
	Frog frog = new Frog(400, 500);
	Car car1 = new Car(ran.nextInt(400 - 1) + 1, 170);
	Car car2 = new Car(ran.nextInt(400 - 1) + 1, 240);
	Car car3 = new Car(ran.nextInt(400 - 1) + 1, 300);
	Car car4 = new Car(ran.nextInt(400 - 1) + 1, 400);
	PImage frogImage;
	PImage carImage;
	PImage backgroundImage;
	@Override
	public void settings() {
		size(WIDTH, HEIGHT);

	}

	@Override
	public void setup() {
		frogImage = loadImage("frog.png");
		frogImage.resize(50, 50);
		carImage = loadImage("carRight.png");
		carImage.resize(100, 50);
		backgroundImage = loadImage("froggerBackground.png");
		backgroundImage.resize(800, 600);
	}

	public void keyPressed() {

		if (key == CODED) {

			if (keyCode == UP && frog.y > 30) {
				frog.y -= 10;
			} else if (keyCode == DOWN && frog.y < 570) {
				frog.y += 10;
				// Frog Y position goes down
			} else if (keyCode == RIGHT && frog.x < 770) {
				frog.x += 10;
				// Frog X position goes right
			} else if (keyCode == LEFT && frog.x > 30) {
				frog.x -= 10;
				// Frog X position goes left
			}
		}
	}

	@Override
	public void draw() {

		image (backgroundImage, 0,0);
		frog.draw();
		car1.draw();
		car2.draw();
		car3.draw();
		car4.draw();
		car1.moveLeft();
		car2.moveRight();
		car3.moveLeft();
		car4.moveRight();
		if (intersects(car1)) {
			frog.resetFrog();
		}
		if (intersects(car2)) {
			frog.resetFrog();
		}
		if (intersects(car3)) {
			frog.resetFrog();
		}
		if (intersects(car4)) {
			frog.resetFrog();
		}

	}

	static public void main(String[] args) {
		PApplet.main(Frogger.class.getName());
	}

	boolean intersects(Car car) {
		if ((frog.gety() > car.getY() && frog.gety() < car.getY() + 50)
				&& (frog.getX() > car.getX() && frog.getX() < car.getX() + car.getwidth())) {
			return true;
		} else {
			return false;
		}
	}

	// Make Car class here
	class Car {

		int getX() {
			return x;
		}

		int getY() {
			return y;
		}

		int getwidth() {
			return width;
		}

		int getheight() {
			return height;
		}

		int x = 0;
		int y = 0;

		Car(int x, int y) {
			this.x = x;
			this.y = y;
		}

		int width = 100;
		int height = 50;

		void draw() {
			image (carImage,x,y);
		}

		void moveLeft() {
			x -= 1;
			if (x == -10) {
				x = 800;
			}

		}

		void moveRight() {
			x += 1;
			if (x == 800) {
				x = -10;
			}
		}

	}

	class Frog {
		void resetFrog() {
			x = 400;
			y = 550;
		}

		int x = 0;
		int y = 0;

		int getX() {
			return x;
		}

		int gety() {
			return y;
		}

		Frog(int x, int y) {
			this.x = x;
			this.y = y;
		}

		void draw() {
			image(frogImage, x, y);
		}
	}

}
