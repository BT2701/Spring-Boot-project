package com.example.demo.View.Styles;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class Styles {
	// mã font, mã màu
    private Font sgUI15b = new Font("Segoe UI", Font.BOLD, 15);
    private Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    private Font sgUI15I = new Font("Segoe UI", Font.ITALIC, 15);
    private Font sgUI13p = new Font("Segoe UI", Font.PLAIN, 13);
    private Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    private Font sgUI18b = new Font("Segoe UI", Font.BOLD, 17);
    private Font tNR13i = new Font("Times New Roman", Font.ITALIC, 13);
    private Font fontTittle = new Font("Tahoma", Font.BOLD, 25);
    private Font fontSubTittle = new Font("Tahoma", Font.BOLD, 20);
    private Font fontTable = new Font("Segoe UI", Font.BOLD, 13);
    private DecimalFormat dcf = new DecimalFormat("###,###");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Color btnoldColor = new Color(52, 152, 219);
    private Color texfieldColor = new Color(45, 52, 54);
    private MatteBorder matteBorderCB = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));
	private LineBorder lineCB = new LineBorder(Color.white);
	MatteBorder borderTxt = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));
	public Styles() {
	}
	public Font getSgUI15b() {
		return sgUI15b;
	}
	public void setSgUI15b(Font sgUI15b) {
		this.sgUI15b = sgUI15b;
	}
	public Font getSgUI15p() {
		return sgUI15p;
	}
	public void setSgUI15p(Font sgUI15p) {
		this.sgUI15p = sgUI15p;
	}
	public Font getSgUI15I() {
		return sgUI15I;
	}
	public void setSgUI15I(Font sgUI15I) {
		this.sgUI15I = sgUI15I;
	}
	public Font getSgUI13p() {
		return sgUI13p;
	}
	public void setSgUI13p(Font sgUI13p) {
		this.sgUI13p = sgUI13p;
	}
	public Font getSgUI13b() {
		return sgUI13b;
	}
	public void setSgUI13b(Font sgUI13b) {
		this.sgUI13b = sgUI13b;
	}
	public Font getSgUI18b() {
		return sgUI18b;
	}
	public void setSgUI18b(Font sgUI18b) {
		this.sgUI18b = sgUI18b;
	}
	public Font gettNR13i() {
		return tNR13i;
	}
	public void settNR13i(Font tNR13i) {
		this.tNR13i = tNR13i;
	}
	public Font getFontTittle() {
		return fontTittle;
	}
	public void setFontTittle(Font fontTittle) {
		this.fontTittle = fontTittle;
	}
	public Font getFontSubTittle() {
		return fontSubTittle;
	}
	public void setFontSubTittle(Font fontSubTittle) {
		this.fontSubTittle = fontSubTittle;
	}
	public Font getFontTable() {
		return fontTable;
	}
	public void setFontTable(Font fontTable) {
		this.fontTable = fontTable;
	}
	public DecimalFormat getDcf() {
		return dcf;
	}
	public void setDcf(DecimalFormat dcf) {
		this.dcf = dcf;
	}
	public SimpleDateFormat getSdf() {
		return sdf;
	}
	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}
	public Color getBtnoldColor() {
		return btnoldColor;
	}
	public void setBtnoldColor(Color btnoldColor) {
		this.btnoldColor = btnoldColor;
	}
	public Color getTexfieldColor() {
		return texfieldColor;
	}
	public void setTexfieldColor(Color texfieldColor) {
		this.texfieldColor = texfieldColor;
	}
	public MatteBorder getMatteBorderCB() {
		return matteBorderCB;
	}
	public void setMatteBorderCB(MatteBorder matteBorderCB) {
		this.matteBorderCB = matteBorderCB;
	}
	public LineBorder getLineCB() {
		return lineCB;
	}
	public void setLineCB(LineBorder lineCB) {
		this.lineCB = lineCB;
	}
	public MatteBorder getBorderTxt() {
		return borderTxt;
	}
	public void setBorderTxt(MatteBorder borderTxt) {
		this.borderTxt = borderTxt;
	}
	
	
}
