package annotation.advancedlevel.rolebasedcontrol;


import java.lang.reflect.Method;

public class AccessControl {

    // Method to check if the user has access to the method
    public static void checkAccess(User user, Object obj, String methodName) {
        try {
            // Get the method from the class
            Method method = obj.getClass().getMethod(methodName, User.class);

            // Check if the method has the @RoleAllowed annotation
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                // Get the role allowed from the annotation
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                String allowedRole = roleAllowed.value();

                // Compare the user's role with the required role
                if (allowedRole.equals(user.getRole())) {
                    // If roles match, invoke the method
                    method.invoke(obj, user);
                } else {
                    // If roles do not match, print "Access Denied!"
                    System.out.println("Access Denied!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
