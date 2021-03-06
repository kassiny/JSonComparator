package JsonStructure;

import JsonStructure.Application;
import JsonStructure.Description;

public class MetaData {
    Description description;
    Application application;

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    @Override
    public String toString() {
        return "JsonStructure.MetaData{" +
                "description=" + description +
                ", application=" + application +
                '}';
    }
}
