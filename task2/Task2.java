package task2;

import java.io.*;

public class Task2 {

    public static void main(String[] args) {
        Circle circle = getCircle(args[0]);
        getPoint(args[1], circle);
    }

    public static Circle getCircle(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String[] centre = bufferedReader.readLine().split(" ");
            return new Circle(Float.parseFloat(centre[0]), Float.parseFloat(centre[1]), Float.parseFloat(bufferedReader.readLine()));
            //circle.showCircle();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        } catch (IOException e) {
            System.out.println("Ошибка данных");
        }
        return null;
    }

    public static void getPoint(String path, Circle circle) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            int count = 0;
            while (bufferedReader.ready() || count >= 100) {
                String[] point = bufferedReader.readLine().split(" ");
                System.out.println(getPosition(circle, Float.parseFloat(point[0]), Float.parseFloat(point[1])));
                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        } catch (IOException e) {
            System.out.println("Ошибка данных");
        }
    }

    public static int getPosition(Circle c, float x, float y) {
        if ((x - c.centreX) * (x - c.centreX) + (y - c.centreY) * (y - c.centreY) < c.r * c.r) {
            return 1;
        } else if ((x - c.centreX) * (x - c.centreX) + (y - c.centreY) * (y - c.centreY) > c.r * c.r) {
            return 2;
        } else return 0;
    }

    public static class Circle {
        float centreX;
        float centreY;
        float r;

        public Circle(float centreX, float centreY, float r) {
            this.centreX = centreX;
            this.centreY = centreY;
            this.r = r;
        }
        public void showCircle() {
            System.out.println(String.format("Создана окружность с корродинатами центра %.1f, %.1f и радиусом %.1f", centreX, centreY, r));
        }
    }
}
