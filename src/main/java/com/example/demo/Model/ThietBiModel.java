package com.example.demo.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "thietbi")
public class ThietBiModel {
	@Id
	@Column(name = "MaTB")
	private Integer maTB;
	@Column(name = "TenTB")
	private String tenTB;
	@Column(name = "MoTaTB")
	private String moTaTB;

	@OneToMany(mappedBy = "thietBi")
	private List<ThongTinSdModel> listInfomation;

	public ThietBiModel() {
	}

	public ThietBiModel(Integer maTB, String tenTB, String moTaTB) {
		this.maTB = maTB;
		this.tenTB = tenTB;
		this.moTaTB = moTaTB;
	}

	public ThietBiModel(Integer maTB, String tenTB, String moTaTB, List<ThongTinSdModel> listInfomation) {
		this.maTB = maTB;
		this.tenTB = tenTB;
		this.moTaTB = moTaTB;
		this.listInfomation = listInfomation;
	}

	public List<ThongTinSdModel> getListInfomation() {
		return listInfomation;
	}

	public void setListInfomation(List<ThongTinSdModel> listInfomation) {
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
		return moTaTB;
	}

	public void setMoTaTB(String moTaTB) {
		this.moTaTB = moTaTB;
	}

	@Override
	public String toString() {
		return "ThietBiModel [maTB=" + maTB + ", tenTB=" + tenTB + ", moTaTB=" + moTaTB + ", listInfomation="
				+ listInfomation + "]";
	}

}
