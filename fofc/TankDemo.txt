// TankDemo.java -- make an ASCII-art "movie" of fish swimming around in a tank
public class TankDemo {
    public static void main(String argv[]) {
	// defaults so command line arguments are optional
	int nfish = 5, width = 30, depth = 10, max_speed = 10, nframes = 1;
	// command line arguments can override defaults
	switch (argv.length) { // handle all cmd line args using fall-through
	    case 5: nframes = Integer.parseInt(argv[4]);
	    case 4: max_speed = Integer.parseInt(argv[3]);
	    case 3: depth = Integer.parseInt(argv[2]);
	    case 2: width = Integer.parseInt(argv[1]);
	    case 1: nfish = Integer.parseInt(argv[0]);
	}
	Tank t = new Tank(nfish, width, depth, max_speed);
	SwimmingFish.census();
	for (int i = 0; i < nframes; i++) {  // make a "movie"
	    t.draw();  // draw one "frame" of the movie
	    t.tick(1); // let one "second" elapse before the next frame
	}
    }
}
