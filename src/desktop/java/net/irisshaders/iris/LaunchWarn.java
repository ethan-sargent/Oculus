package net.irisshaders.iris;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class LaunchWarn {
	public static void main(String[] args) {
		// TODO: make this translatable
		String message = DesktopBuildConfig.IS_SHARED_BETA
			? "If you're seeing this, you didn't read instructions.\n (Hint: This isn't a installer or a Fabric mod. It's a (Neo)Forge mod.)"
			: "This file is the Forge version of Oculus, meant to be installed as a mod. Would you like to get the NeoForge Installer instead?";
		String fallback = DesktopBuildConfig.IS_SHARED_BETA
			? "If you're seeing this, you didn't read instructions.\n (Hint: This isn't a installer or a Fabric mod. It's a (Neo)Forge mod.)"
			: "This file is the Forge version of Oculus, meant to be installed as a mod. Please download the NeoForge Installer from https://neoforged.net.";
		if (GraphicsEnvironment.isHeadless()) {
			System.err.println(fallback);
		} else {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ReflectiveOperationException | UnsupportedLookAndFeelException ignored) {
				// Ignored
			}

			if (Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
				int option = JOptionPane.showOptionDialog(null, message, "Oculus Installer", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

				if (option == JOptionPane.YES_OPTION) {
					try {
						Desktop.getDesktop().browse(URI.create("https://neoforged.net"));
					} catch (IOException e) {
						System.out.println("Welp; we're screwed.");
						e.printStackTrace();
					}
				}
			} else {
				// Fallback for Linux, etc users with no "default" browser
				JOptionPane.showMessageDialog(null, fallback);
			}
		}

		System.exit(0);
	}
}
