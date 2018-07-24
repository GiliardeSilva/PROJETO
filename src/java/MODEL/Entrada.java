/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Giliarde
 */
@Entity
@Table(name = "Entrada")
public class Entrada implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codEntrada")
    private int codigo;
    
    @Column (name = "data")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;   
    
    @Column ( name = "precoTotal")
    private double precoTotal;
    
    @Column (name = "quantidadeEntrada")
    private int quantidadeEntrada;
    
    @JoinColumn(name = "codProduto", referencedColumnName = "codProduto")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Produto produto;

    public Entrada() {
    }

    public Entrada(int codigo, Date data, double precoTotal, int quantidadeEntrada, Produto produto) {
        this.codigo = codigo;
        this.data = data;
        this.precoTotal = precoTotal;
        this.quantidadeEntrada = quantidadeEntrada;
        this.produto = produto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public int getQuantidadeEntrada() {
        return quantidadeEntrada;
    }

    public void setQuantidadeEntrada(int quantidadeEntrada) {
        this.quantidadeEntrada = quantidadeEntrada;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.codigo;
        hash = 67 * hash + Objects.hashCode(this.data);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.precoTotal) ^ (Double.doubleToLongBits(this.precoTotal) >>> 32));
        hash = 67 * hash + this.quantidadeEntrada;
        hash = 67 * hash + Objects.hashCode(this.produto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Entrada other = (Entrada) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (Double.doubleToLongBits(this.precoTotal) != Double.doubleToLongBits(other.precoTotal)) {
            return false;
        }
        if (this.quantidadeEntrada != other.quantidadeEntrada) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entrada{" + "codigo=" + codigo + ", data=" + data + ", precoTotal=" + precoTotal + ", quantidadeEntrada=" + quantidadeEntrada + ", produto=" + produto + '}';
    }

 

    

    
    
}
