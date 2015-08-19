/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totaltech.testesdecodigo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Atendimento
 */
@Entity
@Table(name = "nota_entrada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotaEntrada.findAll", query = "SELECT n FROM NotaEntrada n"),
    @NamedQuery(name = "NotaEntrada.findByIdnotaEntrada", query = "SELECT n FROM NotaEntrada n WHERE n.idnotaEntrada = :idnotaEntrada"),
    @NamedQuery(name = "NotaEntrada.findByNumero", query = "SELECT n FROM NotaEntrada n WHERE n.numero = :numero"),
    @NamedQuery(name = "NotaEntrada.findByChave", query = "SELECT n FROM NotaEntrada n WHERE n.chave = :chave"),
    @NamedQuery(name = "NotaEntrada.findByDataEmi", query = "SELECT n FROM NotaEntrada n WHERE n.dataEmi = :dataEmi"),
    @NamedQuery(name = "NotaEntrada.findByDataEnt", query = "SELECT n FROM NotaEntrada n WHERE n.dataEnt = :dataEnt"),
    @NamedQuery(name = "NotaEntrada.findByCaminho", query = "SELECT n FROM NotaEntrada n WHERE n.caminho = :caminho")})
public class NotaEntrada implements Serializable {
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_total")
    private String valorTotal;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnota_entrada")
    private Integer idnotaEntrada;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "chave")
    private String chave;
    @Column(name = "data_emi")
    @Temporal(TemporalType.DATE)
    private Date dataEmi;
    @Column(name = "data_ent")
    @Temporal(TemporalType.DATE)
    private Date dataEnt;
    @Column(name = "caminho")
    private String caminho;
    @JoinColumn(name = "idfornecedor", referencedColumnName = "idfornecedor")
    @ManyToOne(optional = false)
    private Fornecedor idfornecedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idnotaEntrada")
    private List<EntradaProduto> entradaProdutoList;

    public NotaEntrada() {
    }

    public NotaEntrada(Integer idnotaEntrada) {
        this.idnotaEntrada = idnotaEntrada;
    }

    public Integer getIdnotaEntrada() {
        return idnotaEntrada;
    }

    public void setIdnotaEntrada(Integer idnotaEntrada) {
        this.idnotaEntrada = idnotaEntrada;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public Date getDataEmi() {
        return dataEmi;
    }

    public void setDataEmi(Date dataEmi) {
        this.dataEmi = dataEmi;
    }

    public Date getDataEnt() {
        return dataEnt;
    }

    public void setDataEnt(Date dataEnt) {
        this.dataEnt = dataEnt;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public Fornecedor getIdfornecedor() {
        return idfornecedor;
    }

    public void setIdfornecedor(Fornecedor idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

    @XmlTransient
    public List<EntradaProduto> getEntradaProdutoList() {
        return entradaProdutoList;
    }

    public void setEntradaProdutoList(List<EntradaProduto> entradaProdutoList) {
        this.entradaProdutoList = entradaProdutoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnotaEntrada != null ? idnotaEntrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaEntrada)) {
            return false;
        }
        NotaEntrada other = (NotaEntrada) object;
        if ((this.idnotaEntrada == null && other.idnotaEntrada != null) || (this.idnotaEntrada != null && !this.idnotaEntrada.equals(other.idnotaEntrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.totaltech.testesdecodigo.NotaEntrada[ idnotaEntrada=" + idnotaEntrada + " ]";
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public void addEntradaProduto(EntradaProduto entradaProduto){
        if(entradaProdutoList == null){
            this.entradaProdutoList = new ArrayList<EntradaProduto>();
        }
        this.entradaProdutoList.add(entradaProduto);
    
    }
    
}
