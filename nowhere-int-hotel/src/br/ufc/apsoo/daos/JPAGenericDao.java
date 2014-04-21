package br.ufc.apsoo.daos;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.management.Query;

public abstract class JPAGenericDao<T, PrimaryKeyType extends Serializable>
		implements IJPAGenericDao<T, PrimaryKeyType> {

	protected EntityManager em = null;
	private Class<T> persistentClass = null;

	@SuppressWarnings("unchecked")
	public JPAGenericDao(EntityManager em) {

		this.em = em;

		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	// public JPAGenericDao() {
	//
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see In case you choosed no argument constructor to create a instance of
	 * this class, it is needed to set a EntityManager instance using this
	 * method
	 */
	@SuppressWarnings("unchecked")
	public void setEntityManager(EntityManager em) {

		if (this.em == null && this.persistentClass == null) {

			this.em = em;

			this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lk.hirusadutech.commonlib.dao.IHiruSaduTechGenericDao#getAll()
	 */
	public List<T> getAll() throws DaoException {

		List<T> allEntities = null;

		try {

			CriteriaBuilder builder = em.getCriteriaBuilder();

			CriteriaQuery<T> criteria = builder.createQuery(persistentClass);

			allEntities = em.createQuery(criteria).getResultList();

		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return allEntities;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lk.hirusadutech.commonlib.dao.IHiruSaduTechGenericDao#findByQuery()
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByQuery(String jpql) throws DaoException {

		List<T> allEntities = null;

		try {

			Query query = em.createQuery(jpql);

			allEntities = query.getResultList();

		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return allEntities;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * lk.hirusadutech.commonlib.dao.IHiruSaduTechGenericDao#getEntityByPrimaryKey
	 * (java.io.Serializable)
	 */

	public T findById(PrimaryKeyType id) throws DaoException {

		T entity = null;

		try {

			if (id != null) {
				entity = em.find(persistentClass, id);
			}

		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * lk.hirusadutech.commonlib.dao.IHiruSaduTechGenericDao#insertEntity(java
	 * .lang.Object)
	 */

	public void save(T entity) throws DaoException {

		try {

			if (entity != null) {
				em.persist(entity);
			}

		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * lk.hirusadutech.commonlib.dao.IHiruSaduTechGenericDao#updateEntity(java
	 * .lang.Object)
	 */

	public void updateEntity(T entity) throws DaoException {

		/*
		 * this method should be only used when the object u saving also in the
		 * same persistent context as it going to save now. If the object you
		 * going to save got from a different persistent context, it is needed
		 * to use the 'mergeEntity' method
		 */

		try {

			if (entity != null) {
				em.refresh(entity);
			}

		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * lk.hirusadutech.commonlib.dao.IHiruSaduTechGenericDao#mergeEntity(java
	 * .lang.Object)
	 */

	public void mergeEntity(T entity) throws DaoException {

		try {

			if (entity != null) {
				em.merge(entity);
			}

		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * lk.hirusadutech.commonlib.dao.IHiruSaduTechGenericDao#deleteEntity(java
	 * .lang.Object)
	 */

	public void deleteEntity(T entity) throws DaoException {

		try {

			if (entity != null) {
				em.remove(entity);
			}

		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * lk.hirusadutech.commonlib.dao.IHiruSaduTechGenericDao#deleteEntity(java
	 * .io.Serializable)
	 */

	public void deleteEntity(PrimaryKeyType id) throws DaoException {

		try {

			T entity = this.findById(id);

			em.remove(entity);

		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}
}