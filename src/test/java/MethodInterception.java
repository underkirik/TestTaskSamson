import Interfaces.MainPage;
import Interfaces.Selector;
import org.testng.annotations.Test;

import java.lang.reflect.Proxy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * @author Кирилл Копанчиков
 * Задание №1
 * Прокси класс создается и возвращается в нужном методе, тест выполняется
 * Добавил аннтацию, чтоб не делать два проекта и тест не ломался, т.к. без аннотации ловим NullPointerException
 */
@TestMethodInfo(priority = AnnotationMethod.Priority.Minor, author = "Кирилл Копанчиков", lastModified = "22.09.2022")
public class MethodInterception {

    @Test(testName = "Задание №1")
    public void annotationValue() {
        MainPage mainPage = createPage(MainPage.class);
        assertNotNull(mainPage);
        assertEquals(mainPage.buttonSearch(), ".//*[@test-attr='button_search']");
        assertEquals(mainPage.textInputSearch(), ".//*[@test-attr='input_search']");
    }

    /**
     * Метод для создания прокси-класса, служит как пустая имплементация интерфейса и получение параметров аннотации
     *
     * @param clazz - класс, на основе которого получаем загрузчик
     * @return - возвращаем прокси-класс созданного интерфейса
     */
    private MainPage createPage(Class clazz) {
        return (MainPage) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{MainPage.class},
                ((proxy, method, args) -> method.getAnnotation(Selector.class).xpath()));
    }
}
