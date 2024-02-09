//package ir.resuinventory.model.service;
//
//import ir.store.musicstore.model.entity.Cart;
//import ir.store.musicstore.model.repository.CRUDRepository;
//import ir.store.musicstore.model.service.generic.Service;
//
//import java.util.List;
//
//public class CartService extends Service<Cart, Long> {
//
//    private static CartService cartService = new CartService();
//
//    private CartService(){
//    }
//
//    public static CartService getCartService() {
//        return cartService;
//    }
//
//    public Cart insert(Cart cart) throws Exception {
//        try(CRUDRepository<Cart,Long> repository = new CRUDRepository<>()){
//            return repository.insert(cart);
//        }
//    }
//
//    public Cart update(Cart cart) throws Exception {
//        try(CRUDRepository<Cart,Long> repository = new CRUDRepository<>()){
//            return repository.update(cart);
//        }
//    }
//
//    public Cart delete(Long aLong) throws Exception {
//        try(CRUDRepository<Cart,Long> repository = new CRUDRepository<>()){
//            return repository.delete(Cart.class, aLong);
//        }
//    }
//
//    public List<Cart> selectAll() throws Exception {
//        try(CRUDRepository<Cart,Long> repository = new CRUDRepository<>()){
//            return repository.selectAll(Cart.class);
//        }
//    }
//
//    public Cart selectById(Long aLong) throws Exception {
//        try(CRUDRepository<Cart,Long> repository = new CRUDRepository<>()){
//            return repository.selectById(Cart.class, aLong);
//        }
//    }
//}
