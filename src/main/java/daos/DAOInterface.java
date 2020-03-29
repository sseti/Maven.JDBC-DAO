package daos;

import java.util.List;

public interface DAOInterface <T> {
    public T findById(int id);
    public List findAll();
    public T update(DTO dto);
    public T create(DTO dto);
    public T delete(int id);
}

