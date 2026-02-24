package com.ftsoft.mdt;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MouseDeliriumTremens {
	private static final Logger LOGGER = Logger.getLogger(MouseDeliriumTremens.class.getName());
	private static final int DEFAULT_SLEEP_MILLIS = 180 * 1000;
	private static final int DEFAULT_START_HOUR = 8;
	private static final int DEFAULT_END_HOUR = 18;
	
	private static int sleepMillis;
	private static int startHour;
	private static int endHour;
	private static int moveDirection = 1;

	public static void main(String[] args) {
		initializeConfiguration();
		LOGGER.info("MouseDeliriumTremens started - Interval: " + (sleepMillis/1000) + "s, Active hours: " + startHour + ":00-" + endHour + ":00");
		Robot robot;
		try {
			robot = new Robot();
			addShutdownHook();
			
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int maxY = screenSize.height - 1;
			
			while (true) {
				if (checkTimeInterval()) {
					Point point = MouseInfo.getPointerInfo().getLocation();
					int newY = point.y + moveDirection;
					
					if (newY < 0 || newY > maxY) {
						moveDirection *= -1;
						newY = point.y + moveDirection;
					}
					
					robot.mouseMove(point.x, newY);
					moveDirection *= -1;
					LOGGER.fine("Mouse moved at position: (" + point.x + ", " + newY + ")");
				} else {
					LOGGER.fine("Outside active time interval");
				}
				Thread.sleep(sleepMillis);
			}
		} catch (AWTException e) {
			LOGGER.log(Level.SEVERE, "Failed to create Robot instance", e);
			System.exit(1);
		} catch (InterruptedException e) {
			LOGGER.log(Level.WARNING, "Thread interrupted, shutting down", e);
			Thread.currentThread().interrupt();
		}
	}

	private static void initializeConfiguration() {
		sleepMillis = Integer.parseInt(System.getProperty("mouse.sleep.millis", String.valueOf(DEFAULT_SLEEP_MILLIS)));
		startHour = Integer.parseInt(System.getProperty("mouse.start.hour", String.valueOf(DEFAULT_START_HOUR)));
		endHour = Integer.parseInt(System.getProperty("mouse.end.hour", String.valueOf(DEFAULT_END_HOUR)));
	}
	
	private static boolean checkTimeInterval() {
		LocalTime now = LocalTime.now();
		int hour = now.getHour();
		return hour >= startHour && hour <= endHour;
	}
	
	private static void addShutdownHook() {
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			LOGGER.info("MouseDeliriumTremens shutting down");
		}));
	}
}
