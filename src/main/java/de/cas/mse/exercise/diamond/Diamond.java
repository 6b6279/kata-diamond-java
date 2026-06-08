package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public static String print(int numKarats) {
		if (numKarats <= 0 || numKarats % 2 == 0) {
			return null;
		}
		StringBuilder builder = new StringBuilder();

		boolean maximumReached = false;
		int currentWidth = 1;
		while (currentWidth <= numKarats && !(maximumReached == true && currentWidth == -1)) {
			if (currentWidth == numKarats) {
				maximumReached = true;
			}
			String currentLine = "";
			char[] leadingSpaces = new char[(numKarats - currentWidth) / 2];
			Arrays.fill(leadingSpaces, ' ');
			char[] stars = new char[currentWidth];
			Arrays.fill(stars, '*');

			builder.append(currentLine.concat(new String(leadingSpaces))
							.concat(new String(stars))
							.concat("\n"));

			if (maximumReached) {
				// Start counting down, when the widest line is reached
				currentWidth -= 2;
			} else {
				currentWidth += 2;
			}
		}

		return builder.toString();
	}

}
