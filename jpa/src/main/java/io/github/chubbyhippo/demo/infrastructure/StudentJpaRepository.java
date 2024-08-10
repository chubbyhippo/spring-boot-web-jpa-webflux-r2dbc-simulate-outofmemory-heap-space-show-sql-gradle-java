package io.github.chubbyhippo.demo.infrastructure;

import io.github.chubbyhippo.demo.domain.Student;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import java.util.stream.Stream;

public interface StudentJpaRepository extends JpaRepository<Student, Long> {

//    @Query("SELECT s FROM Student s")
    @Query(value = "select * from student", nativeQuery = true)
    @QueryHints(value = {@QueryHint(name = "org.hibernate.fetchSize", value = "10")})
    Stream<Student> findAllWithStream();
}
