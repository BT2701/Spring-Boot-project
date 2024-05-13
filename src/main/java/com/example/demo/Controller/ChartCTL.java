package com.example.demo.Controller;

import com.example.demo.service.ThongKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ChartCTL {
    @Autowired
    private ThongKeService thongKeService;
    @GetMapping("/memberchart")
    public @ResponseBody Map<String, Object> getChartDataForMember(@RequestParam("year") String year) {
        Map<String, Object> chartData = new HashMap<>();
        List<String> labels = new ArrayList<>();
        List<Integer> data = new ArrayList<>();

        // Duyệt qua danh sách dữ liệu và thêm vào labels và data
        for(int i=0;i<12;i++){
            labels.add((i+1)+"");
            data.add(thongKeService.listCountTime(Integer.parseInt(year)).get(i));
        }

        // Đưa dữ liệu vào map để trả về
        chartData.put("labels", labels);
        chartData.put("data", data);

        return chartData;
    }

    // Lấy dữ liệu cho biểu đồ 2 (Theo các khoa)
    @GetMapping("/departmentchart")
    public @ResponseBody Map<String, Object> getChartDataForDepartment() {
        Map<String, Object> chartData = new HashMap<>();
        List<String> labels = new ArrayList<>();
        List<Integer> data = new ArrayList<>();

        // Lấy dữ liệu từ service
        // Ví dụ: thongKeService.getDataForDepartmentChart()
        // Giả sử thongKeService.getDataForDepartmentChart() trả về một list gồm các đối tượng có thuộc tính 'label' và 'value'
        for (int i=0;i<thongKeService.listDeparment().size();i++){
            labels.add(thongKeService.listDeparment().get(i));
            data.add(thongKeService.listCountDeparment().get(i));
        }

        // Đưa dữ liệu vào map để trả về
        chartData.put("labels", labels);
        chartData.put("data", data);

        return chartData;
    }

    // Lấy dữ liệu cho biểu đồ 3 (Theo các ngành)
    @GetMapping("/branchchart")
    public @ResponseBody Map<String, Object> getChartDataForBranch() {
        Map<String, Object> chartData = new HashMap<>();
        List<String> labels = new ArrayList<>();
        List<Integer> data = new ArrayList<>();

       for(int i=0;i<thongKeService.listBranch().size();i++){
           labels.add(thongKeService.listBranch().get(i));
           data.add(thongKeService.listCountBranch().get(i));
       }
        // Đưa dữ liệu vào map để trả về
        chartData.put("labels", labels);
        chartData.put("data", data);

        return chartData;
    }
    @GetMapping("/currentchart")
    public @ResponseBody Map<String, Object> getChartDataForCurrent(@RequestParam("year")String year, @RequestParam("month")String month) {
        Map<String, Object> chartData = new HashMap<>();
        List<String> labels = new ArrayList<>();
        List<Integer> data = new ArrayList<>();

        for(int i=0;i<thongKeService.listDevice().size();i++){
            labels.add(thongKeService.listDevice().get(i));
            data.add(thongKeService.listCountCurrent(Integer.parseInt(year),Integer.parseInt(month)).get(i));
        }
        // Đưa dữ liệu vào map để trả về
        chartData.put("labels", labels);
        chartData.put("data", data);

        return chartData;
    }
    @GetMapping("/devicechart")
    public @ResponseBody Map<String, Object> getChartDataForDevice(@RequestParam("year")String year, @RequestParam("month")String month) {
        Map<String, Object> chartData = new HashMap<>();
        List<String> labels = new ArrayList<>();
        List<Integer> data = new ArrayList<>();

        for(int i=0;i<thongKeService.listDevice().size();i++){
            labels.add(thongKeService.listDevice().get(i));
            data.add(thongKeService.listCountDevice(Integer.parseInt(year), Integer.parseInt(month)).get(i));
        }
        // Đưa dữ liệu vào map để trả về
        chartData.put("labels", labels);
        chartData.put("data", data);

        return chartData;
    }
    @GetMapping("/handlechart")
    public @ResponseBody Map<String, Object> getChartDataForHandle(@RequestParam("year") String year, @RequestParam("month") String month) {
        Map<String, Object> chartData = new HashMap<>();
        List<String> labels = new ArrayList<>();
        List<Integer> data = new ArrayList<>();

        for(int i=0;i<thongKeService.listHandle().size();i++){
            labels.add(thongKeService.listHandle().get(i));
            data.add(thongKeService.listCountHandle(Integer.parseInt(year), Integer.parseInt(month)).get(i));
        }
        // Đưa dữ liệu vào map để trả về
        chartData.put("labels", labels);
        chartData.put("data", data);

        return chartData;
    }
}
