//package ir.resuinventory.model.service;
//
//import ir.store.musicstore.model.entity.Invoice;
//import ir.store.musicstore.model.repository.CRUDRepository;
//import ir.store.musicstore.model.repository.InvoiceDA;
//import ir.store.musicstore.model.service.generic.Service;
//
//import java.util.List;
//
//public class InvoiceService extends Service<Invoice, Long> {
//
//    private static InvoiceService invoiceService = new InvoiceService();
//
//    private InvoiceService(){
//    }
//
//    public static InvoiceService getInvoiceService() {
//        return invoiceService;
//    }
//
//    public Invoice insert(Invoice invoice) throws Exception {
//        try(CRUDRepository<Invoice,Long> repository = new CRUDRepository<>()){
//            return repository.insert(invoice);
//        }
//    }
//
//    public Invoice update(Invoice invoice) throws Exception {
//        try(CRUDRepository<Invoice,Long> repository = new CRUDRepository<>()){
//            return repository.update(invoice);
//        }
//    }
//
//    public Invoice delete(Long aLong) throws Exception {
//        try(CRUDRepository<Invoice,Long> repository = new CRUDRepository<>()){
//            return repository.delete(Invoice.class, aLong);
//        }
//    }
//
//    public List<Invoice> selectAll() throws Exception {
//        try(CRUDRepository<Invoice,Long> repository = new CRUDRepository<>()){
//            return repository.selectAll(Invoice.class);
//        }
//    }
//
//    public Invoice selectById(Long aLong) throws Exception {
//        try(CRUDRepository<Invoice,Long> repository = new CRUDRepository<>()){
//            return repository.selectById(Invoice.class, aLong);
//        }
//    }
//
//    public List<Invoice> selectUnprocessedInvoices() throws Exception {
//        try(InvoiceDA repository = new InvoiceDA()){
//            return repository.selectUnprocessedInvoices();
//        }
//    }
//}
