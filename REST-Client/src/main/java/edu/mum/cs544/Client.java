package edu.mum.cs544;

import edu.mum.cs544.model.Customer;
import edu.mum.cs544.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Client implements CommandLineRunner {

    @Autowired
    CustomerService customerService;

//    BookService bookServiceApi;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Client Running...");

        Customer customer = new Customer(1, "Su", "Thwe", "Fairfield", "123-456");
        customerService.add(customer);

        /*Book book = bookServiceApi.get(1);
        Book newBook = new Book("NewFromClient", "978-0-306-40615-7", "clientAuthor", 12d);
        bookServiceApi.add(newBook);
        System.out.println(bookServiceApi.getAll());
        book.setPrice(999d);
        bookServiceApi.update(book);
        System.out.println(bookServiceApi.getAll());
        bookServiceApi.delete(2);
        System.out.println(bookServiceApi.getAll());
        book = bookServiceApi.getAll().get(0);
        System.out.println(book.getTitle());*/
    }

}
