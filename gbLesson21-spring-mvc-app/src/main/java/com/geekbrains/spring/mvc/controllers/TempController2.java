package com.geekbrains.spring.mvc.controllers;

//import com.geekbrains.spring.mvc.model.Box;
import com.geekbrains.spring.mvc.model.Box;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TempController2 {
    // GET http://localhost:8189/app/temp
    @RequestMapping(value = "/temp", method = RequestMethod.GET)
    public String showTempPage() {
        return "temp-page";
    }
    //WEB-INF/templates/temp-page.html //1)MVC ищет здесь (указали папку->файл->расширение)

    // GET http://localhost:8189/app/simple_str
    @RequestMapping(value = "/simple_str", method = RequestMethod.GET)
    @ResponseBody//2)в теле ответа вернет то что в return-e
    public String showSimpleString() {
        return "Hello, World!!!";
    }

    //
    // GET http://localhost:8189/app/show_obj
    //@RequestMapping(value = "/show_obj", method = RequestMethod.GET)
    @GetMapping("/show_obj")
    @ResponseBody//3) вернем объект Box-a(в формате JSON), то есть ответом будет объект
    public Box showJavaObject() {
        return new Box(1L, "Green", 10);
    }

    // GET http://localhost:8189/app/show_obj
    @PostMapping("/show_obj")
    @ResponseBody
    public Box showJavaObjectPost() {
        return new Box(1L, "Red", 10);
    }

    // POST http://localhost:8189/app/simple_post
    //@RequestMapping(value = "/simple_post", method = RequestMethod.POST)
    @PostMapping("/simple_post")//4) для поста используем программу Postman(для отправки REST запросов)
    @ResponseBody
    public String simplePostRequest() {
        return "Post request";
    }

    // GET http://localhost:8189/app/hello1?name=Bob
    @GetMapping("/hello1")
    @ResponseBody
    public String sayHello1(@RequestParam String name) {//5) для назначения параметра

        return String.format("Hello, %s!", name);
    }

    // GET http://localhost:8189/app/hello?name=Bob
    @GetMapping("/hello")
    @ResponseBody
    public String sayHello(@RequestParam(required = false) String name, @RequestParam(required = false) String surname) {
        //6)RequestParam сделали не обязательным
        if (name == null && surname == null) {
            return "Hello, stranger!!!";
        }
        StringBuilder resultName = new StringBuilder();
        if (name != null) {
            resultName.append(name).append(" ");
        }
        if (surname != null) {
            resultName.append(surname);
        } else {
            resultName.setLength(resultName.length() - 1);
        }
        return String.format("Hello, %s!!!", resultName.toString());
    }
    // GET http://localhost:8189/app/show_product/88/show
    @GetMapping("/show_product/{id}/show")
    @ResponseBody
    public String showProductById(@PathVariable Long id) {
        return "Product #" + id;
    }
}

