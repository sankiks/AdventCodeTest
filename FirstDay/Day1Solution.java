package FirstDay;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Day1Solution {

	private static void Day1Puzzle1() {
		List<Integer> scans = GetScans();
		puzzleFinder(scans);
	}

	private static void Day1Puzzle2() {
		List<Integer> scans = GetScans();
		scans = windowPuzzle(scans);
		puzzleFinder(scans);
	}

	private static List<Integer> GetScans() {
		List<Integer> scans = new ArrayList<>();
		try {
			File file = new File("files/Day1Input.txt");
			Scanner reader = new Scanner(file);
			while (reader.hasNext()) {
				scans.add(Integer.parseInt(reader.nextLine()));
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred. File path is incorrect");
		}
		return scans;
	}

	private static List<Integer> windowPuzzle(List<Integer> list) {
		List<Integer> windows = new ArrayList<>();
		int first = list.get(0);
		int second = list.get(1);
		int third = 0;
		for (int i = 2; i < list.size(); i++) {
			third = list.get(i);
			windows.add(first + second + third);
			first = list.get(i - 1);
			second = list.get(i);

		}
		return windows;
	}

	private static void puzzleFinder(List<Integer> list) {
		ListIterator<Integer> iterator = list.listIterator();
		int counter = 0;
		int previus = iterator.next();
		int current = 0;
		while (iterator.hasNext()) {
			current = iterator.next();
			if (current > previus) {
				counter++;

			}
			previus = current;
		}

		System.out.println(counter);
	}

	public static void main(String[] args) {

		Day1Solution.Day1Puzzle2();

	}

}
