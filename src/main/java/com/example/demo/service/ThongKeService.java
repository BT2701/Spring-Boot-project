package com.example.demo.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.ThanhVien;
import com.example.demo.Model.ThietBi;
import com.example.demo.Model.ThongTinSD;
import com.example.demo.Model.XuLy;
import com.example.demo.repository.ThanhVienRepository;
import com.example.demo.repository.ThietBiRepository;
import com.example.demo.repository.ThongTinSdRepository;
import com.example.demo.repository.XuLyRepository;

@Service
public class ThongKeService {
	@Autowired
	private ThanhVienRepository thanhVienRepository;
	@Autowired
	private ThietBiRepository thietBiRepository;
	@Autowired
	private ThongTinSdRepository thongTinSdRepository;
	@Autowired
	private XuLyRepository xuLyRepository;
	
	
	public Iterable<ThanhVien> memberList(){
		Iterable<ThanhVien> list=thanhVienRepository.findAll();
		return list;
	}
	public Iterable<ThietBi> deviceList(){
		Iterable<ThietBi> list= thietBiRepository.findAll();
		return list;
	}
	public Iterable<ThongTinSD> inforList(){
		Iterable<ThongTinSD> list= thongTinSdRepository.findAll();
		return list;
	}
	public Iterable<XuLy> handleList(){
		Iterable<XuLy> list=xuLyRepository.findAll();
		return list;
	}
	
//	count member into learning material center
	public int countMemberIntoMaterial() {
		int count = 0;
		for (ThongTinSD model : inforList()) {
			if (model.getTgVao() != null) {
				count++;
			}
		}
		return count;
	}

//	count borrowed device
	public int countBorrowedDevice() {
		int count = 0;
		for (ThongTinSD model : inforList()) {
			if (model.getTgMuon() != null) {
				count++;
			}
		}
		return count;
	}

//	count borrowing device
	public int countBorrowingDevice() {
		int count = 0;
		for (ThongTinSD model : inforList()) {
			if (model.getTgMuon() != null && model.getTgTra() == null) {
				count++;
			}
		}
		return count;
	}

//	count handled violation
	public int countHandledViolation() {
		int count = 0;
		for (XuLy model : handleList()) {
			if (model.getTrangThaiXL() == 0) {
				count++;
			}
		}
		return count;
	}

//	count handled violation
	public int countHandlingViolation() {
		int count = 0;
		for (XuLy model : handleList()) {
			if (model.getTrangThaiXL() != 0) {
				count++;
			}
		}
		return count;
	}

//	count violation
	public int countViolation() {
		int count = 0;
		for (XuLy model : handleList()) {

			count++;

		}
		return count;
	}

//	count fee
	public int countFee() {
		int count = 0;
		for (XuLy model : handleList()) {
			if (model.getSoTien() != null) {
				count += model.getSoTien();
			}
		}
		return count;
	}

//	OVERTIME
	public int countIntoMaterialOverTime(Date from, Date to) {
		int count = 0;
		for (ThongTinSD model : inforList()) {
			if (model.getTgVao() != null) {
				if (from.before(model.getTgVao()) && to.after(model.getTgVao())) {
					count++;
				}
			}
		}
		return count;
	}

	public int countBorrowedDeviceOverTime(Date from, Date to) {
		int count = 0;
		for (ThongTinSD model : inforList()) {
			if (model.getTgMuon() != null) {
				if (from.before(model.getTgMuon()) && to.after(model.getTgMuon())) {
					count++;
				}
			}
		}
		return count;
	}

//	count borrowing device
	public int countBorrowingDeviceOverTime(Date from, Date to) {
		int count = 0;
		for (ThongTinSD model : inforList()) {
			if (model.getTgMuon() != null && model.getTgTra() == null) {
				if (from.before(model.getTgMuon()) && to.after(model.getTgMuon())) {
					count++;
				}
			}
		}
		return count;
	}

//	count handled violation
	public int countHandledViolationOverTime(Date from, Date to) {
		int count = 0;
		for (XuLy model : handleList()) {
			if (model.getTrangThaiXL() == 0) {
				if (model.getNgayXL() != null) {
					if (from.before(model.getNgayXL()) && to.after(model.getNgayXL())) {
						count++;
					}
				}
			}
		}
		return count;
	}

//	count handled violation
	public int countHandlingViolationOverTime(Date from, Date to) {
		int count = 0;
		for (XuLy model : handleList()) {
			if (model.getTrangThaiXL() != 0) {
				if (model.getNgayXL() != null) {
					if (from.before(model.getNgayXL()) && to.after(model.getNgayXL())) {
						count++;
					}
				}
			}
		}
		return count;
	}

//	count violation
	public int countViolationOverTime(Date from, Date to) {
		int count = 0;
		for (XuLy model : handleList()) {

			if (model.getNgayXL() != null) {
				if (from.before(model.getNgayXL()) && to.after(model.getNgayXL())) {
					count++;
				}
			}

		}
		return count;
	}

//	count fee
	public int countFeeOverTime(Date from, Date to) {
		int count = 0;
		for (XuLy model : handleList()) {
			if (model.getSoTien() != null) {
				if (model.getNgayXL() != null) {
					if (from.before(model.getNgayXL()) && to.after(model.getNgayXL())) {
						count += model.getSoTien();
					}
				}
			}
		}
		return count;
	}

//	biểu đồ thống kê số lượng sinh viên ra vào khu tự học
	public ArrayList<Integer> listCountTime(int year) {
		ArrayList<Integer> list = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < 12; i++) {
			for (ThongTinSD model : inforList()) {
				if (model.getTgVao() != null) {
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(model.getTgVao());
					if ((calendar.get(Calendar.MONTH) + 1) == (i + 1) && calendar.get(Calendar.YEAR) == year) {
						count++;
					}
				}
			}
			list.add(count);
			count = 0;
		}

