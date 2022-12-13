package _06_frogger;

import java.util.Random;

import processing.core.PApplet;

public class Frogger extends PApplet {
	static final int WIDTH = 800;
	static final int HEIGHT = 600;
	Random ran = new Random();
	Frog frog = new Frog(400, 500);
	 Car car1 = new Car(ran.nextInt(400 - 1)+1,100); 
	 Car car2 = new Car(ran.nextInt(400 - 1)+1,200); 
	 Car car3 = new Car(ran.nextInt(400 - 1)+1,300); 
	 Car car4 = new Car(ran.nextInt(400 - 1)+1,400); 
	@Override
	public void settings() {
		size(WIDTH, HEIGHT);

	}

	@Override
	public void setup() {
	
		
		
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

		background(0, 0, 255);
		frog.draw();
		car1.draw();
		car2.draw();
		car3.draw();
		car4.draw();
		car1.move();
		car2.move();
		car3.move();
		car4.move();

	}

	static public void main(String[] args) {
		PApplet.main(Frogger.class.getName());
	}

	// Make Car class here
	class Car {
		
		int x = 0;
		int y = 0;

		Car(int x, int y) {
			this.x = x;
			this.y = y;
		}

		void draw() {
			    fill(0,255,0);
			    rect(x , y,  100, 50);
		}
void move(){
	x-=1;
	if (x==-10) {
		x=800;
	}
			
}
		
	}

	class Frog {
		int x = 0;
		int y = 0;

		Frog(int x, int y) {
			this.x = x;
			this.y = y;
		}

		void draw() {
			fill(0, 255, 0);
			ellipse(x, y, 50, 50);
		}
	}

}
