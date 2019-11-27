package JBehaveTests;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.util.Arrays;
import java.util.List;

public class RunJBehaveTest extends JUnitStories {
    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryLoader(
                        new LoadFromClasspath(this.getClass().getClassLoader()))
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withDefaultFormats()
                                .withFormats(Format.HTML, Format.CONSOLE)
                                .withRelativeDirectory("jbehave-report"));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
//        ArrayList<JBehaveTestSteps> stepFileList = new ArrayList<>();
//        stepFileList.add(new JBehaveTestSteps());

        return new InstanceStepsFactory(configuration(), new JBehaveTestSteps());
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().
                findPaths(CodeLocations.codeLocationFromClass(
                        this.getClass()),
                        Arrays.asList("**/*.story"),
                        Arrays.asList(""));

    }
}
