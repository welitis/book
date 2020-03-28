package com.welisit.web;

import com.welisit.bean.User;
import com.welisit.service.UserService;
import com.welisit.service.impl.UserServiceImpl;
import com.welisit.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;


/**
 * @author Welisit
 */
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect(req.getContextPath() + "/pages/user/login.jsp");
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User userOfParam = WebUtils.copyParamsToBean(req.getParameterMap(), new User());
        User user = userService.login(userOfParam);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            String lastUrl = req.getParameter("lastUrl");
            if (lastUrl == null || "".equals(lastUrl)) {
                resp.sendRedirect(req.getContextPath() + "/pages/user/login_success.jsp");
            } else {
                resp.sendRedirect(lastUrl);
            }
        } else {
            System.out.println("用户名["+ userOfParam.getUsername() +"]或密码错误");
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("parameterMap", req.getParameterMap());
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String code = req.getParameter("code");

        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        if (token != null && token.equalsIgnoreCase(code)) {
            // 验证码输入正确

            if (userService.existUsername(username)) {
                // 判断用户名是否存在
                System.out.println("用户名" + username + "已存在");
                req.setAttribute("msg", "用户名已存在");
                req.setAttribute("parameterMap", req.getParameterMap());
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                User user = WebUtils.copyParamsToBean(req.getParameterMap(), new User());
                userService.register(user);
                resp.sendRedirect(req.getContextPath() + "/pages/user/regist_success.jsp");
            }

        } else {
            System.out.println("验证码[" + code + "]错误");
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("parameterMap", req.getParameterMap());
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }

    }

}
