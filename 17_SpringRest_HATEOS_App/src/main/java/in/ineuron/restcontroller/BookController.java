package in.ineuron.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.response.Book;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	@GetMapping(value="/getBook/{isbn}",produces="application/json")
	public ResponseEntity<Book> getBook(@PathVariable("isbn") String isbn){
		Book book=new Book(isbn,"Spring",234.5,"Maruthi");
		Link link=WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks())
				.withRel("allBooks");
		book.add(link);
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}
	
	@GetMapping(value="/allBooks")
	public List<Book> getAllBooks(){
		List<Book> bookList=new ArrayList<Book>();
		bookList.add(new Book("111","Spring",350.5,"RodJohnson"));
		bookList.add(new Book("222","Java",355.5,"Gavi"));
		bookList.add(new Book("333","Servlet",360.5,"Seirra"));
		return bookList;
	}

}
