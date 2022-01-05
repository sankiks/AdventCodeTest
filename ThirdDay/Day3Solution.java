package FirstDay;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day3Solution {

	private static List<String> getScans() {

		List<String> scansBits = new ArrayList<>();

		try {
			File file = new File("files/Day3Input.txt");
			Scanner reader = new Scanner(file);
			while (reader.hasNext()) {

				scansBits.add(reader.next());
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred. File path is incorrect");
		}

		return scansBits;
	}

	private static void GetGammaEpsilonRate(List<String> list) {
		String gamma = "", epsilon = "";
		int counter1, counter0;
		for (int i = 0; i < list.get(0).length(); i++) {
			counter1 = 0;
			counter0 = 0;
			for (int j = 0; j < list.size(); j++) {

				if ('1' == list.get(j).charAt(i)) {
					counter1++;
				} else if ('0' == list.get(j).charAt(i)) {
					counter0++;
				}
			}
			System.out.println("counter0= " + counter0 + " counter1= " + counter1);
			if (counter0 > counter1) {
				gamma = gamma + '0';
			} else {
				gamma = gamma + '1';
			}
		}
		for (int i = 0; i < gamma.length(); i++) {
			if (gamma.charAt(i) == '1') {
				epsilon = epsilon + '0';
			} else {
				epsilon = epsilon + '1';
			}
		}
		System.out.println("gama= " + gamma + " epsilon= " + epsilon);

		int gamaint = Integer.parseInt(gamma, 2);
		int epsilonint = Integer.parseInt(epsilon, 2);
		System.out.println("gamaint= " + gamaint + " epsilonint= " + epsilonint);
		System.out.println(gamaint * epsilonint);
	}

	private static List<String> GetCo2Rating(List<String> list, int index) {
		int counter1 = 0, counter0 = 0;
		List<String> ratings = new ArrayList<>();
		if (list.size() == 1) {
			return list;
		}
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).charAt(index) == '1') {
				counter1++;
			} else {
				counter0++;
			}
		}
		if (counter1 < counter0) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).charAt(index) == '1') {
					ratings.add(list.get(i));
				}

			}
		} else {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).charAt(index) == '0') {
					ratings.add(list.get(i));
				}

			}

		}

		return GetCo2Rating(ratings, index + 1);
	}

	private static List<String> GetOxyRating(List<String> list, int index) {
		int counter1 = 0, counter0 = 0;
		List<String> ratings = new ArrayList<>();
		if (list.size() == 1) {
			return list;
		}
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).charAt(index) == '1') {
				counter1++;
			} else {
				counter0++;
			}
		}
		if (counter1 >= counter0) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).charAt(index) == '1') {
					ratings.add(list.get(i));
				}

			}

		} else {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).charAt(index) == '0') {
					ratings.add(list.get(i));
				}

			}

		}

		return GetOxyRating(ratings, index + 1);
	}

	private static void GetRating(List<String> list) {
		List<String> OXRatings = new ArrayList<>();
		List<String> Co2Ratings = new ArrayList<>();
		int counter1 = 0, counter0 = 0, index = 0;
		for (int i = 0; i < list.size(); i++) {

			if ('1' == list.get(i).charAt(index)) {
				counter1++;
			} else if ('0' == list.get(i).charAt(index)) {
				counter0++;
			}

		}
		if (counter1 > counter0) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).startsWith("1")) {
					OXRatings.add(list.get(i));
				} else {
					Co2Ratings.add(list.get(i));
				}

			}
		} else if (counter0 > counter1) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).startsWith("0")) {
					OXRatings.add(list.get(i));
				} else {
					Co2Ratings.add(list.get(i));
				}

			}
		} else {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(index).startsWith("1")) {
					OXRatings.add(list.get(i));
				} else {
					Co2Ratings.add(list.get(i));
				}

			}
		}
		OXRatings = GetOxyRating(OXRatings, 1);
		Co2Ratings = GetCo2Rating(Co2Ratings, 1);
		System.out.println(Integer.parseInt(OXRatings.get(0), 2) * Integer.parseInt(Co2Ratings.get(0), 2));
	}

	public static void main(String[] args) {
		Day3Solution.GetRating(getScans());
	}

}
