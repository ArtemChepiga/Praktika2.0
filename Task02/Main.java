package Task02.ex1;

import java.io.*;

public class Main {
    private static Calc calc = new Calc();

    /**
     * Метод который вызывает меню
     */
    private void menu() {
        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            do {
                System.out.println("Enter command...");
                System.out.print("'q'uit, 'v'iew, 'g'enerate, 's'ave, 'r'estore: ");
                try {
                    s = in.readLine();
                } catch(IOException e) {
                    System.out.println("Error: " + e);
                    System.exit(0);
                }
            } while (s.length() != 1);
            switch (s.charAt(0)) {
                case 'q':
                    System.out.println("Exit.");
                    break;
                case 'v':
                    System.out.println("View current.");
                    calc.displayCalc();
                    break;
                case 'g':
                    System.out.println("Random generation.");
                    calc.generateBinaryString();
                    calc.displayCalc();
                    break;
                case 's':
                    System.out.println("Save current.");
                    serialize(calc);
                    calc.displayCalc();
                    break;
                case 'r':
                    System.out.println("Restore last saved.");
                    deserealize();
                    calc.displayCalc();
                    break;
                default:
                    System.out.print("Wrong command. ");
            }
        } while(s.charAt(0) != 'q');
    }

    /** Метод который сериализирует объект
     * @param calc - объект, который передаётся на сериализацию
     */
    public boolean serialize(Calc calc){
        try {
            FileOutputStream fs = new FileOutputStream("config.dat");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(calc);
            System.out.println("Serealized!");

            os.close();
            fs.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    /** Метод который десиарилизирует объект
     * @return
     */
    public Calc deserealize(){
        try {
            FileInputStream fs = new FileInputStream("config.dat");
            ObjectInputStream os = new ObjectInputStream(fs);
            Calc calc = new Calc();
            System.out.println("Deserealized!");
            fs.close();
            os.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void main(String args[]){
        Main main = new Main();
        main.menu();
    }
}


