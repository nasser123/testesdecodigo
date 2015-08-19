/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.totaltech.testesdecodigo;

/**
 *
 * @author Producao
 */
public class ProdutoTemp {
    String cProd;		
    String cEAN;		
    String xProd;		
    String NCM;		
    Integer CFOP;		
    String uCom;		
    double qCom;		
    double vUnCom;		
    double vProd;		
    String cEANTrib;
    String uTrib;		
    double qTrib;		
    double vUnTrib;	
    double vDesc;		
    Integer indTot;		

    public String getcProd() {
        return cProd;
    }

    public void setcProd(String cProd) {
        this.cProd = cProd;
    }

    public String getcEAN() {
        return cEAN;
    }

    public void setcEAN(String cEAN) {
        this.cEAN = cEAN;
    }

    public String getxProd() {
        return xProd;
    }

    public void setxProd(String xProd) {
        this.xProd = xProd;
    }

    public String getNCM() {
        return NCM;
    }

    public void setNCM(String NCM) {
        this.NCM = NCM;
    }

    public Integer getCFOP() {
        return CFOP;
    }

    public void setCFOP(Integer CFOP) {
        this.CFOP = CFOP;
    }

    public String getuCom() {
        return uCom;
    }

    public void setuCom(String uCom) {
        this.uCom = uCom;
    }

    public double getqCom() {
        return qCom;
    }

    public void setqCom(double qCom) {
        this.qCom = qCom;
    }

    public double getvUnCom() {
        return vUnCom;
    }

    public void setvUnCom(double vUnCom) {
        this.vUnCom = vUnCom;
    }

    public double getvProd() {
        return vProd;
    }

    public void setvProd(double vProd) {
        this.vProd = vProd;
    }

    public String getcEANTrib() {
        return cEANTrib;
    }

    public void setcEANTrib(String cEANTrib) {
        this.cEANTrib = cEANTrib;
    }

    public String getuTrib() {
        return uTrib;
    }

    public void setuTrib(String uTrib) {
        this.uTrib = uTrib;
    }

    public double getqTrib() {
        return qTrib;
    }

    public void setqTrib(double qTrib) {
        this.qTrib = qTrib;
    }

    public double getvUnTrib() {
        return vUnTrib;
    }

    public void setvUnTrib(double vUnTrib) {
        this.vUnTrib = vUnTrib;
    }

    public double getvDesc() {
        return vDesc;
    }

    public void setvDesc(double vDesc) {
        this.vDesc = vDesc;
    }

    public Integer getIndTot() {
        return indTot;
    }

    public void setIndTot(Integer indTot) {
        this.indTot = indTot;
    }
    public String getProdutoExtenso(){
        return (this.cProd + "-" + this.xProd + "-" + this.vUnCom);
    }

}
