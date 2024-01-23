import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.Locale;

public class LocaleExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {
    private Locale originalLocale;

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        originalLocale = Locale.getDefault();

        Locale.setDefault(Locale.US);
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        Locale.setDefault(originalLocale);
    }
}
