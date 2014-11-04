package org.springframework.web.bind.annotation;

import java.lang.annotation.*;

/**
 * Annotation which indicates that a method parameter should be bound to a URI template
 * variable. Supported for {@link RequestMapping} annotated handler methods in Servlet
 * environments.
 *
 * @author Arjen Poutsma, backported to 2.5.6 by Jakub Fojtl
 * @see RequestMapping
 * @see org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter
 * @see org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter
 * @since 3.0
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PathVariable {

    /** The URI template variable to bind to. */
    String value() default "";

}
