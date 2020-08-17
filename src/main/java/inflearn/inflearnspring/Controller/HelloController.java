package inflearn.inflearnspring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "Hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-mvc";
    }

    //@ResponseBody는 뷰 리졸버를  사용하지 않는다.
    //대신 HTTP 바디에 리턴한 문자 내용을 그대로 직접 반환 (HTML BODY TAG 아님)
    @GetMapping("hello-string")

    public @ResponseBody String helloString(@RequestParam("name") String name){
        return "hello" + name;
    }

    //@ResponseBody를 사용하고 객체를 반환하면 객체가 JSON으로 변환됨
    @GetMapping("hello-api")

    public  @ResponseBody Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    //내브 클래스
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
