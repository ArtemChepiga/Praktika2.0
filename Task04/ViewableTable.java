package Task02.ex3;
import Task02.ex2.ViewableResult;
import Task02.ex2.View;
/** ConcreteCreator
 * (шаблон проектирования
 * Factory Method)<br>
 * Объявляет метод,
 * "фабрикующий" объекты
 * @author xone
 * @version 1.0
 * @see ViewableResult
 * @see ViewableTable#getView()
 */
public class ViewableTable extends ViewableResult {
    /** Создаёт отображаемый объект {@linkplain ViewTable} */
    @Override
    public View getView() {
        return new ViewTable();
    }
}