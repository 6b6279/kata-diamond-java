package de.cas.mse.exercise.diamond;

import java.util.StringJoiner;
import java.util.Arrays;

public class Diamond {

	public static String generateAscii(int numKarats) {
		if (numKarats <= 0 || numKarats % 2 == 0) {
			return null;
		}
		
		StringJoiner joiner = new StringJoiner("\n", "", "\n");

		boolean maximumReached = false;
		int currentWidth = 1;
		// If we have already counted down, and the next line would contain no stars, abort
		while (!(maximumReached == true && currentWidth < 0)) {
			if (currentWidth == numKarats) {
				maximumReached = true;
			}
			
			char[] leadingSpaces = new char[(numKarats - currentWidth) / 2];
			Arrays.fill(leadingSpaces, ' ');
			char[] stars = new char[currentWidth];
			Arrays.fill(stars, '*');

			joiner.add(new String(leadingSpaces)
							.concat(new String(stars)));

			if (maximumReached) {
				// Start counting down, when the widest line is reached
				currentWidth -= 2;
			} else {
				currentWidth += 2;
			}
		}

		return joiner.toString();
	}

}
