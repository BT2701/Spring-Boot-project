package com.example.demo.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "thongtinsd")
public class ThongTinSdModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaTT", insertable = false, updatable = false)
	private Integer maTT;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TGVao")
	private Date tgVao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TGMuon")
	private Date tgMuon;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TGTra")
	private Date tgTra;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TGDatCho")
	private Date tgDatCho;

	@ManyToOne
	@JoinColumn(name = "MaTV")
	private ThanhVienModel thanhVien;

	@ManyToOne
	@JoinColumn(name = "MaTB")
	private ThietBiModel thietBi;

	public ThongTinSdModel() {
	}

	public ThongTinSdModel(Integer maTT, Date tgVao, Date tgMuon, Date tgTra, Date tgDatCho, ThanhVienModel thanhVien,
			ThietBiModel thietBi) {
		this.maTT = maTT;
		this.tgVao = tgVao;
		this.tgMuon = tgMuon;
		this.tgTra = tgTra;
		this.tgDatCho = tgDatCho;
		this.thanhVien = thanhVien;
		this.thietBi = thietBi;
	}

	public Integer getMaTT() {
		return maTT;
	}

	public void setMaTT(Integer maTT) {
		this.maTT = maTT;
	}

	public Date getTgVao() {
		return tgVao;
	}

	public void setTgVao(Date tgVao) {
		this.tgVao = tgVao;
	}

	public Date getTgMuon() {
		return tgMuon;
	}

	public void setTgMuon(Date tgMuon) {
		this.tgMuon = tgMuon;
	}

	public Date getTgTra() {
		return tgTra;
	}

	public void setTgTra(Date tgTra) {
		this.tgTra = tgTra;
	}

	public Date getTgDatCho() {
		return tgDatCho;
	}

	public void setTgDatCho(Date tgDatCho) {
		this.tgDatCho = tgDatCho;
	}

	public ThanhVienModel getThanhVien() {
		return thanhVien;
	}

	public void setThanhVien(ThanhVienModel thanhVien) {
		this.thanhVien = thanhVien;
	}

	public ThietBiModel getThietBi() {
		return thietBi;
	}

	public void setThietBi(ThietBiModel thietBi) {
		this.thietBi = thietBi;
	}

	@Override
	public String toString() {
		return "ThongTinSdModel [maTT=" + maTT + ", tgVao=" + tgVao + ", tgMuon=" + tgMuon + ", tgTra=" + tgTra + "]";
	}

}
