package controller;


    import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.CalculatorService;

    @RestController
    public class Calculatorcontroller {

        private final CalculatorService service;

        public Calculatorcontroller(CalculatorService service) {

            this.service = service;
        }
        @RequestMapping("/calculator")
        public String hello () {
            return "Добро пожаловать в калькулятор";
        }
        @RequestMapping("/calculator")
        public String plus ( @RequestParam("num1") int param1, @RequestParam("num2") int param2){
            return param1 + " + " + param2 + "=" + service.plus(param1, param2);

        }
        @RequestMapping("/calculator/minus")
        public String minus (@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2){
            if (num1 == null || num2 == null) {
                return "Один из аргументов не передан ! ";
            }
            return num1 + " - " + num2 + "=" + service.minus(num1, num2);

        }
        @RequestMapping("/calculator/multiply")
        public String multiply ( @RequestParam int num1, @RequestParam int num2){
            return num1 + " * " + num2 + "=" + service.multiply(num1, num2);

        }
        @RequestMapping("/calculator/divide")
        public String division ( @RequestParam int num1, @RequestParam int num2) {
            if (num2 == 0) {
                return "На ноль делить нельзя";

            }
        }