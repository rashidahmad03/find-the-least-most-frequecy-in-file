/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author rashid ahmad
 */
 @MultipartConfig(maxFileSize = 16177215) 
public class Data1 extends HttpServlet {

     
      public static HashMap h = new HashMap();
   static String fh[]=null;
       ArrayList<String> up=new ArrayList<>();
        ArrayList<String> low=new ArrayList<>();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Data1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Data1 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        h.clear();
       low.clear();
       up.clear();
          HttpSession session=request.getSession();
        Part filePart = request.getPart("file");
        int num=Integer.parseInt( request.getParameter("num"));
            String fileName = filePart.getSubmittedFileName();
            InputStream pis = filePart.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(pis));
          int ram=0;
              int kj = 0;
        String jh = "";
      
      
        while ((kj = br.read()) != -1) {
            if ((char) kj == ' '||(char) kj == '.'||(char) kj == ','||(char) kj == '(') {
                data(jh);
                jh = "";
            } else {
                jh = jh + String.valueOf((char) kj);
            }
        }

        System.gc();


        fh= new String[h.size()];
        int n = 0;
        for (Object f:h.keySet()) {
            fh[n++] = String.valueOf(f + ":" + h.get(f));

        }
        int sz=h.size();
        if(num<sz)
            ram=num;
        else{
             Random rand = new Random();
            ram=rand.nextInt(sz);
        }

     //   System.out.println(h.size());
        sor(num);
        
        session.setAttribute("msg1",low);
         session.setAttribute("msg",up);
                      response.sendRedirect("index.jsp"); 
           
        
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
    
  public void  sor(int count){
        
        BUBBLE bs=new BUBBLE(fh);
for(int i=fh.length-1;i>=fh.length-count;i--)
up.add(String.valueOf(bs.tostr()[i]));


System.out.println(up);
for(int i=0;i<count;i++)
          low.add(bs.tostr()[i]);


}
 static void data(String j){

        if  (h.containsKey(j))
        {
            int s= (int) h.get(j);
            s++;

            h.put(j, s);
        }
        else{
            h.put(j,1);
        }

    }
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    
    
    
    
    
    
    
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
