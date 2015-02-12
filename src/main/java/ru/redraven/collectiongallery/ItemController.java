package ru.redraven.collectiongallery;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/")
public class ItemController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/item", method = RequestMethod.GET, produces = "application/json")
	public Item item(@RequestParam(value="name", defaultValue="World") String name) {
		return new Item(counter.incrementAndGet(),
				String.format(template, name));
	}
}
