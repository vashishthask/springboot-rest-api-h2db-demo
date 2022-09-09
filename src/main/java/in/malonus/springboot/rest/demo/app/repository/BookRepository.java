package in.malonus.springboot.rest.demo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.malonus.springboot.rest.demo.app.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

}
