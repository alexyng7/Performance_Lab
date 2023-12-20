package task4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        int[] nums = getValueToArray(args[0]);
        getMinStep(nums);
    }

    public static int[] getValueToArray(String path) {
        int[] nums;
        List<Integer> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while (bufferedReader.ready()) {
                list.add(Integer.parseInt(bufferedReader.readLine()));
            }
            //System.out.println("Получен массив " + Arrays.toString(nums));
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка данных.");
        } catch (IOException e) {
        }
        // создаем массив необходимой длинны и записываем в него полученные из файла элементы
        nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    public static void getMinStep(int[] array) {
        int sumValue = 0;
        for (int i : array) {
            sumValue += i;
        }
        int averageValue = sumValue / array.length;
        //System.out.println("среднее число " + averageValue);
        int minStep = 0;
        for (int j = 0; j < array.length; j++) {
            int value = array[j];
            while (value != averageValue) {
                if (value < averageValue) {
                    value++;
                } else {
                    value--;
                }
                minStep++;
            }
        }
        System.out.println(minStep);
    }
}
