package com.example.demo.Model;

import java.sql.Timestamp;

import jakarta.persistence.*;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;


@Entity(name = "thongtinsd")
public class ThongTinSD {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaTT", insertable = false, updatable = false)
	private Integer maTT;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TGVao")
	private Timestamp tgVao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TGMuon")
	private Timestamp tgMuon;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TGTra")
	private Timestamp tgTra;

	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Timestamp tgdatcho;

	@ManyToOne
	@JoinColumn(name = "MaTV")
	private ThanhVien thanhVien;

	@ManyToOne
	@JoinColumn(name = "MaTB")
	private ThietBi thietBi;

	public ThongTinSD() {
	}

	public ThongTinSD(Integer maTT, Timestamp tgVao, Timestamp tgMuon, Timestamp tgTra, Timestamp tgDatCho, ThanhVien thanhVien,
			ThietBi thietBi) {
		this.maTT = maTT;
		this.tgVao = tgVao;
		this.tgMuon = tgMuon;
		this.tgTra = tgTra;
		this.tgdatcho = tgDatCho;
		this.thanhVien = thanhVien;
		this.thietBi = thietBi;
	}

	public ThongTinSD(Timestamp tgVao, Timestamp tgMuon, Timestamp tgTra, Timestamp tgDatCho, ThanhVien thanhVien,
					  ThietBi thietBi) {
		this.tgVao = tgVao;
		this.tgMuon = tgMuon;
		this.tgTra = tgTra;
		this.tgdatcho = tgDatCho;
		this.thanhVien = thanhVien;
		this.thietBi = thietBi;
	}

	public Integer getMaTT() {
		return maTT;
	}

	public void setMaTT(Integer maTT) {
		this.maTT = maTT;
	}

	public Timestamp getTgVao() {
		return tgVao;
	}

	public void setTgVao(Timestamp tgVao) {
		this.tgVao = tgVao;
	}

	public Timestamp getTgMuon() {
		return tgMuon;
	}

	public void setTgMuon(Timestamp tgMuon) {
		this.tgMuon = tgMuon;
	}

	public Timestamp getTgTra() {
		return tgTra;
	}

	public void setTgTra(Timestamp tgTra) {
		this.tgTra = tgTra;
	}

	public Timestamp getTgDatCho() {
		return tgdatcho;
	}

	public void setTgDatCho(Timestamp tgDatCho) {
		this.tgdatcho = tgDatCho;
	}

	public ThanhVien getThanhVien() {
		return thanhVien;
	}

	public void setThanhVien(ThanhVien thanhVien) {
		this.thanhVien = thanhVien;
	}

	public ThietBi getThietBi() {
		return thietBi;
	}

	public void setThietBi(ThietBi thietBi) {
		this.thietBi = thietBi;
	}

	@Override
	public String toString() {
		return "ThongTinSdModel [maTT=" + maTT + ", tgVao=" + tgVao + ", tgMuon=" + tgMuon + ", tgTra=" + tgTra + "]";
	}

}
