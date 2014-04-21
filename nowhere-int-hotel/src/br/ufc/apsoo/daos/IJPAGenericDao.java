package br.ufc.apsoo.daos;

import java.io.Serializable;
import java.util.List;

public interface IJPAGenericDao<T, PrimaryKeyType extends Serializable> {
        
        // Setting Entity Manger instance
        
        public void setEntityManager(EntityManager em);
        
        // end of setting EntityManager
        
        // data reading Section
        
        public List<T> getAll() throws DaoException;
        
        public T findById(PrimaryKeyType id)  throws DaoException;
        
        public List<T> findByQuery(String query) throws DaoException;
        
        // end of data reading section
        
        
        // data manipulating section
        
        public void save(T entity) throws DaoException;
        
        public void updateEntity(T entity) throws DaoException;
        
        public void mergeEntity(T entity) throws DaoException;
        
        public void deleteEntity(T entity) throws DaoException;
        
        public void deleteEntity(PrimaryKeyType id) throws DaoException;
        
        // end of data manipulating section
}