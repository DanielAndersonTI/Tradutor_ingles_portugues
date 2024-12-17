package com.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.modelo.TranslationService;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/translate")
public class TranslationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TranslationService translationService;
    private static final Logger LOGGER = Logger.getLogger(TranslationServlet.class.getName());

    @Override
    public void init() throws ServletException {
        String filePath = getServletContext().getRealPath("/WEB-INF/translations.txt");
        try {
            translationService = new TranslationService(filePath);
            LOGGER.info("TranslationService initialized successfully with file: " + filePath);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Unable to load translations", e);
            throw new ServletException("Unable to load translations", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            String word = request.getParameter("word");
            String translation = translationService.translate(word);
            request.setAttribute("originalWord", word);
            request.setAttribute("translation", translation);
            request.getRequestDispatcher("/result.jsp").forward(request, response);
            LOGGER.info("Translation processed for word: " + word);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error processing request", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }
}
