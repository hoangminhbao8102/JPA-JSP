/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jpawebdemo.servlet;

import com.mycompany.jpawebdemo.dao.StudentDAO;
import com.mycompany.jpawebdemo.entity.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

/**
 *
 * @author 20113
 */
@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    private final StudentDAO dao = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "new" -> req.getRequestDispatcher("/students/add.jsp").forward(req, resp);
            case "edit" -> {
                int id = Integer.parseInt(req.getParameter("id"));
                Student s = dao.findById(id);
                req.setAttribute("student", s);
                req.getRequestDispatcher("/students/edit.jsp").forward(req, resp);
            }
            default -> {
                req.setAttribute("list", dao.findAll());
                req.getRequestDispatcher("/students/list.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");

        if (null != action) switch (action) {
            case "insert" -> {
                Student s = new Student();
                s.setName(req.getParameter("name"));
                s.setEmail(req.getParameter("email"));
                dao.save(s);
                }
            case "update" -> {
                int id = Integer.parseInt(req.getParameter("id"));
                Student s = dao.findById(id);
                s.setName(req.getParameter("name"));
                s.setEmail(req.getParameter("email"));
                dao.update(s);
                }
            case "delete" -> {
                int id = Integer.parseInt(req.getParameter("id"));
                dao.delete(id);
                }
            default -> {
            }
        }

        resp.sendRedirect(req.getContextPath() + "/students");
    }
}
