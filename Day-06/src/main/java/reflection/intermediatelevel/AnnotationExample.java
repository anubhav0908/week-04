package reflection.intermediatelevel;

import java.lang.annotation.Annotation;

public class AnnotationExample {
    public static void main(String[] args) {
        try {
            // Get the Book class using reflection
            Class<?> bookClass = Book.class;

            // Check if the Author annotation is present on the class
            if (bookClass.isAnnotationPresent(Author.class)) {
                // Retrieve the Author annotation
                Author authorAnnotation = bookClass.getAnnotation(Author.class);

                // Display the name value from the annotation
                System.out.println("Author Name: " + authorAnnotation.name());
            } else {
                System.out.println("No Author annotation present on the Book class.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

