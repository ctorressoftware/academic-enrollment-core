package io.github.ctorressoftware.academic.enrollment;

import org.springframework.boot.SpringApplication;

public class TestAcademicEnrollmentCoreApplication {

    public static void main(String[] args) {
        SpringApplication.from(AcademicEnrollmentCoreApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
