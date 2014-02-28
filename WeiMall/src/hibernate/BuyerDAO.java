package hibernate;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Buyer
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see hibernate.Buyer
 * @author MyEclipse Persistence Tools
 */

public class BuyerDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(BuyerDAO.class);
	// property constants
	public static final String BUYER_USERNAME = "buyerUsername";
	public static final String BUYER_EMAIL = "buyerEmail";
	public static final String BUYER_PWD = "buyerPwd";
	public static final String BUYER_REAL_NAME = "buyerRealName";
	public static final String BUYER_SEX = "buyerSex";
	public static final String BUYER_BIRTHDAY = "buyerBirthday";
	public static final String BUYER_QQ = "buyerQq";
	public static final String BUYER_PHONE_NUM = "buyerPhoneNum";
	public static final String BUYER_CREDIT = "buyerCredit";

	public void save(Buyer transientInstance) {
		log.debug("saving Buyer instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Buyer persistentInstance) {
		log.debug("deleting Buyer instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Buyer findById(java.lang.Integer id) {
		log.debug("getting Buyer instance with id: " + id);
		try {
			Buyer instance = (Buyer) getSession().get("hibernate.Buyer", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Buyer instance) {
		log.debug("finding Buyer instance by example");
		try {
			List results = getSession().createCriteria("hibernate.Buyer")
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
		log.debug("finding Buyer instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Buyer as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBuyerUsername(Object buyerUsername) {
		return findByProperty(BUYER_USERNAME, buyerUsername);
	}

	public List findByBuyerEmail(Object buyerEmail) {
		return findByProperty(BUYER_EMAIL, buyerEmail);
	}

	public List findByBuyerPwd(Object buyerPwd) {
		return findByProperty(BUYER_PWD, buyerPwd);
	}

	public List findByBuyerRealName(Object buyerRealName) {
		return findByProperty(BUYER_REAL_NAME, buyerRealName);
	}

	public List findByBuyerSex(Object buyerSex) {
		return findByProperty(BUYER_SEX, buyerSex);
	}

	public List findByBuyerBirthday(Object buyerBirthday) {
		return findByProperty(BUYER_BIRTHDAY, buyerBirthday);
	}

	public List findByBuyerQq(Object buyerQq) {
		return findByProperty(BUYER_QQ, buyerQq);
	}

	public List findByBuyerPhoneNum(Object buyerPhoneNum) {
		return findByProperty(BUYER_PHONE_NUM, buyerPhoneNum);
	}

	public List findByBuyerCredit(Object buyerCredit) {
		return findByProperty(BUYER_CREDIT, buyerCredit);
	}

	public List findAll() {
		log.debug("finding all Buyer instances");
		try {
			String queryString = "from Buyer";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Buyer merge(Buyer detachedInstance) {
		log.debug("merging Buyer instance");
		try {
			Buyer result = (Buyer) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Buyer instance) {
		log.debug("attaching dirty Buyer instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Buyer instance) {
		log.debug("attaching clean Buyer instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}