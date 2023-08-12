package com.eazybytes.eazyschool.repository;

import com.eazybytes.eazyschool.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Integer> {
    /*
    Spring Data JPA allows us to apply static sorting by adding the OrderBy keyword
    to the method name along with the property name and sort direction (Asc or Desc).
     */

    List<Courses> findByOrderByNameDesc();


    /*
    sorts the results in the ascending order.
    The Asc keyword is optional as OrderBy, by default,
     */
}
