package Task02.ex1;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Калькулятор для вычисления сумы площадей треугольника
 */
public class Calc implements Serializable {
    private String binaryString;
    private int triArea;
    private int recArea;
    private int sumArea;

    /**
     * Метод где пользователь может ввести число в двоичном формате
     */
    public void printBinaryString(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть довжину сторони (в двійковій системі числення): ");
        binaryString = scanner.nextLine();
        calculate();
    }

    /**
     * Метод который генерирует случайное двоичное число
     */
    public void generateBinaryString(){
        int temp;
        String binar = "";
        for (int i = 0; i < 10; i++){
            temp = (int) Math.round(Math.random());
            binar += temp;
        }
        binaryString = binar;
        calculate();
    }

    /**
     * Вычисляет треугольник
     */
    public void calculate(){
        int side = Integer.parseInt(binaryString, 2); //Переведення та обчислення
        triArea = (int) (Math.pow(side, 2) * Math.sqrt(3) / 4);
        recArea = (int) (Math.pow(side, 2));
        sumArea = triArea + recArea;
    }

    /**
     * Выводит информацию про треугольник
     */
    public void displayCalc(){
        System.out.println("Площа рівностороннього трикутника: " + triArea); //вивод
        System.out.println("Площа рівностороннього прямокутника: " + recArea);
        System.out.println("Сума площ: " + sumArea);
    }

    public String getBinaryString() {
        return binaryString;
    }

    public void setBinaryString(String binaryString) {
        this.binaryString = binaryString;
    }
}
