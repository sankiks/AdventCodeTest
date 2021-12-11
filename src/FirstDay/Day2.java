package FirstDay;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.Position;

public class Day2 {

	private static void puzzle3() {
		position(getScans());
	}
	
	private static void puzzle4() {
		position2(getScans());
	}

	private static List<String> getScans() {
		List<String> scans = new ArrayList<>();
		try {
			File file = new File("files/inputDirections.txt");
			Scanner reader = new Scanner(file);
			while (reader.hasNext()) {
				scans.add(reader.nextLine());

			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
		}

		return scans;

	}

	private static void position2(List<String> scans) {
		int Aim = 0, horisontel = 0, position = 0, depth = 0;
		String[] sample;
		Iterator<String> iterator = scans.iterator();
		while (iterator.hasNext()) {
			sample = iterator.next().split(" ");

			if (sample[0].equals("up")) {
				Aim = Aim - Integer.parseInt(sample[1]);

			} else if (sample[0].equals("down")) {
				Aim = Aim + Integer.parseInt(sample[1]);
			} else if (sample[0].equals("forward")) {
				horisontel = horisontel + Integer.parseInt(sample[1]);
				depth =(Integer.parseInt(sample[1])* Aim) + depth;
			}
		}
		position = depth * horisontel;
		System.out.println(position);
		
	}

	private static void position(List<String> scans) {
		int depth = 0, horisontel = 0, position = 0;

		String[] sample;
		Iterator<String> iterator = scans.iterator();
		while (iterator.hasNext()) {
			sample = iterator.next().split(" ");
			System.out.println(sample[0]);
			if (sample[0].equals("up")) {
				depth = depth - Integer.parseInt(sample[1]);

			} else if (sample[0].equals("down")) {
				depth = depth + Integer.parseInt(sample[1]);
			} else if (sample[0].equals("forward")) {
				horisontel = horisontel + Integer.parseInt(sample[1]);
			}
		}

		position = depth * horisontel;
		System.out.println(position);
	}

	public static void main(String[] args) {
		Day2 obj = new Day2();
		obj.puzzle4();
	}

}
