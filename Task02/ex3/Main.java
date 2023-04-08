package Task02.ex3;
import Task02.ex2.View;
/** Вычисление и отображение результатов<br>
 * Содержит реализацию статического метода main()
 * @author xone
 * @version 3.0
 * @see Main#main
 */
public class Main extends Task02.ex2.Main { /** Инициализирует поле {@linkplai view} */
    public Main(View view) {
        super(view);

    }/** Выполняется при запуске программы;
     * вызывает метод {@linkplain}
     * @param args - параметры запуска программы
     */
    public static void main(String[] args) {
        Main main = new Main(new ViewableTable().getView());
        main.menu();
    }
}