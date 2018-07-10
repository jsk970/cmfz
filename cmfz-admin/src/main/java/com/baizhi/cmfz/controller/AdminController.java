package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;


    @RequestMapping("/regist")
    @ResponseBody
    public boolean regist(Admin admin){
        System.out.println(admin);
        int i = adminService.addAdmin(admin);
        if(i!=0){
            return true;
        }else{
            return false;
        }
    }


    @RequestMapping("/login")
    @ResponseBody
    public String login(String name, String password,String enCode,boolean RememberUsername, HttpSession session,HttpServletResponse response){

       // System.out.println(name);
        //System.out.println(password);


        String result = "success";
        Admin admin = null;
        String code = (String) session.getAttribute("code");
        if(code.equalsIgnoreCase(enCode)){
            try {
                admin = adminService.queryAdminByNameAndPassword(name, password);
                if(RememberUsername){

                    Cookie name1 = new Cookie("name", URLEncoder.encode(name, "utf-8"));
                    name1.setMaxAge(6000);
                    response.addCookie(name1);
                }
                session.setAttribute("Admin",admin);
                return result;
            } catch (Exception e) {

                return "errorAdmin";
            }

        }else{
            return "errorCode";
        }

    }

    @RequestMapping("/getCookie")
    @ResponseBody
    public String getCookie(HttpServletRequest request){
        Cookie[] cks = request.getCookies();
        String result = "";
        for (Cookie ck : cks)
            if (ck.getName().equals("name")) {

                try {
                    result =  URLDecoder.decode(ck.getValue(), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
    return result;
    }
}
