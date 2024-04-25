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
import jakarta.persistence.Transient;

@Entity
@Table(name = "xuly")
public class XuLyModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaXL", insertable = false, updatable = false)
	private Integer maXL;

	@Column(name = "HinhThucXL")
	private String hinhThucXL;

	@Column(name = "SoTien")
	private Integer soTien;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "NgayXL")
	private Date ngayXL;

	@Column(name = "TrangThaiXL")
	private Integer trangThaiXL;
	
	@Transient
    private String trangthai;

	@ManyToOne
	@JoinColumn(name = "MaTV")
	private ThanhVienModel thanhVien;

	public XuLyModel() {
	}

	public XuLyModel(Integer maXL, String hinhThucXL, Integer soTien, Date ngayXL, Integer trangThaiXL,
			ThanhVienModel thanhVien) {
		this.maXL = maXL;
		this.hinhThucXL = hinhThucXL;
		this.soTien = soTien;
		this.ngayXL = ngayXL;
		this.trangThaiXL = trangThaiXL;
		this.thanhVien = thanhVien;
	}

	public Integer getMaXL() {
		return maXL;
	}

	public void setMaXL(Integer maXL) {
		this.maXL = maXL;
	}

	public String getHinhThucXL() {
		return hinhThucXL;
	}

	public void setHinhThucXL(String hinhThucXL) {
		this.hinhThucXL = hinhThucXL;
	}

	public Integer getSoTien() {
		return soTien;
	}

	public void setSoTien(Integer soTien) {
		this.soTien = soTien;
	}

	public Date getNgayXL() {
		return ngayXL;
	}

	public void setNgayXL(Date ngayXL) {
		this.ngayXL = ngayXL;
	}

	public Integer getTrangThaiXL() {
		return trangThaiXL;
	}

	public void setTrangThaiXL(Integer trangThaiXL) {
		this.trangThaiXL = trangThaiXL;
	}

	public ThanhVienModel getThanhVien() {
		return thanhVien;
	}

	public void setThanhVien(ThanhVienModel thanhVien) {
		this.thanhVien = thanhVien;
	}
	public String getTrangthai() {
        if (this.trangThaiXL == 0) return "Chưa xử lý";
        else return "Đã xử lý";
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

	@Override
	public String toString() {
		return "XuLyModel [maXL=" + maXL + ", hinhThucXL=" + hinhThucXL + ", soTien=" + soTien + ", ngayXL=" + ngayXL
				+ ", trangThaiXL=" + trangThaiXL +  "]";
	}

}
