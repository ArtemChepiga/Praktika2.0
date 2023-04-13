package Task02.ex2;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import Task02.ex1.Calc;

/** ConcreteProduct
 * (Шаблон проектирования
 * Factory Method)<br>
 * Вычисление функции,
 * сохранение и отображение
 * результатов
 * @author xone
 * @version 1.0
 * @see View
 */
public class ViewResult implements View {
    /** Имя файла, используемое при сериализации */
    private static final String FNAME = "items.bin";
    /** Определяет количество значений для вычисления по умолчанию */
    private static final int DEFAULT_NUM = 10;
    /** Коллекция аргументов и результатов вычислений */
    private ArrayList<Calc> items = new ArrayList<Calc>();
    /** Вызывает {@linkplain ViewResult#ViewResult(int n) ViewResult(int n)}
     * с параметром {@linkplain ViewResult#DEFAULT_NUM DEFAULT_NUM}
     */
    public ViewResult() {
        this(DEFAULT_NUM);
    }
    /** Инициализирует коллекцию {@linkplain ViewResult#items}
     * @param n начальное количество элементов
     */
    public ViewResult(int n) {
        for(int ctr = 0; ctr < n; ctr++) {
            items.add(new Calc());
        }
    }
    /** Получить значение {@linkplain ViewResult#items}
     * @return текущее значение ссылки на объект {@linkplain ArrayList}
     */
    public ArrayList<Calc> getItems() {
        return items;
    }
    /** Вычисляет значение функции

     11

     * @param x аргумент вычисляемой функции
     * @return результат вычисления функции
     */
    private double calc(double x) {
        return Math.sin(x * Math.PI / 180);
    }
    /** Вычисляет значение функции и сохраняет
     * результат в коллекции {@linkplain ViewResult#items}
     */
    public void init() {
        for(Calc item : items) {
            item.generateBinaryString();
        }
    }
    /** Вызывает <b>init(double stepX)</b> со случайным значением аргумента<br>
     * {@inheritDoc}
     */
    @Override
    public void viewInit() {
        init();
    }
    /** Реализация метода {@linkplain View#viewSave()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewSave() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(items);
        os.flush();
        os.close();
    }
    /** Реализация метода {@linkplain View#viewRestore()}<br>
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void viewRestore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        items = (ArrayList<Calc>) is.readObject();
        is.close();
    }

    /** Реализация метода {@linkplain View#viewHeader()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewHeader() {
        System.out.println("Results:");
    }
    /** Реализация метода {@linkplain View#viewBody()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewBody() {
        for (Calc item : items) {
            item.displayCalc();
            System.out.println("---------------");
        }
    }
    /** Реализация метода {@linkplain View#viewFooter()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewFooter() {
        System.out.println("End.");
    }
    /** Реализация метода {@linkplain View#viewShow()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
    }
}