import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Кирилл Копанчиков
 * Задание №2
 * Надеюсь, я правильно понял, что аннотация должна быть на уровне класса
 */
@TestMethodInfo(priority = AnnotationMethod.Priority.Critical, author = "Test user", lastModified = "20.08.2019")
public class AnnotationMethod {

    public enum Priority {
        Blocker, Critical, Major, Minor
    }

    @Test(testName = "Задание №2")
    public void annotation() {
        assertEquals(1, 1);
    }
}