		return list;
	}
//	end

//	biểu đồ thống kê lượng sinh viên thuộc các khoa
	public ArrayList<Integer> listCountDeparment() {
		ArrayList<Integer> list = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < listDeparment().size(); i++) {
			for (ThongTinSD model : inforList()) {
				if (model.getTgVao() != null
						&& model.getThanhVien().getKhoa().equalsIgnoreCase(listDeparment().get(i))) {
					count++;
				}
			}
			list.add(count);
			count = 0;
		}

		return list;
	}

	public ArrayList<String> listDeparment() {
		ArrayList<String> list = new ArrayList<>();
		for (ThanhVien mem : memberList()) {
			list.add(mem.getKhoa());
		}
		Set<String> set = new HashSet<>();
		set.addAll(list);
		list = new ArrayList<>(set);
		return list;
	}

//	end

//	biểu đồ thống kê lượng sinh viên thuộc các ngành
	public ArrayList<Integer> listCountBranch() {
		ArrayList<Integer> list = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < listBranch().size(); i++) {
			for (ThongTinSD model : inforList()) {
				if (model.getTgVao() != null && model.getThanhVien().getNganh().equalsIgnoreCase(listBranch().get(i))) {
					count++;
				}
			}
			list.add(count);
			count = 0;
		}

		return list;
	}

	public ArrayList<String> listBranch() {
		ArrayList<String> list = new ArrayList<>();
		for (ThanhVien mem : memberList()) {
			list.add(mem.getNganh());
		}
		Set<String> set = new HashSet<>();
		set.addAll(list);
		list = new ArrayList<>(set);
		return list;
	}

//	end
//	biểu đồ thống kê lượng thiết bị đã được mượn
	public ArrayList<Integer> listCountDevice(int year, int month) {
		ArrayList<Integer> list = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < listDevice().size(); i++) {
			for (ThongTinSD model : inforList()) {
				if(model.getTgMuon()!=null) {
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(model.getTgMuon());
					if(calendar.get(Calendar.YEAR)  == year &&(calendar.get(Calendar.MONTH) + 1) == month && model.getThietBi().getTenTB().equalsIgnoreCase(listDevice().get(i))) {
						count++;
					}
				}
			}
			list.add(count);
			count = 0;
		}

		return list;
	}

	public ArrayList<String> listDevice() {
		ArrayList<String> list = new ArrayList<>();
		for (ThongTinSD info : inforList()) {
			if(info.getThietBi()!=null) {
				list.add(info.getThietBi().getTenTB());
			}
		}
		Set<String> set = new HashSet<>();
		set.addAll(list);
		list = new ArrayList<>(set);
		return list;
	}

//	end
	
//	biểu đồ thống kê lượng thiết bị đang được mượn
	public ArrayList<Integer> listCountCurrent(int year, int month) {
		ArrayList<Integer> list = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < listDevice().size(); i++) {
			for (ThongTinSD model : inforList()) {
				if(model.getTgMuon()!=null) {
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(model.getTgMuon());
					if(model.getTgTra()==null &&calendar.get(Calendar.YEAR)  == year &&(calendar.get(Calendar.MONTH) + 1) == month && model.getThietBi().getTenTB().equalsIgnoreCase(listDevice().get(i))) {
						count++;
					}
				}
			}
			list.add(count);
			count = 0;
		}

		return list;
	}
//	end
	
//	biểu đồ thống kê xử lý vi phạm
	public ArrayList<Integer> listCountHandle(int year, int month) {
		ArrayList<Integer> list = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < listHandle().size(); i++) {
			for (XuLy model : handleList()) {
				if(model.getNgayXL()!=null) {
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(model.getNgayXL());
					if(calendar.get(Calendar.YEAR)  == year &&(calendar.get(Calendar.MONTH) + 1) == month  && model.getHinhThucXL().equalsIgnoreCase(listHandle().get(i))) {
						count++;
					}
				}
			}
			list.add(count);
			count = 0;
		}

		return list;
	}

	public ArrayList<String> listHandle() {
		ArrayList<String> list = new ArrayList<>();
		for (XuLy handle : handleList()) {
			list.add(handle.getHinhThucXL());
		}
		Set<String> set = new HashSet<>();
		set.addAll(list);
		list = new ArrayList<>(set);
		return list;
	}

//	end
}
