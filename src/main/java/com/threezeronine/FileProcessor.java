package com.threezeronine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileProcessor {

    public static void read(String fName) throws FileNotFoundException {
        int flag = 0;
        ArrayList<Point> points = new ArrayList<>();
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

                points.add(new Point(x_cord, y_cord));

            } else if (flag == 0 && line.charAt(0) == '1') {
                flag = 1;
            }
        }
        Fitting.fit(points);
        Repository repo = Repository.getInstance();
        for (Point p : points) {
            repo.addPoint(p);
        }
    }
}
