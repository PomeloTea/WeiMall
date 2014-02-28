package hibernate;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * GoodsInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate.GoodsInfo
 * @author MyEclipse Persistence Tools
 */

public class GoodsInfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(GoodsInfoDAO.class);
	// property constants
	public static final String GOODS_NAME = "goodsName";
	public static final String GOODS_PRICE = "goodsPrice";
	public static final String GOODS_STANDARD1 = "goodsStandard1";
	public static final String GOODS_STANDARD2 = "goodsStandard2";
	public static final String GOODS_AMOUNT = "goodsAmount";
	public static final String GOODS_ART_NO = "goodsArtNo";
	public static final String GOODS_ON_SELL = "goodsOnSell";
	public static final String GOODS_PIC = "goodsPic";
	public static final String GOODS_INFO = "goodsInfo";
	public static final String GOODS_TYPES = "goodsTypes";
	public static final String SHOP_GOODS_TYPES = "shopGoodsTypes";

	public void save(GoodsInfo transientInstance) {
		log.debug("saving GoodsInfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(GoodsInfo persistentInstance) {
		log.debug("deleting GoodsInfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GoodsInfo findById(java.lang.Integer id) {
		log.debug("getting GoodsInfo instance with id: " + id);
		try {
			GoodsInfo instance = (GoodsInfo) getSession().get(
					"hibernate.GoodsInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(GoodsInfo instance) {
		log.debug("finding GoodsInfo instance by example");
		try {
			List results = getSession().createCriteria("hibernate.GoodsInfo")
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
		log.debug("finding GoodsInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from GoodsInfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByGoodsName(Object goodsName) {
		return findByProperty(GOODS_NAME, goodsName);
	}

	public List findByGoodsPrice(Object goodsPrice) {
		return findByProperty(GOODS_PRICE, goodsPrice);
	}

	public List findByGoodsStandard1(Object goodsStandard1) {
		return findByProperty(GOODS_STANDARD1, goodsStandard1);
	}

	public List findByGoodsStandard2(Object goodsStandard2) {
		return findByProperty(GOODS_STANDARD2, goodsStandard2);
	}

	public List findByGoodsAmount(Object goodsAmount) {
		return findByProperty(GOODS_AMOUNT, goodsAmount);
	}

	public List findByGoodsArtNo(Object goodsArtNo) {
		return findByProperty(GOODS_ART_NO, goodsArtNo);
	}

	public List findByGoodsOnSell(Object goodsOnSell) {
		return findByProperty(GOODS_ON_SELL, goodsOnSell);
	}

	public List findByGoodsPic(Object goodsPic) {
		return findByProperty(GOODS_PIC, goodsPic);
	}

	public List findByGoodsInfo(Object goodsInfo) {
		return findByProperty(GOODS_INFO, goodsInfo);
	}

	public List findByGoodsTypes(Object goodsTypes) {
		return findByProperty(GOODS_TYPES, goodsTypes);
	}

	public List findByShopGoodsTypes(Object shopGoodsTypes) {
		return findByProperty(SHOP_GOODS_TYPES, shopGoodsTypes);
	}

	public List findAll() {
		log.debug("finding all GoodsInfo instances");
		try {
			String queryString = "from GoodsInfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public GoodsInfo merge(GoodsInfo detachedInstance) {
		log.debug("merging GoodsInfo instance");
		try {
			GoodsInfo result = (GoodsInfo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(GoodsInfo instance) {
		log.debug("attaching dirty GoodsInfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GoodsInfo instance) {
		log.debug("attaching clean GoodsInfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}