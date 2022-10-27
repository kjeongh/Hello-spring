package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!");
        model.addAttribute("data", "hi!");


        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(required = true) String id, Model model) {
        model.addAttribute("test", "commit");

        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http프로토콜의 body부에 이 내용을 직접 넣어주겠다.
    public String helloString(@RequestParam("name") String test) {
        return "hello"+test;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloInstance(@RequestParam("param") String name) {
        Hello hello = new Hello();
        hello.setHelloString(name);
        return hello;

    }


    static class Hello {
        private String  helloString;


        public void setHelloString(String helloString) {
            this.helloString = helloString;
        }

        public String getHelloString() {
            return helloString;
        }
    }

}
