package com.example.fortest.onlinereading;

import com.example.fortest.onlinereading.feign.BookOaService;
import com.example.fortest.onlinereading.feign.PayService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class OnlineController {

    @Autowired
    PayService payService;

    @Autowired
    BookOaService bookOaService;
    public static final double fee = 10;
    public static Map<Integer,String> books = new HashMap<>();

    @GetMapping(value = "/getBook/{id}/{page}")
    public Msg getBook(String id,int page){
        Msg msg = new Msg();
        //判断金额是否足够
        if(!payService.pay(fee)){
            msg.setMsgCode("-1");
            msg.setMsgTxt("金额不足");
            return msg;
        }

        msg.setMsgTxt("succ");
        msg.setMsgCode("1");
        msg.setData("11111111111111111111111111111111111111111111111111111");
        return msg;
    }

    @GetMapping(value = "/findBookIdByName/{name}")
    public Msg findBookIdByName(String name){
        Map<Integer,String> books = bookOaService.getBookLike(name);
        final Msg msg = new Msg();
        if (books.size()==0){
            msg.setMsgCode("-1");
            msg.setMsgTxt("没有找到相关书籍");
            return msg;
        }

        msg.setMsgTxt("succ");
        msg.setMsgCode("1");
        books.forEach((k,v)->{
            msg.setData(msg.getData()+k+"_"+v+",");;
        });
        return msg;
    }



}
