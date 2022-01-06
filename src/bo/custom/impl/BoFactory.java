package bo.custom.impl;

public class BoFactory {
    private static BoFactory boFactory;
    private BoFactory() {
    }

    public static BoFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BoFactory();
        }
        return boFactory;
    }

    public enum BOTypes {
        COURSE;
    }

    public CourseBo getBO(BOTypes types) {
        switch (types) {
            case COURSE:
                return new CourseBoImpl();
            default:
                return null;
        }
    }
}
