/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jpawebdemo.servlet;

import com.mycompany.jpawebdemo.dao.CourseDAO;
import com.mycompany.jpawebdemo.entity.Course;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

/**
 *
 * @author 20113
 */
@WebServlet("/courses")
public class CourseServlet extends HttpServlet {
    private final CourseDAO dao = new CourseDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "new" -> req.getRequestDispatcher("/courses/add.jsp").forward(req, resp);
            case "edit" -> {
                int id = Integer.parseInt(req.getParameter("id"));
                Course c = dao.findById(id);
                req.setAttribute("course", c);
                req.getRequestDispatcher("/courses/edit.jsp").forward(req, resp);
            }
            default -> {
                req.setAttribute("list", dao.findAll());
                req.getRequestDispatcher("/courses/list.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");

        if (null != action) switch (action) {
            case "insert" -> {
                Course c = new Course();
                c.setTitle(req.getParameter("title"));
                c.setCredits(Integer.parseInt(req.getParameter("credits")));
                dao.save(c);
                }
            case "update" -> {
                int id = Integer.parseInt(req.getParameter("id"));
                Course c = dao.findById(id);
                c.setTitle(req.getParameter("title"));
                c.setCredits(Integer.parseInt(req.getParameter("credits")));
                dao.update(c);
                }
            case "delete" -> {
                int id = Integer.parseInt(req.getParameter("id"));
                dao.delete(id);
                }
            default -> {
            }
        }

        resp.sendRedirect(req.getContextPath() + "/courses");
    }
}
