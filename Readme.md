This repository contains "Hello World!" using Spring
It used the following 
```
@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
```
which allows users to type "?anyname" in the URL that shows the Hello World as "Hello Anyname!"
