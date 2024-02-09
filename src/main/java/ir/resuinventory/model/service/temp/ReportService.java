//package ir.resuinventory.model.service;
//
//import ir.store.musicstore.model.repository.ReportDA;
//import org.apache.poi.ss.usermodel.Workbook;
//
//public class ReportService {
//
//    private static ReportService reportService = new ReportService();
//
//    private ReportService(){
//    }
//
//    public static ReportService getReportService() {
//        return reportService;
//    }
//
//    public Workbook getUserEmail() throws Exception {
//        try(ReportDA repository = new ReportDA()){
//            return repository.getUserEmail();
//        }
//    }
//
//    public Workbook getDownloadDetail(String startDate, String endDate) throws Exception {
//        try(ReportDA repository = new ReportDA()){
//            return repository.getDownloadDetail(startDate, endDate);
//        }
//    }
//}
