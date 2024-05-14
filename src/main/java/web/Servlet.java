package web;
import dao.IProduitDao;
import dao.ProduitDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.entites.Produit;

import java.io.IOException;
import java.util.List;
@WebServlet(name = "cs" ,urlPatterns = "*.do")
public class Servlet extends HttpServlet {
    private IProduitDao metier;
    @Override
    public void init() throws ServletException {
        metier= new ProduitDaoImpl();
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{
        //pour avoir le path utilse pour l'acces a cette servlet
        String path = request.getServletPath();
        if (path.equals("/index.do")){
            request.getRequestDispatcher("produits.jsp").forward(request,response);
        }
        else if(path.equals("/chercher.do")){
            String motCle = request.getParameter("motCle");
            ProduitModel model= new ProduitModel();
            model.setMotCle(motCle);
            List<Produit> produits = metier.produitParMC("%"+motCle +"%");
            model.setProduits(produits);
            request.setAttribute("model",model);
            request.getRequestDispatcher("produits.jsp").forward(request,response);
        } else if (path.equals("/saisie.do")) {
            request.setAttribute("produit",new Produit());
            request.getRequestDispatcher("saisieProduits.jsp").forward(request,response);
        } else if (path.equals("/saveProduit.do") && (request.getMethod().equals("POST"))) {
            String des = request.getParameter("designation");
            double prix = Double.parseDouble(request.getParameter("prix"));
            int quantite = Integer.parseInt(request.getParameter("quantite"));
            Produit p=metier.save(new Produit(des,prix,quantite));
            request.setAttribute("produit",p);
            request.getRequestDispatcher("confirm.jsp").forward(request,response);
        } else if (path.equals("/supprimer.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            metier.delete(id);
            //request.getRequestDispatcher("produits.jsp").forward(request,response);
            response.sendRedirect("chercher.do?motCle=");
        }  else if (path.equals("/edit.do")) {
        Long id = Long.parseLong(request.getParameter("id"));
        Produit p = metier.getProduit(id);
        request.setAttribute("produit",p);
        request.getRequestDispatcher("EditProduit.jsp").forward(request,response);
    }
        else if (path.equals("/update.do") && (request.getMethod().equals("POST"))) {
            Long id =  Long.parseLong(request.getParameter("id"));
            String des = request.getParameter("designation");
            double prix = Double.parseDouble(request.getParameter("prix"));
            int quantite = Integer.parseInt(request.getParameter("quantite"));
            Produit p=metier.save(new Produit(des,prix,quantite));
            p.setId(id);
            metier.upadte(p);
            request.setAttribute("produit",p);
            request.getRequestDispatcher("confirm.jsp").forward(request,response);
        }
        else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
