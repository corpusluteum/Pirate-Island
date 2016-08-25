package com.manik.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.manik.StartIslandMenu;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title=StartIslandMenu.TITLE;
		new LwjglApplication(new StartIslandMenu(), config);
	}
}
