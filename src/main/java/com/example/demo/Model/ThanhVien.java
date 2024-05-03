package com.example.demo.Model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;

@Entity(name="thanhvien")
public class ThanhVien {

	@Id
	private Integer maTV;

	@Column
	private String hoten;

	@Column
	private String khoa;

	@Column
	private String nganh;

	@Column
	private String sdt;

	@OneToMany(mappedBy = "thanhVien")
	private List<ThongTinSD> listInfomation;

	@OneToMany(mappedBy = "thanhVien")
	private List<XuLy> listHandle;

	@Column
	private String email;

	@Column
	private String password;

	public ThanhVien() {
	}

	public ThanhVien(Integer maTV, String hoTen, String khoa, String nganh, String sdt, String email,
			String password) {
		this.maTV = maTV;
		this.hoten = hoTen;
		this.khoa = khoa;
		this.nganh = nganh;
		this.sdt = sdt;
		this.email = email;
		this.password = password;
	}

	public Integer getMaTV() {
		return maTV;
	}

	public void setMaTV(Integer maTV) {
		this.maTV = maTV;
	}

	public String getHoTen() {
		return hoten;
	}

	public void setHoTen(String hoTen) {
		this.hoten = hoTen;
	}

	public String getKhoa() {
		return khoa;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}

	public String getNganh() {
		return nganh;
	}

	public void setNganh(String nganh) {
		this.nganh = nganh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public List<ThongTinSD> getListInfomation() {
		return listInfomation;
	}

	public void setListInfomation(List<ThongTinSD> listInfomation) {
		this.listInfomation = listInfomation;
	}

	public List<XuLy> getListHandle() {
		return listHandle;
	}

	public void setListHandle(List<XuLy> listHandle) {
		this.listHandle = listHandle;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
