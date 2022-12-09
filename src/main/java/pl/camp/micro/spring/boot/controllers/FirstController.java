package pl.camp.micro.spring.boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.camp.micro.spring.boot.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class FirstController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        System.out.println("Działa !!");
        System.out.println("Przyszedł request HTTP !!!");

        return "index";
    }

    @RequestMapping(path = "/test2", method = RequestMethod.GET)
    /*@GetMapping("/test2")
    @PostMapping("/test2")
    @PutMapping("/test2")*/
    public String test2() {
        System.out.println("Metoda test2 !!!");
        System.out.println("tez dziala !!!");

        return "index";
    }

    @RequestMapping(path = "/test3", method = RequestMethod.GET)
    public String test3(@RequestParam("wiek") int age,
                        @RequestParam("imie") String name) {
        System.out.println(age);
        System.out.println(name);

        return "index";
    }

    @RequestMapping(value = "/test4/{age}/{name}/{cos}", method = RequestMethod.GET)
    public String test4(@PathVariable int age,
                        @PathVariable String name,
                        @PathVariable String cos) {
        System.out.println(age);
        System.out.println(name);
        System.out.println(cos);

        return "index";
    }

    @RequestMapping(value = "/test5/{param1}/{param2}", method = RequestMethod.GET)
    public String test5(@PathVariable String param1,
                        @PathVariable String param2,
                        @RequestParam("wiek") int age,
                        @RequestParam("imie") String name) {
        System.out.println(param1);
        System.out.println(param2);
        System.out.println(age);
        System.out.println(name);

        return "index";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        System.out.println(user);
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String form2(@ModelAttribute User user) {
        System.out.println(user);
        System.out.println("parametry z form");
        System.out.println(user.getName());
        System.out.println(user.getSurname());
        return "index";
    }

    @RequestMapping(value = "/test6", method = RequestMethod.GET)
    public String test6(Model model) {
        List<String> names = new ArrayList<>();
        names.add("Janusz");
        names.add("Mateusz");
        names.add("Wiesiek");
        names.add("Karol");
        names.add("Zbyszek");

        model.addAttribute("name", names.get(new Random().nextInt(names.size())));
        model.addAttribute("imiona", names);

        return "names";
    }
}
