package ir.resuinventory.model.service.generic;

import java.util.List;

public abstract class Service <T, ID> {
    public abstract T insert(T t) throws Exception;

    public abstract T update(T t) throws Exception;

    public abstract T delete(ID id) throws Exception;

    public abstract List<T> selectAll() throws Exception;

    public abstract T selectById(ID id) throws Exception;

}