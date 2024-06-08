package io.github.chubbyhippo.demo.infrastructure;

import io.github.chubbyhippo.demo.domain.Student;
import io.github.chubbyhippo.demo.domain.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Qualifier("jpaRepository")
public class StudentRepositoryImpl implements StudentRepository {

    private final StudentJpaRepository studentJpaRepository;

    @Override
    public List<Student> findAll() {
        return studentJpaRepository.findAll();
    }

    @Override
    public List<Student> find10Students() {
        var pageRequest = PageRequest.of(0, 10);
        return studentJpaRepository.findAll(pageRequest)
                .stream()
                .toList();
    }
}
