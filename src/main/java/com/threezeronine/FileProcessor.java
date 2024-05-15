package com.threezeronine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileProcessor {

    public static void read(String fName) throws FileNotFoundException {
        int flag = 0;
        List<Point> points = new ArrayList<Point>();
        Scanner scanner = new Scanner(new File(fName));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("EOF")) {
                break;
            }
            else if (flag == 1) {
                line = line.substring(line.indexOf(' '));
                line = line.trim();
                double x_cord = Double.parseDouble(line.substring(0, line.indexOf(' ')));

                line = line.substring(line.indexOf(' '));
                line = line.trim();

                double y_cord = Double.parseDouble(line);

                points.add(new Point((int)x_cord, (int)y_cord));

            } else if (flag == 0 && line.charAt(0) == '1') {
                flag = 1;
            }
        }
        Fitting.fit((ArrayList<Point>) points);
        Repository repo = Repository.getInstance();
        repo.addPoints(points);
    }
}
