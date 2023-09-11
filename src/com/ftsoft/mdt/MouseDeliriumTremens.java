package com.ftsoft.mdt;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.util.Calendar;

public class MouseDeliriumTremens {
	public static final int SLEEP_MILLIS = 180 * 1000;

	// This app gets the mouse pointer's current location and moves the mouse to
	// where it already is.
	// From a user perspective the mouse doesn't move, but it does prevent the
	// computer from going idle.
	public static void main(String[] args) {
		Robot robot;
		try {
			robot = new Robot();		
			Point pointOld= null;
			while (true) {
				if (checkTimeInterval()) {				
					Point point = MouseInfo.getPointerInfo().getLocation();
					if (pointOld==null || !point.equals(pointOld)) {
						robot.mouseMove(point.x, point.y+1);
						pointOld= point;
						//System.out.println("Mouse Moved!!");
					}
				} else {
					//System.out.println("Not in time interval");
				}
				Thread.sleep(SLEEP_MILLIS);
			}
		} catch (AWTException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static boolean checkTimeInterval() {
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		//int minutes = cal.get(Calendar.MINUTE);
		return hour >= 8 && hour <= 18;
	}
}
