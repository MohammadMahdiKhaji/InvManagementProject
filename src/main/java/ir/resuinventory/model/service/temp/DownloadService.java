//package ir.resuinventory.model.service;
//
//import ir.store.musicstore.model.entity.Download;
//import ir.store.musicstore.model.repository.CRUDRepository;
//import ir.store.musicstore.model.service.generic.Service;
//
//import java.util.List;
//
//public class DownloadService extends Service<Download, Long> {
//
//    private static DownloadService downloadService = new DownloadService();
//
//    private DownloadService(){
//    }
//
//    public static DownloadService getDownloadService() {
//        return downloadService;
//    }
//
//    public Download insert(Download download) throws Exception {
//        try(CRUDRepository<Download,Long> repository = new CRUDRepository<>()){
//            return repository.insert(download);
//        }
//    }
//
//    public Download update(Download download) throws Exception {
//        try(CRUDRepository<Download,Long> repository = new CRUDRepository<>()){
//            return repository.update(download);
//        }
//    }
//
//    public Download delete(Long aLong) throws Exception {
//        try(CRUDRepository<Download,Long> repository = new CRUDRepository<>()){
//            return repository.delete(Download.class, aLong);
//        }
//    }
//
//    public List<Download> selectAll() throws Exception {
//        try(CRUDRepository<Download,Long> repository = new CRUDRepository<>()){
//            return repository.selectAll(Download.class);
//        }
//    }
//
//    public Download selectById(Long aLong) throws Exception {
//        try(CRUDRepository<Download,Long> repository = new CRUDRepository<>()){
//            return repository.selectById(Download.class, aLong);
//        }
//    }
//}
