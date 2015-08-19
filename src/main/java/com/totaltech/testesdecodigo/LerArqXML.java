package com.totaltech.testesdecodigo;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Adelcio C. Porto email: portoinfo@sercomtel.com.br
 */
public class LerArqXML {

    ArrayList<ProdutoTemp> produtos = new ArrayList();
    NotaEntrada ne = new NotaEntrada();

    private NotaEntrada lerarq(String caminho) {
//Aqui você informa o nome do arquivo XML. 
        //File f = new File("C:\\Users\\Producao\\Dropbox\\Totaltech\\Softwares\\xml\\teste.xml");
        File f = new File(caminho);

//Criamos uma classe SAXBuilder que vai processar o XML 
        SAXBuilder sb = new SAXBuilder();

//Este documento agora possui toda a estrutura do arquivo. 
        Document d;
        try {
            d = sb.build(f);
//Recuperamos o elemento root 
            Element nfe = d.getRootElement();

//Recuperamos os atributos filhos (Attributes) 
            List atributes = nfe.getAttributes();
            Iterator i_atr = atributes.iterator();

//Iteramos com os atributos filhos 
            while (i_atr.hasNext()) {
                Attribute atrib = (Attribute) i_atr.next();
                //System.out.println("attribute de (" + nfe.getName() + "):" + atrib.getName() + " - valor: " + atrib.getValue());
            }
//Recuperamos os elementos filhos (children) 
            List elements = nfe.getChildren();
            Iterator i = elements.iterator();

//Iteramos com os elementos filhos, e filhos do dos filhos 
            while (i.hasNext()) {
                Element element = (Element) i.next();
                //System.out.println("element:" + element.getName());
                trataElement(element);
            }
            

        } catch (JDOMException ex) {
            Logger.getLogger(LerArqXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LerArqXML.class.getName()).log(Level.SEVERE, null, ex);
        }
       return this.ne; 
    }

    private void trataElement(Element element) {
        ProdutoTemp p = new ProdutoTemp();
        Produto produto = new Produto();
        EntradaProduto entradaProduto = new EntradaProduto();

//Recuperamos os atributos filhos (Attributes) 
        List atributes = element.getAttributes();
        Iterator i_atr = atributes.iterator();

//Iteramos com os atributos filhos 
        while (i_atr.hasNext()) {
            Attribute atrib = (Attribute) i_atr.next();
//            if (atrib.getName().equals("det")) {
//                //System.out.println("attribute de TESTE(" + element.getName() + "):" + atrib.getName() + " - valor: " + atrib.getValue());
//            }
        }
//Recuperamos os elementos filhos (children) 

        List elements = element.getChildren();
        Iterator it = elements.iterator();

//Iteramos com os elementos filhos, e filhos do dos filhos 
        while (it.hasNext()) {

            Element el = (Element) it.next();
            if (element.getName().equals("ide")) {
                if (!el.getText().isEmpty()) {
                    String teste = el.getName();
                    switch (teste) {
                        case ("nNF"):
                            this.ne.setNumero(Integer.parseInt(el.getText()));
                            break;
                        case ("dhEmi"):
                            //ne.setDataEmi((Date)el.getText());
                            break;
                        case ("dhSaiEnt"):
                        //ne.setDataEnt((Date)el.getText());

                    }
                }

            }

            if (element.getName().equals("total")) {
                if (!el.getText().isEmpty()) {
                    String teste = el.getName();
                    switch (teste) {
                        case ("vNf"):
                            this.ne.setValorTotal(el.getText());
                            break;
                    }
                }

            }

            if (element.getName().equals("infProt")) {
                if (!el.getText().isEmpty()) {
                    String teste = el.getName();
                    switch (teste) {
                        case ("chNFe"):
                            this.ne.setChave(el.getText());
                            break;
                    }
                }

            }

            if (element.getName().equals("prod")) {
                //System.out.println("element(" + element.getName() + ")\t:" + el.getName() + "\t\t - Valor: " + el.getText());
                if (!el.getText().isEmpty()) {
                    String teste = el.getName();
                    switch (teste) {
                        case ("cProd"):
                            p.setcProd(el.getText());
                            produto.setCodigo(Integer.parseInt(el.getText()));
                            break;
                        case ("cEAN"):
                            p.setcEAN(el.getText());
                            produto.setCodigobarras((el.getText()));
                            break;

                        case ("xProd"):
                            p.setxProd(el.getText());
                            produto.setDescricao(el.getText());
                            break;
                        case ("NCM"):
                            p.setNCM(el.getText());
                            produto.setNcm(Integer.parseInt(el.getText()));
                            break;
                        case ("CFOP"):
                            p.setCFOP(Integer.parseInt(el.getText()));
                            entradaProduto.setCfop(Integer.parseInt(el.getText()));
                            break;
                        case ("uCom"):
                            p.setuCom(el.getText());
                            //entradaProduto.setQuantidade(Integer.MIN_VALUE);
                            break;
                        case ("qCom"):
                            p.setqCom(Double.parseDouble(el.getText()));
                           // entradaProduto.setQuantidade(Integer.parseInt(el.getText()));
                            break;
                        case ("vUnCom"):
                            p.setvUnCom(Double.parseDouble(el.getText()));
                            entradaProduto.setPrecoUnit(BigDecimal.valueOf(p.getvUnCom()));
                        case ("vProd"):
                            p.setvProd(Double.parseDouble(el.getText()));
                            //entradaProduto.set
                            break;
                        case ("cEANTrib"):
                            p.setcEAN(el.getText());
                            break;
                        case ("uTrib"):
                            p.setuTrib(el.getText());
                            break;
                        case ("qTrib"):
                            p.setqTrib(Double.parseDouble(el.getText()));
                            break;
                        case ("vUnTrib"):
                            p.setvUnTrib(Double.parseDouble(el.getText()));
                            break;
                        case ("vDesc"):
                            p.setvDesc(Double.parseDouble(el.getText()));
                            break;
                        case ("indTot"):
                            p.setIndTot(Integer.parseInt(el.getText()));
                            break;
                    }

                }

            }

// aqui voce pode escolher qual(is) campo(s) quer manipular 
//            if (el.getName().equals("nNF")) {
//// grava_no_banco de dados(element.getAttributeValue("nNF")); 
//                System.out.println("encontrou nNF . . . com valor: " + el.getText());
//            }
            trataElement(el);
        }
        if (element.getName().equals("prod")) {
            produtos.add(p);
            entradaProduto.setIdproduto(produto);
            this.ne.addEntradaProduto(entradaProduto);
        }
    }

    private void imprimeProdutos() {
        for (int i = 0; i < produtos.size(); i++) {
            // if (produtos.get(i).getcProd() != null) {
            //System.out.println(produtos.get(i).getProdutoExtenso());
        }
        // System.out.println(i);
        //  }
    }

    public ArrayList<ProdutoTemp> getListaProdutos(String caminho) {
        LerArqXML lexml = new LerArqXML();
        lexml.lerarq(caminho);
        return lexml.produtos;
    }

    public NotaEntrada getNotaEntrada(String caminho) {
        LerArqXML lexml = new LerArqXML();
        //lexml.lerarq(caminho);
        return lexml.lerarq(caminho);
    }

    public static void main(String[] args) {
        LerArqXML lexml = new LerArqXML();
        //  lexml.lerarq();
        lexml.imprimeProdutos();
    }
}
