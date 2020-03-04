package com.example.fortest.bookoa;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class BookOaController {

    public static Map<Integer,String> books = new HashMap<>();

    @GetMapping(value = "/addBook/{id}/{name}")
    public Boolean addBook(@PathVariable("id") Integer id,@PathVariable("name") String name){
        if(id==null || id<=0 || StringUtils.isEmpty(name)){
            System.out.println("书籍添加失败，参数为==>"+id+","+name);
            return false;
        }
        System.out.println("成功添加书籍id="+id+",书名:"+name);
        books.put(id,name);
            return true;
    }

    @GetMapping(value = "/addBook/{name}")
    public Map<Integer,String> getBookLike(@PathVariable("name") String book){
        Map rs = new HashMap();
        books.forEach((k,v)->{
            if(v.indexOf(book)>-1){
                rs.put(k,v);
            }
        });
        return rs;
    }

}
