/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jpawebdemo.servlet;

import com.mycompany.jpawebdemo.dao.CourseDAO;
import com.mycompany.jpawebdemo.dao.EnrollmentDAO;
import com.mycompany.jpawebdemo.dao.StudentDAO;
import com.mycompany.jpawebdemo.entity.Course;
import com.mycompany.jpawebdemo.entity.Enrollment;
import com.mycompany.jpawebdemo.entity.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

/**
 *
 * @author 20113
 */
@WebServlet("/enrollments")
public class EnrollmentServlet extends HttpServlet {
    private final EnrollmentDAO enrollmentDAO = new EnrollmentDAO();
    private final StudentDAO studentDAO = new StudentDAO();
    private final CourseDAO courseDAO = new CourseDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "new" -> {
                req.setAttribute("students", studentDAO.findAll());
                req.setAttribute("courses", courseDAO.findAll());
                req.getRequestDispatcher("/enrollments/add.jsp").forward(req, resp);
            }
            default -> {
                req.setAttribute("list", enrollmentDAO.findAll());
                req.getRequestDispatcher("/enrollments/list.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("insert".equals(action)) {
            int studentId = Integer.parseInt(req.getParameter("studentId"));
            int courseId = Integer.parseInt(req.getParameter("courseId"));

            Student student = studentDAO.findById(studentId);
            Course course = courseDAO.findById(courseId);

            Enrollment enrollment = new Enrollment();
            enrollment.setStudent(student);
            enrollment.setCourse(course);

            enrollmentDAO.save(enrollment);
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            enrollmentDAO.delete(id);
        }

        resp.sendRedirect(req.getContextPath() + "/enrollments");
    }
}
