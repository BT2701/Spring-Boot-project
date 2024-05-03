package com.example.demo.Model;

import java.util.List;

import jakarta.persistence.*;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;

@Entity(name = "thietbi")
public class ThietBi {
	@Id
	private Integer maTB;
	
	@Column
	private String tenTB;
	
	@Column
	private String motatb;

	@OneToMany(mappedBy = "thietBi")
	private List<ThongTinSD> listInfomation;

	public ThietBi() {
	}

	public ThietBi(Integer maTB, String tenTB, String moTaTB) {
		this.maTB = maTB;
		this.tenTB = tenTB;
		this.motatb = moTaTB;
	}

	public ThietBi(Integer maTB, String tenTB, String moTaTB, List<ThongTinSD> listInfomation) {
		this.maTB = maTB;
		this.tenTB = tenTB;
		this.motatb = moTaTB;
		this.listInfomation = listInfomation;
	}

	public List<ThongTinSD> getListInfomation() {
		return listInfomation;
	}

	public void setListInfomation(List<ThongTinSD> listInfomation) {
		this.listInfomation = listInfomation;
	}

	public Integer getMaTB() {
		return maTB;
	}

	public void setMaTB(Integer maTB) {
		this.maTB = maTB;
	}

	public String getTenTB() {
		return tenTB;
	}

	public void setTenTB(String tenTB) {
		this.tenTB = tenTB;
	}

	public String getMoTaTB() {
		return motatb;
	}

	public void setMoTaTB(String moTaTB) {
		this.motatb = moTaTB;
	}

	@Override
	public String toString() {
		return "ThietBiModel [maTB=" + maTB + ", tenTB=" + tenTB + ", moTaTB=" + motatb + ", listInfomation="
				+ listInfomation + "]";
	}

}
