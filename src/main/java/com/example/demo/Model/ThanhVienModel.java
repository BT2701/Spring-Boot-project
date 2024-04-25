package com.example.demo.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.example.demo.Model.ThongTinSdModel;

@Entity
@Table(name = "thanhvien")
public class ThanhVienModel {

	@Id
	@Column(name = "MaTV")
	private Integer maTV;

	@Column(name = "HoTen")
	private String hoTen;

	@Column(name = "Khoa")
	private String khoa;

	@Column(name = "Nganh")
	private String nganh;

	@Column(name = "SDT")
	private String sdt;

	@OneToMany(mappedBy = "thanhVien")
	private List<ThongTinSdModel> listInfomation;

	@OneToMany(mappedBy = "thanhVien")
	private List<XuLyModel> listHandle;

	@Column
	private String email;

	@Column
	private String password;

	public ThanhVienModel() {
	}

	public ThanhVienModel(Integer maTV, String hoTen, String khoa, String nganh, String sdt, String email,
			String password) {
		this.maTV = maTV;
		this.hoTen = hoTen;
		this.khoa = khoa;
		this.nganh = nganh;
		this.sdt = sdt;
		this.listInfomation = listInfomation;
		this.listHandle = listHandle;
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
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
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

	public List<ThongTinSdModel> getListInfomation() {
		return listInfomation;
	}

	public void setListInfomation(List<ThongTinSdModel> listInfomation) {
		this.listInfomation = listInfomation;
	}

	public List<XuLyModel> getListHandle() {
		return listHandle;
	}

	public void setListHandle(List<XuLyModel> listHandle) {
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

	@Override
	public String toString() {
		return "ThanhVienModel [maTV=" + maTV + ", hoTen=" + hoTen + ", khoa=" + khoa + ", nganh=" + nganh + ", sdt="
				+ sdt + ", listInfomation=" + listInfomation + ", listHandle=" + listHandle + "]";
	}

}
