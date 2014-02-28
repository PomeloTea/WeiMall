package hibernate;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Shop
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see hibernate.Shop
 * @author MyEclipse Persistence Tools
 */

public class ShopDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ShopDAO.class);
	// property constants
	public static final String SHOP_HOMEPAGE_URL = "shopHomepageUrl";
	public static final String SHOP_LOGO = "shopLogo";
	public static final String SHOP_QR_CODE = "shopQrCode";
	public static final String SHOP_LATEST_GOODS_LOGO = "shopLatestGoodsLogo";
	public static final String SHOP_RECOMMENDED_GOODS_LOGO = "shopRecommendedGoodsLogo";
	public static final String SHOP_HOTTEST_GOODS_LOGO = "shopHottestGoodsLogo";
	public static final String SHOP_NAME = "shopName";
	public static final String SHOP_AREA = "shopArea";
	public static final String SHOP_ADDRESS = "shopAddress";
	public static final String SHOP_TEL = "shopTel";
	public static final String SHOP_QQ = "shopQq";
	public static final String SHOP_INTRODUCTION = "shopIntroduction";
	public static final String SHOP_HOMEPAGE_AD_PIC = "shopHomepageAdPic";
	public static final String SHOP_HOMEPAGE_AD_URL = "shopHomepageAdUrl";
	public static final String SHOP_GOODS_TYPES = "shopGoodsTypes";

	public void save(Shop transientInstance) {
		log.debug("saving Shop instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Shop persistentInstance) {
		log.debug("deleting Shop instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Shop findById(java.lang.Integer id) {
		log.debug("getting Shop instance with id: " + id);
		try {
			Shop instance = (Shop) getSession().get("hibernate.Shop", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Shop instance) {
		log.debug("finding Shop instance by example");
		try {
			List results = getSession().createCriteria("hibernate.Shop")
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
		log.debug("finding Shop instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Shop as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByShopHomepageUrl(Object shopHomepageUrl) {
		return findByProperty(SHOP_HOMEPAGE_URL, shopHomepageUrl);
	}

	public List findByShopLogo(Object shopLogo) {
		return findByProperty(SHOP_LOGO, shopLogo);
	}

	public List findByShopQrCode(Object shopQrCode) {
		return findByProperty(SHOP_QR_CODE, shopQrCode);
	}

	public List findByShopLatestGoodsLogo(Object shopLatestGoodsLogo) {
		return findByProperty(SHOP_LATEST_GOODS_LOGO, shopLatestGoodsLogo);
	}

	public List findByShopRecommendedGoodsLogo(Object shopRecommendedGoodsLogo) {
		return findByProperty(SHOP_RECOMMENDED_GOODS_LOGO,
				shopRecommendedGoodsLogo);
	}

	public List findByShopHottestGoodsLogo(Object shopHottestGoodsLogo) {
		return findByProperty(SHOP_HOTTEST_GOODS_LOGO, shopHottestGoodsLogo);
	}

	public List findByShopName(Object shopName) {
		return findByProperty(SHOP_NAME, shopName);
	}

	public List findByShopArea(Object shopArea) {
		return findByProperty(SHOP_AREA, shopArea);
	}

	public List findByShopAddress(Object shopAddress) {
		return findByProperty(SHOP_ADDRESS, shopAddress);
	}

	public List findByShopTel(Object shopTel) {
		return findByProperty(SHOP_TEL, shopTel);
	}

	public List findByShopQq(Object shopQq) {
		return findByProperty(SHOP_QQ, shopQq);
	}

	public List findByShopIntroduction(Object shopIntroduction) {
		return findByProperty(SHOP_INTRODUCTION, shopIntroduction);
	}

	public List findByShopHomepageAdPic(Object shopHomepageAdPic) {
		return findByProperty(SHOP_HOMEPAGE_AD_PIC, shopHomepageAdPic);
	}

	public List findByShopHomepageAdUrl(Object shopHomepageAdUrl) {
		return findByProperty(SHOP_HOMEPAGE_AD_URL, shopHomepageAdUrl);
	}

	public List findByShopGoodsTypes(Object shopGoodsTypes) {
		return findByProperty(SHOP_GOODS_TYPES, shopGoodsTypes);
	}

	public List findAll() {
		log.debug("finding all Shop instances");
		try {
			String queryString = "from Shop";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Shop merge(Shop detachedInstance) {
		log.debug("merging Shop instance");
		try {
			Shop result = (Shop) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Shop instance) {
		log.debug("attaching dirty Shop instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Shop instance) {
		log.debug("attaching clean Shop instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}