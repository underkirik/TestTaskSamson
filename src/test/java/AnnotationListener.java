import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

/**
 * @author Кирилл Копанчиковъ
 * Класс имплементирующий слушатель, который выполняет перед методами
 * Он и выводит информацию в консоль, подгружается через ServiceLoader, как в документации
 */
public class AnnotationListener implements IInvokedMethodListener {

    /**
     * Метод выполняется перед выполняемыми методами теста
     *
     * @param iInvokedMethod - выполняемый метод теста
     * @param iTestResult    - результат теста
     */
    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        TestMethodInfo testMethodInfo = (TestMethodInfo) iInvokedMethod.getTestMethod().getRealClass().getAnnotation(TestMethodInfo.class);
        System.out.println("Priority - " + testMethodInfo.priority());
        System.out.println("Author - " + testMethodInfo.author());
        System.out.println("LastModified - " + testMethodInfo.lastModified());
    }

    /**
     * Метод выполняется после выполняемыми методами теста
     *
     * @param iInvokedMethod - выполняемый метод теста
     * @param iTestResult    - результат теста
     */
    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        System.out.println("Test is finished");
    }
}
