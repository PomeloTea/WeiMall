package hibernate;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Seller entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate.Seller
 * @author MyEclipse Persistence Tools
 */

public class SellerDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(SellerDAO.class);
	// property constants
	public static final String SELLER_NAME = "sellerName";
	public static final String SELLER_EMAIL = "sellerEmail";
	public static final String SELLER_PWD = "sellerPwd";
	public static final String SELLER_REAL_NAME = "sellerRealName";
	public static final String SELLER_SEX = "sellerSex";
	public static final String SELLER_BIRTHDAY = "sellerBirthday";
	public static final String SELLER_QQ = "sellerQq";
	public static final String SELLER_PHONE_NUM = "sellerPhoneNum";
	public static final String SELLER_LAST_LOGIN_TIME = "sellerLastLoginTime";
	public static final String SELLER_LAST_LOGIN_IP = "sellerLastLoginIp";
	public static final String SELLER_CREDIT = "sellerCredit";
	public static final String SELLER_GOOD_EVALUATION_NUM = "sellerGoodEvaluationNum";
	public static final String SELLER_SHOP_LEVEL = "sellerShopLevel";
	public static final String SELLER_VALIDITY = "sellerValidity";
	public static final String SELLER_GOODS_ON_SELL = "sellerGoodsOnSell";
	public static final String SELLER_TOTAL_GOODS_NUM = "sellerTotalGoodsNum";

	public void save(Seller transientInstance) {
		log.debug("saving Seller instance");
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(transientInstance);
			log.debug("save successful");
			transaction.commit();
			session.flush();
			session.close();
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Seller persistentInstance) {
		log.debug("deleting Seller instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Seller findById(java.lang.Integer id) {
		log.debug("getting Seller instance with id: " + id);
		try {
			Seller instance = (Seller) getSession().get("hibernate.Seller", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Seller instance) {
		log.debug("finding Seller instance by example");
		try {
			List results = getSession().createCriteria("hibernate.Seller")
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
		log.debug("finding Seller instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Seller as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySellerName(Object sellerName) {
		return findByProperty(SELLER_NAME, sellerName);
	}

	public List findBySellerEmail(Object sellerEmail) {
		return findByProperty(SELLER_EMAIL, sellerEmail);
	}

	public List findBySellerPwd(Object sellerPwd) {
		return findByProperty(SELLER_PWD, sellerPwd);
	}

	public List findBySellerRealName(Object sellerRealName) {
		return findByProperty(SELLER_REAL_NAME, sellerRealName);
	}

	public List findBySellerSex(Object sellerSex) {
		return findByProperty(SELLER_SEX, sellerSex);
	}

	public List findBySellerBirthday(Object sellerBirthday) {
		return findByProperty(SELLER_BIRTHDAY, sellerBirthday);
	}

	public List findBySellerQq(Object sellerQq) {
		return findByProperty(SELLER_QQ, sellerQq);
	}

	public List findBySellerPhoneNum(Object sellerPhoneNum) {
		return findByProperty(SELLER_PHONE_NUM, sellerPhoneNum);
	}

	public List findBySellerLastLoginTime(Object sellerLastLoginTime) {
		return findByProperty(SELLER_LAST_LOGIN_TIME, sellerLastLoginTime);
	}

	public List findBySellerLastLoginIp(Object sellerLastLoginIp) {
		return findByProperty(SELLER_LAST_LOGIN_IP, sellerLastLoginIp);
	}

	public List findBySellerCredit(Object sellerCredit) {
		return findByProperty(SELLER_CREDIT, sellerCredit);
	}

	public List findBySellerGoodEvaluationNum(Object sellerGoodEvaluationNum) {
		return findByProperty(SELLER_GOOD_EVALUATION_NUM,
				sellerGoodEvaluationNum);
	}

	public List findBySellerShopLevel(Object sellerShopLevel) {
		return findByProperty(SELLER_SHOP_LEVEL, sellerShopLevel);
	}

	public List findBySellerValidity(Object sellerValidity) {
		return findByProperty(SELLER_VALIDITY, sellerValidity);
	}

	public List findBySellerGoodsOnSell(Object sellerGoodsOnSell) {
		return findByProperty(SELLER_GOODS_ON_SELL, sellerGoodsOnSell);
	}

	public List findBySellerTotalGoodsNum(Object sellerTotalGoodsNum) {
		return findByProperty(SELLER_TOTAL_GOODS_NUM, sellerTotalGoodsNum);
	}

	public List findAll() {
		log.debug("finding all Seller instances");
		try {
			String queryString = "from Seller";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Seller merge(Seller detachedInstance) {
		log.debug("merging Seller instance");
		try {
			Seller result = (Seller) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Seller instance) {
		log.debug("attaching dirty Seller instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Seller instance) {
		log.debug("attaching clean Seller instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}