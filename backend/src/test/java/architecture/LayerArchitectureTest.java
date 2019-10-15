package architecture;

import com.phodal.pholedge.core.domain.ApplicationService;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.phodal.pholedge")
public class LayerArchitectureTest {
    private JavaClasses classes;

    @BeforeEach
    void setUp() {
        classes = new ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                .importPackages("com.phodal.pholedge");
    }

    @Nested
    class service {
        @Test
        void services_should_be_named_ending_with_Service() {
            classes()
                    .that().resideInAPackage("..book..")
                    .and().implement(ApplicationService.class)
                    .should().haveSimpleNameEndingWith("ApplicationService")
                    .as("The domain services should be named ending with 'Service'.")
                    .check(classes);
        }
    }
}
