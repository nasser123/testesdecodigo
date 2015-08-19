/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totaltech.testesdecodigo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Atendimento
 */
@Entity
@Table(name = "entrada_produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntradaProduto.findAll", query = "SELECT e FROM EntradaProduto e"),
    @NamedQuery(name = "EntradaProduto.findByIdentradaProduto", query = "SELECT e FROM EntradaProduto e WHERE e.identradaProduto = :identradaProduto"),
    @NamedQuery(name = "EntradaProduto.findByCfop", query = "SELECT e FROM EntradaProduto e WHERE e.cfop = :cfop"),
    @NamedQuery(name = "EntradaProduto.findByQuantidade", query = "SELECT e FROM EntradaProduto e WHERE e.quantidade = :quantidade"),
    @NamedQuery(name = "EntradaProduto.findByPrecoUnit", query = "SELECT e FROM EntradaProduto e WHERE e.precoUnit = :precoUnit"),
    @NamedQuery(name = "EntradaProduto.findByPIcms", query = "SELECT e FROM EntradaProduto e WHERE e.pIcms = :pIcms"),
    @NamedQuery(name = "EntradaProduto.findByVIcms", query = "SELECT e FROM EntradaProduto e WHERE e.vIcms = :vIcms"),
    @NamedQuery(name = "EntradaProduto.findByPIcmsst", query = "SELECT e FROM EntradaProduto e WHERE e.pIcmsst = :pIcmsst"),
    @NamedQuery(name = "EntradaProduto.findByVIcmsst", query = "SELECT e FROM EntradaProduto e WHERE e.vIcmsst = :vIcmsst"),
    @NamedQuery(name = "EntradaProduto.findByPIpi", query = "SELECT e FROM EntradaProduto e WHERE e.pIpi = :pIpi"),
    @NamedQuery(name = "EntradaProduto.findByVIpi", query = "SELECT e FROM EntradaProduto e WHERE e.vIpi = :vIpi"),
    @NamedQuery(name = "EntradaProduto.findByTotUnit", query = "SELECT e FROM EntradaProduto e WHERE e.totUnit = :totUnit"),
    @NamedQuery(name = "EntradaProduto.findByTotProd", query = "SELECT e FROM EntradaProduto e WHERE e.totProd = :totProd"),
    @NamedQuery(name = "EntradaProduto.findByVFrete", query = "SELECT e FROM EntradaProduto e WHERE e.vFrete = :vFrete")})
public class EntradaProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "identrada_produto")
    private Integer identradaProduto;
    @Column(name = "cfop")
    private Integer cfop;
    @Column(name = "quantidade")
    private Integer quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco_unit")
    private BigDecimal precoUnit;
    @Column(name = "p_icms")
    private BigDecimal pIcms;
    @Column(name = "v_icms")
    private BigDecimal vIcms;
    @Column(name = "p_icmsst")
    private BigDecimal pIcmsst;
    @Column(name = "v_icmsst")
    private BigDecimal vIcmsst;
    @Column(name = "p_ipi")
    private BigDecimal pIpi;
    @Column(name = "v_ipi")
    private BigDecimal vIpi;
    @Column(name = "tot_unit")
    private BigDecimal totUnit;
    @Column(name = "tot_prod")
    private BigDecimal totProd;
    @Column(name = "v_frete")
    private BigDecimal vFrete;
    @JoinColumn(name = "idnota_entrada", referencedColumnName = "idnota_entrada")
    @ManyToOne(optional = false)
    private NotaEntrada idnotaEntrada;
    @JoinColumn(name = "idproduto", referencedColumnName = "idproduto")
    @ManyToOne(optional = false)
    private Produto idproduto;

    public EntradaProduto() {
    }

    public EntradaProduto(Integer identradaProduto) {
        this.identradaProduto = identradaProduto;
    }

    public Integer getIdentradaProduto() {
        return identradaProduto;
    }

    public void setIdentradaProduto(Integer identradaProduto) {
        this.identradaProduto = identradaProduto;
    }

    public Integer getCfop() {
        return cfop;
    }

    public void setCfop(Integer cfop) {
        this.cfop = cfop;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(BigDecimal precoUnit) {
        this.precoUnit = precoUnit;
    }

    public BigDecimal getPIcms() {
        return pIcms;
    }

    public void setPIcms(BigDecimal pIcms) {
        this.pIcms = pIcms;
    }

    public BigDecimal getVIcms() {
        return vIcms;
    }

    public void setVIcms(BigDecimal vIcms) {
        this.vIcms = vIcms;
    }

    public BigDecimal getPIcmsst() {
        return pIcmsst;
    }

    public void setPIcmsst(BigDecimal pIcmsst) {
        this.pIcmsst = pIcmsst;
    }

    public BigDecimal getVIcmsst() {
        return vIcmsst;
    }

    public void setVIcmsst(BigDecimal vIcmsst) {
        this.vIcmsst = vIcmsst;
    }

    public BigDecimal getPIpi() {
        return pIpi;
    }

    public void setPIpi(BigDecimal pIpi) {
        this.pIpi = pIpi;
    }

    public BigDecimal getVIpi() {
        return vIpi;
    }

    public void setVIpi(BigDecimal vIpi) {
        this.vIpi = vIpi;
    }

    public BigDecimal getTotUnit() {
        return totUnit;
    }

    public void setTotUnit(BigDecimal totUnit) {
        this.totUnit = totUnit;
    }

    public BigDecimal getTotProd() {
        return totProd;
    }

    public void setTotProd(BigDecimal totProd) {
        this.totProd = totProd;
    }

    public BigDecimal getVFrete() {
        return vFrete;
    }

    public void setVFrete(BigDecimal vFrete) {
        this.vFrete = vFrete;
    }

    public NotaEntrada getIdnotaEntrada() {
        return idnotaEntrada;
    }

    public void setIdnotaEntrada(NotaEntrada idnotaEntrada) {
        this.idnotaEntrada = idnotaEntrada;
    }

    public Produto getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(Produto idproduto) {
        this.idproduto = idproduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identradaProduto != null ? identradaProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntradaProduto)) {
            return false;
        }
        EntradaProduto other = (EntradaProduto) object;
        if ((this.identradaProduto == null && other.identradaProduto != null) || (this.identradaProduto != null && !this.identradaProduto.equals(other.identradaProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.totaltech.testesdecodigo.EntradaProduto[ identradaProduto=" + identradaProduto + " ]";
    }
    
}
