package dao.test;

import dao.ProduitDaoImpl;
import metier.entites.Produit;

import java.util.List;

public class TestDao {
    public static void main(String[] args){
        ProduitDaoImpl dao =new ProduitDaoImpl();
        Produit p1= dao.save(new Produit("HP 6580",900,45));
        Produit p2= dao.save(new Produit("Imprimante Epson 760",1000,15));
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        List<Produit> produits = dao.produitParMC("%H%");
        for (Produit P: produits){
            System.out.println(P.toString());
        }
    }

}
