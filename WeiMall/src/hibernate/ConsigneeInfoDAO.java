package hibernate;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * ConsigneeInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see hibernate.ConsigneeInfo
 * @author MyEclipse Persistence Tools
 */

public class ConsigneeInfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ConsigneeInfoDAO.class);
	// property constants
	public static final String CONSIGNEE_INFO_NAME = "consigneeInfoName";
	public static final String CONSIGNEE_PHONE = "consigneePhone";
	public static final String CONSIGNEE_ADDRESS = "consigneeAddress";

	public void save(ConsigneeInfo transientInstance) {
		log.debug("saving ConsigneeInfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ConsigneeInfo persistentInstance) {
		log.debug("deleting ConsigneeInfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ConsigneeInfo findById(java.lang.Integer id) {
		log.debug("getting ConsigneeInfo instance with id: " + id);
		try {
			ConsigneeInfo instance = (ConsigneeInfo) getSession().get(
					"hibernate.ConsigneeInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ConsigneeInfo instance) {
		log.debug("finding ConsigneeInfo instance by example");
		try {
			List results = getSession()
					.createCriteria("hibernate.ConsigneeInfo")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding ConsigneeInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ConsigneeInfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByConsigneeInfoName(Object consigneeInfoName) {
		return findByProperty(CONSIGNEE_INFO_NAME, consigneeInfoName);
	}

	public List findByConsigneePhone(Object consigneePhone) {
		return findByProperty(CONSIGNEE_PHONE, consigneePhone);
	}

	public List findByConsigneeAddress(Object consigneeAddress) {
		return findByProperty(CONSIGNEE_ADDRESS, consigneeAddress);
	}

	public List findAll() {
		log.debug("finding all ConsigneeInfo instances");
		try {
			String queryString = "from ConsigneeInfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ConsigneeInfo merge(ConsigneeInfo detachedInstance) {
		log.debug("merging ConsigneeInfo instance");
		try {
			ConsigneeInfo result = (ConsigneeInfo) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ConsigneeInfo instance) {
		log.debug("attaching dirty ConsigneeInfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ConsigneeInfo instance) {
		log.debug("attaching clean ConsigneeInfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}