package com.nasir.order.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nasir.order.book.entity.Books;

@Repository
public interface BookRepository extends JpaRepository<Books,Long> {

}
