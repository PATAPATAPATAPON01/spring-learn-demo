package spring.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Part;
/**
 * Created with IntelliJ IDEA.
 * User: za-lvjian
 * Date: 2017/8/14 14:19
 * DESC:
 */
@Controller
public class UserController {


    @PostMapping("/upload")
    @ResponseBody
    @ResponseStatus()
    @ExceptionHandler()
    public void uploadFile(@RequestPart("myFile") Part part, @RequestParam("myname") String name) { //使用part接受文件上传，就没有必要


        System.out.println(name);
        System.out.println(part);

    }




}
