package dao;

import metier.entites.Produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProduitDaoImpl implements IProduitDao{
    private static Connection connection = Connexion.getConnection();
    @Override
    public Produit save(Produit p) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO produits (designation,prix,quantite) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,p.getDesignation());
            ps.setDouble(2,p.getPrix());
            ps.setInt(3,p.getQuantite());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                p.setId(rs.getInt(1));
            }
            ps.close();
            System.out.println("Produit bien ajoute");
        }catch (Exception e){
            System.out.println("Produit pas bien ajoute");
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public List<Produit> produitParMC(String mc) {
        List<Produit> produits = new ArrayList<Produit>();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from produits where designation like ?");
            ps.setString(1, mc);
            ResultSet rs =ps.executeQuery();
            while (rs.next()){
                Produit produit= new Produit();
                produit.setId(rs.getInt(1));
                produit.setDesignation(rs.getString(2));
                produit.setPrix(rs.getDouble(3));
                produit.setQuantite(rs.getInt(4));
                produits.add(produit);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return produits;
    }

    @Override
    public Produit getProduit(Long id) {
        Produit p = null;
        try {
            PreparedStatement ps = connection.prepareStatement("select * from produits where id=?");
            ps.setLong(1, id);
            ResultSet rs =ps.executeQuery();
            if (rs.next()){
                p =new Produit();
                p.setId(rs.getLong(1));
                p.setDesignation(rs.getString(2));
                p.setPrix(rs.getDouble(3));
                p.setQuantite(rs.getInt(4));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public Produit upadte(Produit p) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE  produits SET designation= ? ,prix=?,quantite=? WHERE id=?");
            ps.setString(1,p.getDesignation());
            ps.setDouble(2,p.getPrix());
            ps.setInt(3,p.getQuantite());
            ps.setLong(4,p.getId());
            ps.executeUpdate();
            ps.close();
            System.out.println("Produit bien modifie");
        }catch (Exception e){
            System.out.println("Produit pas bien modifie");
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public void delete(Long id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE from produits where id=?");
            ps.setLong(1,id);
            ps.executeUpdate();
            ps.close();
            System.out.println("Produit bien supprime");
        }catch (Exception e){
            System.out.println("Produit pas bien supp");
            e.printStackTrace();
        }
    }
}
