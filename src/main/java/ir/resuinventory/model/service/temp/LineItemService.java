//package ir.resuinventory.model.service;
//
//import ir.store.musicstore.model.entity.LineItem;
//import ir.store.musicstore.model.repository.CRUDRepository;
//import ir.store.musicstore.model.service.generic.Service;
//
//import java.util.List;
//
//public class LineItemService extends Service<LineItem, Long> {
//
//    private static LineItemService lineItemService = new LineItemService();
//
//    private LineItemService(){
//    }
//
//    public static LineItemService getLineItemService() {
//        return lineItemService;
//    }
//
//    public LineItem insert(LineItem lineItem) throws Exception {
//        try(CRUDRepository<LineItem,Long> repository = new CRUDRepository<>()){
//            return repository.insert(lineItem);
//        }
//    }
//
//    public LineItem update(LineItem lineItem) throws Exception {
//        try(CRUDRepository<LineItem,Long> repository = new CRUDRepository<>()){
//            return repository.update(lineItem);
//        }
//    }
//
//    public LineItem delete(Long aLong) throws Exception {
//        try(CRUDRepository<LineItem,Long> repository = new CRUDRepository<>()){
//            return repository.delete(LineItem.class, aLong);
//        }
//    }
//
//    public List<LineItem> selectAll() throws Exception {
//        try(CRUDRepository<LineItem,Long> repository = new CRUDRepository<>()){
//            return repository.selectAll(LineItem.class);
//        }
//    }
//
//    public LineItem selectById(Long aLong) throws Exception {
//        try(CRUDRepository<LineItem,Long> repository = new CRUDRepository<>()){
//            return repository.selectById(LineItem.class, aLong);
//        }
//    }
//}
