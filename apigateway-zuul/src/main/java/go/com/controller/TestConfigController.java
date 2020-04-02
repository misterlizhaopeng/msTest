package go.com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestConfigController {

    @Value("${constant}")  // 来自config server
    private  String t;

    @GetMapping("/getVal/{id}")
    public String getVal(@PathVariable("id")  String id){
        return "configServer->"+t+";Input->"+id;
    }
}
