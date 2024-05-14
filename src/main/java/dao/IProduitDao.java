package dao;

import metier.entites.Produit;

import java.util.List;

public interface IProduitDao {
    public Produit save(Produit p);
    public List<Produit> produitParMC(String mc);//mc = mot cle
    public Produit getProduit(Long id);
    public Produit upadte(Produit p);
    public void delete(Long id);
}
