import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

public class MouseDeliriumTremens {
	public static final int SLEEP_MILLIS = 60 * 1000;

	// This app gets the mouse pointer's current location and moves the mouse to where it already is. 
	// From a user perspective the mouse doesn't move, but it does prevent the computer from going idle.
	public static void main(String... args) throws Exception {
		Robot robot = new Robot();
		while (true) {
			Point point = MouseInfo.getPointerInfo().getLocation();
			robot.mouseMove(point.x, point.y);
			System.out.println("Mouse Moved!!");
			Thread.sleep(SLEEP_MILLIS);
		}
	}
}