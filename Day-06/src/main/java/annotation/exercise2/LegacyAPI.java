package annotation.exercise2;

// Class LegacyAPI
public class LegacyAPI {

    // Old method marked as deprecated
    @Deprecated
    public void oldFeature() {
        System.out.println("This is the old feature. It is deprecated.");
    }

    // New method to be used instead
    public void newFeature() {
        System.out.println("This is the new feature. Please use this.");
    }
}

